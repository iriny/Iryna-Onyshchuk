package com.monefy;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;

import java.io.IOException;

import static utils.AttachmentsHelper.screenshot;

public class BaseAndroidTest {

    @AfterEach
    public void closeWebDriver() throws IOException {
        screenshot();
        Selenide.closeWebDriver();
    }

    protected <T> T userCanAt(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
