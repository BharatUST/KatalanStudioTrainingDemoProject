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
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys as Keys

KeywordUtil.logInfo("[STEP 1] Launching Chrome browser...")
WebUI.openBrowser('')

KeywordUtil.logInfo("[STEP 2] Navigating to Flipkart home page...")
WebUI.navigateToUrl(GlobalVariable.Flipkart_Url)

KeywordUtil.logInfo("[STEP 3] Searching for 'iPhone 7'...")
WebUI.setText(findTestObject('Flipkart/Checkout/Search'), 'i phone 7')
WebUI.sendKeys(findTestObject('Flipkart/Checkout/Search'), Keys.chord(Keys.ENTER))
WebUI.delay(1)

String expectedText = 'Currently unavailable'
KeywordUtil.logInfo("[STEP 4] Verifying product availability message: 'out of stock'")

boolean isUnavailable = WebUI.verifyTextPresent(expectedText, false, FailureHandling.OPTIONAL)

if (isUnavailable) {
	KeywordUtil.logInfo("✅ Product is unavailable as expected.")
	WebUI.takeScreenshot('Screenshots/iPhone7Check1.png')
	
} else {
	KeywordUtil.markWarning("Product might be available or text changed.")
	WebUI.takeScreenshot('Screenshots/iPhone7Check2.png')
}

try {
    WebUI.verifyTextPresent('Currently unavailable1', false)
    KeywordUtil.logInfo("✅ Text verification PASSED: 'Currently unavailable' found on page.")
	WebUI.takeScreenshot('Screenshots/iPhone7Check3.png')
	
} catch (Exception e) {
    KeywordUtil.markError("❌ Text verification FAILED: 'Currently unavailable' not found. Error - " + e.getMessage())
	WebUI.takeScreenshot('Screenshots/iPhone7Check4.png')
	
        //repeating 'try' block again	
		WebUI.verifyTextPresent('Currently unavailable1', false)
		KeywordUtil.logInfo("✅ Text verification PASSED: 'Currently unavailable' found on page.")
		WebUI.takeScreenshot('Screenshots/iPhone7Check3.png')

}
