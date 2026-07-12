package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("sausedemo.user"),PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withLockedPermission() {
        return new User(PropertyReader.getProperty("sausedemo.locked_user"),
                PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withEmptyLoginPermission() {
        return new User("",PropertyReader.getProperty("sausedemo.password"));
    }

    public static User withEmptyPasswordPermission() {
        return new User(PropertyReader.getProperty("sausedemo.user"),"");
    }

    public static User withIncorrectCredentialsPermission() {
        return new User(PropertyReader.getProperty("sausedemo.incorrect_user"),
                PropertyReader.getProperty("sausedemo.password"));
    }
}
