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

public class ClaimsPageTests {

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
//        driver.hideKeyboard();

        MobileElement el3 = (MobileElement) driver.findElementById("enter_button");
        el3.isDisplayed();
        el3.click();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openClaimsPage() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el4.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addNewClaimWithCorrectFillingOfFields() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim 05.23", driver);

        MobileElement el6 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        TextGenerator.typeText("Petrov Petr Petrovich", driver);
//        driver.hideKeyboard();

        MobileElement el7 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.isDisplayed();
        el8.click();

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
        TextGenerator.typeText("claim description", driver);
//        driver.hideKeyboard();

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);
        MobileElement el13 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addNewClaimFieldExecutorIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim 05.23", driver);

        MobileElement el7 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.isDisplayed();
        el8.click();

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
        TextGenerator.typeText("claim description", driver);
//        driver.hideKeyboard();

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);
        MobileElement el13 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addNewClaimOneOfTheTextFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim 05.23", driver);

        MobileElement el7 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        Thread.sleep(1000);
        MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
        el8.isDisplayed();
        el8.click();

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
//        driver.hideKeyboard();

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);

        MobileElement el13 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);

        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("cancel_button");
        el15.click();
    }

    @Test
    public void addNewClaimDateOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("add_new_claim_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(1000);

        MobileElement el5 = (MobileElement) driver.findElementById("title_edit_text");
        el5.isDisplayed();
        TextGenerator.typeText("New claim 05.23", driver);

        MobileElement el9 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementById("description_edit_text");
        el11.isDisplayed();
        el11.click();
        TextGenerator.typeText("claim description", driver);
//        driver.hideKeyboard();

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);

        MobileElement el13 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);

        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.click();
        MobileElement el15 = (MobileElement) driver.findElementById("cancel_button");
        el15.click();
    }

    @Test
    public void changeClaimStatus() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el4.isDisplayed();
        el4.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el5 = (MobileElement) driver.findElementById("status_processing_image_button");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el6.isDisplayed();
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementById("status_processing_image_button");
        el7.isDisplayed();
        el7.click();
        MobileElement el18 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el18.click();

        MobileElement el9 = (MobileElement) driver.findElementById("editText");
        el9.isDisplayed();
        TextGenerator.typeText("done", driver);
        Thread.sleep(1000);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(1000);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(1000);

        MobileElement el11 = (MobileElement) driver.findElementById("close_image_button");
        el11.isDisplayed();
        el11.click();

        Thread.sleep(1000);
        MobileElement el12 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el12.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void changeClaimFields() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("edit_processing_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);

        MobileElement el9 = (MobileElement) driver.findElementById("title_edit_text");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText(" (added change to claim)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el10.isDisplayed();
        el10.click();
        el10.click();
        TextGenerator.typeText("Petrov Petr Petrovich", driver);
//        driver.hideKeyboard();

        MobileElement el11 = (MobileElement) driver.findElementById("date_in_plan_text_input_edit_text");
        el11.isDisplayed();
        el11.click();
        Thread.sleep(1000);
        MobileElement el12 = (MobileElement) driver.findElementById("android:id/button1");
        el12.isDisplayed();
        el12.click();

        MobileElement el13 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el13.isDisplayed();
        el13.click();
        Thread.sleep(1000);
        MobileElement el14 = (MobileElement) driver.findElementById("android:id/button1");
        el14.isDisplayed();
        el14.click();

        MobileElement el15 = (MobileElement) driver.findElementById("description_edit_text");
        el15.isDisplayed();
        el15.click();
        TextGenerator.typeText(" (added change to claim description)", driver);
//        driver.hideKeyboard();

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(1000);
        MobileElement el17 = (MobileElement) driver.findElementById("status_label_text_view");

        boolean actual = el17.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void changeClaimFieldsTextFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("edit_processing_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);

        MobileElement el9 = (MobileElement) driver.findElementById("title_edit_text");
        el9.isDisplayed();
        el9.clear();

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(2000);

        MobileElement el17 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el17.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void changeClaimFieldsDataOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("edit_processing_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);

        MobileElement el13 = (MobileElement) driver.findElementById("time_in_plan_text_input_edit_text");
        el13.isDisplayed();
        el13.clear();

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(2000);

        MobileElement el17 = (MobileElement) driver.findElementById("android:id/message");
        boolean actual = el17.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void filterClaimByStatusAllCheckboxAreBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_open");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el6.isDisplayed();
        el6.click();

        MobileElement el7 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el7.isDisplayed();
        el7.click();

        Thread.sleep(2000);
        MobileElement el8 = (MobileElement) driver.findElementById("empty_claim_list_text_view");
        boolean actual = el8.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    public void addCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("add_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el9.isDisplayed();
        TextGenerator.typeText("comment (diplom-QAMID)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]");
        String actual = el11.getText();

        Assertions.assertEquals("comment (diplom-QAMID)", actual);
    }

    @Test
    public void addBlankCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("add_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(2000);
//        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
//        el9.isDisplayed();
//        TextGenerator.typeText("comment (diplom-QAMID)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(3000);

        MobileElement el11 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el11.isDisplayed();
        Assertions.assertTrue(actual);

//        el11.isDisplayed();
//        el10.click();
//        MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]");
//        String actual = el11.getText();
//
//        Assertions.assertEquals("comment (diplom-QAMID)", actual);
    }

    @Test
    public void changeCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("edit_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(2000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el9.isDisplayed();
        el9.clear();
        TextGenerator.typeText("changed comment (diplom-QAMID)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(1000);

        MobileElement el11 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/androidx.cardview.widget.CardView[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView[1]");
        String actual = el11.getText();

        Assertions.assertEquals("changed comment (diplom-QAMID)", actual);
    }

    @Test
    public void changeToBlankCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(1000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(3000);
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el7.isDisplayed();
        el7.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el8 = (MobileElement) driver.findElementById("edit_comment_image_button");
        el8.isDisplayed();
        el8.click();

        Thread.sleep(2000);
        MobileElement el9 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el9.isDisplayed();
        el9.clear();

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(3000);

        MobileElement el11 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el11.isDisplayed();
        Assertions.assertTrue(actual);
    }
}
