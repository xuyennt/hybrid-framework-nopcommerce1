package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;

	public void openPageUrl(WebDriver driver, String pageUrl) {
		// bien cuc bo
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void waitForAlertPresence(WebDriver driver) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelToAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void getTextInAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String keysToSend) {
		driver.switchTo().alert().sendKeys(keysToSend);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public Set<Cookie> getBrowserCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public void deleteAllCookie(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}

	public void clickToElement(WebDriver driver, String locator) {
		// driver.findElement(By.xpath(locator)).click();
		getWebElement(driver, locator).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {

		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);
	}

	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void selectItemDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}

	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		List<WebElement> allItems = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}
	public String getElementText(WebDriver driver, String locator) {

		return getWebElement(driver, locator).getText();
	}
    public String getElementAttribute(WebDriver driver, String locator,String attributeName) {
    	return getWebElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
    	return getWebElement(driver, locator).getCssValue(cssPropertyName);
    }
    public String convertRGBAToHexaColor(WebDriver driver, String locator) {
    	return Color.fromString(getElementCssValue(driver,locator,"backgroud-color")).asHex();
    }
    public int getListElementSize(WebDriver driver, String locator) {
    	return getListWebElement(driver,locator).size();
    }
    public void checkToElement(WebDriver driver, String locator) {
    	if(!getWebElement(driver, locator).isSelected()) {
    		getWebElement(driver, locator).click();
    	}
    }
    public void uncheckToElement(WebDriver driver, String locator) {
    	if(getWebElement(driver, locator).isSelected()) {
    		getWebElement(driver, locator).click();
    	}
    }
    public boolean isElementDisplayed(WebDriver driver, String locator) {
    	return getWebElement(driver, locator).isDisplayed();
    }
    public boolean isElementSelected(WebDriver driver, String locator) {
    	return getWebElement(driver, locator).isSelected();
    }
    public boolean isElementEnabled(WebDriver driver, String locator) {
    	return getWebElement(driver, locator).isEnabled();
    }
    public void swithToIframe(WebDriver driver, String locator) {
    	driver.switchTo().frame(getWebElement(driver,locator));
    }
    public void switchToDefaultContent(WebDriver driver) {
    	driver.switchTo().defaultContent();
    }
    public void hoverToElement(WebDriver driver,String locator) {
    	new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }
    public void doubleClickToElement(WebDriver driver,String locator) {
    	new Actions(driver).doubleClick(getWebElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver,String locator) {
    	new Actions(driver).contextClick(getWebElement(driver,locator)).perform();
    }
    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
    	new Actions(driver).dragAndDrop(getWebElement(driver,sourceLocator),getWebElement(driver,targetLocator));
    }
    public void sendKeyBoardToElement(WebDriver driver,String locator, Keys key) {
    	new Actions(driver).sendKeys(getWebElement(driver,locator),key).perform();
    }
    public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
    
}
