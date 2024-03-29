package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);

	}

	public String getFirstNameErrorMessageText() {
		waitForElementVisible(driver,RegisterPageUI.FIRSTNAME_ERROR_MSG);
		return getElementText(driver,RegisterPageUI.FIRSTNAME_ERROR_MSG);
		
	}

	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver,RegisterPageUI.LASTNAME_ERROR_MSG);
		return getElementText(driver,RegisterPageUI.LASTNAME_ERROR_MSG);
	}

	public String getEmailErrorMessageText() {
		waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MSG);
		return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MSG);
	}

	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MSG);
		return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MSG);
	}

	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver,RegisterPageUI.COMFIRM_PASSWORD_ERROR_MSG);
		return getElementText(driver,RegisterPageUI.COMFIRM_PASSWORD_ERROR_MSG);
	}

	public HomePageObject clickToNopCommerceLogo() {
		waitForElementClickable(driver,RegisterPageUI.NOP_COMMERCE_LOGO);
		clickToElement(driver,RegisterPageUI.NOP_COMMERCE_LOGO);
		return new HomePageObject(driver);

	}

	public void enterToFirstNameTextbox(String firstNameValue) {
		waitForElementVisible(driver,RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);

	}

	public void enterToLastNameTextbox(String lastNameValue) {
		waitForElementVisible(driver,RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);
	}

	public void enterToEmailTextbox(String emailValue) {
		waitForElementVisible(driver,RegisterPageUI.Email_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.Email_TEXTBOX, emailValue);

	}

	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver,RegisterPageUI.Password_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.Password_TEXTBOX, passwordValue);

	}

	public void enterToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitForElementVisible(driver,RegisterPageUI.ConfirmPassword_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.ConfirmPassword_TEXTBOX, confirmPasswordValue);

	}

	public String getRegisterSuccessMessageText() {
		waitForElementVisible(driver,RegisterPageUI.REGISTRATION_COMPLETED_MSG);
		return getElementText(driver,RegisterPageUI.REGISTRATION_COMPLETED_MSG);
	}

}
