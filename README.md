🧰 Tech Stack
Component	Tool/Library
💻 Language	Java
🧪 Framework	TestNG
🔨 Build Tool	Maven
🌐 Automation Tool	Selenium WebDriver
📊 Reporting	ExtentReports
🧱 Design Pattern	Page Object Model (POM)
📗 Test Data	Apache POI (Excel)

| Path                   | Description                                                                                        |
| ---------------------- | -------------------------------------------------------------------------------------------------- |
| `src/main/java/`       | Reserved for application code (not used in this automation project).                               |
| `src/main/resources/`  | Holds global resource files if needed.                                                             |
| `src/test/java/Base/`  | Contains `BaseTest.java`, which sets up the WebDriver and other configurations.                    |
| `src/test/java/Pages/` | Page Object classes like `LoginPage` and `PatientDashboardPage`. Each class represents a web page. |
| `src/test/java/Tests/` | Test classes like `LoginTest` and `PatientDashboardTest`, which contain actual test logic.         |
| `src/test/java/Utils/` | Utility classes: reusable methods, test data providers, Excel handling, reports, listeners, etc.   |
| `src/test/resources/`  | Keeps any resource files needed for testing (like log configs or templates).                       |
| `TestData/`            | Excel files used for data-driven testing (`LoginData.xlsx`, `AddPatientData.xlsx`).                |
| `reports/`             | ExtentReports HTML output after test execution (`index.html`).                                     |
| `pom.xml`              | Maven configuration file – contains project dependencies and plugins.                              |
| `testng.xml`           | TestNG suite file used to define and run specific test classes.                                    |


🛠️ How to Run the Automation Tests
✅ Prerequisites
Java 11 or higher
Maven
Chrome Browser
Git
⚙️ Setup Steps
Clone the repository
git clone https://github.com/your-rameshamale/kerrsor-automation.git
cd kerrsor-automation
mvn test
View the test report :reports/index.html
