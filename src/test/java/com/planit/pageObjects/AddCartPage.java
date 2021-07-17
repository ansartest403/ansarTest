package com.planit.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.planit.Base.BaseClass;
import com.planit.commonMethods.CommonMethods;

import com.planit.commonMethods.CommonMethods;
import com.planit.testCases.OrderProduct;

import junit.framework.Assert;

public class AddCartPage {

	WebDriver ldriver;
	
	
	public AddCartPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@class='overview']//div[@class='product-price']//span") WebElement price;
	@FindBy(xpath="//div[@class='overview']//div[@class='add-to-cart-panel']//input[@class='qty-input']") WebElement quantity;
	@FindBy(xpath="//div[@class='overview']//div[@class='add-to-cart-panel']//input[@type='button']") WebElement addToCart;
	@FindBy(xpath="//p[text()='The product has been added to your ']") WebElement sucessMessage;
	@FindBy(xpath="//table[@class='cart-total']//tr/td/span") List<WebElement> SubTotal;
	@FindBy(xpath="//input[@id='termsofservice']") WebElement termsAndCondition;
	@FindBy(xpath="//button[@id='checkout']") WebElement checkout;
	@FindBy(xpath="//select[@id='billing-address-select']") WebElement billingAdress;
	@FindBy(xpath="//div[@id='billing-buttons-container']/input") WebElement billingAdressContiune;
	@FindBy(xpath="//span[@id='shipping-please-wait']/..//input") WebElement shippingAdressContiune;
	@FindBy(xpath="//span[@id='shipping-method-please-wait']/..//input") WebElement shippingMethodContiune;
	@FindBy(xpath="//span[@id='payment-method-please-wait']/..//input") WebElement PaymentMethodContiune;
	@FindBy(xpath="//span[@id='payment-info-please-wait']/..//input") WebElement Contiune;
	@FindBy(xpath="//input[@value='Continue']") WebElement orderConfromContinue;
	@FindBy(xpath="//select[@id='shipping-address-select']") WebElement shippingAdress;
	@FindBy(xpath="//label[contains(text(),'Next Day Air')]") WebElement nextDayAir;
	@FindBy(xpath="//p[text()='You will pay by COD']") WebElement CODMessage;
	@FindBy(xpath="//label[contains(text(),'Cash On Delivery (COD)')]") WebElement COD;
	@FindBy(xpath="//span[@id='confirm-order-please-wait']/..//input") WebElement confromOrder;
	@FindBy(xpath="//strong[text()='Your order has been successfully processed!']") WebElement orderSucessfullyProceed;
	@FindBy(xpath="//ul[@class='details']/li") WebElement orderNumber;
	
	
	
	

	public int getPrice() {
		
		return (int)Float.parseFloat(price.getText());
				
		
	}
	
	public void enterQuantity(String value) {
		quantity.clear();
		quantity.sendKeys(value);
		
	}
	
   public void addToCart() {
	   CommonMethods.elementToBeClickableWithWebElement(20,addToCart,ldriver);
	   addToCart.click();
	  
   }
   
   public void sucessMessage() {
	
	   Assert.assertTrue(sucessMessage.isDisplayed());
   }
	
   public int subTotal(String value) {
	   return CommonMethods.selectNGetIndexByText(SubTotal,value,false,ldriver);
   }
   
   public void validateSubTotal(int value,String values,String text) {
	  int index = subTotal(text);
	  WebElement subtotal =  ldriver.findElement(By.xpath("//table[@class='cart-total']//tr['"+index+"']/td//span[@class='product-price']"));
	  Assert.assertEquals(value*Integer.parseInt(values),(int)Float.parseFloat(subtotal.getText()));
	   
   }
   
   public void clickOnTermsAndConditions() {
	   termsAndCondition.click();
   }
   
   public void clickOnCheckOut() {
	   checkout.click();
   }
   
   public void selectBillingAdress(String text) {
	   CommonMethods.SelectedDropDownValue(billingAdress,text);
   }
   
   public void selectShippingAdress(String text) {
	   CommonMethods.SelectedDropDownValue(shippingAdress,text);
   }
   
   public void clickShippingMethod() {
	   nextDayAir.click();
   }
   
   public void clickCOD() {
	   COD.click();
   }
   
   public void validateCODMessage() {
	   
	   Assert.assertTrue(CODMessage.isDisplayed());
   }
   
   public void clickOnConfromOrder() {
	   
	   confromOrder.click();
   }
   
   public void printOrder() {
	   BaseClass.logger.info( orderNumber.getText());
	}
   
   public void clickOnContinueAtBillingAdress() {
	   billingAdressContiune.click();
	}
	
	public void clickOnContinueAtShippingAdress() {
		shippingAdressContiune.click();
	}

	public void clickOnContinueAtShippingMethod() {
		shippingMethodContiune.click();
	}

	public void clickOnContinueAtCOD() {
		PaymentMethodContiune.click();
	}

	public void clickOnContinueAt() {
		Contiune.click();
	}


	public void clickOnContinueAtConfromOrder() {
		orderConfromContinue.click();
	}
	
	public void validateOrderSucessMessage() {
		
		Assert.assertTrue(orderSucessfullyProceed.isDisplayed());
	}

}
