package com.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.monefy.widgets.CommonElements.monefyElementIdPrefix;

public class SubscriptionAppPage {

    @Step("Close subscription page")
    public SubscriptionAppPage close() {
        $(AppiumBy.id(monefyElementIdPrefix + "buttonClose"))
                .shouldBe(visible).click();
        return this;
    }
}
