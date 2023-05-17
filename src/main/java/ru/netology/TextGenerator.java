package ru.netology;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class TextGenerator {
    public static void typeLogin(String login, WebDriver driver) {
        char[] strToArray = login.toCharArray();
        for (char c : strToArray) {
            new Actions(driver).sendKeys(String.valueOf(c)).perform();
        }
    }

    public static void typePassword(String password, WebDriver driver) {
        char[] strToArray = password.toCharArray();
        for (char c : strToArray) {
            new Actions(driver).sendKeys(String.valueOf(c)).perform();
        }
    }
}