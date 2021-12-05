package com.medpay.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medpay.qa.base.TestBase;
import com.medpay.qa.util.DecodeUtils;

public class HomePage extends TestBase {
	@FindBy(xpath = "//input[@id='username']")
	WebElement userNameTxtBox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordtxtBox;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	
	public DashboardPage login(String un, String pwd) {
		userNameTxtBox.sendKeys(DecodeUtils.getDecodedString(un));
		passwordtxtBox.sendKeys(DecodeUtils.getDecodedString(pwd));
		loginButton.click();
		return new DashboardPage();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

}
