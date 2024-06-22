# GENERATE RANDOM DATE UI TEST AUTOMATION <br/>


 This repository contains automated UI tests using the  **Selenium - Cucumber BDD - JUnit** framework.<br/> The tests are organized into packages for ease of use and maintainability.

-Java 21<br/>

-Build Tool : Maven<br/>

-UI Address : https://codebeautify.org/generate-random-date<br/>


**-test**: This directory contains all our test-related code and resources.

**-pages**: Page Object classes are stored here. Locators and some methods are stored here as well.

**-runners**: These classes configure and run Cucumber tests.

**-stepDefinitions**: These classes contain the actual code to implement the steps defined in feature files.

**-utility**: Utility classes that assist in various testing tasks, such as Driver,ReusableMethods and configurationReader, are stored here.

**-features**: This directory holds our Gherkin feature files, where define test scenarios in a human-readable format.

**-target**: When we run our tests, some reports create in target file such as ExtentPdf and SparkReport.

**-pom.xml**: This is the Maven project configuration file that specifies dependencies and other project settings.
