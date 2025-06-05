package com.monefy.widgets;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.monefy.widgets.CommonElements.monefyElementIdPrefix;

public class ButtonKeyboard {

    public static void select(String... keyboardSymbol) {
        for (String text: keyboardSymbol) {
            $(AppiumBy.id(monefyElementIdPrefix + "buttonKeyboard" + text))
                    .shouldBe(visible)
                    .click();
        }
    }
}
