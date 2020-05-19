package service;

import model.User;

public class UserCreator {

    public static final String USER_NAME = "testdata.user.name";
    public static final String USER_PASSWORD = "testdata.user.password";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestDsta(USER_NAME), TestDataReader.getTestDsta(USER_PASSWORD));
    }

    public static User withEmptyUserName(){
        return new User("", TestDataReader.getTestDsta(USER_PASSWORD));
    }

    public static User withEmptyUserPassword(){
        return new User(TestDataReader.getTestDsta(USER_NAME), "");
    }
}
