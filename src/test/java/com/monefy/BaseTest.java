package com.monefy;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;

import java.io.IOException;

import static utils.AttachmentsHelper.screenshot;

public class BaseTest {

    @AfterEach
    public void closeWebDriver() throws IOException {
        screenshot();
        WebDriverRunner.closeWebDriver();
    }

    protected <T> T userCanAt(Class<T> tClass) {
        try {
            return tClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
