package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("c:/1/logs/"));

        System.out.println("*************Задание 1*************");
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()) + ": ");
        System.out.println(logParser.getUniqueIPs(null, new Date()));
        System.out.println("Amigo: " + logParser.getIPsForUser("Amigo", null, null));
        System.out.println("LOGIN: " + logParser.getIPsForEvent(Event.LOGIN, null, null));
        System.out.println("OK: " + logParser.getIPsForStatus(Status.OK, null, null));
        System.out.println("*************Задание 2*************");
        System.out.println(logParser.getNumberOfUsers(new Date(), null));
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getUsersForIP("127.0.0.1", null, null));
        System.out.println(logParser.getLoggedUsers(null, null));
        System.out.println(logParser.getDownloadedPluginUsers(null, null));
        System.out.println(logParser.getSolvedTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null));
        System.out.println(logParser.getDoneTaskUsers(null, null, 15));
        System.out.println(logParser.getSolvedTaskUsers(null, null, 18));
        System.out.println("*************Задание 3*************");
        System.out.println(logParser.getDatesForUserAndEvent("Amigo", Event.LOGIN, null, null));
        System.out.println(logParser.getDatesWhenSomethingFailed(null, null));
        System.out.println(logParser.getDatesWhenErrorHappened(null, null));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", null, null));
        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo", 18, null, null));
        System.out.println(logParser.getDateWhenUserDoneTask("Amigo", 18, null, null));
        System.out.println(logParser.getDatesWhenUserWroteMessage("Eduard Petrovich Morozko", null, null));
        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko", null, null));
        System.out.println("*************Задание 4*************");
        System.out.println(logParser.getNumberOfAllEvents(null, null));
        System.out.println(logParser.getAllEvents(null, null));
        System.out.println(logParser.getEventsForIP("146.34.15.5", null, null));
        System.out.println(logParser.getEventsForUser("Amigo", null, null));
        System.out.println(logParser.getFailedEvents(null, null));
        System.out.println(logParser.getErrorEvents(null, null));
        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getNumberOfSuccessfulAttemptToSolveTask(18, null, null));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
        System.out.println("*************Задание 5*************");
        /*System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));*/
        System.out.println("*************Задание 6*************");
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get status for date = \"30.01.2014 12:56:22\""));
        System.out.println(logParser.execute("get user for ip = \"12.12.12.12\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}
