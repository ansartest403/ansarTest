package com.planit.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.planit.Base.BaseClass;
import com.planit.pageObjects.AddCartPage;
import com.planit.pageObjects.HomePage;
import com.planit.pageObjects.LoginPage;
import com.planit.utilities.ReadConfig;
import com.planit.utilities.XLUtils;

public class OrderProduct extends BaseClass
{

	public int value ;
	ReadConfig readconfig=new ReadConfig();
	public String excelPath=readconfig.getExcelPath();
	public String excelSheet=readconfig.getExcelSheetName();
	@Test(dataProvider="LoginData")
	public void addNewCustomer(String username,String password,String categories,String iteam,String quantity,String columnName,String billingAdress,String shippingAdress) throws InterruptedException, IOException
	{
		LoginPage loginPage =new LoginPage(driver);
		loginPage.clickOnSigin();
		loginPage.validateWelcomeMessage();
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSubmit();
		
		HomePage homePage = new HomePage(driver);
		homePage.validateAccountIdIsDisplayed();
		homePage.clearTheCart();
		homePage.clickonHomeButton();
		homePage.selectCategories(categories);
		homePage.selectBook(iteam);
		
		AddCartPage addCartPage = new AddCartPage(driver);
		value = addCartPage.getPrice();
		addCartPage.enterQuantity(quantity);
		addCartPage.addToCart();
		addCartPage.sucessMessage();
		homePage.clickOnShoppingCart();
		addCartPage.validateSubTotal(value,quantity,columnName);
		addCartPage.clickOnTermsAndConditions();
		addCartPage.clickOnCheckOut();
		addCartPage.selectBillingAdress(billingAdress);
		addCartPage.clickOnContinueAtBillingAdress();
		addCartPage.selectShippingAdress(shippingAdress);
		addCartPage.clickOnContinueAtShippingAdress();
		addCartPage.clickShippingMethod();
		addCartPage.clickOnContinueAtShippingMethod();
		addCartPage.clickCOD();
		addCartPage.clickOnContinueAtCOD();
		addCartPage.validateCODMessage();
		addCartPage.clickOnContinueAt();
		addCartPage.clickOnConfromOrder();
		addCartPage.validateOrderSucessMessage();
		addCartPage.printOrder();
		addCartPage.clickOnContinueAtConfromOrder();
		homePage.clickLogout();
				
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+excelPath;
		
		int rownum=XLUtils.getRowCount(path, excelSheet);
		int colcount=XLUtils.getCellCount(path,excelSheet,1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int rowValue=1;rowValue<=rownum;rowValue++)
		{
			for(int colValue=0;colValue<colcount;colValue++)
			{
				logindata[rowValue-1][colValue]=XLUtils.getCellData(path,excelSheet, rowValue,colValue);
			}
				
		}
	return logindata;
	}
	
	
}
