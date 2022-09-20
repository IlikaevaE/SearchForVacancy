package cloud.autotests.pages;

import cloud.autotests.tests.TestData;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DefinedVacancyPage extends TestData {
    SelenideElement
            clickOnButton = $(".bloko-button"),
            checkCompanyName = $(".vacancy-serp-item-body"),
            buttonVisible = $(byText(ANSWER_VACANCY));

    @Step("Открываем сайт вакансий hh.ru")
    public DefinedVacancyPage openSecondPage() {
        open("/search/vacancy?text=selenium&from=suggest_post&fromSearchLine=true&area=26");
        return this;
    }

    @Step("Нажимаем на кнопку ОТКЛИКНУТЬСЯ")
    public DefinedVacancyPage buttonClick() {
        clickOnButton.click();
        return this;
    }

    @Step("Проверяем, что вакансия принадлежит заданной компании")
    public DefinedVacancyPage checkResultCompany(String value) {
        checkCompanyName.shouldBe(text(value));
        return this;
    }

    @Step("Проверяем, что кнопка 'Откликнуться' видима")
    public DefinedVacancyPage checkButtonVisible() {
        buttonVisible.shouldBe(visible);
        return this;
    }
}
