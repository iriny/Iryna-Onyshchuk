package com.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.monefy.widgets.CommonElements.monefyElementIdPrefix;

public class StartAppPage {

    @Step("Click Confirm")
    public StartAppPage confirm(String... confirmButtonsText) {
        for (String text: confirmButtonsText) {
            $(AppiumBy.id(monefyElementIdPrefix + "buttonContinue"))
                    .shouldBe(visible)
                    .find(byText(text)).click();
        }
        return this;
    }
}
