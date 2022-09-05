package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static cloud.autotests.tests.TestData.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {

    @Test
    @DisplayName("Проверяем работу сайта вакансий")
    void openVacancyPage() {
        mainPage
                .openPage()
                .checkResult();
    }

    @Test
    @DisplayName("Ищем вакансию по скилу Selenium")
    void searchForVacancy() {

        searchVacancyPage
                .openPage()
                .searchFieldClick()
                .valueEnter(SEARCH_VALUE)
                .submitSearch()
                .checkResultParam(VACANCY_NAME)
                .checkResultParam(ANSWER_VACANCY)
                .checkResultParam(PARAMETER_1)
                .checkResultParam(PARAMETER_2);
    }

    @Test
    @DisplayName("Проверяем местоположение вакансии")
    void checkCity() {
        searchVacancyPage
                .openPage()
                .searchFieldClick()
                .valueEnter(SEARCH_VALUE)
                .submitSearch()
                .checkResultLocation(CITY_NAME);
    }

    @Test
    @DisplayName("Проверяем принадлежность вакансии компании ОФИСМАГ")
    void checkCompany() {
        definedVacancyPage
                .openPage()
                .checkResultCompany(COMPANY_NAME);
    }

    @Test
    @DisplayName("Проверяем видимость кнопки 'Откликнуться'")
    void answerVacancyButton() {
        definedVacancyPage
                .openPage()
                .checkButtonVisible();
    }

    @Test
    @Disabled
    @DisplayName("Тест в разработке")
    void answerVacancy() {
        definedVacancyPage
                .openPage()
                .buttonClick();
    }

    @Test
    @DisplayName("В Concole Log страницы не должно быть ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем сайт вакансий hh.ru", () ->
                open(BASEURL));
        step("В консоле ошибок не должно содержаться текста 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}