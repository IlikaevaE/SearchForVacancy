# Проект автоматизированного поиска вакансии на hh.ru
## :bookmark_tabs: Основной контент: 
> :grey_exclamation: [Используемые технологии](#computer-mag_right-используемые-технологии)
> 
> :radio_button: [Реализация проверок](#ballot_box_with_check-реализация-проверок)
> 
> :radio_button: [Команда запуска тестов локально в IntelliJ в терминале](#arrow_forward-команда-запуска-тестов-локально-в-IntelliJ-в-терминале)
> 
> :grey_exclamation: [Команда запуска тестов удаленно в Jenkins](#repeat_one-команда-запуска-тестов-удаленно-в-Jenkins) 
> 
> :grey_exclamation: [Параметры в Jenkins](#-параметры-в-Jenkins)
> 
> :grey_exclamation: [Сборка в Jenkins](#-сборка-в-Jenkins)
> 
> :grey_exclamation: [Allure отчет](#orange_square-allure-отчет)
> 
> :grey_exclamation: [Allure TestOps отчет](#green_square-allure-testOps-отчет)
> 
> :grey_exclamation: [Отчет о прохождении тестов в Telegram](#-отчет-о-прохождении-тестов-в-telegram)
> 
> :grey_exclamation: [Интеграция Allure TestOps с Jira(Ticket Tracking Tool)](#-интеграция-allure-testOps-с-jira(Ticket Tracking Tool))
 
# :computer: :mag_right: Используемые технологии

# :ballot_box_with_check: Реализация проверок

# :arrow_forward: Команда запуска тестов локально в IntelliJ в терминале

# :repeat_one: Команда запуска тестов удаленно в Jenkins

# Параметры в Jenkins

# Сборка в Jenkins

# :orange_square: Allure отчет

# :green_square: Allure TestOps отчет

# Отчет о прохождении тестов в Telegram

# Интеграция Allure TestOps с Jira(Ticket Tracking Tool)

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
