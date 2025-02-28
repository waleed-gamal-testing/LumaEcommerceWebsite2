package com.luma.utils;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.Locale;

public class TestDataProviderUtils {
    private static final Faker faker = new Faker(new Locale("en-US"));

    @DataProvider(name = "invalidLoginData")
    public Object[][] provideInvalidLoginData() {
        return new Object[][] {
                {"invalid@email.com", "wrongpassword"},
                {"test@test", "1234"},
                {"wa@t", "password"},
                {"valid@email.com", "123"}
        };
    }

    @DataProvider(name = "registrationData")
    public Object[][] provideRegistrationData() {
        return new Object[][] {
                {faker.name().firstName(), faker.internet().emailAddress(), faker.internet().password(8, 16), "valid"},
                {"", faker.internet().emailAddress(), faker.internet().password(8, 16), "invalid"},
                {faker.name().firstName(), "invalid-email", faker.internet().password(8, 16), "invalid"},
                {faker.name().firstName(), faker.internet().emailAddress(), "short", "invalid"}
        };
    }
}

