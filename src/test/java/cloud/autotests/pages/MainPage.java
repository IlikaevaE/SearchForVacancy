package cloud.autotests.pages;

import cloud.autotests.tests.TestData;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends TestData {

    SelenideElement
    checkTextResult = $(".supernova-dashboard-search");

    @Step("Открываем сайт вакансий hh.ru")
    public MainPage openPage() {
        open(BASEURL);
        return this;
    }

    @Step("Проверяем, что нужная страница открылась")
    public MainPage checkResult() {
        checkTextResult.shouldHave(Condition.text(BASE_TEXT));
        return this;
    }

}
