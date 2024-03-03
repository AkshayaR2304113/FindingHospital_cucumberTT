package TestRunner;



import org.junit.runner.RunWith; 
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(features = ".//Feature_files//DocSearch.feature", glue = "Step_Definitions",
plugin= {"pretty", "html:reports/myreport.html", 
		  "rerun:target/rerun.txt",
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		  },

		
     dryRun=false,    // checks mapping between scenario steps and step definition methods
     monochrome=true,    // to avoid junk characters in output
     publish=true, 
     tags="@sanity and @regression" 
)


public class testRunner {
	// Your test runner class implementation
	}
