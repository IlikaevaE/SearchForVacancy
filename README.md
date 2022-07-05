# Проект автоматизированного поиска вакансии на hh.ru
## :bookmark_tabs: Основной контент: 
> :radio_button: [***Используемые технологии***](#computer-mag_right-используемые-технологии)
> 
> :radio_button: [***Реализация проверок***](#ballot_box_with_check-реализация-проверок)
> 
> :radio_button: [***Команда запуска тестов локально в IntelliJ в терминале***](#arrow_forward-команда-запуска-тестов-локально-в-IntelliJ-в-терминале)
> 
> :radio_button: [***Команда запуска тестов удаленно в Jenkins***](#repeat_one-команда-запуска-тестов-удаленно-в-Jenkins) 
> 
> :radio_button: [***Сборка в Jenkins***](#package-сборка-в-jenkins)
> 
> :radio_button: [***Запуск с параметрами в Jenkins***](#label-запуск-с-параметрами-в-jenkins)
> 
> :radio_button: [***Allure отчет***](#bar_chart-allure-отчет)
> 
> :radio_button: [***Allure TestOps отчет***](#chart_with_upwards_trend-allure-testOps-отчет)
> 
> :radio_button: [***Отчет о прохождении тестов в Telegram***](#envelope-отчет-о-прохождении-тестов-в-telegram)
> 
> :radio_button: [***Интеграция Allure TestOps с Ticket Tracking Tool Jira***](#link-интеграция-allure-testOps-с-ticket-tracking-tool-jira)
 
## :computer: :mag_right: _Используемые технологии_
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

## :ballot_box_with_check: _Реализация проверок_
### :bulb: Проверка перехода на заданную страницу
### :bulb: Проверка нахождение вакансии с нужным именем 
### :bulb: Проверка принадлежности вакансии заданному городу
### :bulb: Проверка принадлежности вакансии заданной компании
### :bulb: Проверка наличия ошибок в консоли

## :arrow_forward: _Команда запуска тестов локально в IntelliJ в терминале_

```bash
gradle clean test
```

## :repeat_one: _Команда запуска тестов удаленно в Jenkins_

> _Для Запуска тестов удаленным путем используется настраиваемые параметры в Jenkins:_  

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
## :package: _Сборка в Jenkins_

<p align="center">
  <img src="images/screens/JenkinsJob.jpg" alt="job" width="800">
</p>

## :label: _Запуск с параметрами в Jenkins_

<p align="center">
  <img src="images/screens/JenkinsPreference.jpg" alt="job" width="800">
</p>

## :bar_chart: _Allure отчет_

## :chart_with_upwards_trend: _Allure TestOps отчет_

## :envelope: _Отчет о прохождении тестов в Telegram_
> _С помощью созданного бота в Телеграм приходят уведомления о результат прохождения тестов_

<p align="center">
  <img src="images/screens/TelegramBot.jpg" alt="job" width="800">
</p>

## :link: _Интеграция Allure TestOps с Ticket Tracking Tool Jira_
> _Благодаря интеграции Allure TestOps с Jira Cloud тестовые случаи и отчет о прохожденни тестов из Allure TestOps можно отобразить в Jira Cloud._
<p align="center">
  <img src="images/screens/TestCasesJira.jpg" alt="job" width="800">
</p>






<a target="_blank" href="https://allure.autotests.cloud/project/%s">allure.autotests.cloud/project/%s</a> (ask admin@qa.guru for access)

# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/%s">jenkins.autotests.cloud/job/%s</a>



### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)




###### For further development there are some example tests in src/test/java/cloud.autotests/tests/demowebshop
* remove @Disabled("...") annotation to run tests
```bash
gradle clean demowebshop
```

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
