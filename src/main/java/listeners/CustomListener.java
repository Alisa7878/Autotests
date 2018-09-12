package listeners;

import com.gurock.testrail.TestRailsConnector;
import deflogger.TestsLogger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by st on 03.09.2018.
 */
public class CustomListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        TestsLogger.startTestCase(iTestResult.getMethod().getDescription());

    }

    public void onTestSuccess(ITestResult iTestResult) {
        int resultId = 1;
        String comment = "TEST PASSED: " + iTestResult.getName()+ "\n";
        String testCaseId = iTestResult.getMethod().getDescription();

        long duration = (iTestResult.getEndMillis() - iTestResult.getStartMillis())/1000;

        TestRailsConnector testRailsConnector = new TestRailsConnector("https://itstep092018.testrail.io",
                "dididf2004@gmail.com",
                "QAtsrh5814");
        testRailsConnector.sendTestResult(testCaseId, resultId, comment, duration, "10");
    }

    public void onTestFailure(ITestResult iTestResult) {
      int resultId = 5;
      String comment = "TEST FAILED: " + iTestResult.getName()+ "\n";
      String testCaseId = iTestResult.getMethod().getDescription();

      long duration = (iTestResult.getEndMillis() - iTestResult.getStartMillis())/1000;

      TestRailsConnector testRailsConnector = new TestRailsConnector("https://itstep092018.testrail.io",
              "dididf2004@gmail.com",
              "QAtsrh5814");
      testRailsConnector.sendTestResult(testCaseId, resultId, comment, duration, "10");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        int resultId = 2;
        String comment = "TEST SKIPPED: " + iTestResult.getName()+ "\n";
        String testCaseId = iTestResult.getMethod().getDescription();

        long duration = (iTestResult.getEndMillis() - iTestResult.getStartMillis())/1000;

        TestRailsConnector testRailsConnector = new TestRailsConnector("https://itstep092018.testrail.io",
                "dididf2004@gmail.com",
                "QAtsrh5814");
        testRailsConnector.sendTestResult(testCaseId, resultId, comment, duration, "10");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }


}
