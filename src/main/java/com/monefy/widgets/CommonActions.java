package com.monefy.widgets;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.monefy.widgets.CommonElements.noteField;

public class CommonActions {

    public static void addNote(String note) {
        noteField.doubleTap()
                .shouldBe(visible, Duration.ofSeconds(15)).setValue(note);
        noteField.hideKeyboard();
    }
}
