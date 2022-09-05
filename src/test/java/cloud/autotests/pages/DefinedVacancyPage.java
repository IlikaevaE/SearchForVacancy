package cloud.autotests.pages;

import cloud.autotests.tests.TestData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DefinedVacancyPage extends TestData{
    SelenideElement
            clickOnButton = $(".bloko-button"),
            checkCompanyName = $(".vacancy-serp-item-body"),
            buttonVisible = $(Selectors.byText(ANSWER_VACANCY));

    @Step("Открываем сайт вакансий hh.ru")
    public DefinedVacancyPage openPage() {
        open(SECOND_URL);
        return this;
    }

    @Step("Нажимаем на кнопку ОТКЛИКНУТЬСЯ")
    public DefinedVacancyPage buttonClick() {
        clickOnButton.click();
        return this;
    }

    @Step("Проверяем, что вакансия принадлежит заданной компании")
    public DefinedVacancyPage checkResultCompany(String value) {
        checkCompanyName.shouldBe(Condition.text(value));
        return this;
    }

    @Step("Проверяем, что кнопка 'Откликнуться' видима")
    public DefinedVacancyPage checkButtonVisible() {
        buttonVisible.shouldBe(Condition.visible);
        return this;
    }
}
