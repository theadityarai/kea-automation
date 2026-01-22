# Logging and Reporting

## Logging Strategy

The framework uses **log4j2** for centralized logging.

### Objectives

* Debug failures quickly
* Maintain readable execution logs
* Separate framework logs from test logic

### Rules

* No logging configuration inside tests
* Pages may log actions but not assertions
* Log configuration is centralized

---

## Reporting Strategy

Extent Reports is used for HTML reporting.

### Responsibilities

* Capture test status (pass/fail/skip)
* Attach screenshots on failure
* Provide execution summary

### Design

* Reporting is managed via TestNG listeners
* Tests do not directly interact with Extent APIs
* ThreadLocal ExtentTest ensures parallel safety

---

## Listener-Based Design

* `TestListener` handles reporting hooks
* Screenshot capture is triggered on failures
* Reporting lifecycle is independent of test logic

---

## CI Compatibility

* Reports are generated in a CI-friendly location
* No dependency on local machine paths

---

This design ensures reporting and logging remain cross-cutting concerns, not test responsibilities.
