	package ToolsQA;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
public class listeners extends baseclass implements ITestListener
{
	public ExtentTest test;
	public WebDriver driver;
	public String obj1;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		 Reporter.log(obj1);
	}

	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		
		extentTest.get().log(Status.PASS, "Test Passed");
		
	}
	

	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());//result will return the log of failed tests
		driver=null;
		String testCaseName=result.getMethod().getMethodName();
		try 
		{
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e)
		{
	
		}
		try 
		{
			 extentTest.get().addScreenCaptureFromPath(getTakeScreenShotPath(testCaseName,driver),result.getMethod().getMethodName());
			//String path=getTakeScreenShotPath(testCaseName,driver);
			//extentTest.get().addScreenCaptureFromPath(extentTest.get().log(Status.FAIL,test.addScreenCaptureFromBase64String(getTakeScreenShotPath(testCaseName,driver))+ "Test Failed"), result.getMethod().getMethodName());
			//extentTest.get().log(Status.FAIL,path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub
		extent.flush();
	}

}
