package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

/**
 * Created by Администратор on 07.03.2016.
 */
public class BotClient extends Client
{
    private static int number = 0;

    @Override
    protected String getUserName()
    {
        if (number > 99)
            number = 0;
        return String.format("date_bot_%d", number++);
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            Message sendMessage;
            String messageToSend;
            SimpleDateFormat simpleDateFormat;
            Calendar calendar = new GregorianCalendar();

            ConsoleHelper.writeMessage(message);
            if (message.contains(": "))
            {
                String[] userNameAndText = message.split(": ");
                switch (userNameAndText[1])
                {
                    case ("дата"):
                        simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case ("день"):
                        simpleDateFormat = new SimpleDateFormat("d");
                        break;
                    case ("месяц"):
                        simpleDateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case ("год"):
                        simpleDateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case ("время"):
                        simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case ("час"):
                        simpleDateFormat = new SimpleDateFormat("H");
                        break;
                    case ("минуты"):
                        simpleDateFormat = new SimpleDateFormat("m");
                        break;
                    case ("секунды"):
                        simpleDateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        simpleDateFormat = null;
                }

                if (simpleDateFormat != null)
                {
                    String temp = simpleDateFormat.format(calendar.getTime());
                    messageToSend = String.format("Информация для %s: %s", userNameAndText[0], temp);

                    sendTextMessage(messageToSend);
                }
            }
        }
    }
}
