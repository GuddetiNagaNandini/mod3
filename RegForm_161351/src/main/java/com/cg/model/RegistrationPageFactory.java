package com.cg.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFactory {
	
	
	WebDriver driver;
	
    @FindBy(name="userid")
    @CacheLookup
	WebElement userId;
    
    @FindBy(name="passid")
    @CacheLookup
	WebElement passWord;
	
    @FindBy(id="usrname")
    @CacheLookup
    WebElement name;
    
    @FindBy(id="addr")
    @CacheLookup
	WebElement address;
    
    @FindBy(name="country")
    @CacheLookup
	WebElement country;
    
    @FindBy(name="zip")
    @CacheLookup
	WebElement zipCode;
    
    @FindBy(name="email")
    @CacheLookup
	WebElement emailId;
    
    @FindBy(xpath="/html/body/form/ul/li[16]/input")
    @CacheLookup
	WebElement gendermale;
    
    @FindBy(xpath="/html/body/form/ul/li[17]/input")
    @CacheLookup
	WebElement genderfemale;
    
    @FindBy(xpath="/html/body/form/ul/li[19]/input")
    @CacheLookup
	WebElement check1;
    
    @FindBy(xpath="/html/body/form/ul/li[20]/input")
    @CacheLookup
	WebElement check2;
    
    @FindBy(name="submit")
    @CacheLookup
	WebElement submitBtn;
	
public RegistrationPageFactory() {
		
	}
	
	public RegistrationPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//setting user id
	public void setUserId(String user) {
		userId.sendKeys(user);
		
	}
	
	//setting password
	public void setPassWord(String pwd) {
		passWord.sendKeys(pwd);
		
	}
	
	//setting name
	public void setName(String name1) {
		name.sendKeys(name1);
		
	}
	
	//setting address
	public void setAddress(String add) {
		address.sendKeys(add);
		
	}
	
	//setting country
	public void setCountry(String country1) {
		country.sendKeys(country1);
		
	}
	
	//setting zipcode
	public void setZipCode(String pin) {
		zipCode.sendKeys(pin);
		
	}
	
	//setting email
	public void setemail(String mail) {
		emailId.sendKeys(mail);
		
	}
	
	//setting gender(radio button)
	public void setGender(String gen) {
		if(gen.equalsIgnoreCase("female"))
			genderfemale.click();
		else
			gendermale.click();
	}
	
	//setting language(check boxes) which is by default english
	public void setlanguage(String type) {
		if(type.equalsIgnoreCase("english"))
			check1.click();
		else
			check2.click();
	}
	
	//setting submit button
	public void clickSubmitButton() {
		submitBtn.click();
	
	}
}
