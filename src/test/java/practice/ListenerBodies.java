package practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtility;

public class ListenerBodies implements ITestListener
{
      @Override
      public void onStart(ITestContext context)
      {
    	  System.out.println("Welcome, please go to reports");
      }
      
      @Override
      public void onFinish(ITestContext Result)
      {
    	 Reporter.log("Thank you");
      }
      
      @Override
      public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
      {
    	 Reporter.log("Test passed with in success percentage");
      }
      
      @Override
      public void onTestFailure(ITestResult Result)
      {
    	  	try
    	  	{
    	  		TestUtility tu=new TestUtility();
    	  		String fp=tu.captureScreenShot();
    	  		Reporter.log(Result.getName()+"Test failed");
    	  		Reporter.log("<a href=\""+fp+"\"> <img src=\""+fp+"\" height=\"100\" width=\"100\" /> </a>");
    	  	}
    	  	catch (Exception ex)
    	  	{
    	  		Reporter.log(Result.getName()+"Test failed but an issue in Screen shot");
    	  	}
      }
      
      @Override
      public void onTestStart(ITestResult Result)
      {
    	 Reporter.log(Result.getName()+ "Test case started");
      }
      
      @Override
      public void onTestSkipped(ITestResult Result)
      {
    	 Reporter.log("The name of the test case skipped is :"+Result.getName());
      }
      
      @Override
      public void onTestSuccess(ITestResult Result)
      {
    	 Reporter.log("The name of the test case passed is :"+Result.getName());
      }
      
}
