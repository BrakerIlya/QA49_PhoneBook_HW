package utils;

import dto.User;
import net.datafaker.Faker;

public class User_Factory {
    static Faker faker=new Faker();
    public static User positiveUser(){
        return User.builder().username(faker.internet().emailAddress()).password("Password123!").build();
    }
}
