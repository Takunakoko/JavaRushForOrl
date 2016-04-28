package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    final public static class Constants{
        final public static String serverIsNotAccessibleForNow = "Server is not accessible for now.";
        final public static String userIsNotAuthorized = "User is not authorized.";
        final public static String userIsBanned = "User is banned.";
        final public static String accessIsDenied = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(new Constants().serverIsNotAccessibleForNow);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(new Constants().serverIsNotAccessibleForNow, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(new Constants().userIsNotAuthorized);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(new Constants().userIsNotAuthorized, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(new Constants().userIsBanned);
        }

        public BannedUserException(Throwable cause) {
            super(new Constants().userIsBanned, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(new Constants().accessIsDenied);
        }

        public RestrictionException(Throwable cause) {
            super(new Constants().accessIsDenied, cause);
        }
    }
}
