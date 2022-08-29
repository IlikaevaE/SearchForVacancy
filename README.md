# Автоматизация тестирования на примере поиска работы на hh.ru <img width="8%" title="HH.ru" src="images/logo/HeadHunter_logo.png">

# <a name="Содержание">Содержание:</a>
+ [Используемые технологии](#ИспользуемыеТехнологии) 
+ [Реализация проверок](#РеализацияПроверок)
+ [Запуск тестов локально](#ЗапускТестовЛокально)
+ [Запуск тестов из Jenkins](#ЗапускТестовИзJenkins)
+ [Сборка в Jenkins](#СборкаВJenkins)
+ [Запуск задачи в Jenkins с параметрами](#ЗапускЗадачиВJenkinsСПараметрами)
+ [Отчет о результатах прохождения тестов в Allure Report](#ОтчетОРезультатахПрохожденияТестовВAllureReport)
+ [Allure TestOps отчет](#AllureTestOpsОтчет)
+ [Оповещение в Telegram](#ОповещениеВTelegram)
+ [Интеграция с Jira](#ИнтеграцияСJira)
+ [Видео о прохождении тестов](#ВидеоОПрохожденииТестов)

# <a name="ИспользуемыеТехнологии">Используемые технологии</a>

<p align="center">
<img width="6%" title="IntelliJ" src="images/logo/IntelliJ.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="GitHub" src="images/logo/github.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Allure TestOps" src="images/logo/AllureTestOps.svg">
<img width="6%" title="Allure Report" src="images/logo/AllureReport.svg">
<img width="6%" title="Jira Cloud" src="images/logo/Jira.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
</p>

# <a name="РеализацияПроверок">Реализация проверок</a>

> Проверка поиска вакансии с заданным параметром поиска
> 
> Проверка принадлежности вакансии заданному городу
> 
> Проверка принадлежности вакансии заданной компании
> 
> Проверка наличия ошибок в консоли
> 


# <a name="ЗапускТестовЛокально">Запуск тестов локально</a>

```bash
gradle clean test
```

# <a name="ЗапускТестовИзJenkins">Запуск тестов из Jenkins</a>

```bash
clean
test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserMobileView="${BROWSER_MOBILE}"
-DremoteDriverUrl=https://user1:1234@${REMOTE_DRIVER_URL}/wd/hub/
-DvideoStorage=https://${REMOTE_DRIVER_URL}/video/
-Dthreads=${THREADS}
```

# <a name="СборкаВJenkins">Сборка в Jenkins</a>

<p align="center">
  <img src="images/screens/JenkinsJob.jpg" alt="job" width="800">
</p>


# <a name="ЗапускЗадачиВJenkinsСПараметрами">Запуск задачи в Jenkins с параметрами</a>


<p align="center">
  <img src="images/screens/JenkinsPreference.png" alt="job" width="800">
</p>

# <a name="ОтчетОРезультатахПрохожденияТестовВAllureReport">Отчет о результатах прохождения тестов в Allure Report</a>


Общее представление о прохождении тестов с дэшбордами и виджетами: 

<p align="center">
  <img src="images/screens/AllureOverview.png" alt="job" width="800">
</p>

Тест кейсы в Allure Report:

<p align="center">
  <img src="images/screens/AllureTestCases.png" alt="job" width="800">
</p>

#### Тестовые артефакты:

> - Набор тест кейсов
> - Screenshot
> - Page Source
> - Video

<p align="center">
  <img src="images/screens/AllureResult.png" alt="job" width="800">
</p>


<p align="center">
  <img src="images/screens/AllureGraphs.png" alt="job" width="800">
</p>


# <a name="AllureTestOpsОтчет">Allure TestOps отчет</a>

Тест кейсы в Allure TestOps:

<p align="center">
  <img src="images/screens/TestCasesTestOps.png" alt="job" width="800">
</p>

# <a name="ОповещениеВTelegram">Оповещение в Telegram</a>

Отправка уведомлений о результатах прохождения тестов осуществляется с помощью Telegram бота.

<p align="center">
  <img src="images/screens/TelegramBot.png" alt="job" width="800">
</p>

# <a name="ИнтеграцияСJira">Интеграция с Jira</a>
Интеграция с Jira позволяет отследить результаты прохождения тестов.

<p align="center">
  <img src="images/screens/TestCasesJira.png" alt="job" width="800">
</p>

# <a name="ВидеоОПрохожденииТестов">Видео о прохождении тестов</a>

<p align="center">
<img title="Video Result" src="images/video/VideoResults.gif" width="250" height="153"  alt="video">
</p>