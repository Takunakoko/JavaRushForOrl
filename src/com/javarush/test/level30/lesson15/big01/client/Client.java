package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Администратор on 06.03.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress()
    {
        String address;
        ConsoleHelper.writeMessage("Введите адрес сервера");
        address = ConsoleHelper.readString();
        return address;
    }

    protected int getServerPort()
    {
        int port;
        ConsoleHelper.writeMessage("Введите порт сервера");
        port = ConsoleHelper.readInt();
        return port;
    }

    protected String getUserName()
    {
        String userName;
        ConsoleHelper.writeMessage("Введите имя пользователя");
        userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        Message message = new Message(MessageType.TEXT, text);
        try
        {
            connection.send(message);
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Сообщение не было отправлено\n" + e.getMessage());
            clientConnected = false;
        }
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка текущего потока" + e.getMessage());
        }
        if (clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        while (clientConnected)
        {
            String string = ConsoleHelper.readString();
            if ("exit".equals(string))
            {
                clientConnected = false;
                break;
            }
            if (shouldSentTextFromConsole())
                sendTextMessage(string);
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("Участник с именем %s присоединился к чату", userName));
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("Участник с именем %s покинул чат", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST)
                {
                    String userName = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                }else
                if (message.getType() == MessageType.NAME_ACCEPTED)
                {
                    notifyConnectionStatusChanged(true);
                    break;
                }else
                    throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                    processIncomingMessage(message.getData());
                else
                if (message.getType() == MessageType.USER_ADDED)
                    informAboutAddingNewUser(message.getData());
                else
                if (message.getType() == MessageType.USER_REMOVED)
                    informAboutDeletingNewUser(message.getData());
                else
                    throw new IOException("Unexpected MessageType");
            }
        }

        @Override
        public void run()
        {
            String address = getServerAddress();
            int port = getServerPort();
            Socket socket;

            try
            {
                socket = new Socket(address, port);
                connection = new Connection(socket);

                clientHandshake();
                clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
