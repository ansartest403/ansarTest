package com.planit.commonMethods;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planit.Base.BaseClass;

public class CommonMethods  {
	
	
	
	public static void elementToBeClickableWithWebElement(int time, WebElement Locator,WebDriver driver)
	{
	 WebDriverWait wait = new WebDriverWait(driver, time);
	 wait.until(ExpectedConditions.elementToBeClickable(Locator));
	 }

	
	public static void visibilityOf(int time, WebElement Locator,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(Locator));
	}

	public static int selectNGetIndexByText(List<WebElement> element,String text,Boolean isClick,WebDriver driver) {
		int index =0 ;
		for(int locater=0; locater<=element.size(); locater++) {
			if(element.get(locater).getText().equals(text)) {
				if(isClick) {
				CommonMethods.elementToBeClickableWithWebElement(20,element.get(locater),driver);
				element.get(locater).click();
				break;
				}
				index = locater+1;
				break;
			}
		}
		
		return index;
		
	}
	
	public static void SelectedDropDownValue(WebElement element,String text) {
		try {
			Select selectElement = new Select(element);
			selectElement.selectByVisibleText(text);
		} 
		catch (Exception message) {
			BaseClass.logger.info(message.getMessage());
		}
		
	}
	
}
