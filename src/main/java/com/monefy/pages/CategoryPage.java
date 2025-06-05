package com.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static com.monefy.widgets.CommonElements.monefyElementIdPrefix;

public class CategoryPage {

    @Step("Select Category icon")
    public CategoryPage selectCategoryIcon(String iconName) {
        $$(AppiumBy.id(monefyElementIdPrefix + "textCategoryName"))
                .find(text(iconName))
                .shouldBe(visible, Duration.ofSeconds(8))
                .click();
        return this;
    }

    @Step("Tap Choose category")
    public static CategoryPage tapChooseCategory() {
        $(AppiumBy.id(monefyElementIdPrefix + "keyboard_action_button"))
                .find(byText("CHOOSE CATEGORY")).click();
        return new CategoryPage();
    }
}
