package cloud.autotests.pages;

import cloud.autotests.tests.TestData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Ставим курсор в поле для поиска")
    public SearchVacancyPage searchFieldClick() {
        searchClick.click();
        return this;
    }

    @Step("Вводим параметр \"Selenium\"")
    public SearchVacancyPage valueSet(String value) {
        valueInput.sendKeys(value);
        return this;
    }

    @Step("Подтверждаем поиск")
    public SearchVacancyPage submitSearch() {
        submitAction.submit();
        return this;
    }

    @Step("Проверяем, что вакансия с заданными параметрами существует")
    public SearchVacancyPage checkResultParam(String value) {
        checkParam.shouldHave(Condition.text(value));
        return this;
    }

    @Step("Проверяем, что вакансия находится в нужном городе")
    public SearchVacancyPage checkResultLocation(String value) {
        checkLocation.shouldHave(Condition.text(value));
        return this;
    }
}
