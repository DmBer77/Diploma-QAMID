package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.AuxiliaryActions;
import ru.netology.TextGenerator;
import ru.netology.base.BaseTest;
import ru.netology.base.TestListener;

@ExtendWith(TestListener.class)
public class ClaimsPageTests extends BaseTest {

    @Test
    @Step("2. Переход на страницу заявок и перемещение по странице вверз/вниз")
    @Description("Открытие сраницы с блоками заявок")
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
    @Step("2. Переход на страницу заявок, запуск элемента управления новостями и добавление нового элемента с заполнением всех полей корректными значениями")
    @Description("Создание новой заявки с корректным заполнением всех полей")
    public void addNewClaimWithCorrectFillingOfFields() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
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

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);
        MobileElement el13 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на страницу заявок и добавление нового элемента с незаполненным полем \"Исполнитель\"")
    @Description("Создание новой заявки с незаполненным полем \"Исполнитель\"")
    public void addNewClaimFieldExecutorIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
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

        MobileElement el12 = (MobileElement) driver.findElementById("save_button");
        el12.isDisplayed();
        el12.click();

        Thread.sleep(2000);
        MobileElement el13 = (MobileElement) driver.findElementById("container_list_claim_include");

        boolean actual = el13.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на страницу заявок и добавление нового элемента с незаполненным полем \"Описание\"")
    @Description("Создание новой заявки с незаполненным одним из текстовых полей")
    public void addNewClaimOneOfTheTextFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
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
    @Step("2. Переход на страницу заявок и добавление нового элемента с незаполненным полем \"Дата\"")
    @Description("Создание новой заявки с незаполненным одним из полей \"Дата\" или \"Время\"")
    public void addNewClaimDateOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
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
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка и изменение статуса заявки, сохранение изменений")
    @Description("Открытие одной из заявок и изменение ее статуса")
    public void changeClaimStatus() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(5000);
        MobileElement el31 = (MobileElement) driver.findElementById("filters_material_button");
        el31.isDisplayed();
        el31.click();

        Thread.sleep(1000);
        MobileElement el32 = (MobileElement) driver.findElementById("item_filter_open");
        el32.isDisplayed();
        el32.click();
        MobileElement el33 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el33.isDisplayed();
        el33.click();

        Thread.sleep(3000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(500);
        MobileElement el41 = (MobileElement) driver.findElementById("title_text_view");
        el41.isDisplayed();
        String actual1 = el41.getText();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el5 = (MobileElement) driver.findElementById("status_processing_image_button");
        el5.isDisplayed();
        el5.click();
        Thread.sleep(500);
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el6.isDisplayed();
        el6.click();
        Thread.sleep(500);

        MobileElement el9 = (MobileElement) driver.findElementById("editText");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("done", driver);
        Thread.sleep(500);
        MobileElement el10 = (MobileElement) driver.findElementById("android:id/button1");
        el10.isDisplayed();
        el10.click();
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el11 = (MobileElement) driver.findElementById("close_image_button");
        el11.isDisplayed();
        el11.click();

        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);
        Thread.sleep(500);

        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el12.isDisplayed();
        el12.click();

        MobileElement el13 = (MobileElement) driver.findElementById("title_text_view");
        el13.isDisplayed();
        String actual2 = el13.getText();

        Thread.sleep(500);

        Assertions.assertNotEquals(actual1, actual2);
    }

    @Test
    @Step("2. Переход на страницу заявок открытие первого элемента из списка и внесение изменений в заявку (без изменения даты и времени создания заявки), сохранение изменений")
    @Description("Открытие одной из заявок и изменение текста заявки")
    public void changeClaimFieldsNotChangeDataOrTime() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
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

        Thread.sleep(5000);

        MobileElement el71 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el71.isDisplayed();
        el71.click();

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
        el9.clear();
        TextGenerator.typeText("added change to claim", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("executor_drop_menu_auto_complete_text_view");
        el10.isDisplayed();
        el10.click();
        el10.clear();
        TextGenerator.typeText("Petrov Petr Petrovich", driver);

        MobileElement el15 = (MobileElement) driver.findElementById("description_edit_text");
        el15.isDisplayed();
        el15.click();
        el15.clear();
        TextGenerator.typeText("added change to claim description", driver);

        MobileElement el16 = (MobileElement) driver.findElementById("save_button");
        el16.isDisplayed();
        el16.click();

        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el17 = (MobileElement) driver.findElementById("close_image_button");
        el17.isDisplayed();
        el17.click();

        AuxiliaryActions.verticalSwipeByPercentages(40, 90, 50, driver);
        Thread.sleep(500);

        MobileElement el18 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
        el18.isDisplayed();
        el18.click();

        MobileElement el19 = (MobileElement) driver.findElementById("title_text_view");
        el19.isDisplayed();
        String actual2 = el19.getText();

        Thread.sleep(500);

        Assertions.assertEquals("added change to claim", actual2);
    }

    @Test
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка и очистка поля \"Заголовок\" и попытка сохранения изменений")
    @Description("Открытие одной из заявок, очистка одного из текстовых полей и попытка сохранение изменений")
    public void changeClaimFieldsTextFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        MobileElement el4 = (MobileElement) driver.findElementById("filters_material_button");
        el4.isDisplayed();
        el4.click();

        Thread.sleep(2000);
        MobileElement el5 = (MobileElement) driver.findElementById("item_filter_in_progress");
        el5.isDisplayed();
        el5.click();

        MobileElement el6 = (MobileElement) driver.findElementById("claim_list_filter_ok_material_button");
        el6.isDisplayed();
        el6.click();

        Thread.sleep(5000);
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
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка и очистка поля \"Времяк\" и попытка сохранения изменений")
    @Description("Открытие одной из заявок, очистка одного из полей даты и времени и попытка сохранения изменений")
    public void changeClaimFieldsDataOrTimeFieldIsBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(500);
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

        Thread.sleep(5000);
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
    @Step("2. Переход на страницу заявок, вызов элемента фильтрации, отключение всех фильтров, попытка фильтрации по статусу заявок")
    @Description("Фильтрация сохраненных заявок при отсутсвии параметров")
    public void filterClaimByStatusAllCheckboxAreBlank() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
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
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка, запуск элемента добавления комментариев, сохранение изменений")
    @Description("Открытие одной из заявок и добавление комментария к заявке")
    public void addCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(500);
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

        Thread.sleep(5000);
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
        el9.click();
        TextGenerator.typeText("comment (diplom-QAMID)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);
        AuxiliaryActions.verticalSwipeByPercentages(90, 30, 50, driver);
        Thread.sleep(500);

        MobileElement el11 = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"comment (diplom-QAMID)\")");
        el11.isDisplayed();
        el11.click();
        String actual = el11.getText();
        Assertions.assertEquals("comment (diplom-QAMID)", actual);
    }

    @Test
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка, запуск элемента добавления комментариев, поле \"Комментарий\" оставлено незаполненным, сохранение изменений")
    @Description("Открытие одной из заявок и попытка добавления комментария к заявке с незаполненным текстовым полем")
    public void addBlankCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(1000);
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

        Thread.sleep(5000);
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

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(3000);

        MobileElement el11 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el11.isDisplayed();
        Assertions.assertTrue(actual);
    }

    @Test
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка, запуск элемента добавления комментариев, добавление нового комментария, сохранение изменений, повторный в ход в ранее созданый комментарий и внесение в него изменений, сохранение")
    @Description("Открытие одной из заявок и внесение изменений в имеющийся комментарий заявке")
    public void changeCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(1000);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
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

        Thread.sleep(6000);
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

        Thread.sleep(500);
        MobileElement el9 = (MobileElement) driver.findElementById("comment_text_input_layout");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("comment (diplom-QAMID)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(500);
        MobileElement el11 = (MobileElement) driver.findElementById("edit_comment_image_button");
        el11.isDisplayed();
        el11.click();

        Thread.sleep(500);
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el12.isDisplayed();
        el12.clear();
        el12.click();
        TextGenerator.typeText("changed comment (diplom-QAMID)", driver);

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(1000);
        MobileElement el14 = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().text(\"changed comment (diplom-QAMID)\")");
        el14.isDisplayed();
        el14.click();
        String actual = el14.getText();

        Assertions.assertEquals("changed comment (diplom-QAMID)", actual);
    }

    @Test
    @Step("2. Переход на страницу заявок, фильтрация по статусу заявок, открытие первого элемента из списка, запуск элемента добавления комментариев, добавление нового комментария, сохранение изменений, повторный в ход в ранее созданый комментарий и очитска такстового поля, попытка сохранения изменений")
    @Description("Открытие одной из заявок и попытка внесение изменений в имеющийся комментарий заявке при незаполненном текстовом поле")
    public void changeToBlankCommentToClaim() throws InterruptedException {
        Thread.sleep(2000);

        MobileElement el2 = (MobileElement) driver.findElementById("main_menu_image_button");
        el2.isDisplayed();
        el2.click();

        Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout");
        el3.isDisplayed();
        el3.click();

        Thread.sleep(2000);
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

        Thread.sleep(5000);
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

        Thread.sleep(500);
        MobileElement el9 = (MobileElement) driver.findElementById("comment_text_input_layout");
        el9.isDisplayed();
        el9.click();
        TextGenerator.typeText("comment (diplom-QAMID)", driver);

        MobileElement el10 = (MobileElement) driver.findElementById("save_button");
        el10.isDisplayed();
        el10.click();

        Thread.sleep(500);
        MobileElement el11 = (MobileElement) driver.findElementById("edit_comment_image_button");
        el11.isDisplayed();
        el11.click();

        Thread.sleep(500);
        MobileElement el12 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/androidx.cardview.widget.CardView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText");
        el12.isDisplayed();
        el12.clear();

        MobileElement el13 = (MobileElement) driver.findElementById("save_button");
        el13.isDisplayed();
        el13.click();

        Thread.sleep(3000);

        MobileElement el14 = (MobileElement) driver.findElementById("save_button");
        boolean actual = el14.isDisplayed();
        Assertions.assertTrue(actual);
    }
}
