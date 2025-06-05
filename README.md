# N26 Challenge

- [N26 Challenge](#n26-challenge)
    - [Intro](#intro)
    - [Setup](#setup)
    - [Running tests](#running-tests)
    - [Testing design](#testing-design)

## Intro

This document guides the user through the installation of the required tools, and the procedure to run the tests and generate test report.

It is intended to be run on Mac OS (the project has been developed on Mac OS v14.6.x).

## Setup

Requirements:

- Java JDK: Used the Temurin JDK 17 distribution; download from [the official website](https://adoptium.net/temurin/releases/?os=any&arch=any&version=17)
- Maven: Install via Brew (terminal): `brew install maven`
- Android Studio: Download from the [official Android website](https://developer.android.com/studio)
- Virtual Device: From Android Studio, open action `AVD Manager` -> `Create Virtual Device…`, with specs:
    - Name: `Pixel 5 API 30`
    - Resolution: `1080×2340 440dpi`
    - API: `30`
    - Target: `Android 11`
    - CPU/ABI: `x86`
    - Install Monefy app on virtual device
- Appium: Install via npm (terminal): `npm -i --location=global appium`
- UiAutomator 2: Install via Appium (terminal): `appium driver install uiautomator2`
- Set up Petstore environment as explained in [this guide](https://github.com/swagger-api/swagger-petstore?tab=readme-ov-file)

## Running tests

Preparation:

- Start appium from the terminal:
  ```sh
  $ appium
  ```
- Open Android Studio -> `AVD Manager` -> Start device by clicking on the playback button

In order to run the Android tests, run from the terminal:

```sh
$ mvn -Dtest=com.monefy.*Test clean test
```

In order to run API tests, run from the terminal:

```sh
$ mvn -Dtest=io.swagger.petstore.*Test clean test
```

In order to generate test report which opens report automatically in a browser:

```sh
$ mvn allure:serve
```
or this command, which will store Allure report at `target/site/allure-maven-plugin`:

```sh
$ mvn allure:report
```

## Testing design

This test suite has been designed using two established patterns:

- **Page Object:** allows decomposing the application in pages, and map the same architecture in the code, so that there is a very intuitive view on the application from the testing perspective
- **Fluent Design:** allows chaining of functions emulating user action in any order, which improves the flexibility of the test scenarios, and makes the code look like natural language

## Choice of tools:

### For Android tests

- **Selenide Appium:** has been chosen because it has many ready-to-use tools, and implemented waiters, for making development faster, which allows the QA engineer to focus on testing logic; the alternative Selenium Appium framework offers considerably less higher-level APIs, requiring a longer time to have the project ready for test development.
- **JUnit 5:** was chosen because it is more modern, easier to extend, and has useful features like parameterized tests built in. Compared to TestNG, it works better with new Java tools and is a better choice for future projects.

### For API coverage

- **Rest Assured:** besides that fact that this tool is one of the ones used in N26 testing setup, it was chosen because it makes API testing for RESTful services easy and readable. With built-in support for JSON and XML and compatibility with Hamcrest matchers it has a great combo for Java ecosystem with useful assertions. Compared to other tools, it demands less setup and has human-readable gherkin style to follow the testing logic when build coverage.
- **Lombok:** was chosen as it helps to reduce boilerplate code like getters, setters, constructors, and more which saves time and makes JSON object classes easier to read and maintain. Also, it is a great combo with IntelliJ **Robo Pojo Generator** plugin which helps to save even more time when working with JSON objects.
- **Java Faker:** was chosen as it easily generates fake realistic data like names, emails, phone numbers, and addresses. It saves time and improves test reliability.

### For test report

- **Allure:** was chosen as it's nicely compatible with Selenide Appium, JUnit5 and Rest Assured and can be easily generated after the test run. It provides well-structured visual test reports, can contain screenshot attachments on failed test steps, makes it easy to provide readable description for tests and used data for reducing time for debugging. 

![Screenshot 2025-06-05 at 12.07.22.png](Screenshot%202025-06-05%20at%2012.07.22.png)
![Screenshot 2025-06-05 at 20.43.18.png](Screenshot%202025-06-05%20at%2020.43.18.png)