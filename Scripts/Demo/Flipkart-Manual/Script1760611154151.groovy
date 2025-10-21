import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

//WebUI.openBrowser('')
//WebUI.navigateToUrl(GlobalVariable.Flipkart_Url)
//WebUI.maximizeWindow()
//WebUI.setText(findTestObject('Flipkart/Checkout/Search'), 'i phone 14')
//WebUI.sendKeys(findTestObject('Flipkart/Checkout/Search'), Keys.chord(Keys.ENTER))  //to press Enter key
//WebUI.delay(1)
//WebUI.click(findTestObject('Flipkart/Checkout/1stProduct'))
//WebUI.delay(5)
//WebUI.switchToWindowIndex(1)
//WebUI.delay(5)
//WebUI.click(findTestObject('Flipkart/Checkout/AddToCart'))    //add to cart
//--------------------------------------------------------------------------------------------------------------
//WebUI.verifyTextPresent('NOTIFY ME', false) // to verify text anywhere on a page & throws error if verification fails unless wrapped in try-catch

//String productText = WebUI.getText(findTestObject('Flipkart/Checkout/1stProduct')) //to extract/read text from a specific web element & store it in a variable for further use.
//--------------------------------------------------------------------------------------------------------------
WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.Flipkart_Url)
WebUI.maximizeWindow()
WebUI.setText(findTestObject('Flipkart/Checkout/Search'), 'i phone 16')
WebUI.sendKeys(findTestObject('Flipkart/Checkout/Search'), Keys.chord(Keys.ENTER))
WebUI.delay(1)
WebUI.click(findTestObject('Flipkart/Checkout/1stProduct'))  //PDP
WebUI.delay(5)
WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject("Flipkart/Checkout/AddToCart"), 1)  //optional
WebUI.waitForElementVisible(findTestObject("Flipkart/Checkout/NotifyMe"), 1)   //optional

//if(WebUI.verifyTextPresent('NOTIFY ME', false)){
if(WebUI.verifyElementPresent(findTestObject("Flipkart/Checkout/NotifyMe"), 2, FailureHandling.OPTIONAL)) {  //searching for 'Notify Me' text
    KeywordUtil.markWarning("Product is out of stock. Skipping add to cart.")
} else {
    WebUI.click(findTestObject("Flipkart/Checkout/AddToCart"))   //Add to cart only if it’s in stock
    KeywordUtil.logInfo("Product added to cart successfully.")
}

String TotalAmountText = WebUI.getText(findTestObject('Flipkart/Checkout/Total Amount'))   //reading the 'Total Amount' text from webpage
double TotalAmount = TotalAmountText.replaceAll("[^0-9]", "").toDouble()  //convert text to number. Example: "₹12,499" → 12499
double threshold = 53050.0    // Compare with threshold

switch (true) {
	case (TotalAmount > threshold):
		WebUI.delay(1)
		WebUI.click(findTestObject('Flipkart/Checkout/Place Order'))    //place order
		break

	case (TotalAmount == threshold):
		WebUI.delay(1)
		WebUI.click(findTestObject('Flipkart/Checkout/Place Order'))   //place order
		break

	default:
		WebUI.delay(1)
		KeywordUtil.markWarning("Cart total is below threshold. Not proceeding to checkout.")   
		break                                                          //abort placing order
}