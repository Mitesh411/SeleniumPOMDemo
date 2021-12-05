package com.medpay.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medpay.qa.base.TestBase;
import com.medpay.qa.pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		homePage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"Order Dashboard");
	}
	
		
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		unload();

	}

}
