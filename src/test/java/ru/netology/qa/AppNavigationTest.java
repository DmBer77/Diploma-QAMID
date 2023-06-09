package ru.netology.qa;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.AuxiliaryActions;
import ru.netology.base.BaseTest;
import ru.netology.base.TestListener;

@ExtendWith(TestListener.class)
public class AppNavigationTest extends BaseTest {

    @Test
    @Step("2. ������� �� �������� � ��������")
    @Description("�������� �������� ������������ �����")
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
    @Step("2. ������� �� �������� � �������� � ��������� �������� �����/����")
    @Description("�������� �������� ������������ �����")
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
    @Step("2. ������� �� �������� ������, ����� �� �������� �������, ����� ������� �� ���������������")
    @Description("������������ ����� ���������� ���������� ����� ������ �������� ����")
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
