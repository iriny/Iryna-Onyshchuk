package com.monefy.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.monefy.pages.CategoryPage.tapChooseCategory;
import static com.monefy.widgets.ButtonKeyboard.select;
import static com.monefy.widgets.CommonActions.addNote;
import static com.monefy.widgets.CommonElements.amountField;

public class ExpensePage {

    @Step("Add expense data")
    public ExpensePage addExpenseData(String note) {
        addNote(note);
        amountField.shouldBe(visible);
        select("1", "0");
        tapChooseCategory();
        return this;
    }
}
