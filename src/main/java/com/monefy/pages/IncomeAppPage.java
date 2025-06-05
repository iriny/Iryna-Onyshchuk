package com.monefy.pages;

import com.monefy.widgets.ButtonKeyboard;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.monefy.pages.CategoryPage.tapChooseCategory;
import static com.monefy.widgets.CommonActions.addNote;
import static com.monefy.widgets.CommonElements.amountField;

public class IncomeAppPage {

    @Step("Add income data")
    public IncomeAppPage addIncomeData(String note) {
        addNote(note);
        amountField.shouldBe(visible);
        ButtonKeyboard.select("5", "0");
        tapChooseCategory();
        return this;
    }
}
