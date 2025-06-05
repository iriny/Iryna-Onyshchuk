package com.monefy;

import com.codeborne.selenide.Configuration;
import com.monefy.pages.CategoryPage;
import com.monefy.pages.MainAppPage;
import com.monefy.pages.StartAppPage;
import com.monefy.pages.SubscriptionAppPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MonefyTest extends BaseAndroidTest {

    @BeforeEach
    void confirmGetStarted() {
        Configuration.browser = AndroidDriverSetUp.class.getName();
        Configuration.browserSize = null;
        open();
        userCanAt(StartAppPage.class)
                .confirm("GET STARTED", "AMAZING", "I’M READY");
        userCanAt(SubscriptionAppPage.class).close();
    }

    @Test
    @DisplayName("User can add income")
    public void userCanAddIncome() {
        userCanAt(MainAppPage.class)
                .addIncome()
                .addIncomeData("Deposit_1");

        userCanAt(CategoryPage.class)
                .selectCategoryIcon("Deposits");

        userCanAt(MainAppPage.class)
                .checkIncomeAmount("$50.00")
                .checkExpenseAmount("$0.00")
                .checkBalance("$50.00");
    }

    @Test
    @DisplayName("User can add expense")
    public void userCanAddExpense() {
        userCanAt(MainAppPage.class)
                .addExpense()
                .addExpenseData("Expense_1");

        userCanAt(CategoryPage.class)
                .selectCategoryIcon("Bills");

        userCanAt(MainAppPage.class)
                .checkExpenseAmount("$10.00")
                .checkIncomeAmount("$0.00")
                .checkBalance("-$10.00");
    }

    @Test
    @DisplayName("User can see balance changed after added expense and income")
    public void userCanSeeChangedBalanceAfterAddExpense() {
        userCanAt(MainAppPage.class)
                .addExpense()
                .addExpenseData("Expense_2");

        userCanAt(CategoryPage.class)
                .selectCategoryIcon("Clothes");

        userCanAt(MainAppPage.class)
                .checkExpenseAmount("$10.00")
                .checkAlert("Clothes: $10.00 added")
                .checkBalance("Balance -$10.00");

        userCanAt(MainAppPage.class)
                .addIncome()
                .addIncomeData("Deposit_2");

        userCanAt(CategoryPage.class)
                .selectCategoryIcon("Savings");

        userCanAt(MainAppPage.class)
                .checkBalance("Balance $40.00");

        userCanAt(MainAppPage.class)
                .checkIncomeAmount("$50.00")
                .checkExpenseAmount("$10.00");
    }
}
