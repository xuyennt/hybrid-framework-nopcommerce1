package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage{

	WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public String getFirstNameTextboxAttributeValue() {
		waitForElementVisible(driver,CustomerPageUI.FIRSTNAME_TEXTBOX);
		return  getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxAttributeValue() {
		waitForElementVisible(driver,CustomerPageUI.LASTNAME_TEXTBOX);
		return  getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
	}

	public String getEmailAddressTextboxAttributeValue() {
		waitForElementVisible(driver,CustomerPageUI.Email_TEXTBOX);
		return  getElementAttribute(driver, CustomerPageUI.Email_TEXTBOX, "value");
	}

}
