package pageObject.factory;

import org.openqa.selenium.WebDriver;

import commons.BasePageFactory;

public class CustomerPageObject extends BasePageFactory{
   WebDriver driver;
	
	public CustomerPageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public String getFirstNameTextboxAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastNameTextboxAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmailAddressTextboxAttributeValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
