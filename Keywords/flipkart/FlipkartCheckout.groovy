package flipkart

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class FlipkartCheckout {

	@Keyword
	def PDP () {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.Flipkart_Url)
		WebUI.maximizeWindow()
		WebUI.setText(findTestObject('Flipkart/Checkout/Search'), 'i phone 16')
		WebUI.sendKeys(findTestObject('Flipkart/Checkout/Search'), Keys.chord(Keys.ENTER))
		WebUI.delay(1)
		WebUI.click(findTestObject('Flipkart/Checkout/1stProduct'))  //PDP
		WebUI.delay(5)
		WebUI.switchToWindowIndex(1)
	}

	@Keyword
	def CheckingStock () {
		if(WebUI.verifyElementPresent(findTestObject("Flipkart/Checkout/NotifyMe"), 2, FailureHandling.OPTIONAL)) {//searching for 'Notify Me' text
		KeywordUtil.markWarning("Product is out of stock. Skipping add to cart.")
		} else {
			WebUI.click(findTestObject("Flipkart/Checkout/AddToCart"))   //Add to cart only if it’s in stock
			KeywordUtil.logInfo("Product added to cart successfully.")
		}
	}
}


