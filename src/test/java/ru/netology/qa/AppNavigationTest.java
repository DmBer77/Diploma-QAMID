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
import ru.netology.AuxiliaryActions;
import ru.netology.TextGenerator;
import ru.netology.base.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(TestListener.class)
public class AppNavigationTest {

    public AndroidDriver driver;

    @BeforeEach
    @Step ("1. Запуск приложения и авторизация")
    public void setUp() throws MalformedURLException, InterruptedException {
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
    }

    @AfterEach
    @Step ("3. Закрытие приложения")
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Step ("2. Переход на страницу с цитатами")
    @Description("Открытие страницы тематических цитат")
    public void openThematicQuotesPage() throws InterruptedException {
        Thread.sleep(1000);

        MobileElement el1 = (MobileElement) driver.findElementById("our_mission_image_button");
        el1.isDisplayed();
        el1.click();

        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("our_mission_title_text_view");

        boolean actual = el2.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step ("2. Переход на страницу с цитатами и прокрутка страницы вверх/вниз")
    @Description("Открытие страницы тематических цитат")
    public void thematicQuotesPageNav() throws InterruptedException {
        Thread.sleep(1000);

        MobileElement el1 = (MobileElement) driver.findElementById("our_mission_image_button");
        el1.isDisplayed();
        el1.click();

        Thread.sleep(2000);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[6]/android.view.ViewGroup/android.widget.TextView");
        el2.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        MobileElement el3 = (MobileElement) driver.findElementById("ru.iteco.fmhandroid:id/our_mission_item_description_text_view");

        boolean actual = el3.isDisplayed();
        Assertions.assertTrue(actual);

        Thread.sleep(2000);
        AuxiliaryActions.verticalSwipeByPercentages(30, 90, 50, driver);

    }

    @Test
    @Step ("2. Переход на страницу заявок, затем на старницу новосте, затем возврат на главнуюстраницу")
    @Description("Переключение между страницами приложения через кнопку главного меню")
    public void moveByMenu() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual1 = el4.isDisplayed();
        Assertions.assertTrue(actual1);

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("main_menu_image_button");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("container_list_news_include");

        boolean actual2 = el8.isDisplayed();
        Assertions.assertTrue(actual2);

        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("main_menu_image_button");
        el9.isDisplayed();
        el9.click();

        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(2000);
        MobileElement el11 = (MobileElement) driver.findElementById("container_list_news_include_on_fragment_main");
        MobileElement el12 = (MobileElement) driver.findElementById("container_list_claim_include_on_fragment_main");

        boolean actual3 = el11.isDisplayed();
        boolean actual4 = el12.isDisplayed();
        boolean actual5 = actual3 && actual4;

        Assertions.assertTrue(actual5);
    }

}
