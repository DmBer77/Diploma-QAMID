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
public class NewsPageTests {

    public AndroidDriver driver;

    @BeforeEach
    @Step("1. Запуск приложения и авторизация")
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
    @Step("3. Закрытие приложения")
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Step("2. Переход на страницу с блоками новостей и перемещение по странице вверз/вниз")
    @Description("Открытие сраницы с блоками новостей")
    public void openNewsPage() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
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
    @Step("2. Переход на страницу с блоками новостей, запуск элемента управления новостями и добавление нового элемента с заполнением всех полей корректными значениями")
    @Description("Открытие страницы новостей и добавление нового элемента с корректно заполнеными полями")
    public void addNewsWithCorrectFillingFields() throws InterruptedException {

        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(500);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();
        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 645, driver);

        Thread.sleep(500);
        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        String text = "Header_of_news_" + AuxiliaryActions.getCurrentTime();
        TextGenerator.typeText(text, driver);

        Thread.sleep(500);
        MobileElement el8 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el8.isDisplayed();
        el8.click();
        Thread.sleep(1000);
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.isDisplayed();
        el9.click();
        Thread.sleep(500);
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

        Thread.sleep(1000);
        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals(text, actual2);
    }

    @Test
    @Step("2. Переход на страницу с блоками новостей, запуск элемента управления новостями и добавление нового элемента с незаполненным полем \"Категория\"")
    @Description("Открытие страницы новостей и попытка добавления нового элемента с незаполненным полем \"Категория\"")
    public void addNewsCategoryFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
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
        String text = "Header_of_news_" + AuxiliaryActions.getCurrentTime();
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

        Thread.sleep(3000);

        MobileElement el15 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el15.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на страницу с блоками новостей, запуск элемента управления новостями и добавление нового элемента с незаполненными полями \"Дата\" или \"Время\"")
    @Description("Открытие страницы новостей и попытка добавления нового элемента с незаполненным одним из полей \"Дата\" или \"Время\"")
    public void addNewsDataOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
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
    @Step("2. Переход на страницу с блоками новостей, запуск элемента управления новостями и добавление нового элемента с незаполненным одним из текстовых полей")
    @Description("Открытие страницы новостей и попытка добавления нового элемента с незаполненным тектовым полем")
    public void addNewsOneOfTheTextFieldsIsBlank() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
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
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, внесение изменений и сохранение элемента")
    @Description("Открытие страницы новостей и изменение одного из элементов с корректным заполнением полей")
    public void changeNewsWithCorrectFillingFields() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(3000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();
        Thread.sleep(1000);
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

        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals("Changed_news", actual2);
    }

    @Test
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, очистка поля \"Категория\" и попытка сохранения внесеных изменений")
    @Description("Открытие страницы новостей и попытка внесения изменений с незаполненным полем \"Категория\"")
    public void changeNewsCategoryFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(3000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(3000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
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
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, очистка поля \"Время\" и попытка сохранения внесеных изменений")
    @Description("Открытие страницы новостей и попытка внесения изменений с незаполненным полем \"Дата\" или \"Время\"")
    public void changeNewsDateOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("edit_news_item_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
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
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, очистка поля \"Заголовок\" и попытка сохранения внесеных изменений")
    @Description("Открытие страницы новостей и попытка внесения изменений с незаполненным одним из текстовых полей")
    public void changeNewsOneOfTheTextFieldsIsBlank() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(3000);
        MobileElement el5 = (MobileElement) driver.findElementById("ru.iteco.fmhandroid:id/edit_news_item_image_view");
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
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, добавления нового элемента в ленту, удаление новостного элемента со страницы")
    @Description("Открытие страницы новостей и удаление одного из элементов")
    public void deleteNews() throws InterruptedException {
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
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
        String text = "Test_news_for_deleting_" + AuxiliaryActions.getCurrentTime();

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

        Thread.sleep(1000);
        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Assertions.assertEquals(text, actual2);

        Thread.sleep(1000);

        MobileElement el21 = (MobileElement) driver.findElementById("delete_news_item_image_view");
        el21.isDisplayed();
        el21.click();
        Thread.sleep(1000);
        MobileElement el22 = (MobileElement) driver.findElementById("android:id/button1");
        el22.isDisplayed();
        el22.click();
        Thread.sleep(500);

        Thread.sleep(1000);
        MobileElement el26 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el26.isDisplayed();
        String actual3 = el26.getText();

        Assertions.assertNotEquals(actual2, actual3);
    }

    @Test
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, добавление нового элемента в ленту, фильтрация новостной ленты по полям \"Категория\" и \"Дата\"")
    @Description("Открытие страницы новостей и фильтрация ленты новостей по \"Категории\" и \"Дате публикации\"")
    public void filterNews() throws InterruptedException {
//        -----------creation----------
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
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

        Thread.sleep(3000);

        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();
        String actual2 = el17.getText();

        Thread.sleep(1000);

//        --------filtering----------------

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

        MobileElement el251 = (MobileElement) driver.findElementById("filter_news_inactive_material_check_box");
        el251.isDisplayed();
        el251.click();

        MobileElement el26 = (MobileElement) driver.findElementById("filter_button");
        el26.isDisplayed();
        el26.click();

        Thread.sleep(1000);

        MobileElement el29 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el29.isDisplayed();
        String actual3 = el29.getText();

        Assertions.assertEquals(actual2, actual3);

//        --------deleting----------------

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

    @Test
    @Step("2. Переход на страницу с блоками новостей, открытие одного из блоков, запуск элемента редактирования новости, добавление 2-х новых элементов в ленту, сортировка новостных блоков по полю \"Дата\"")
    @Description("Открытие страницы новостей и сортировка новостей по Дате публикации")
    public void sortNews() throws InterruptedException {
//        -----------creation----------
        Thread.sleep(2000);
        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.isDisplayed();
        el3.click();

//        -----------1-st news----------
        Thread.sleep(2000);
        MobileElement el4 = (MobileElement) driver.findElementById("edit_news_material_button");
        el4.isDisplayed();
        el4.click();

        MobileElement el5 = (MobileElement) driver.findElementById("add_news_image_view");
        el5.isDisplayed();
        el5.click();

        Thread.sleep(1000);
        MobileElement el6 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 1090, driver);

        MobileElement el7 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el7.isDisplayed();
        el7.click();
        el7.clear();
        String text1 = "Test_news_for_sorting_" + AuxiliaryActions.getCurrentTime();
        TextGenerator.typeText(text1, driver);

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

        MobileElement el17 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el17.isDisplayed();

        Thread.sleep(1000);

//      -----------2-nd news----------
        Thread.sleep(2000);

        MobileElement el51 = (MobileElement) driver.findElementById("add_news_image_view");
        el51.isDisplayed();
        el51.click();

        Thread.sleep(1000);
        MobileElement el61 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el61.isDisplayed();
        el61.click();
        Thread.sleep(500);

        AuxiliaryActions.tapByCoordinates(380, 1090, driver);

        MobileElement el71 = (MobileElement) driver.findElementById("news_item_title_text_input_edit_text");
        el71.isDisplayed();
        el71.click();
        el71.clear();
        String text2 = "Test_news_for_sorting_" + AuxiliaryActions.getCurrentTime();
        TextGenerator.typeText(text2, driver);

        MobileElement el81 = (MobileElement) driver.findElementById("news_item_publish_date_text_input_edit_text");
        el81.isDisplayed();
        el81.click();
        Thread.sleep(1000);
        MobileElement el91 = (MobileElement) driver.findElementById("android:id/button1");
        el91.isDisplayed();
        el91.click();
        MobileElement el101 = (MobileElement) driver.findElementById("news_item_publish_time_text_input_edit_text");
        el101.isDisplayed();
        el101.click();
        Thread.sleep(1000);
        MobileElement el111 = (MobileElement) driver.findElementById("android:id/button1");
        el111.isDisplayed();
        el111.click();

        MobileElement el121 = (MobileElement) driver.findElementById("news_item_description_text_input_edit_text");
        el121.isDisplayed();
        el121.click();
        TextGenerator.typeText("Lorem ipsum dolor sit amet", driver);
        Thread.sleep(500);

        MobileElement el131 = (MobileElement) driver.findElementById("save_button");
        el131.isDisplayed();
        el131.click();

        Thread.sleep(3000);

        MobileElement el171 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el171.isDisplayed();

        Thread.sleep(1000);

//        --------filtering----------------

        MobileElement el20 = (MobileElement) driver.findElementById("filter_news_material_button");
        el20.isDisplayed();
        el20.click();

        Thread.sleep(1000);

        MobileElement el21 = (MobileElement) driver.findElementById("news_item_category_text_auto_complete_text_view");
        el21.isDisplayed();
        el21.click();
        Thread.sleep(1000);
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

        Thread.sleep(1000);
        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);
        Thread.sleep(1000);

        MobileElement el29 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el29.isDisplayed();
        String actual3 = el29.getText();

//        --------sorting----------------

        MobileElement el30 = (MobileElement) driver.findElementById("sort_news_material_button");
        el30.isDisplayed();
        el30.click();

        Thread.sleep(2000);
        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);

        MobileElement el32 = (MobileElement) driver.findElementById("news_item_title_text_view");
        el32.isDisplayed();
        String actual4 = el32.getText();

        Assertions.assertNotEquals(actual3, actual4);
    }
}
