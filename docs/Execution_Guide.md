# Execution Guide

## Supported Execution Modes

* Local execution via Maven
* IDE execution (Eclipse)
* CI execution (Jenkins ready)

---

## Execution Control Strategy

Execution is controlled using a **hybrid configuration approach** with strict priority:

1. TestNG XML parameters (highest priority)
2. `run-config.properties`
3. Environment-specific properties (`qa.properties`, `dev.properties`)

---

## Common Execution Parameters

* `env` → qa / dev
* `browser` → chrome / edge / firefox

---

## Running Tests via Maven

Example:

```
mvn test
```

To override values:

```
mvn test -Denv=qa -Dbrowser=chrome
```

---

## Running via TestNG XML

Each suite file defines scope and grouping:

* `smoke.xml`
* `sanity.xml`
* `regression.xml`
* `e2e.xml`

TestNG parameters can override configuration files when provided.

---

## Group-Based Execution

Supported TestNG groups:

* smoke
* sanity
* regression
* e2e
* module-based groups (login, dashboard, etc.)

---

## Parallel Execution

Parallel execution is enabled and safe by default using ThreadLocal WebDriver.
Refer to `Parallel_Execution_Design.md` for details.

---

## Important Rules

* Do not hardcode browser or environment
* Do not modify execution priority logic
* Do not disable ThreadLocal usage
