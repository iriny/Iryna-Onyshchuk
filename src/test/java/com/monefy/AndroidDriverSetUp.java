package com.monefy;

import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class AndroidDriverSetUp implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setDeviceName("emulator-5554");
        options.setPlatformName("Android");
        options.setAppPackage("com.monefy.app.lite");
        options.setAppActivity("com.monefy.activities.main.MainActivity_");
        options.setCapability("autoGrantPermissions", true);
        options.setNewCommandTimeout(Duration.ofSeconds(30));

        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);
            WebDriverRunner.setWebDriver(driver);
            return driver;

        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}
