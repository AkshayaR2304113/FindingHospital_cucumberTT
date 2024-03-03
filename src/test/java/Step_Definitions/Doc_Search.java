package Step_Definitions;

import UtilityFile.excel;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import UtilityFile.excel;
import pageObjects.Corporate;
import pageObjects.FilterDoctor;
import pageObjects.FindingDoctors;
import pageObjects.GetDocName;
import pageObjects.Surgeries;
import factory.BaseClass;


public class Doc_Search {
	
	
	WebDriver driver = BaseClass.getDriver();
	
	@Given("Opening the browser")
	public void opening_the_browser() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		BaseClass.getLogger().info("Goto Find Doctors");
		Thread.sleep(3000);
		
		
	}
	
	@When("Provide Location and Specialization of the Doctor")
	public void provide_location_and_specialization_of_the_doctor() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		BaseClass.getLogger().info("Enter Location and details..");
		
		Thread.sleep(3000);
		
		
		FindingDoctors searchH = new FindingDoctors(driver);
		String[] data = excel.FileData();
		searchH.location_Nav();
		searchH.Location_Value(data[0], driver);
		
		Thread.sleep(3000);
		
		
		searchH.Search_Nav();
		searchH.Search_Value(data[1],driver);
		
		Thread.sleep(3000);
		
		
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\locNdSp.png");
		FileHandler.copy(FirstScr, destination);
		
		
	}

	@When("Filter by Experience, Patient Stories")
	public void filter_by_experience_patient_stories() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		BaseClass.getLogger().info("Provide the Filters to sort the doctors in the given location");
        
		FilterDoctor sortDoc = new FilterDoctor(driver);
		
		Thread.sleep(3000);
		
		
		sortDoc.PStories_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\Pstories.png");
		FileHandler.copy(FirstScr, destination);
		
		Thread.sleep(3000);
		
		
		
		
		sortDoc.PStories();
		
		sortDoc.Experience_Nav();
		File FirstScr1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination1 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\exp.png");
		FileHandler.copy(FirstScr1, destination1);
		
		Thread.sleep(3000);
		
		
		
		
		sortDoc.Experience_val();
		
		sortDoc.AllFilters_Nav();
		
		File FirstScr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\allFilter.png");
		FileHandler.copy(FirstScr2, destination2);
		
		
		
		
		sortDoc.Availability_Nav();
		
		sortDoc.Sort_Nav();
		File FirstScr3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\sort.png");
		FileHandler.copy(FirstScr3, destination3);
		
		
		
		sortDoc.Sort();
	}

	@When("Retrive first five Doctors")
	public void retrive_first_doctors() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		BaseClass.getLogger().info("Retrive the Doctor details");
		
        GetDocName GetDoc = new GetDocName(driver);
		
		GetDoc.Doctor_Nav();
        
		GetDoc.Hospital_Nav();
		
		GetDoc.Write_Data_Excel();
		
		Thread.sleep(5000);

	}

	@When("Retrive the list of surgeries")
	public void retrive_the_list_of_surgeries() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Goto Surgery --> Retrive the Surgery List");
		
		Surgeries surg = new Surgeries(driver);
		surg.Surgery_Nav();
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\surg.png");
		FileHandler.copy(FirstScr, destination);
		
		
		
		Thread.sleep(3000);
		
		surg.SurgeryList();
		
		Thread.sleep(3000);
		
		surg.Write_Data_Excel();
		
		Thread.sleep(5000);
	}

	@When("Validate form by valid and invalid data")
	
	public void validate_form_by_valid_and_invalid_data() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		BaseClass.getLogger().info("Validate Form fields with invalid input");
		
		Corporate form = new Corporate(driver);
		form.Corporate_Nav();
		
		Thread.sleep(3000);
		
		File FirstScr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\form.png");
		FileHandler.copy(FirstScr, destination);
		
		
		
		Thread.sleep(3000);
		
		form.Form_Val("2304113@.com");
		form.Submit();
		File FirstScr2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination2 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\invalid.png");
		FileHandler.copy(FirstScr2, destination2);
		
		
		
		Thread.sleep(3000);
		
		BaseClass.getLogger().info("validate form Details with valid input");
		
		form.Form_Val("2304113@cognizant.com");
		form.Submit();
		
		Thread.sleep(3000);
		
		File FirstScr3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destination3 = new File("C:\\Users\\2304113\\eclipse-workspace\\Hproject_cucumber\\Screenshot\\valid.png");
		FileHandler.copy(FirstScr3, destination3);
		
		
	}

	@When("close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		
		BaseClass.getLogger().info("Browser is closed");
		
	}


}
