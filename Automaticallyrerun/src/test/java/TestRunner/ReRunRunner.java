package TestRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;	

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"@rerun/failed_scenarios.txt",
		}, 
		//Cucumber execute failed scenarios from this file
		//format= {"html:target/site/cucumber-pretty;json:target/cucumber.json&quot"},
		glue={"step_definitions"}, //the path of the step definition files
		plugin= {"pretty","html:target/site/cucmber-pretty", "json:target/cucumber/cucumber.json", "junit:target/cucumber.xml","com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}, //to generate different types of reporting
		monochrome = true, //display the console output in a proper readable format
		strict = true, //it will check if any step is not defined in step definition file
		dryRun = false//to check the mapping is proper between feature file and step def file
		//tags = {"@all"}			
		)

public class ReRunRunner 
{
}