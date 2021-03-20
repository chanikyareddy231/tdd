package practice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtility;

public class Dummy20 
{
	  TestUtility tu;
	  String vp;
	  ATUTestRecorder recorder;
	  
      @BeforeMethod
      public void method1(Method m) throws Exception
      {
    	  SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
    	  Date d=new Date();
    	  vp="target\\"+m.getName()+"-"+sf.format(d); //".mov" is the default extension
    	  Reporter.log("<video width=\"400\" controls autoplay>\n"+
    			  			"<source src=\""+vp+"\" type=\"video/mp4\">\n"
    			  			+"</video>");
    	  recorder=new ATUTestRecorder(vp,false); //false means no audio
    	  recorder.start();  
      }
      
      @Test(priority=1)
      public void method2() throws Exception
      {
    	  tu=new TestUtility();
    	  tu.openBrowser("chrome");
    	  tu.lanuchSite("http://www.google.co.in");  
    	  Thread.sleep(5000);
    	  tu.closeSite();
      }
      
      @Test(priority=2)
      public void method3() throws Exception
      {
    	  tu=new TestUtility();
    	  tu.openBrowser("Firefox");
    	  tu.lanuchSite("http://www.gmail.com");  
    	  Thread.sleep(5000);
    	  tu.closeSite();
      }
      
      @AfterMethod
      public void method4() throws Exception
      {
    	  recorder.stop();
      }
}
