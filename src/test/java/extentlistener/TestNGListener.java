package extentlistener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test.BaseTest;
import utility.Screenshot;
public class TestNGListener extends BaseTest implements ITestListener
{
	ExtentReports extent =ExtentReporterGen.extendReportGenerator();
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println("test case "+result.getName()+" Started");
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("test case "+result.getName()+" Has passed");
		test.log(Status.PASS,"Test Case Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 							// method Declaration
	{
		System.out.println("test case "+result.getName()+" has failed");   // method Defination	
		test.fail(result.getThrowable());
		Screenshot scr=new Screenshot();
		try {
			String path = scr.Screenshot(driver, result.getName());
			test.addScreenCaptureFromPath(path);
		}
		catch (IOException e)
		{
			System.out.println("while excuting take screenshot");
			String message = e.getMessage();
			System.out.println(message);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("test case "+result.getName()+" has Skipped");
		test.log(Status.SKIP, "test case Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{
		System.out.println("test tag "+context.getName()+" has started ");		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("test tag "+context.getName()+" has completed ");
		extent.flush();
	}


}
