package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.TestUtility;

public class Dummy17
{
     public TestUtility tu;
     
     @Test(description="OpenBrowser")
     public void openBrowser() throws Exception
     {
    	 tu=new TestUtility();
    	 tu.openBrowser("chrome");
    	 tu.lanuchSite("http://www.google.co.in");
    	 Thread.sleep(5000);
    	 String fp=tu.captureScreenShot();
    	 Reporter.log("Chrome browser opened");
    	 Reporter.log(
    			"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
    	 tu.closeSite();
    	 
     }
    		 
}
