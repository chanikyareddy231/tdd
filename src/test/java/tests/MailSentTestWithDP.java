package tests;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.TestUtility;

public class MailSentTestWithDP 
{
	public TestUtility tu;
	public RemoteWebDriver driver;
    public WebDriverWait wait;
    public HomePage hp;
    public LoginPage lp;
    public ComposePage cp;
    public LogoutPage lop;
    public ATUTestRecorder recorder;
    
    @BeforeClass
    public void setUp() throws Exception
    {
    	tu=new TestUtility();
    	SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
    	Date dt=new Date();
    	String vr="\\target"+df.format(dt);
    	recorder=new ATUTestRecorder(vr,false);
    	recorder.start();
    }
    
    @DataProvider(parallel=true)
    public Object[][] providerMethod(Method m)
    {
    	Object[][] x=new Object[][] {
    									{"chrome","chanikyareddy231","Chanikya231","chanikyareddy231@gmail.com","hi","go do deep of subject","C:\\images\\3 d image for background.jpg"},
    									{"firefox","chanikyareddy231","Chanikya231","chanikyareddy231@gmail.com","hi","go do deep of subject","C:\\images\\3 d image for background.jpg"},
    									{"opera","chanikyareddy231","Chanikya231","chanikyareddy231@gmail.com","hi","go do deep of subject","C:\\images\\3 d image for background.jpg"},
    									{"edge","chanikyareddy231","Chanikya231","chanikyareddy231@gmail.com","hi","go do deep of subject","C:\\images\\3 d image for background.jpg"}
    							 	};
    							 	return (x);
    }   
    
    @Test(priority=1,dataProvider="providerMethod")
    public void mailSentTest(String bn,String u,String p, String t,String s,String b,String fp) throws Exception
    {
    	//Mail sent testing with multiple test data in cross browser environment
    	//Open browser by creating driver object
    	RemoteWebDriver driver=tu.openBrowser(bn);
    	//define wait object by using driver object
    	WebDriverWait wait=tu.defineWait(driver);
    	//create objects to page classes by using driver and wait objects
    	HomePage hp=new HomePage(driver,wait);
    	LoginPage lp=new LoginPage(driver,wait);
    	ComposePage cp=new ComposePage(driver,wait);
    	LogoutPage lop=new LogoutPage(driver,wait);
    	String url=tu.getPropertyValue("url");
    	tu.lanuchSite(url);
    	hp.uidfill(u);
    	hp.uidNextClick();
    	lp.pwdFill(p);
    	lp.pwdNextClick();
    	try
    	{
    		cp.clickCompose();
    		cp.fillTo(t);
    		cp.fillSubject(s);
    		cp.fillBody(b);
    		cp.attachment(fp);
    	    cp.clickSend();
    	    Thread.sleep(5000);
    	    String msg=cp.getOutPutMessage();
    	    if(!msg.contains("Sorry"))
    	    {
    	    	Reporter.log("Compose test passed and we got :"+msg);
    	    	Assert.assertTrue(true);
    	    }
    	    else
    	    {
    	    	Reporter.log("Compose test failed and see :");
    	    	String sp=tu.captureScreenShot();
    	    	Reporter.log("<a href=\""+sp+"\"><img src=\""+sp+"\" height=\"100\" width=\"100\"/></a>");
    	    	Assert.fail();
    	    }
    	    //Do logout
    	    lop.clickProfilePic();
    	    lop.clickSignOut();
    	    //close site
    	    tu.closeSite(); 	    
    	}
    	catch(Exception ex)
    	{
    		Reporter.log(ex.getMessage()+"and see: ");
    		String sp=tu.captureScreenShot();
	    	Reporter.log("<a href=\""+sp+"\"><img src=\""+sp+"\" height=\"100\" width=\"100\"/></a>");
	    	//close site
	    	tu.closeSite();
	    	Assert.fail();		
    	}		
    }
    
    @AfterClass
    public void method4() throws ATUTestRecorderException
    {
    	recorder.stop();
    }	
}
