package practice;

import org.testng.annotations.Test;

public class Dummy5 
{
      @Test(priority=1)
      public void openbrowser()
      {
    	  System.out.println("Open browser");
      }
      
      @Test(priority=2,enabled=false)
      public void login()
      {
    	  System.out.println("do login");
      }
      
      @Test(priority=3)
      public void sendmail()
      {
    	  System.out.println("send a mail");
      }
}
