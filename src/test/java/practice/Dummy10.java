package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.TestUtility;

public class Dummy10
{
       public ExcelUtility eu;
     
     @DataProvider(name="exceldata")
     public Object[][] excelProvider() throws Exception
     {
    	  eu=new ExcelUtility("src//test//resources//dummy10.xlsx");
    	  eu.openSheet("Sheet1");
    	  int nour=eu.getRowsCount();
    	  int nouc=eu.getColumnCount();
    	  Object[][] data=new Object[nour-1][nouc];
    	  for(int i=1;i<nour;i++)
    	  {
    		  for(int j=0;j<nouc;j++)
    		  {
    			  data[i-1][j]=eu.getCellValue(i,j);
    		  }
    	  }
    	  eu.saveAndCloseExcel();
    	  return(data);
     }
     
     @Test(dataProvider="exceldata")
     public void excelData(String x,	String y, String z)
     {
    	 String w=x+"."+y+""+z;
    	 System.out.println(w);
     }
     
}
