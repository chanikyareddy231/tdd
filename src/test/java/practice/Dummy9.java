package practice;



import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy9 
{
     @DataProvider(name="testdata")
     public Object[][] datemethod(ITestContext context)
     {
    	 Object[][] data=null;
    	 for(String g:context.getIncludedGroups())
    	 {
    	 if(g.equalsIgnoreCase("ArithmeticOperations"))
    	 {
    		 
    		 	data=new Object[][] {
    		                            {"12","64"},
    		                            {"24","64"}
    		                            
    	 							 };
    	 							 return (data);
    	 }
    	 else if(g.equalsIgnoreCase("StringManupulations"))
    	 {
    		 
    		 	data=new Object[][] {
    		                            {"abdul","kalam"},
    		                            {"mahesh","reddy"}
    	 							 };
    	 							 return (data);
    	 }
      }
     return(null);
     }
      @Test(groups={"ArithmeticOperations"},dataProvider="testdata")
      public void numbersaddition(String x,String y)
      {
    	  int a=Integer.parseInt(x);
    	  int b=Integer.parseInt(y);
    	  int c=a+b;
    	  System.out.println(c);
      }
      @Test(groups={"StringManupulations"},dataProvider="testdata")
      public void StringConcat(String x,String y)
      {
    	String z=x+y;
    	System.out.println(z);
      }
     
}
