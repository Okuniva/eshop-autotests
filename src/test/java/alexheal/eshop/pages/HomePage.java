package alexheal.eshop.pages;

import alexheal.eshop.config.App;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    @Step("open HomePage")
    public HomePage openHomePage() {
        open(App.config.webUrl());

        return this;
    }
}
