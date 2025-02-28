# Luma - E-commerce Website

## Overview
This project automates the testing of an e-commerce website named **Luma**. It follows a structured approach to validate the end-to-end flow from the homepage to payment completion and back to the homepage. The project supports multiple environments and browsers, utilizes best practices, and generates comprehensive reports.

## Test Flow
The automation suite covers the following flow:
1. **Homepage**: Validate UI elements and responsiveness.
3. **Homepage (Post-Login)**: Validate user authentication and redirection.
4. **Search Page**: Test product search functionality.
5. **Product Page**: Verify product listing and details.
6. **View Specific Product Page**: Validate product details, images, and descriptions.
7. **Cart Page**: Add, remove, and update product quantities.
8. **Checkout Page**: Validate order summary and checkout process.

## Features Implemented
- **Valid and Invalid Data Testing**
- **Fluent Wait with Intervals** (Utility for handling dynamic elements efficiently)
- **Best Practices in Test Automation**
- **Builder Design Pattern** (For scalable and reusable test data creation)
- **Data Provider** (Parameterized testing for various test cases)
- **Java Faker** (Random data generation for robust testing)
- **Hard and Soft Assertions** (Ensuring thorough test validations)
- **Extent Reports & Allure Reports** (Comprehensive test reporting)
- **Multi-Environment Support** (Dev, QA, Staging, Production)
- **Multi-Browser Testing** (Chrome, Firefox, Edge, Safari)
- **Parallel Execution** (Optimized test execution across multiple threads)

## Project Structure
```
LumaEcommerceWebsite2/
│-- src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── config/        # Environment configurations
│   │   │   ├── pages/         # Page Object Models (POM)
│   │   │   ├── utils/         # Utility classes (Waits, Data Providers, etc.)
│   │   │   ├── builders/      # Test data builder pattern
│   │   ├── resources/        # Configurations & test data files
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/        # Test cases
│   │   │   ├── base/         # Test base setup (Hooks, Listeners)
│   │   ├── resources/        # Test configuration files
│-- reports/
│   ├── allure-results/       # Allure report data
│   ├── extent-reports/       # Extent reports output
│-- testng.xml                # TestNG configuration for parallel execution
│-- pom.xml                    # Maven dependencies & plugins
```

## Setup & Execution
### Prerequisites
- Install **Java 19+**
- Install **Maven**
- Install **Allure** (for reporting)
- Configure **Selenium WebDriver**
- Set up **TestNG** for test execution

### Running Tests
Run the complete suite:
```sh
**mvn clean test**
```
Run tests in parallel:
```sh
mvn clean test -Dtestng.xml
```
Generate Allure report:
```sh
allure serve allure-results
```

## Reporting
- **Extent Report**: Located in `reports/extent-reports/`
- **Allure Report**: Located in `reports/allure-results/`, use `allure serve` to visualize
- **Screenshots for Allure Report**:
- ![Screenshot (398)](https://github.com/user-attachments/assets/2787f95e-9486-436d-909c-b598e1de1053)
- ![Screenshot (399)](https://github.com/user-attachments/assets/e9406028-7324-4dc2-b0e1-3496712ea3e6)



## Contribution
- Follow Page Object Model (POM) best practices.
- Write clear and reusable utility methods.
- Ensure parallel execution is stable before committing changes.
- Keep test data organized and configurable.
## video for the project 
**Video Link**: https://drive.google.com/file/d/1JI2iBfvDv4Cldrd9rvb2udnCiTvaqquY/view?usp=sharing
