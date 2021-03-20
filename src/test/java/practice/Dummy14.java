package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dummy14 
{
	
	@BeforeMethod
	public void beformethod()
	{
		System.out.println("Before Method will execute before every test method");
	}

	@AfterMethod
	public void aftormethod()
	{
		System.out.println("Aftor Method will execute After every test method");
	}
	

	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class will execute prior to Before Method and Test Method");
	}
	

	@AfterClass
	public void afterClass()
	{
		System.out.println("After class will execute later to After Method and Test Method");
	}
	
	

	@BeforeTest
	public void befortest()
	{
		System.out.println("Before Test will always execute prior to Before Class,Before method and test method");
	}
	

	@AfterTest
	public void aftortest()
	{
		System.out.println("After Test will always execute later to After Class,After method");
	}
	

	@BeforeSuite
	public void beforsuite()
	{
		System.out.println("Before Suite will always execute prior to all annotations or tests in the suite");
	}
	

	@AfterSuite
	public void aftersuite()
	{
		System.out.println("After Suite will always execute at last when all annotations or tests in the suite");
	}
	
	@Test
	public void testCase1()
	{
		System.out.println("This is my first Case 1");
	}	
}
