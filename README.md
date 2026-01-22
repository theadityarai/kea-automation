# Kea Automation Framework

Enterprise-grade Java Selenium Test Automation Framework for web applications.

This framework is designed to be:
- Config-driven (browser & environment)
- Easy to onboard new QA engineers
- CI/CD ready (Jenkins compatible)
- Scalable for large test suites

---

## Tech Stack
- Java 17
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- log4j2

---

## Project Structure

src/main/java
└── com.keanest.framework
├── base
├── config
├── driver
├── exceptions
├── logger
├── reports
├── retry
└── utils

src/test/java
└── com.keanest.tests
├── pages
└── testcases

src/test/resources
├── config
├── testdata
└── testng

