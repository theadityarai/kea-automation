# Kea Automation Framework

## Overview

Kea Automation Framework is a Java-based Selenium Test Automation framework designed for a **Healthcare SaaS web application**. The framework is built with **stability, scalability, and parallel execution** as first-class concerns and follows strict separation of responsibilities to meet MNC product standards.

This repository represents a **baseline, production-ready automation framework** intended to be extended feature-by-feature without architectural drift.

---

## Key Objectives

* Web UI automation only (no API / mobile)
* Support Smoke, Sanity, Regression, and E2E testing
* Parallel execution from Day-1
* Multi-browser & multi-environment execution
* CI/CD readiness (Jenkins planned)
* Clean, maintainable, and testable architecture

---

## Tech Stack

* Java 17
* Selenium WebDriver 4.x
* TestNG
* Maven
* Extent Reports
* log4j2
* Eclipse IDE

---

## Project Structure (High Level)

* `src/main/java` → Core framework (driver, config, reporting, utils)
* `src/test/java` → Test layer (BaseTest, pages, test cases)
* `src/test/resources` → Configurations, test data, TestNG XMLs

> Folder structure is intentionally fixed and should not be modified unless explicitly approved.

---

## Execution Control (Hybrid)

Execution configuration follows a strict priority order:

1. TestNG XML parameters
2. `run-config.properties`
3. Environment-specific property files (`qa.properties`, `dev.properties`)

No browser or environment is hardcoded in code or tests.

---

## Design Principles

* ThreadLocal WebDriver (parallel-safe)
* No WebDriver creation in tests or pages
* Pages contain no assertions
* Tests contain no driver or config logic
* No static waits or hardcoding

---

## Getting Started

Refer to:

* `docs/Setup_Guide.md`
* `docs/Execution_Guide.md`

---

## Status

This framework is a **stable baseline**. New features will be added incrementally in controlled phases.

---

