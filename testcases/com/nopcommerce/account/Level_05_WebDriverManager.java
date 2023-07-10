package com.nopcommerce.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_05_WebDriverManager extends BaseTest {

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
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Register_01_Empty_Data() {

		homePage.clickToRegisterLink();

		// tu hom page click vao register link no se mo ra trang register page
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToNopCommerceLogo();

		// dang tu Register page click vao logo thi no mo ra trang home
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		// tu hom page click vao register link no se mo ra trang register page
		registerPage = new RegisterPageObject(driver);
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

		registerPage.clickToNopCommerceLogo();

		// dang tu Register page click vao logo thi no mo ra trang home
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		// tu hom page click vao register link no se mo ra trang register page
		registerPage = new RegisterPageObject(driver);
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
		registerPage.clickToNopCommerceLogo();

		// dang tu Register page click vao logo thi no mo ra trang home
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		// tu hom page click vao register link no se mo ra trang register page
		registerPage = new RegisterPageObject(driver);
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
		registerPage.clickToNopCommerceLogo();

		// dang tu Register page click vao logo thi no mo ra trang home
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		// tu hom page click vao register link no se mo ra trang register page
		registerPage = new RegisterPageObject(driver);
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
		registerPage.clickToNopCommerceLogo();
		// dang tu Register page click vao logo thi no mo ra trang home
		homePage = new HomePageObject(driver);

		homePage.clickToLoginLink();

		// tu trang home click vao login link no se mo ra trang login
		loginPage = new LoginPageObject(driver);
		// input Email/ Password
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		// tu trang login nhap data hop le va click login button thi no se quay lai
		// trang home(logi thanh cong)

		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
		// tu trang home click My Account no se mo ra trang Customer info
		customerPage = new CustomerPageObject(driver);

		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "xuyen");
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "nguyen");
		Assert.assertEquals(customerPage.getEmailAddressTextboxAttributeValue(), emailAddress);

	}

	@AfterClass
	public void afterClass() {
		closeBrowser();
	}

}
