# OrangeHRM_Automation

This repository contains an automated test framework for the [OrangeHRM demo site](https://opensource-demo.orangehrmlive.com), primarily built using Java, Selenium WebDriver, TestNG, and Maven. The goal is to automate functional testing of OrangeHRM features, report results, and streamline browser-based regression suites.

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Execution](#execution)
- [Reporting](#reporting)
- [Dependencies](#dependencies)

## Features

- Automated login functionality & test scenarios for OrangeHRM
- WebDriver & browser management via WebDriverManager
- Data-driven testing using Apache POI (Excel)
- Screenshots on failure (saved to `/reports/screenshots/`)
- Allure reporting integration
- Central test configuration using TestNG
- Logging with Log4j2

## Project Structure

```
.
├── .github/             # GitHub workflows & assets
├── .idea/               # IDE configuration (IntelliJ)
├── lib/                 # External libraries (if any)
├── allure-results/      # Allure report output
├── src/
│   ├── main/            # Main automation source code
│   └── test/            # Test scripts, resources, testdata
├── config.properties    # Environment and framework configuration
├── pom.xml              # Maven project definition & dependencies
├── testng.xml           # TestNG test suite configuration
├── .gitignore           # Untracked files
```

## Getting Started

1. **Clone the Repo**
    ```sh
    git clone https://github.com/sanjaytk01/OrangeHRM_Automation.git
    cd OrangeHRM_Automation
    ```

2. **Install Java (17+) and Maven**

3. **Download browser drivers if not auto-managed by WebDriverManager**

## Configuration

The `config.properties` file defines test environment and framework settings:
```ini
baseURL=https://opensource-demo.orangehrmlive.com
adminUsername=Admin
adminPassword=admin123
browser=chrome
timeout=20
excelPath=./src/test/resources/testdata/EmployeeData.xlsx
screenshotPath=./reports/screenshots/
```

## Execution

- **Run all tests:**

    ```sh
    mvn clean test
    ```

Test are run according to the TestNG suite configuration in [`testng.xml`](https://github.com/sanjaytk01/OrangeHRM_Automation/blob/master/testng.xml), which defines test groups and sequences.

## Reporting

- **Allure Reports:** After test execution, reports are generated in `allure-results/`. To view:
    ```sh
    allure serve allure-results
    ```
- **Screenshots:** On failures, screenshots are saved to `./reports/screenshots/`.

## Dependencies

All dependencies are managed in [`pom.xml`](https://github.com/sanjaytk01/OrangeHRM_Automation/blob/master/pom.xml), including:
- Selenium WebDriver (Browser automation)
- WebDriverManager (Driver management)
- TestNG (Test orchestration)
- Apache POI (Excel for data-driven tests)
- Allure (Reporting)
- Log4j2 (Logging)
- Commons IO (Screenshots)

---

For questions or contributions, feel free to open an issue or pull request!
