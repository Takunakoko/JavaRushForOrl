package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery
{
    private Path logDir;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
    private Map<Date, String> uniqueIPsMessage = new TreeMap<>();


    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        readDateFromLogFile(logDir);
    }

    private String getIP(String s)
    {
        return s.split("\t")[0];
    }

    private String getName(String s)
    {
        return s.split("\t")[1];
    }

    private String getDate(String s)
    {
        return s.split("\t")[2];
    }

    private String getEvent(String s)
    {
        return s.split("\t")[3];
    }

    private String getStatus(String s)
    {
        return s.split("\t")[4];
    }

    private void readDateFromLogFile(Path logDir)
    {
        File folderLog = new File(logDir.toString());
        File[] listOfLog = folderLog.listFiles();

        for (File file : listOfLog)
        {
            if (file.getName().endsWith(".log"))
            {
                try (BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    String s;
                    while ((s = br.readLine()) != null)
                    {
                        Date date = format.parse(getDate(s));
                        uniqueIPsMessage.put(date, s);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private Set<String> createSetMessageToCurrentDate(Date after, Date before)
    {
        Set<String> setMessageOfCurrentDate = new TreeSet<>();
        for (Map.Entry<Date, String> entry : uniqueIPsMessage.entrySet())
        {
            long time = entry.getKey().getTime();
            if ((after == null || after.getTime() <= time) && (before == null || before.getTime() >= time))
                setMessageOfCurrentDate.add(entry.getValue());
        }
        return setMessageOfCurrentDate;
    }

    private Set<String> getStringParameters(Date after, Date before, String typeFilter, String value)
    {
        Set<String> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            switch (value)
            {
                case ("ip"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getIP(s));
                    break;
                case ("user"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getName(s));
                    break;
                case ("event"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getEvent(s).split(" ")[0]);
                    break;
            }
        }
        return set;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        return getStringParameters(after, before, null, "ip");
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        return getStringParameters(after, before, user, "ip");
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        return getStringParameters(after, before, event.name(), "ip");
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        return getStringParameters(after, before, status.name(), "ip");
    }

    @Override
    public Set<String> getAllUsers()
    {
        return getStringParameters(null, null, null, "user");
    }

    @Override
    public int getNumberOfUsers(Date after, Date before)
    {
        return getStringParameters(after, before, null, "user").size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before)
    {
        return getStringParameters(after, before, user, "event").size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before)
    {
        return getStringParameters(after, before, ip, "user");
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before)
    {
        return getStringParameters(after, before, Event.LOGIN.name(), "user");
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before)
    {
        return getStringParameters(after, before, Event.DOWNLOAD_PLUGIN.name(), "user");
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before)
    {
        return getStringParameters(after, before, Event.WRITE_MESSAGE.name(), "user");
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before)
    {
        return getStringParameters(after, before, Event.SOLVE_TASK.name(), "user");
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task)
    {
        return getStringParameters(after, before, Event.SOLVE_TASK.name() + " " + task, "user");
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before)
    {
        return getStringParameters(after, before, Event.DONE_TASK.name(), "user");
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task)
    {
        Set<String> doneTaskUsers = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String event = getEvent(s).split(" ")[0];

            String userName = getName(s);
            if (event.equals(Event.DONE_TASK.name()))
            {
                int numTask = Integer.parseInt(getEvent(s).split(" ")[1]);
                if (numTask == task)
                    doneTaskUsers.add(userName);
            }
        }
        return getStringParameters(after, before, Event.DONE_TASK.name() + " " + task, "user");
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before)
    {
        Set<Date> datesForUserAndEvent = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String nameUser = getName(s);
            String eventUser = getEvent(s).split(" ")[0];
            if (nameUser.equals(user) && eventUser.equals(event.name()))
                try
                {
                    datesForUserAndEvent.add(format.parse(getDate(s)));
                }
                catch (Exception e)
                {
                }

        }
        return datesForUserAndEvent;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before)
    {
        Set<Date> datesWhenSomethingFailed = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String statusUser = getStatus(s);
            if (statusUser.equals(Status.FAILED.name()))
                try
                {
                    datesWhenSomethingFailed.add(format.parse(getDate(s)));
                }
                catch (Exception e)
                {
                }
        }
        return datesWhenSomethingFailed;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before)
    {
        Set<Date> datesWhenErrorHappened = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String statusUser = getStatus(s);
            if (statusUser.equals(Status.ERROR.name()))
                try
                {
                    datesWhenErrorHappened.add(format.parse(getDate(s)));
                }
                catch (Exception e)
                {
                }
        }
        return datesWhenErrorHappened;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before)
    {
        Date date = null;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s);
            String userName = getName(s);
            if (userName.equals(user) && eventUser.equals(Event.LOGIN.name()))
                try
                {
                    date = format.parse(getDate(s));
                    break;
                }
                catch (Exception e)
                {
                }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before)
    {
        Date date = null;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s).split(" ")[0];
            String userName = getName(s);
            if (userName.equals(user) && eventUser.equals(Event.SOLVE_TASK.name()))
                if (Integer.parseInt(getEvent(s).split(" ")[1]) == task)
                    try
                    {
                        date = format.parse(getDate(s));
                        break;
                    }
                    catch (Exception e)
                    {
                    }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before)
    {
        Date date = null;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s).split(" ")[0];
            String userName = getName(s);
            if (userName.equals(user) && eventUser.equals(Event.DONE_TASK.name()))
                if (Integer.parseInt(getEvent(s).split(" ")[1]) == task)
                    try
                    {
                        date = format.parse(getDate(s));
                        break;
                    }
                    catch (Exception e)
                    {
                    }
        }
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before)
    {
        Set<Date> datesWhenUserWroteMessage = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String userName = getName(s);
            String userEvent = getEvent(s);
            if (userName.equals(user) && userEvent.equals(Event.WRITE_MESSAGE.name()))
                try
                {
                    datesWhenUserWroteMessage.add(format.parse(getDate(s)));
                }
                catch (Exception e)
                {
                }
        }
        return datesWhenUserWroteMessage;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before)
    {
        Set<Date> datesWhenUserDownloadedPlugin = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String userName = getName(s);
            String userEvent = getEvent(s);
            if (userName.equals(user) && userEvent.equals(Event.DOWNLOAD_PLUGIN.name()))
                try
                {
                    datesWhenUserDownloadedPlugin.add(format.parse(getDate(s)));
                }
                catch (Exception e)
                {
                }
        }
        return datesWhenUserDownloadedPlugin;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before)
    {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before)
    {
        Set<Event> allEvent = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            Event event = Event.valueOf(getEvent(s).split(" ")[0]);
            allEvent.add(event);
        }
        return allEvent;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before)
    {
        Set<Event> eventsForIP = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String ipUser = getIP(s);
            Event event = Event.valueOf(getEvent(s).split(" ")[0]);
            if (ipUser.equals(ip))
                eventsForIP.add(event);
        }
        return eventsForIP;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before)
    {
        Set<Event> eventsForUser = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String userName = getName(s);
            Event event = Event.valueOf(getEvent(s).split(" ")[0]);
            if (userName.equals(user))
                eventsForUser.add(event);
        }
        return eventsForUser;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before)
    {
        Set<Event> eventsFailedEvents = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String userStatus = getStatus(s);
            Event event = Event.valueOf(getEvent(s).split(" ")[0]);
            if (userStatus.equals(Status.FAILED.name()))
                eventsFailedEvents.add(event);
        }
        return eventsFailedEvents;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before)
    {
        Set<Event> eventsErrorEvents = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String userStatus = getStatus(s);
            Event event = Event.valueOf(getEvent(s).split(" ")[0]);
            if (userStatus.equals(Status.ERROR.name()))
                eventsErrorEvents.add(event);
        }
        return eventsErrorEvents;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before)
    {
        int count = 0;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s).split(" ")[0];
            if (eventUser.equals(Event.SOLVE_TASK.name()))
            {
                int taskUser = Integer.parseInt(getEvent(s).split(" ")[1]);
                if (taskUser == task)
                    count++;
            }
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before)
    {
        int count = 0;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s).split(" ")[0];
            if (eventUser.equals(Event.DONE_TASK.name()))
            {
                int taskUser = Integer.parseInt(getEvent(s).split(" ")[1]);
                if (taskUser == task)
                    count++;
            }
        }
        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before)
    {
        Map<Integer, Integer> allSolvedTasksAndTheirNumber = new HashMap<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s).split(" ")[0];
            if (eventUser.equals(Event.SOLVE_TASK.name()))
            {
                int task = Integer.parseInt(getEvent(s).split(" ")[1]);
                allSolvedTasksAndTheirNumber.put(task, getNumberOfAttemptToSolveTask(task, after, before));
            }
        }
        return allSolvedTasksAndTheirNumber;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before)
    {
        Map<Integer, Integer> allDoneTasksAndTheirNumber = new HashMap<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s).split(" ")[0];
            if (eventUser.equals(Event.DONE_TASK.name()))
            {
                int task = Integer.parseInt(getEvent(s).split(" ")[1]);
                allDoneTasksAndTheirNumber.put(task, getNumberOfSuccessfulAttemptToSolveTask(task, after, before));
            }
        }
        return allDoneTasksAndTheirNumber;
    }

    @Override
    public Set<Object> execute(String query)
    {
        return null;
    }
}