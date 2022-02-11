# QaseTest
Test Automation framework for Qase.io project

#CHECKLIST
- Login
- Creation of Milestone
- Creation of new project
- Creation of new test-cases
- Creation of new defects
- Creation of test suite
- Creation of test plan
- Creation of milestone
  Creation of test run

#PRE-CONDITIONS
- Maven 3
- Java 8
- Chrome Driver

#TECHNOLOGIES/LIABRARIES

- TestNG
- Maven
- Selenium

#TIPS AND TRICKS
//именование бранчей:
//feature/ITA-1-page-object
//bugfix/ITA-2-npe-fix - фиксим баг или добавляем фичу. Номер тикета. Краткое описание маленькими буквами через тире

feature/ITA-12-testng
commit example: [ITA-12] removed sout

//TODO
// Что должно быть во фреймворке:
//        - Allure - скриншотинг и steps pattern
//        - CircleCI интеграция
//        - API тесты

Запуск тестов через maven: 
mvn clean test - запуск всех тестов
mvn clean test -Dtest=DefectTest - запуск всех тестов из класса DefectTest
mvn clean test -Dtest=DefectTest#createNewDefectWithoutAttachment - запуск теста createNewDefectWithoutAttachment из класса DefectTest
mvn clean test -Dtest=DefectTest#createNewDefectWithoutAttachment+createNewDefectWithoutAssigneeAndAttachment - запуск тестов createNewDefectWithoutAttachment и createNewDefectWithoutAssigneeAndAttachment из класса DefectTest

/*
git branch *feature/8-tests
git add .
git status
git tag v1.5
git commit -am ' text of message'
git push --set-upstream origin fix/8-tests
 */
//https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06