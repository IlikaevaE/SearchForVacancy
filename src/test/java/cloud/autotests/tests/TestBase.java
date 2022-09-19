package cloud.autotests.tests;

import cloud.autotests.config.Project;
import cloud.autotests.config.ProjectConfig;
import cloud.autotests.helpers.AllureAttachments;
import cloud.autotests.helpers.DriverSettings;
import cloud.autotests.helpers.DriverUtils;
import cloud.autotests.pages.DefinedVacancyPage;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.SearchVacancyPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    MainPage mainPage = new MainPage();
    SearchVacancyPage searchVacancyPage = new SearchVacancyPage();
    DefinedVacancyPage definedVacancyPage = new DefinedVacancyPage();
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties()); // !!

    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
        Configuration.baseUrl = config.baseUrl();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();
        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }
}
