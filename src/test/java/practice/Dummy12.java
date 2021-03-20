package practice;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Dummy12
{
     @Test
     @Parameters({"x","y"})
     public void testmethod(@Optional ("mahesh") String a,@Optional ("reddy")String b)
     {
    	 String c=a+" "+b;
    	 System.out.println(c);
     }
}
