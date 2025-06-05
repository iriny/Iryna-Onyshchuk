package com.monefy.widgets;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CommonElements {

    public static String monefyElementIdPrefix = "com.monefy.app.lite:id/";
    public static SelenideAppiumElement
            noteField = $(AppiumBy.id(monefyElementIdPrefix + "textViewNote")),
            amountField = $(AppiumBy.id(monefyElementIdPrefix + "amount_text"));

}
