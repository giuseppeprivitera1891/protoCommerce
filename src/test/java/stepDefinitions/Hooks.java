package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utility.DriverManager;

public class Hooks {
    @BeforeAll
    public static void beforeAll() {
        DriverManager.initDriver();
    }

    @AfterAll
    public static void afterAll() {
        DriverManager.quitDriver();
    }
}
