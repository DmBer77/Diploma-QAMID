package ru.netology.qa;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.AuxiliaryActions;
import ru.netology.TextGenerator;

import java.net.MalformedURLException;
import java.net.URL;


public class NewsPageTests {

    public AndroidDriver driver;

    @BeforeEach
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
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openNewsPage() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("container_list_news_include");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addNewsWithCorrectFillingFields() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Header_of_news_05.23", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("Lorem ipsum dolor sit amet", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(2000);

        MobileElement el14 = (MobileElement) driver.findElementById("main_menu_image_button");
        el14.isDisplayed();
        el14.click();
        Thread.sleep(500);

        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el15.isDisplayed();
        el15.click();

        MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el16.isDisplayed();
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals("Header_of_news_05.23", actual2);
    }

    @Test
    public void addNewsCategoryFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Header_of_news_05.23", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("Lorem ipsum dolor sit amet", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addNewsDataOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Header_of_news_05.23", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("Lorem ipsum dolor sit amet", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addNewsOneOfTheTextFieldsIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void changeNewsWithCorrectFillingFields() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 780, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Changed_news", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Happy birthday", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(2000);

        MobileElement el14 = (MobileElement) driver.findElementById("main_menu_image_button");
        el14.isDisplayed();
        el14.click();
        Thread.sleep(500);

        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el15.isDisplayed();
        el15.click();

        MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el16.isDisplayed();
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals("Changed_news", actual2);
    }

    @Test
    public void changeNewsCategoryFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        el6.clear();
        Thread.sleep(500);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Changed_news", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Happy birthday", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void changeNewsDateOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 780, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        TextGenerator.typeText("Changed_news", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.clear();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Happy birthday", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void changeNewsOneOfTheTextFieldsIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 780, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        el12.clear();
        TextGenerator.typeText("Happy birthday", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void deleteNews() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();

        TextGenerator.typeText("Test_news_for_deleting", driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("Lorem ipsum dolor sit amet", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(2000);

        MobileElement el14 = (MobileElement) driver.findElementById("main_menu_image_button");
        el14.isDisplayed();
        el14.click();
        Thread.sleep(500);

        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el15.isDisplayed();
        el15.click();

        MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el16.isDisplayed();
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals("Test_news_for_deleting", actual2);

        Thread.sleep(1000);

        MobileElement el20 = (MobileElement) driver.findElementById("edit_news_material_button");
        el20.isDisplayed();
        el20.click();

        Thread.sleep(2000);
        MobileElement el21 = (MobileElement) driver.findElementById("delete_news_item_image_view");
        el21.isDisplayed();
        el21.click();
        Thread.sleep(1000);
        MobileElement el22 = (MobileElement) driver.findElementById("android:id/button1");
        el22.isDisplayed();
        el22.click();
        Thread.sleep(500);

        MobileElement el23 = (MobileElement) driver.findElementById("main_menu_image_button");
        el23.isDisplayed();
        el23.click();
        Thread.sleep(500);

        MobileElement el24 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el24.isDisplayed();
        el24.click();

        MobileElement el25 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el25.isDisplayed();
        el25.click();
        MobileElement el26 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el26.isDisplayed();
        String actual3 = el26.getText();

        Assertions.assertNotEquals(actual2, actual3);
    }

    @Test
    public void sortAndFilterNews() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();
        Thread.sleep(500);

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 1090, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        String text = "Test_news_for_sorting_and_filtering_" + AuxiliaryActions.getCurrentTime();
        TextGenerator.typeText(text, driver);

        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(1000);
        MobileElement el11 = (MobileElement) driver.findElementById("android:id/button1");
        el11.isDisplayed();
        el11.click();

        MobileElement el12 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el12.isDisplayed();
        el12.click();
        TextGenerator.typeText("Lorem ipsum dolor sit amet", driver);
        Thread.sleep(500);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(2000);

        MobileElement el14 = (MobileElement) driver.findElementById("main_menu_image_button");
        el14.isDisplayed();
        el14.click();
        Thread.sleep(500);

        MobileElement el15 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el15.isDisplayed();
        el15.click();

        MobileElement el16 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el16.isDisplayed();
        el16.click();
        MobileElement el17 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Thread.sleep(1000);

        MobileElement el20 = (MobileElement) driver.findElementById("filter_news_material_button");
        el20.isDisplayed();
        el20.click();

        Thread.sleep(1000);

        MobileElement el21 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el21.isDisplayed();
        el21.click();

        AuxiliaryActions.tapByCoordinates(380, 950, driver);

        MobileElement el22 = (MobileElement) driver.findElementById("news_item_publish_date_start_text_input_edit_text");
        el22.isDisplayed();
        el22.click();
        Thread.sleep(1000);
        MobileElement el23 = (MobileElement) driver.findElementById("android:id/button1");
        el23.isDisplayed();
        el23.click();
        MobileElement el24 = (MobileElement) driver.findElementById("news_item_publish_date_end_text_input_edit_text");
        el24.isDisplayed();
        el24.click();
        Thread.sleep(1000);
        MobileElement el25 = (MobileElement) driver.findElementById("android:id/button1");
        el25.isDisplayed();
        el25.click();

        MobileElement el26 = (MobileElement) driver.findElementById("filter_button");
        el26.isDisplayed();
        el26.click();

//        --------filtering----------------

        Thread.sleep(500);

        MobileElement el28 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el28.isDisplayed();
        el28.click();

        MobileElement el29 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el29.isDisplayed();
        String actual3 = el29.getText();

        Assertions.assertEquals(actual2, actual3);

//        --------sorting----------------

        MobileElement el30 = (MobileElement) driver.findElementById("sort_news_material_button");
        el30.isDisplayed();
        el30.click();

        Thread.sleep(1000);
        AuxiliaryActions.verticalSwipeByPercentages(30, 90, 50, driver);

        MobileElement el31 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el31.isDisplayed();
        el31.click();
        MobileElement el32 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup/android.widget.TextView[1]");
        el32.isDisplayed();
        String actual4 = el32.getText();

        Assertions.assertNotEquals(actual2, actual4);

//        --------deleting----------------

        Thread.sleep(1000);

        MobileElement el36 = (MobileElement) driver.findElementById("edit_news_material_button");
        el36.isDisplayed();
        el36.click();

        Thread.sleep(1000);
        MobileElement el37 = (MobileElement) driver.findElementById("delete_news_item_image_view");
        el37.isDisplayed();
        el37.click();
        Thread.sleep(1000);
        MobileElement el38 = (MobileElement) driver.findElementById("android:id/button1");
        el38.isDisplayed();
        el38.click();
        Thread.sleep(500);
    }
}
