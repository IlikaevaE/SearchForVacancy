package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    @Test
    @DisplayName("Opening the start page")
    void openVacancyPage() {

        step("Open the vacancy page hh.ru", () -> {
            open("https://voronezh.hh.ru/");
        });

        step("", () -> {
            $(".supernova-dashboard-search").shouldHave(Condition.text("Работа найдется для каждого"));

        });
    }

    @Test
    @DisplayName("Searching for the defined vacancy")
    void searchForVacancy() {
        step("Open the vacancy page hh.ru", () -> {
            open("https://voronezh.hh.ru/");
        });
        step("Click on the search input field", () -> {
            $("[id=a11y-search-input]").click();
        });
        step("Type the word \"Selenide\"", () -> {
            $("[id=a11y-search-input]").sendKeys("Selenide");
        });

        step("Submit the search", () -> {
            $(".supernova-search-group__input").submit();
        });

        step("", () -> {
            $(".vacancy-serp-content").shouldHave(Condition.text("QA Automation Engineer (Java) / инженер по автоматизированному тестированию"));
        });
    }

    @Test
    void checkCity() {
        step("Open the vacancy page hh.ru", () -> {
            open("https://voronezh.hh.ru/");
        });
        step("Click on the search input field", () -> {
            $("[id=a11y-search-input]").click();
        });
        step("Type the word \"Selenide\"", () -> {
            $("[id=a11y-search-input]").sendKeys("Selenide");
        });

        step("Submit the search", () -> {
            $(".supernova-search-group__input").submit();
        });
        step("Check the location of vacancy", () -> {
            $(".vacancy-serp-item-body").shouldHave(Condition.text("Воронеж"));
        });
    }
    @Test
    void checkCompany() {
        open("https://voronezh.hh.ru/search/vacancy?text=selenide&from=suggest_post&fromSearchLine=true&area=26");
        step("", () -> {
            $(".vacancy-serp-item-body").shouldBe(Condition.text("ITooLabs"));
        });
    }
    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open URL for vacancy", () ->
                open("https://voronezh.hh.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}