# mortgage-calculator

### 1. Understanding And Breaking Down The Requirements
- [Mortgage Vs Lender](https://drive.google.com/file/d/1aTzuKJjPKleCiH0P_eeVcH2RTi-A5yZl/view?usp=sharing)
- [Test Table](https://docs.google.com/spreadsheets/d/1ylQhPdgWgxmX1WwW-__SO05X9HXZVLSAV20Pj83LbY0/edit?usp=sharing)

### 2. Setting Up The _Playwright_ Project

- Follow the [installation doc for Playwright using Java (maven)](https://playwright.dev/java/docs/intro)
  - Helpful read as well [Installing Maven](https://mkyong.com/maven/install-maven-on-mac-osx/)

### 3. Running The Tests

- Clone this repository and complete the setup documentation here as guidance **_Setting Up The _Playwright_ Project_**
- Tests can be found under the `src/main/java/tests/hsbc.calculator.tests` for execution as per the [Running Tests](https://playwright.dev/java/docs/running-tests) documentation on the playwright.dev website.

## Notes:

- For this project I made use of [intelliJ](https://www.jetbrains.com/idea/download/#section=mac)
- I made use of macOS - but to get setup should be quite similar on Windows or Linux OS
- Java Version:
```
openjdk version "20.0.1" 2023-04-18
OpenJDK Runtime Environment (build 20.0.1+9-29)
OpenJDK 64-Bit Server VM (build 20.0.1+9-29, mixed mode, sharing)
```

## Next Steps:

- Input the tests into a CI/CD CRON job on Jenkins to allow for nightly tests to run
- Expand on more test scenarios -> jot down scenarios in testrail or another test management tool