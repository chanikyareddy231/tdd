package practice;

import org.testng.annotations.Test;

public class Dummy1 
{	
     @Test(description="Open browser",timeOut=5000)
     public void method()
     {
    	 System.out.println("launch browser");
     }
}
