package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cloud.autotests.tests.TestData.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class SearchTests extends TestBase {
    @Test
    @DisplayName("Проверяем работу сайта вакансий")
    void openVacancyPage() {
        step("Открываем стартовую страницу hh.ru", ()
                -> open(baseUrl));
        step("", ()
                -> mainPage.checkTitleHeaderOnPage(TITLE));
    }

    @Test
    @DisplayName("Ищем вакансию по параметру Selenium")
    void searchForVacancy() {
        searchVacancyPage
                .openPage(baseUrl)
                .setValue(SEARCH_VALUE)
                .checkResultParam(VACANCY_NAME)
                .checkResultParam(ANSWER_VACANCY)
                .checkResultParam(TEXT_1)
                .checkResultParam(TEXT_2);
    }

    @Test
    @DisplayName("Проверяем местоположение вакансии")
    void checkCity() {
        searchVacancyPage
                .openPage(baseUrl)
                .setValue(SEARCH_VALUE)
                .checkResultLocation(CITY_NAME);
    }

    @Test
    @DisplayName("Проверяем принадлежность вакансии компании ОФИСМАГ")
    void checkCompany() {
        definedVacancyPage
                .openSecondPage()
                .checkResultCompany(COMPANY_NAME);
    }

    @Test
    @DisplayName("Проверяем видимость кнопки ОТКЛИКНУТЬСЯ")
    void answerVacancyButton() {
        definedVacancyPage
                .openSecondPage()
                .checkButtonVisible();
    }

    @Test
    @Disabled
    @DisplayName("Проверяем работоспособность кнопки ОТКЛИКНУТЬСЯ")
    void answerVacancy() {
        definedVacancyPage
                .openSecondPage()
                .buttonClick();
    }

    @Test
    @DisplayName("В Console Log страницы не должно быть ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт вакансий hh.ru", () ->
                open(baseUrl));
        step("В консоле ошибок не должно содержаться текста 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
