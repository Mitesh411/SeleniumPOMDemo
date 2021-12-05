package com.medpay.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.google.common.util.concurrent.Uninterruptibles;
import com.medpay.qa.base.TestBase;
import com.medpay.qa.util.TestUtil;

public class DashboardPage extends TestBase {
	
	@FindBy(xpath = "//p[@class='chakra-text css-sfv7k1']")
	WebElement pharmacyOrderLabel;

	@FindBy(xpath = "//button[@aria-label='Change to pending state']//*[name()='svg']")
	WebElement notificationCancelButton;

	@FindBy(xpath = "//button[normalize-space()='Place an order']")
	WebElement placeOrderButton;

	@FindBy(xpath = "//input[@id='partner_order_id']")
	WebElement partnerOrderIdTextField;

	@FindBy(xpath = "")
	WebElement orderTypeDropDown;

	// Customer Details Text Field

	@FindBy(xpath = "//input[@id='name']")
	WebElement customerDetailsNameTextField;

	@FindBy(xpath = "//input[@id='mobile']")
	WebElement customerDetailsMobileTextField;

	@FindBy(xpath = "//input[@id='alternative_mobile']")
	WebElement customerDetailsAlternateMobileTextField;

	@FindBy(xpath = "//input[@id='email']")
	WebElement customerDetailsEmailTextField;

	// Address Details

	@FindBy(xpath = "//input[@id='address']")
	WebElement AddressDetailsAddressTextField;

	@FindBy(xpath = "//input[@id='landmark']")
	WebElement AddressDetailsLandMarkTextField;

	@FindBy(xpath = "//input[@id='pin_code']")
	WebElement AddressDetailsPincodeTextField;

	@FindBy(xpath = "//input[@id='city']")
	WebElement AddressDetailsCityTextField;

	@FindBy(xpath = "//input[@id='state']")
	WebElement AddressDetailsStateTextField;

	// Upload Prescription

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadPrescriptionButton;

	// Doctor
	@FindBy(xpath = "//input[@id='doctor']")
	WebElement doctorTextField;

	// Item Details

//	@FindBy (xpath = "//div[text()='Item name']/..//input")
	@FindBy(xpath = "//input[starts-with(@id,'react')]")
	WebElement itemDetailsTextField;

	@FindBy(xpath = "//input[@placeholder='details']")
	WebElement itemDetailAddTextField;

	// Quantity xpath  => //div[@placeholder='Quantity']
	
	
	@FindBy(xpath = "//input[@placeholder='MRP']")
	WebElement itemDetailPriceTextField;

	@FindBy(xpath = "//input[@placeholder='Amount']")
	WebElement itemDetailAmountTextField;
	
	@FindBy(xpath = "//p[@class='chakra-text css-mch0gu']")
	WebElement itemDetailTotalAmountTextField;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement itemDetailsSubmitButton;

	public void addItemDetails() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		itemDetailsTextField.sendKeys("Paracetamol");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		itemDetailsTextField.sendKeys(Keys.ENTER);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		itemDetailAddTextField.sendKeys("Head Ache");
		itemDetailPriceTextField.sendKeys("10");
		
		// itemDetailsSubmitButton.click();
		Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);

	}

	
	public void fetchAmount() {
		String printAmt = itemDetailAmountTextField.getAttribute("value");
		System.out.println("\n Item Amount :- "+printAmt);
		
		String printTotalAmt = itemDetailTotalAmountTextField.getText();
		System.out.println("\n Total Amount :- "+printTotalAmt);
		
		
	}
	
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	public String verify_dashboardPageTitle() {
		return driver.getTitle();
	}

	public void verify_pharmacyOrderLabel() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		pharmacyOrderLabel.isDisplayed();
	}

	public void verify_closenotification() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		notificationCancelButton.click();
	}

	public void enter_partnerorderid() {
		placeOrderButton.click();

		partnerOrderIdTextField.sendKeys("123456789");

	}

	public void addCustomerDetails() {
		

		
		customerDetailsNameTextField.sendKeys("Mitesh");
		customerDetailsMobileTextField.sendKeys("9865320145");
		customerDetailsAlternateMobileTextField.sendKeys("9865320145");
		customerDetailsEmailTextField.sendKeys("demo@gmail.com");

	}

	public void addAddressDetails() {

		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

		AddressDetailsAddressTextField.sendKeys("Demo Address");
		AddressDetailsLandMarkTextField.sendKeys("SBI Bank");
		AddressDetailsPincodeTextField.sendKeys("395009");
		AddressDetailsCityTextField.sendKeys("Bangaluru");
		AddressDetailsStateTextField.sendKeys("Karnataka");
		// AddressDetailsAddressTextField.sendKeys(Keys.DOWN);

	}

	public void uploadPrescription() {

		uploadPrescriptionButton.sendKeys("C:\\Users\\pc\\Downloads\\medicalprescription.png");
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
	}

	public void addDoctor() {

		doctorTextField.sendKeys("Dr. Batra");
		Actions action = new Actions(driver);
//		//SCROLL DOWN
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

	}

}
