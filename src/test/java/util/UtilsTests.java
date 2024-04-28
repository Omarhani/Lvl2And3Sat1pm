package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class UtilsTests {
    ExtentReports extent;
    public void createReport(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report/report.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("My Report");
        extent.attachReporter(spark);
    }
}
