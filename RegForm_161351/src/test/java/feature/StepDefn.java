package feature;

import javax.xml.xpath.XPath;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.cg.model.RegistrationPageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefn {
	RegistrationPageFactory regPage;
	WebDriver driver;
	
	@Given("^User is on webpage$")
	public void user_is_on_webpage() throws Throwable {
		
		driver=new FirefoxDriver();
		driver.get("D:\\WebPages_for test\\RegistrationForm.html");
		
		regPage=new RegistrationPageFactory(driver); 
		System.out.println("page loaded in browser");
	    
	}
	
    //testing for title match
	@When("^Verify the title$")
    public void verify_the_title() throws Throwable {
	WebElement titleTxt=driver.findElement(By.xpath("/html/head/title"));	
	   
	}


//if title not matches displays title not matched in the console
@Then("^Title will be displayed$")
	public void title_will_be_displayed() throws Throwable {
			String actualMsg=driver.getTitle();
	        String expMsg="Welcome to jobsWorld";
	        Assert.assertNotEquals(expMsg,actualMsg);
	        System.out.println("Title not matched");
	        driver.close();
	    
	}

    //testing for user id when entered blank
	@When("^userid entered is blank$")
	public void userid_entered_is_blank() throws Throwable {
	   regPage.setUserId("");
	   regPage.clickSubmitButton();
	   
	}
     
	//checking whether it displays correct alert
	@Then("^Display alertbox 'User id cannot be blank'$")
	public void display_alertbox_User_id_cannot_be_blank() throws Throwable {

		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="User Id should not be empty / length be between 5 to 12";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
 
	//testing for user id when it is invalid
	@When("^user id is not valid$")
	public void user_id_is_not_valid() throws Throwable {
		regPage.setUserId("nan");
		regPage.clickSubmitButton();
	    
	}
	
	
	//checking whether it displays correct alert
	@Then("^Display alertbox 'Userid is invalid'$")
	public void display_alertbox_Userid_is_invalid() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="User Id should not be empty / length be between 5 to 12";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	//testing for not entering password it gives alert 
	@When("^password is blank$")
	public void password_is_blank() throws Throwable {
	    regPage.setUserId("Nandini");
	    regPage.setPassWord("");
		regPage.clickSubmitButton();
	}
	
	//checking whether it displays correct alert
	@Then("^Display alertbox 'password cannot be blank'$")
	public void display_alertbox_password_cannot_be_blank() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Password should not be empty / length be between 7 to 12";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	    
	}
	//testing for entering invalid password it gives alert 
	@When("^password is not valid$")
	public void password_is_not_valid() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandu");
		regPage.clickSubmitButton();
	    
	}

	//checking whether it displays correct alert
	@Then("^Display alertbox 'Password is invalid'$")
	public void display_alertbox_Password_is_invalid() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Password should not be empty / length be between 7 to 12";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	//testing for not entering name it gives alert 
	@When("^name is not entered$")
	public void name_is_not_entered() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("");
		regPage.clickSubmitButton();
	}
	
	//checking whether it displays correct alert
	@Then("^Display alertbox 'name should not be empty'$")
	public void display_alertbox_name_should_not_be_empty() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Name should not be empty and must have alphabet characters only";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	//testing for entering invalid name it gives alert 
	@When("^numbers are entered in the name$")
	public void numbers_are_entered_in_the_name() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("123Nandini");
		regPage.clickSubmitButton();
	}

	//checking whether it displays correct alert
	@Then("^Display alertbox 'numerics are not allowed'$")
	public void display_alertbox_numerics_are_not_allowed() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Name should not be empty and must have alphabet characters only";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	//testing for not entering address it gives alert 
	@When("^address is not entered$")
	public void address_is_not_entered() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("");
		regPage.clickSubmitButton();
	}
	
	
	//checking whether it displays correct alert
	@Then("^Display alertbox 'Address cannot be blank'$")
	public void display_alertbox_Address_cannot_be_blank() throws Throwable {
		
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="User address must have alphanumeric characters only";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	//testing for invalid address displays to display alert
	@When("^address is invalid$")
	public void address_is_invalid() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("12***&*&&^&67");
		regPage.clickSubmitButton();
	    
	}

	//checking it gives correct alert or not
	@Then("^Display alertbox 'Address should be alphanumeric'$")
	public void display_alertbox_Address_should_be_alphanumeric() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="User address must have alphanumeric characters only";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	    
	}

	//testing for not selecting country it gives alert 
	@When("^country is not selected$")
	public void country_is_not_selected() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("Hyderabad");
	    regPage.setCountry("");
		regPage.clickSubmitButton();

	}
	
	//checking whether it displays correct alert
	@Then("^Display alertbox 'country should be selected from the list'$")
	public void display_alertbox_country_should_be_selected_from_the_list() throws Throwable {
		
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Select your country from the list";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	//testing for entering invalid zip it gives alert 
	@When("^zipcade is not valid$")
	public void zipcade_is_not_valid() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("Hyderabad");
	    regPage.setCountry("India");
	    regPage.setZipCode("hyd123");
		regPage.clickSubmitButton();
	}

	//checking whether it displays correct alert
	@Then("^Display alertbox 'zipcode cannot have alphabets'$")
	public void display_alertbox_zipcode_cannot_have_alphabets() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="ZIP code must have numeric characters only";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();

	}

	//testing for entering invalid email it gives alert 
	@When("^email id entered is invalid$")
	public void email_id_entered_is_invalid() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("Hyderabad");
	    regPage.setCountry("India");
	    regPage.setZipCode("123456");
	    regPage.setemail("xyz*gjd");
		regPage.clickSubmitButton();
	}

	//checking whether it displays correct alert
	@Then("^Display alertbox 'email id is invalid'$")
	public void display_alertbox_email_id_is_invalid() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="You have entered an invalid email address!";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
    //testing for not selecting gender it gives alert 
	@When("^gender is not selected$")
	public void gender_is_not_selected() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("Hyderabad");
	    regPage.setCountry("India");
	    regPage.setZipCode("123456");
	    regPage.setemail("nandu.guddeti@gmail.com");
	    regPage.clickSubmitButton();
	    
	}
	
	//checking whether it displays correct alert
	@Then("^Display alertbox 'gender should be selected'$")
	public void display_alertbox_gender_should_be_selected() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Please Select gender";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	   
	}
	
    //testing for language selection
	@When("^language is selected$")
	public void language_is_selected() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("Hyderabad");
	    regPage.setCountry("India");
	    regPage.setZipCode("123456");
	    regPage.setemail("nandu.guddeti@gmail.com");
	    regPage.setGender("Female");
	    regPage.setlanguage("english");
		regPage.clickSubmitButton();
	}

	//checking whether it displays correct alert
	@Then("^language gets selected$")
	public void language_gets_selected() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Your Registration with JobsWorld.com has successfully done plz check your registred email addres to activate your profile";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}
	
    //testing for whole registration form with correct details
	@When("^registration form is filled completely$")
	public void registration_form_is_filled_completely() throws Throwable {
		regPage.setUserId("Nandini");
	    regPage.setPassWord("nandini123");
	    regPage.setName("Nandini");
	    regPage.setAddress("Hyderabad");
	    regPage.setCountry("India");
	    regPage.setZipCode("123456");
	    regPage.setemail("nandu.guddeti@gmail.com");
	    regPage.setGender("Female");
	    regPage.setlanguage("english");
		regPage.clickSubmitButton();
	   
	}
	
	//checking whether it displays correct alert
	@Then("^registration is completed$")
	public void registration_is_completed() throws Throwable {
		String actualErrorMsg=driver.switchTo().alert().getText();
		String expErrorMsg="Your Registration with JobsWorld.com has successfully done plz check your registred email addres to activate your profile";
		Assert.assertEquals(expErrorMsg, actualErrorMsg);
		driver.switchTo().alert().accept();
		driver.close();
	}





}
