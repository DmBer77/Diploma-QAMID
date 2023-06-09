package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.TextGenerator;
import ru.netology.base.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(TestListener.class)
public class LoginTests {

    public AndroidDriver driver;

    @BeforeEach
    @Step("1. ������ ����������")
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appium:deviceName", "samsung");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:appPackage", "ru.iteco.fmhandroid");
        desiredCapabilities.setCapability("appium:appActivity", "ru.iteco.fmhandroid.ui.AppActivity");
        desiredCapabilities.setCapability("appium:unicodeKeyboard", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @AfterEach
    @Step("3. �������� ����������")
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Step("2. ����������� � ����������")
    @Description("���� � ���������� � ��������� ������� � �������")
    public void validLoginAndPassword() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementById("trademark_image_view");
//        el4.isDisplayed();
//
//        String actual = el4.getId();
//        Assertions.assertEquals("trademark_image_view", actual );

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. ������������ � ����������")
    @Description("������� ����� � ���������� � ��������� ������� � �������, �� � ����������� �����")
    public void validLoginAndPasswordWithoutConnection() throws InterruptedException {
        Thread.sleep(5000);

        driver.toggleAirplaneMode();
        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        driver.toggleAirplaneMode();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. ����������� � ����������")
    @Description("������� ����� � ���������� � ��������� ������� � �������� �������")
    public void invalidLoginAndValidPassword() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. ����������� � ����������")
    @Description("������� ����� � ���������� � ������� ������� � ������������� ����� ������")
    public void validLoginAndBlankPasswordField() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. ����������� � ����������")
    @Description("���� � ����� �� ���������� � ��������� ������� � �������")
    public void LoginAndLogout() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementById("trademark_image_view");

        boolean actualLogIn = el4.isDisplayed();
        Assertions.assertTrue(actualLogIn);

        MobileElement el5 = (MobileElement) driver.findElementById("authorization_image_button");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(500);
        MobileElement el6 = (MobileElement) driver.findElementById("android:id/title");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(2000);
        MobileElement el7 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el7.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. ����������� � ����������")
    @Description("���� � ���������� � ��������� ������� � ������� � ����������� ��������� ���������� ��� ����������� ������")
    public void LoginAndQuitWithoutLogout() throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el1 = (MobileElement) driver.findElementById("login_text_input_layout");
        el1.isDisplayed();
        el1.click();
        TextGenerator.typeText("login2", driver);

        MobileElement el2 = (MobileElement) driver.findElementById("password_text_input_layout");
        el2.isDisplayed();
        el2.click();
        TextGenerator.typeText("password2", driver);

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementById("trademark_image_view");

        boolean actualLogIn = el4.isDisplayed();
        Assertions.assertTrue(actualLogIn);

        driver.closeApp();
        driver.launchApp();

        Thread.sleep(5000);

        MobileElement el5 = (MobileElement) driver.findElementById("enter_button");

        boolean actual = el5.isDisplayed();
        Assertions.assertTrue(actual);
    }

}
