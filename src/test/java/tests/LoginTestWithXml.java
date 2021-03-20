package tests;

import static org.testng.Assert.fail;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.TestUtility;

public class LoginTestWithXml 
{
	public TestUtility tu;
	public RemoteWebDriver driver;
    public WebDriverWait wait;
    public HomePage hp;
    public LoginPage lp;
    public ComposePage cp;
    public LogoutPage lop;
    
    @BeforeClass()
    public void setUp()
    {
    	tu=new TestUtility();
    }
    
    @Test(priority=1)
    @Parameters({"browser"})
    public void launch(String bn) throws Exception
    {
    	driver=tu.openBrowser(bn);
    	wait=tu.defineWait(driver);
    	hp=new HomePage(driver,wait);
    	lp=new LoginPage(driver,wait);
    	cp=new ComposePage(driver,wait);
    	lop=new LogoutPage(driver,wait);
    	String url=tu.getPropertyValue("url");
    	tu.lanuchSite(url);
    }
    
    @Test(priority=2)
    @Parameters({"uid","uic"})
    public void userIdTesting(String u, String uc) throws Exception
    {
    	try
    	{
    		hp.uidfill(u);
        	hp.uidNextClick();
        	if(u.length()==0 && uc.equalsIgnoreCase("blank"))
        	{
        		if(hp.isBlankuidError())
        		{
        			Reporter.log("Blank user id test passed");
        			Assert.assertTrue(true);
        		}
        		else
        		{
        			Reporter.log("Blank user id test failed and see :");
        			String fp=tu.captureScreenShot();
        			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
        			Assert.fail();
        		}
        	}
        	else if(u.length()!=0 && uc.equalsIgnoreCase("invalid"))
        	{
        		if(hp.isInvaliduidError())
        		{
        			Reporter.log("Invalid user id test passed");
        			Assert.assertTrue(true);
        		}
        		else
        		{
        			Reporter.log("Invalid user id test failed and see :");
        			String fp=tu.captureScreenShot();
        			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
        			Assert.fail();
        		}
        	}
        	else
        	{
        		if(hp.isPasswordVisible())
        		{
        			Reporter.log("User id test passed");
        			Assert.assertTrue(true);
        		}
        		else
        		{
        			Reporter.log("valid user id test failed and see :");
        			String fp=tu.captureScreenShot();
        			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
        			Assert.fail();
        		}
        	}
    	}
    	catch(Exception ex)
    	{
    		Reporter.log(ex.getMessage()+" and see");
			String fp=tu.captureScreenShot();
			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
			Assert.fail();
    	}	
    } 
    
    @Test(priority=3)
    @Parameters({"pwd","pwc"})
    public void passwordTesting(String p, String pc) throws Exception
    {
    	if(p.equals("N/A") || pc.equals("N/A"))
    	{
    		Reporter.log("No need for password testing");
    		Assert.assertTrue(true);
    	}
    	else
    	{
    	try
    	{
    		lp.pwdFill(p);
        	lp.pwdNextClick();
        	if(p.length()==0 && pc.equalsIgnoreCase("blank"))
        	{
        		if(lp.isBlankPwdError())
        		{
        			Reporter.log("Blank password test passed");
        			Assert.assertTrue(true);
        		}
        		else
        		{
        			Reporter.log("Blank password test failed and see :");
        			String fp=tu.captureScreenShot();
        			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
        			Assert.fail();
        		}
        	}
        	else if(p.length()!=0 && pc.equalsIgnoreCase("invalid"))
        	{
        		if(lp.isInvalidPwdError())
        		{
        			Reporter.log("Invalid password test passed");
        			Assert.assertTrue(true);
        		}
        		else
        		{
        			Reporter.log("Invalid password test failed and see :");
        			String fp=tu.captureScreenShot();
        			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
        			Assert.fail();
        		}
        	}
        	else
        	{
        		if(cp.isComposeVisible())
        		{
        			Reporter.log("Valid pwd test passed");
        			Assert.assertTrue(true);
        			//Do logout
        			lop.clickProfilePic();
        			lop.clickSignOut();
        		}
        		else
        		{
        			Reporter.log("valid pwd test failed and see :");
        			String fp=tu.captureScreenShot();
        			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
        			Assert.fail();
        		}
        	}
    	}
    	catch(Exception ex4)
    	{
    		Reporter.log(ex4.getMessage()+" and see");
			String fp=tu.captureScreenShot();
			Reporter.log("<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");
			Assert.fail();
    	}	
    	}
    }   
    
    @Test(priority=4)
    public void closeSite()
    {
    	tu.closeSite();
    }
}
