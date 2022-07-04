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
> :radio_button: [***Параметры в Jenkins***](#label-параметры-в-jenkins)
> 
> :radio_button: [***Сборка в Jenkins***](#package-сборка-в-jenkins)
> 
> :radio_button: [***Allure отчет***](#bar_chart-allure-отчет)
> 
> :radio_button: [***Allure TestOps отчет***](#chart_with_upwards_trend-allure-testOps-отчет)
> 
> :radio_button: [***Отчет о прохождении тестов в Telegram***](#envelope-отчет-о-прохождении-тестов-в-telegram)
> 
> :radio_button: [***Интеграция Allure TestOps с Ticket Tracking Tool Jira***](#link-интеграция-allure-testOps-с-ticket-tracking-tool-jira)
 
# :computer: :mag_right: Используемые технологии
<p align="center">
<img width="6%" title="Allure Report" src="images/logo/Allure.svg">

</p>

# :ballot_box_with_check: Реализация проверок

# :arrow_forward: Команда запуска тестов локально в IntelliJ в терминале

```bash
gradle clean test
```

# :repeat_one: Команда запуска тестов удаленно в Jenkins

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

# :label: Параметры в Jenkins

# :package: Сборка в Jenkins

# :bar_chart: Allure отчет

# :chart_with_upwards_trend: Allure TestOps отчет

# :envelope: Отчет о прохождении тестов в Telegram

# :link: Интеграция Allure TestOps с Ticket Tracking Tool Jira

<a target="_blank" href="https://allure.autotests.cloud/project/%s">allure.autotests.cloud/project/%s</a> (ask admin@qa.guru for access)

# Jenkins job
<a target="_blank" href="https://jenkins.autotests.cloud/job/%s">jenkins.autotests.cloud/job/%s</a>


# USAGE examples

### For run remote tests need fill remote.properties or to pass value:

* browser (default chrome)
* browserVersion (default 89.0)
* browserSize (default 1920x1080)
* browserMobileView (mobile device name, for example iPhone X)
* remoteDriverUrl (url address from selenoid or grid)
* videoStorage (url address where you should get video)
* threads (number of threads)


Run tests with filled remote.properties:
```bash
gradle clean test
```

Run tests with not filled remote.properties:
```bash
gradle clean -DremoteDriverUrl=https://%s:%s@selenoid.autotests.cloud/wd/hub/ -DvideoStorage=https://selenoid.autotests.cloud/video/ -Dthreads=1 test
```

Serve report:
```bash
allure serve build/allure-results
```


###### For further development there are some example tests in src/test/java/cloud.autotests/tests/demowebshop
* remove @Disabled("...") annotation to run tests
```bash
gradle clean demowebshop
```

:heart: <a target="_blank" href="https://qa.guru">qa.guru</a><br/>
:blue_heart: <a target="_blank" href="https://t.me/qa_automation">t.me/qa_automation</a>
