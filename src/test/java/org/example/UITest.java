package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UITest {
    @Test
    public void correctLoginMobileID() {
        open("https://profile.esto.ee/login/mobile-id");

        SelenideElement mobileInput = $(By.xpath("//*[@data-cy=\"mobile-id-phone-input\"]/div/input"));
        SelenideElement idInput = $(By.xpath("//*[@data-cy=\"mobile-id-id-input\"]/div/input"));

        mobileInput.setValue("53912688");
        idInput.setValue("39155120201");
        $(By.xpath("//*[@data-cy=\"mobile-id-login-button\"]")).click();
        $(By.xpath("//*[@data-cy=\"mobile-id-polling-pin\"]"))
                .shouldBe(Condition.visible);

    }

    @Test
    public void correctLoginSmartID() {
        open("https://profile.esto.ee/login/smart-id");

        SelenideElement idInput = $(By.xpath("//*[@data-cy=\"smart-id-input\"]/div/input"));

        idInput.setValue("39155120201");
        $(By.xpath("//*[@data-cy=\"smart-id-login-button\"]")).click();
        $(By.xpath("//*[@data-cy=\"smart-id-polling-pin\"]"))
                .shouldBe(Condition.visible);

    }

    @Test
    public void correctLoginPassword() {
        open("https://profile.esto.ee/login/password");

        SelenideElement nameInput = $(By.xpath("//*[@data-cy=\"username-input\"]/div/input"));
        SelenideElement passwordInput = $(By.xpath("//*[@data-cy=\"password-input\"]/div/input"));

        nameInput.setValue("rhrhrdb");
        passwordInput.setValue("fhdbsbs");
        $(By.xpath("//*[@data-cy=\"password-login-button\"]")).click();
        $(By.xpath("//*[@data-cy=\"password-login-error\"]"))
                .shouldBe(Condition.hidden);
    }

    @Test
    public void emptyLoginPassword() {
        open("https://profile.esto.ee/login/password");


        $(By.xpath("//*[@data-cy=\"password-login-button\"]")).click();
        $(By.xpath("//*[@data-cy=\"password-login-button\"]"))
                .shouldBe(Condition.disabled);
    }

    @Test
    public void wrongIdLoginSmartID() {
        open("https://profile.esto.ee/login/smart-id");

        SelenideElement idInput = $(By.xpath("//*[@data-cy=\"smart-id-input\"]/div/input"));

        idInput.setValue("3456");
        $(By.xpath("//*[@data-cy=\"smart-id-login-button\"]")).click();
        $(By.xpath("//*[@data-cy=\"smart-id-validation-error\"]"))
                .shouldBe(Condition.visible);

    }

}
