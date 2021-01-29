package ToolsQA;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReporterNG
{
	public static ExtentReports extent;
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Report");
		reporter.config().setDocumentTitle("ExtentReports 4.0");
		
		ExtentReports extent =new ExtentReports();
	    extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Gopalaswamy M");
		return extent;
	}	
}
