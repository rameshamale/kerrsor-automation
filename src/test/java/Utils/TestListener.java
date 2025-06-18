package Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentReportManager.setupReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>> TestNG Listener started");
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();
        String[] groups = result.getMethod().getGroups();

        ExtentReportManager.createTestNode(className, methodName, groups);
        ExtentReportManager.getTest().info("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">>> TestNG Listener started");
        ExtentReportManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.getTest().fail("Test Failed: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.getTest().skip("Test Skipped: " + result.getThrowable());
    }
}
