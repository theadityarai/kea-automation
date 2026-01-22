# Framework Overview

## Purpose

The Kea Automation Framework is designed to provide a **robust, maintainable, and parallel-ready** test automation foundation for a Healthcare SaaS web application.

The framework emphasizes:

* Clear separation of concerns
* Predictable execution behavior
* Minimal coupling between layers

---

## Layered Architecture

### 1. Test Layer (`src/test/java`)

Responsibilities:

* Define test scenarios
* Apply TestNG groups
* Control test flow only

Rules:

* Must not create or manage WebDriver
* Must not read configuration files
* Must not contain business logic

---

### 2. Page Layer (`pages`)

Responsibilities:

* Encapsulate UI interactions
* Represent application pages and components

Rules:

* No assertions
* No test logic
* No driver lifecycle management

---

### 3. Base Layer

* `BaseTest`: Manages test lifecycle (setup, teardown)
* `BasePage`: Provides common WebDriver utilities to pages

---

### 4. Driver Management Layer

* ThreadLocal WebDriver implementation
* Supports parallel execution
* Supports multi-browser execution

Key Classes:

* `DriverManager`
* `DriverFactory`

---

### 5. Configuration Layer

* Centralized configuration resolution
* Hybrid priority-based execution control

Key Classes:

* `ConfigReader`
* `EnvironmentConfig`

---

### 6. Reporting & Logging

* Centralized reporting via Extent Reports
* Centralized logging via log4j2
* Listeners manage cross-cutting concerns

---

## Non-Goals

* No BDD or Cucumber
* No API automation
* No mobile automation
* No PageFactory

---

This architecture is intentionally conservative to ensure long-term maintainability in a product environment.
