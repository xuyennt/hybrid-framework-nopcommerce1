package pageObject.factory;

import org.openqa.selenium.WebDriver;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
   WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		
	}

	public String getFirstNameErrorMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmailErrorMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastNameErrorMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPasswordErrorMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getConfirmPasswordErrorMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToNopCommerceLogo() {
		// TODO Auto-generated method stub
		
	}

	public void enterToLastNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToFirstNameTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public void enterToConfirmPasswordTextbox(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getRegisterSuccessMessageText() {
		// TODO Auto-generated method stub
		return null;
	}

}
