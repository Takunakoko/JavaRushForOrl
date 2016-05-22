package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private Set<String> getStringParameters(Date after, Date before, String value, String typeValue)
    {
        Set<String> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            switch (typeValue)
            {
                case ("ip"):
                    if (value == null || s.contains(value))
                        set.add(getIP(s));
                    break;
                case ("user"):
                    if (value == null || s.contains(value))
                        set.add(getName(s));
                    break;
                case ("event"):
                    if (value == null || s.contains(value))
                        set.add(getEvent(s).split(" ")[0]);
                    break;
            }
        }
        return set;
    }

    private Set<Date> getDateParameters(Date after, Date before, String typeFilter, String value)
    {
        Set<Date> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            if ((value == null || s.contains(value)) && (typeFilter == null) || s.contains(typeFilter))
                try
                {
                    set.add(format.parse(getDate(s)));
                }
                catch (Exception e)
                {
                }
        }
        return set;
    }

    private Date getDateFirstTime(Date after, Date before, String user, String filter)
    {
        Date date = null;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String eventUser = getEvent(s);
            String userName = getName(s);
            if (userName.equals(user) && eventUser.equals(filter))
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

    private Set<Event> getEventParameter(Date after, Date before, String typeFilter, String value)
    {
        Set<Event> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            if ((typeFilter == null || s.contains(typeFilter)) && (value == null || s.contains(value)))
                set.add(Event.valueOf(getEvent(s).split(" ")[0]));
        }
        return set;
    }

    private Set<Status> getStatusParameter(Date after, Date before, String typeFilter, String value)
    {
        Set<Status> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            if ((typeFilter == null || s.contains(typeFilter)) && (value == null || s.contains(value)))
                set.add(Status.valueOf(getStatus(s)));
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
        return getStringParameters(after, before, Event.DONE_TASK.name() + " " + task, "user");
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before)
    {
        return getDateParameters(after, before, user, event.name());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before)
    {
        return getDateParameters(after, before, Status.FAILED.name(), null);
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before)
    {
        return getDateParameters(after, before, Status.ERROR.name(), null);
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before)
    {
        return getDateFirstTime(after, before, user, Event.LOGIN.name());
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before)
    {
        return getDateFirstTime(after, before, user, Event.SOLVE_TASK.name() + " " + task);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before)
    {
        return getDateFirstTime(after, before, user, Event.DONE_TASK.name() + " " + task);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before)
    {
        return getDateParameters(after, before, Event.WRITE_MESSAGE.name(), user);
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before)
    {
        return getDateParameters(after, before, Event.DOWNLOAD_PLUGIN.name(), user);
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before)
    {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before)
    {
        return getEventParameter(after, before, null, null);
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before)
    {
        return getEventParameter(after, before, ip, null);
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before)
    {
        return getEventParameter(after, before, user, null);
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before)
    {
        return getEventParameter(after, before, Status.FAILED.name(), null);
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before)
    {
        return getEventParameter(after, before, Status.ERROR.name(), null);
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before)
    {
        int count = 0;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            if (s.contains(Event.SOLVE_TASK + " " + task))
                count++;
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before)
    {
        int count = 0;
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            if (s.contains(Event.DONE_TASK + " " + task))
                count++;
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
        Set<Object> set = new HashSet<>();
        String[] message = query.split(" ");

                                                                        //get field1 for field2 = "value1"
        Pattern p = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher m = p.matcher(query);
        m.matches();
        String field1 = m.group(1);
        String field2 = m.group(3);
        String value1 = m.group(4);
        Date after;
        Date before;
        try
        {
            after = format.parse(m.group(6));
            before = format.parse(m.group(7));
        }catch (Exception e)
        {
            after = null;
            before = null;
        }
        if ("get".equals(message[0]))
            switch (field1)
            {
                case ("ip"):
                    set.addAll(getStringParameters(after, before, value1, field1));
                    break;
                case ("user"):
                    set.addAll(getStringParameters(after, before, value1, field1));
                    break;
                case ("date"):
                    set.addAll(getDateParameters(after, before, value1, null));
                    break;
                case ("event"):
                    set.addAll(getEventParameter(after, before, value1, null));
                    break;
                case ("status"):
                    set.addAll(getStatusParameter(after, before, value1, null));
                    break;
            }

        return set;
    }
}