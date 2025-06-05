package com.monefy.pages;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.monefy.widgets.CommonElements.monefyElementIdPrefix;

public class MainAppPage {

    @Step("Click Add expense")
    public ExpensePage addExpense() {
        $(AppiumBy.id(monefyElementIdPrefix + "expense_button_title"))
                .shouldBe(visible, Duration.ofSeconds(15)).click();
        return new ExpensePage();
    }

    @Step("Click Add income")
    public IncomeAppPage addIncome() {
        $(AppiumBy.id(monefyElementIdPrefix + "income_button_title"))
                .shouldBe(visible).click();
        return new IncomeAppPage();
    }

    @Step("Check income amount")
    public MainAppPage checkIncomeAmount(String amountText) {
        $(AppiumBy.id(monefyElementIdPrefix + "income_amount_text"))
                .shouldHave(text(amountText), Duration.ofSeconds(6));
        return this;
    }

    @Step("Check balance")
    public MainAppPage checkBalance(String balanceText) {
        $(AppiumBy.id(monefyElementIdPrefix + "balance_amount"))
                .shouldHave(text(balanceText), Duration.ofSeconds(6));
        return this;
    }

    @Step("Check expense amount")
    public MainAppPage checkExpenseAmount(String amountText) {
        $(AppiumBy.id(monefyElementIdPrefix + "expense_amount_text"))
                .shouldHave(text(amountText), Duration.ofSeconds(6));
        return this;
    }

    @Step("Check alert")
    public MainAppPage checkAlert(String alertText) {
        $(AppiumBy.id(monefyElementIdPrefix + "snackbar_text"))
                .shouldHave(text(alertText), Duration.ofSeconds(6))
                .shouldNotBe(visible, Duration.ofSeconds(40));
        return this;
    }
}
