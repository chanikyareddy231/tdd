package practice;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy8 
{
     @DataProvider()
     public Object[][] method1(Method m)
     {
    	 if(m.getName().equalsIgnoreCase("method2"))
    	 {
    		 
    	 Object[][] x=new Object[][] {
    		                            {12,64,54},
    		                            {24,64,69},
    		                            {87,58,32}
    	 							 };
    	 							 return (x);
    	 }
    	 else if(m.getName().equalsIgnoreCase("method3"))
    	 {
    		 
    	 Object[][] x=new Object[][] {
    		                            {"abdul","kalam","apj"},
    		                            {"kohli","anuska","baby"},
    		                            {"modi","narendra","pm"},
    		                            {"mahesh","reddy","ch"}
    	 							 };
    	 							 return (x);
    	 }
    	 else 
    	 {
    		 return(null);
    	 }
     }
      @Test(priority=1,dataProvider="method1")
      public void method2(int x,int y,int z)
      {
    	int w=x+y+z;
    	System.out.println(w);
      }
      @Test(priority=2,dataProvider="method1")
      public void method3(String x,String y,String z)
      {
    	String w=x+y+"."+z;
    	System.out.println(w);
      }
     
}
