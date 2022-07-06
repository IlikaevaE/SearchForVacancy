package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class GeneratedTests extends TestBase {
    private final String BASEURL = "https://voronezh.hh.ru/";
    private final String SECOND_URL = "https://voronezh.hh.ru/search/vacancy?text=selenide&from=suggest_post&fromSearchLine=true&area=26";
    private final String BASE_TEXT = "Работа найдется для каждого";
    private final String SEARCH_VALUE = "Selenide";
    private final String VACANCY_NAME = "QA Automation Engineer (Java) / инженер по автоматизированному тестированию";
    private final String ANSWER_VACANCY = "Откликнуться";
    private final String PARAMETER_1 = "Можно работать из дома";
    private final String PARAMETER_2 = "Показать контакты";
    private final String CITY_NAME = "Воронеж";
    private final String COMPANY_NAME = "ITooLabs";

    @Test
    @DisplayName("Проверяем работу сайта вакансий")
    void openVacancyPage() {

        step("Открываем сайт вакансий hh.ru", () -> {
            open(BASEURL);
        });

        step("Проверяем, что нужная страница открылась", () -> {
            $(".supernova-dashboard-search").shouldHave(Condition.text(BASE_TEXT));

        });
    }

    @Test
    @DisplayName("Ищем вакансию по скилу Selenide")
    void searchForVacancy() {
        step("Открываем сайт вакансий hh.ru", () -> {
            open(BASEURL);
        });
        step("Ставим курсор в поле для поиска", () -> {
            $("[id=a11y-search-input]").click();
        });
        step("Вводим значение \"Selenide\"", () -> {
            $("[id=a11y-search-input]").sendKeys(SEARCH_VALUE);
        });

        step("Подтверждаем поиск", () -> {
            $(".supernova-search-group__input").submit();
        });

        step("Проверяем, что вакансия с заданными параметрами существует", () -> {
            $(".vacancy-serp-content").shouldHave(Condition.text(VACANCY_NAME))
                    .shouldHave(Condition.text(ANSWER_VACANCY))
                    .shouldHave(Condition.text(PARAMETER_1))
                    .shouldHave(Condition.text(PARAMETER_2));
        });
    }

    @Test
    @DisplayName("Проверяем местоположение вакансии" )
    void checkCity() {
        step("Открываем сайт вакансий hh.ru", () -> {
            open(BASEURL);
        });
        step("Ищем вакансию с ключом \"Selenide\"", () -> {
            $("[id=a11y-search-input]").click();
            $("[id=a11y-search-input]").sendKeys(SEARCH_VALUE);
            $(".supernova-search-group__input").submit();
        });
        step("Проверяем, что вакансия находится в нужном городе", () -> {
            $(".vacancy-serp-item-body").shouldHave(Condition.text(CITY_NAME));
        });
    }

    @Test
    @DisplayName("Проверяем принадлежность вакансии компании ITooLabs")
    void checkCompany() {
        step("Открываем сайт вакансий hh.ru", () -> {
            open(SECOND_URL);
        });
        step("Проверяем, что вакансия принадлежить заданной компании", () -> {
            $(".vacancy-serp-item-body").shouldBe(Condition.text(COMPANY_NAME));
        });
    }

    @Test
    @DisplayName("Проверяем видимость кнопки 'Откликнуться'")
    void answerVacancyButton() {
        step("Открываем сайт вакансий hh.ru", () -> {
            open(SECOND_URL);
        });
        step("Проверяем, что кнопка 'Откликнуться' видима", () -> {
            $(Selectors.byText(ANSWER_VACANCY)).shouldBe(Condition.visible);
        });
    }

    @Test
    @Disabled
    @DisplayName("Тест в разработке")
    void answerVacancy() {
        step("Открываем сайт вакансий hh.ru", () -> {
            open(SECOND_URL);
        });
        $(".bloko-button").find(withText("Откликнуться")).click();
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