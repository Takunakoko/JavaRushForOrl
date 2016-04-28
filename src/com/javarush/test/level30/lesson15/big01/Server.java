package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 04.03.2016.
 */
public class Server
{
    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args)
    {
        int port;

        ConsoleHelper.writeMessage("Введите порт сервера");

        port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true)
            {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
        {
            try
            {
                pair.getValue().send(message);
            }
            catch (IOException e)
            {
                ConsoleHelper.writeMessage("Сообщение не отправлено " + pair.getKey());
            }
        }
    }


    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            String userName;
            Message message;

            while (true)
            {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();

                if (message.getType() == MessageType.USER_NAME)
                {
                    userName = message.getData();
                    if (userName != null && !userName.isEmpty() && !connectionMap.containsKey(userName))
                    {
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
            {
                String otherUser = pair.getKey();
                if (!userName.equals(otherUser))
                {
                    Message message = new Message(MessageType.USER_ADDED, otherUser);
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    Message messageToAll = new Message(MessageType.TEXT, String.format("%s: %s", userName, message.getData()));
                    sendBroadcastMessage(messageToAll);
                } else
                    ConsoleHelper.writeMessage("Ошибка, не текст!");
            }
        }

        public void run()
        {
            String newUser = null;

            try(Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Установлено новое соединение с удаленом адресом " + connection.getRemoteSocketAddress());
                newUser = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));
                sendListOfUsers(connection, newUser);
                serverMainLoop(connection, newUser);
            }
            catch (IOException | ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("Произошла ошибка приобмене данными с удаленным адресом\n" + e.getMessage());
            } finally
            {
                if (newUser != null)
                {
                    connectionMap.remove(newUser);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
                }
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }
    }
}
