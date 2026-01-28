# Guru99 Selenium Automation Framework (Java + TestNG + POM)

This project is a Selenium Automation Testing Framework built using **Java**, **TestNG**, and the **Page Object Model (POM)** design pattern.
It automates the main features of the Guru99 Demo Banking website:

🔗 Website: https://demo.guru99.com/V4/

---

## 📌 Project Features (What this framework tests)

### ✅ 1) Login Feature
- Open login page
- Enter valid User ID & Password
- Click Login
- Verify user is redirected to Home Page successfully (Manager ID is displayed)

Test file:
- `tests/LoginTest.java`

---

### ✅ 2) Verify Home Page Feature
- Validate important elements exist after login:
  - Manager ID text
  - Welcome message
  - Page title

Test file:
- `tests/VerifyHomePageTest.java`

---

### ✅ 3) Create New Customer Feature
- Navigate to **New Customer**
- Fill customer form fields:
  - Customer Name
  - Gender
  - Date of Birth
  - Address
  - City
  - State
  - PIN
  - Mobile
  - Email (generated unique to avoid duplicates)
  - Password
- Submit form
- Verify customer created successfully
- Capture Customer ID

Test file:
- `tests/NewCustomerTest.java`

Page file:
- `pages/NewCustomerPage.java`

---

### ✅ 4) Create New Account Feature
- Navigate to **New Account**
- Enter:
  - Customer ID
  - Account Type
  - Initial Deposit
- Submit form
- Verify account created successfully
- Capture Account ID

Test file:
- `tests/NewAccountTest.java`

Page file:
- `pages/NewAccountPage.java`

---

### ✅ 5) Logout Feature
- Click Logout
- Handle logout confirmation alert
- Verify user is logged out successfully

Test file:
- `tests/LogoutTest.java`

Page file:
- `pages/LogoutPage.java`

---

### ✅ 6) Full Cycle Feature (End-to-End Flow)
This test executes the full scenario in one flow:

1. Login
2. Create New Customer
3. Capture Customer ID
4. Create New Account using Customer ID
5. Capture Account ID
6. Logout

Test file:
- `tests/FullCycleTest.java`

---



## 🧰 Technologies Used
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- IntelliJ IDEA


