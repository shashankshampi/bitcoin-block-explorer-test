<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/shashankshampi/blockstream-ui-automation">
    <img src="https://seeklogo.com/images/B/bitcoin-logo-BCFF2D1650-seeklogo.com.png" alt="Logo" width="100" height="100">
  </a>

<h3 align="center">Blockstream Explorer UI Automation</h3>

  <p align="center">
    UI Automation of Blockstream Bitcoin Explorer using Java, Selenium & TestNG
    <br />
    <a href="https://github.com/shashankshampi/blockstream-ui-automation"><strong>Explore the Code »</strong></a>
  </p>
</div>

---

## Table of Contents

- [Overview](#overview)
    - [Features](#features)
    - [Built With](#built-with)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
    - [Test Case 1: Validate Transaction Header](#test-case-1-validate-transaction-header)
    - [Test Case 2: Filter Specific Transactions](#test-case-2-filter-specific-transactions)
- [Validation](#validation)
- [Contact](#contact)

---

## Overview

This automation project validates the UI of a Bitcoin block page on Blockstream Explorer. It performs DOM-level validation and intelligent filtering using Selenium WebDriver and TestNG.

### Features

- 🔍 Transaction header validation for accurate count display
- 🎯 Dynamic filtering of transaction data based on inputs and outputs
- 📊 Rich test reporting using ExtentReports
- 🧱 Modular test architecture for readability and reuse
- ✅ Java 18 support with WebDriverManager for smooth driver handling

### Built With

* [![Java][java-badge]][java-url]
* [![Selenium][selenium-badge]][selenium-url]
* [![TestNG][testng-badge]][testng-url]
* [![ExtentReports][extent-badge]][extent-url]
* [![WebDriverManager][wdm-badge]][wdm-url]

---

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 18+
- Maven 3.6+
- Chrome browser

### Installation

Clone the repository:

git clone https://github.com/shashankshampi/blockstream-ui-automation
cd blockstream-ui-automation

Install dependencies and compile:

mvn clean compile
---

## Usage

Run all tests:

```
mvn test
```

Test reports will be available at:

/test-output/ExtentReports/index.html


### Test Case 1: Validate Transaction Header

> 📍 Visit [Block 680000](https://blockstream.info/block/000000000000000000076c036ff5119e5a5a74df77abf64203473364509f7732)  
> ✅ Assert the presence of text: `"25 of 2875 Transactions"`

Log Output:

✅ Transaction section heading found: "25 of 2875 Transactions"


### Test Case 2: Filter Specific Transactions

> ✅ Iterate over visible transactions  
> ✅ Print hash for those with **1 input** and **2 outputs**

Sample Output:

Transaction with 1 input and 2 outputs:
Hash: a1b2c3d4e5...
Hash: f6g7h8i9j0...

---

## Validation

Test reports are auto-generated after each run:

- ✅ Extent Report with screenshots
- ✅ Console logs for filtered hashes
- ✅ Assertions for all validations

> Navigate to `test-output/ExtentReports/` for a full test execution report.

---

## Contact

Created by:

- [@Shashank Sanket](mailto:shashank.sanket1995@gmail.com)

---

<!-- MARKDOWN LINKS & BADGES -->
[java-badge]: https://img.shields.io/badge/Java-18-blue.svg?logo=java
[java-url]: https://www.oracle.com/java/
[selenium-badge]: https://img.shields.io/badge/Selenium-4.33.0-43B02A?logo=selenium
[selenium-url]: https://www.selenium.dev/
[testng-badge]: https://img.shields.io/badge/TestNG-7.5-red.svg?logo=testng
[testng-url]: https://testng.org/
[extent-badge]: https://img.shields.io/badge/ExtentReports-5.0.9-purple.svg?logo=html5
[extent-url]: https://extentreports.com/
[wdm-badge]: https://img.shields.io/badge/WebDriverManager-6.1.0-35B5E5?logo=google-chrome
[wdm-url]: https://github.com/bonigarcia/webdrivermanager

<p align="right">(<a href="#readme-top">back to top</a>)</p>