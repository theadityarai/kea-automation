# Parallel Execution Design

## Objective

Enable safe and predictable parallel execution from Day-1 without test interference.

---

## Core Principle

Each test thread must have its own isolated WebDriver instance.

This is achieved using **ThreadLocal**.

---

## WebDriver Management

* WebDriver instances are stored in ThreadLocal
* Driver lifecycle is managed centrally
* Tests and pages only retrieve the driver

Key Classes:

* `DriverManager`
* `DriverFactory`

---

## TestNG Configuration

* Parallel execution is enabled at suite level
* Thread count is configurable via TestNG XML

---

## Reporting in Parallel

* ExtentTest is also ThreadLocal
* Prevents report corruption
* Each test thread writes independently

---

## Safety Rules

* No static WebDriver
* No shared mutable state
* No sleeps for synchronization

---

## CI Readiness

* Designed to scale on Jenkins agents
* Supports increased thread count without code changes
