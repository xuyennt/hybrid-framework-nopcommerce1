package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driverPageObject) {

		this.driver = driverPageObject;
	}

	public RegisterPageObject clickToRegisterLink() {
		
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
         return PageGeneratorManager.getRegisterPage(driver);

	}

	public CustomerPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getCustomerPage(driver);

	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver,HomePageUI.LOGIN_LINK);
	    return PageGeneratorManager.getLoginPage(driver);
	}

}
