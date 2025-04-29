# AutomationLabCodenBoxFinal

This is a test automation project using **Selenium WebDriver** with **TestNG** for interacting with various web elements on [CodenBox Automation Lab Practice Page](https://codenboxautomationlab.com/practice/). The project is implemented in **Java** and uses **Microsoft Edge** as the browser driver.

## 🔧 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- EdgeDriver (Microsoft Edge)
- Maven (recommended for build management)

---

## 🚀 Features Covered

This project includes automated test cases for the following UI interactions:

- ✅ Radio button selection
- ✅ Dynamic dropdown selection (auto-suggest)
- ✅ Static dropdown selection (select tag)
- ✅ Checkbox interaction
- ✅ Switching between windows and browser tabs
- ✅ Alert and confirmation box handling
- ✅ Table data parsing
- ✅ Element visibility and display handling
- ✅ Mouse hover actions
- ✅ iFrame interaction
- ✅ File download test

> **Note**: Most tests are currently disabled via `enabled = false`. You can enable individual tests by setting `enabled = true`.

---

## 🧪 How to Run

### 1. Prerequisites
- JDK 8 or higher
- Maven
- Edge browser installed
- Edge WebDriver compatible with your browser version

### 2. Clone the Repository

```bash
git clone https://github.com/your-username/AutomationLabCodenBoxFinal.git
cd AutomationLabCodenBoxFinal
```

### 3. Run the Tests

You can run the tests using TestNG in your IDE (e.g., Eclipse or IntelliJ), or via Maven (if configured):

```bash
mvn test
```

> Make sure the `AppTest.java` class is configured as a TestNG test suite.

---

## 📁 Project Structure

```
AutomationLabCodenBoxFinal/
└── src/
    └── test/
        └── java/
            └── AutomationLabCodenBoxFinal/
                └── AppTest.java   # Main test class with test cases
```