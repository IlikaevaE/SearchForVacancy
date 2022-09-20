package cloud.autotests.pages;

import cloud.autotests.tests.TestData;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchVacancyPage extends TestData {
    SelenideElement
            searchClick = $("[id=a11y-search-input]"),
            valueInput = $("[id=a11y-search-input]"),
            submitAction = $(".supernova-search-group__input"),
            checkParam = $(".vacancy-serp-content"),
            checkLocation = $(".vacancy-serp-item-body");

    @Step("Открываем сайт вакансий hh.ru")
    public SearchVacancyPage openPage(String value) {
        open(value);
        return this;
    }

    @Step("Вводим параметр \"Selenium\"")
    public SearchVacancyPage setValue(String value) {
        searchClick.click();
        valueInput.sendKeys(value);
        submitAction.submit();
        return this;
    }

    @Step("Проверяем, что вакансия с заданными параметрами существует")
    public SearchVacancyPage checkResultParam(String value) {
        checkParam.shouldHave(text(value));
        return this;
    }

    @Step("Проверяем, что вакансия находится в нужном городе")
    public SearchVacancyPage checkResultLocation(String value) {
        checkLocation.shouldHave(text(value));
        return this;
    }
}
