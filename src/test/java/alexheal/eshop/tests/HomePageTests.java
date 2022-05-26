package alexheal.eshop.tests;

import alexheal.eshop.config.App;
import alexheal.eshop.config.Project;
import alexheal.eshop.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTests extends TestBase {
    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open homepage", () ->
                open(App.config.webUrl()));

        step("Page title should have text 'eShopOnContainers - SPA'", () -> {
            String expectedTitle = "eShopOnContainers - SPA";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open homepage", () ->
                open(App.config.webUrl()));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
