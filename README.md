# Selenium E-commerce Test Automation Framework

## 📌 Overview
This is a complete **Selenium-based test automation framework** for E-commerce applications, designed for efficient and scalable testing. It leverages **TestNG, Maven, and the Page Object Model (POM)** to ensure maintainability and reusability.

## 🚀 Features
- **Test Automation with Selenium WebDriver**
- **TestNG Integration for Test Execution & Reporting**
- **Page Object Model (POM) for Better Maintainability**
- **Maven for Dependency Management**
- **Log4j for Logging**
- **Extent Reports for Detailed Test Reports**
- **CI/CD Ready** (Can be integrated with Jenkins)

## 🛠️ Setup & Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/selenium-ecommerce-framework.git
   ```
2. Navigate to the project directory:
   ```sh
   cd selenium-ecommerce-framework
   ```
3. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```
4. Run the test suite:
   ```sh
   mvn test
   ```

## 📂 Project Structure
```
selenium-ecommerce-framework/
│── src/
│   ├── main/java/
│   │   ├── pages/          # Page Object Model classes
│   │   ├── utilities/      # Utility classes (e.g., WebDriver management)
│   ├── test/java/
│   │   ├── tests/          # Test cases
│   │   ├── testdata/       # Test data files
│── pom.xml                 # Maven configuration file
│── testng.xml              # TestNG suite configuration
│── logs/                   # Log files
│── reports/                # Test reports (Extent Reports)
```

## 📊 Reporting
- **TestNG Reports**: Generated after test execution.
- **Extent Reports**: Found under the `reports/` directory with detailed execution logs.

## 🔗 CI/CD Integration
This framework can be easily integrated with **Jenkins, GitHub Actions, or other CI/CD tools** for automated test execution.

## 👨‍💻 Contributing
Feel free to fork this repository and submit pull requests to improve the framework!

