package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static Map<String, ExtentTest> classTestMap = new HashMap<>();

    public static void setupReport() {
        String timestamp = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ssa").format(new Date());
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" + timestamp + ".html";

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName("Automation Test Report");
        spark.config().setDocumentTitle("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Ramesh");
    }

    // Get or create parent test for the class
    public static ExtentTest getClassTest(String className) {
        ExtentTest classTest = classTestMap.get(className);
        if (classTest == null) {
            classTest = extent.createTest(className);
            classTestMap.put(className, classTest);
        }
        return classTest;
    }

    // Create a test node for the method with categories
    public static void createTestNode(String className, String methodName, String[] groups) {
        ExtentTest classTest = getClassTest(className);
        ExtentTest methodNode = classTest.createNode(methodName);

        if (groups != null) {
            for (String group : groups) {
                methodNode.assignCategory(group);
            }
        }

        test.set(methodNode);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
