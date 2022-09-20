package cloud.autotests.pages;

import cloud.autotests.tests.TestData;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends TestData {
    SelenideElement
            checkTitleTextOnPage = $(".supernova-dashboard-search");

    @Step("Проверяем, что нужная страница открылась")
    public MainPage checkTitleHeaderOnPage(String value) {
        checkTitleTextOnPage.shouldHave(text(value));
        return this;
    }
}
