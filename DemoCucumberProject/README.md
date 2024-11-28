# Demo-Cucumber-Project
# Selenium Test Automation with Cucumber

## Overview
This project demonstrates **Selenium Test Automation** using the **Cucumber** BDD framework with **JUnit**. 
It supports browser-based UI testing for the OrangeHRM demo site, including features like login,dropdown interaction, table verification, and dynamic row-column handling.


## Project Structure

### 1. **BaseClass**
   - Manages WebDriver setup and teardown for browser sessions.
   - Loads configuration properties (e.g., `chromedriverPath`, credentials).
   - Supports cross-browser testing by extending browser initialization.

### 2. **LoginPage**
   - Handles the Login functionality on the OrangeHRM demo site.
   - Key Features:
     - Enter username and password.
     - Validate login success or failure messages.
     - Handles timeouts and unexpected error scenarios.

### 3. **DDandTablePage**
   - Handles interactions with the **Admin module** page elements.
   - Features:
     - Dropdown interaction.
     - Table data verification and column-based filtering.
     - Dynamically fetches row and column counts.

### 4. **Step Definitions**
   - Implements step definitions for Cucumber feature files.
   - Automates the user journey for searching users in the Admin module.
   - Verifies table column data and calculates row counts.

### 5. **Test Runner**
   - Executes all Cucumber feature files.
   - Generates detailed Extent reports.

---

## Features

1. **Login Functionality Validation**:
   - Validates login success and failure using dynamic credentials.
   - Verifies success via the presence of the dashboard or error message.

2. **Dropdown and Table Interaction**:
   - Interact with dynamic dropdowns.
   - Verify column data and count table rows.

3. **Cross-Browser Support**:
   - Run tests on multiple browsers like Chrome and Firefox.

4. **Jenkins Integration**:
   - Supports execution through a Jenkins pipeline.
     
---

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) installed.
- Maven installed for dependency management.
- Selenium WebDriver for browser automation.
- Git installed for version control.

---
