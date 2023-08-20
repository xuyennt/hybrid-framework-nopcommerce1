package com.nopcommerce.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_07_Page_Generator_Manager_I3 extends BaseTest {

	WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String emailAddress = getEmailRandom();

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);
		
		homePage= PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Register_01_Empty_Data() {

		registerPage = homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("xuyen");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox("xuyen@nguyen@");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Wrong email");

	}

	@Test
	public void Register_03_Invalid_Password() {

		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("xuyen");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox("xuyen@nguyen@");
		registerPage.enterToPasswordTextbox("123");
		registerPage.enterToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getPasswordErrorMessageText(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_04_Incorrect_Confirm_Password() {
		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("xuyen");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox("xuyen@nguyen@");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("654789");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),
				"The password and confirmation password do not match.");

	}

	@Test
	public void Register_05_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		registerPage = homePage.clickToRegisterLink();

		registerPage.enterToFirstNameTextbox("xuyen");
		registerPage.enterToLastNameTextbox("nguyen");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@Test
	public void user_06_Login_Success() {
		homePage = registerPage.clickToNopCommerceLogo();

		loginPage = homePage.clickToLoginLink();

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		homePage = loginPage.clickToLoginButton();

		customerPage = homePage.clickToMyAccountLink();

		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "xuyen");
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "nguyen");
		Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
