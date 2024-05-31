package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC002_CreateLead extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFileName = "TC02";
		authors = "Shubhana";
		category = "Sanity";
		testName = "Create Lead Scenario";
		testDesc = "Create Lead Field  Validation and Creating Lead";
		moduleName = "Create Lead";
	}

	@Test(priority = 1,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String sUserName,String sPassword) {
		boolean result = new LoginPage(driver,node)
		.enterUserName(sUserName)
	    .enterPassword(sPassword)
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(FakerDataFactory.getLastName())
		.enterCompanyName(FakerDataFactory.getCompanyName())
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		
		Assert.assertTrue(result);
	}
	
}
