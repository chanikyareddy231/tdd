package practice;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
//import org.testng.xml.XmlSuite;

//public class MyReporter implements IReporter
//{
	//@Override
	/*public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String outputDirectory)
	{
		//Second parameter of this methods ISuite will contain all the suite executed
		for(ISuite iSuite:arg1)
		{
			//Get a map of results of a single suite at a time
			Map<String,ISuiteResult> results=iSuite.getResults();
			//Get the key of the results map
			Set<String> keys=results.keySet();
			//Go to each map value one by one
			for(String key:keys)
			{
				//The Context object  of current results
				ITestContext context=results.get(key).getTestContext();
				//print Suite detail in console
				System.out.println("Suite Name "+context.getName()+"\nReport "
			}
						
		}
	}
}*/