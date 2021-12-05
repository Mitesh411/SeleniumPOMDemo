package com.medpay.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medpay.qa.util.*;
import com.medpay.qa.base.TestBase;
import com.medpay.qa.pages.DashboardPage;
import com.medpay.qa.pages.HomePage;

public class DashboardPageTest extends TestBase {

	HomePage homePage;
	DashboardPage dashboardpage;

	public DashboardPageTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
		dashboardpage = new DashboardPage();
		homePage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

//	@Test(priority=1)
	public void verify_DashBoardPageTitle() {
		String dashboardpageTitle = dashboardpage.verify_dashboardPageTitle();
		Assert.assertEquals(dashboardpageTitle, "Order Dashboard");
	}

//	@Test(priority=2)
	public void verify_pharmacyOrderLabel() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		dashboardpage.verify_pharmacyOrderLabel();
	}
	
	@Test(priority = 3)
	public void verify_closenotificationmessage() {

		dashboardpage.verify_closenotification();
		dashboardpage.enter_partnerorderid();
		dashboardpage.addCustomerDetails();
		dashboardpage.addAddressDetails();
		dashboardpage.uploadPrescription();
		dashboardpage.addDoctor();
		dashboardpage.addItemDetails();
		dashboardpage.fetchAmount();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
		unload();

	}

}
