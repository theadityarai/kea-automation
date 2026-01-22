# Setup Guide

## Prerequisites

* Java 17 installed
* Maven installed
* Eclipse IDE (recommended)
* Git

---

## Project Setup

1. Clone the repository

```
git clone https://github.com/theadityarai/kea-automation.git
```

2. Import into Eclipse

* File → Import → Existing Maven Project
* Select project root

3. Verify Maven dependencies

```
mvn clean test
```

---

## Configuration Setup

### run-config.properties

Defines default execution values:

* browser
* environment

### Environment Files

* `qa.properties`
* `dev.properties`

Contain environment-specific URLs and settings.

---

## IDE Execution

* Right-click TestNG XML → Run As → TestNG Suite
* Or run individual tests via TestNG

---

## Validation Checklist

* Browser launches correctly
* Correct environment URL loads
* No hardcoded values detected

---

## Common Issues

* Java version mismatch
* Missing Maven dependencies
* Incorrect TestNG configuration

---

Framework is now ready for development and execution.
