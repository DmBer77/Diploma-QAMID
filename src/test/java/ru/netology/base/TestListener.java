package ru.netology.base;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.extension.TestWatcher;


public class TestListener implements TestWatcher {
    public AndroidDriver driver;

//    @Override
//    public void testFailed(ExtensionContext context) {
////        Object instance = context.getRequiredTestInstance();
////        WebDriver driver = instance.getClass().getDeclaredField("driver").get(instance);
//        Allure.getLifecycle().addAttachment(
//                "screenshot", "image/png", "png",
//                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//        driver.close();
//        driver.quit();
//    }
}