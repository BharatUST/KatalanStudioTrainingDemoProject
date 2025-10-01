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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.ParaBank_Url)

WebUI.click(findTestObject('ParaBank/Registration/Register'))

//
//WebUI.setText(findTestObject('ParaBank/Registration/First Name'), FirstName)
//
//WebUI.setText(findTestObject('ParaBank/Registration/Last Name'), LastName)
//
//WebUI.setText(findTestObject('ParaBank/Registration/Address'), Address)
//
//WebUI.setText(findTestObject('ParaBank/Registration/City'), City)
//
//WebUI.setText(findTestObject('ParaBank/Registration/State'), State)
//
//WebUI.setText(findTestObject('ParaBank/Registration/Zip Code'), ZipCode)
//
//WebUI.setText(findTestObject('ParaBank/Registration/Phone'), Phone)
//
//WebUI.setText(findTestObject('ParaBank/Registration/SSN'), SSN)
//
//WebUI.setText(findTestObject('ParaBank/Registration/Username'), Username)
//
//WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Password'), Password)
//
//WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Confirm'), Confirm)
//
//WebUI.delay(2)
//
//WebUI.click(findTestObject('ParaBank/Registration/Register Finally'))
//
//WebUI.click(findTestObject('ParaBank/Registration/Logout'))
//
//WebUI.closeBrowser()

for (def rowNum=1; rowNum<= findTestData("ParaBank-Registration").getRowNumbers(); rowNum++)
	{
	WebUI.setText(findTestObject('ParaBank/Registration/First Name'),findTestData("ParaBank-Registration").getValue(1,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/Last Name'),findTestData("ParaBank-Registration").getValue(2,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/Address'),findTestData("ParaBank-Registration").getValue(3,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/City'),findTestData("ParaBank-Registration").getValue(4,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/State'),findTestData("ParaBank-Registration").getValue(5,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/Zip Code'),findTestData("ParaBank-Registration").getValue(6,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/Phone'),findTestData("ParaBank-Registration").getValue(7,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/SSN'),findTestData("ParaBank-Registration").getValue(8,rowNum))
	WebUI.setText(findTestObject('ParaBank/Registration/Username'),findTestData("ParaBank-Registration").getValue(9,rowNum))
	WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Password'),findTestData("ParaBank-Registration").getValue(10,rowNum))
	WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Confirm'),findTestData("ParaBank-Registration").getValue(11,rowNum))
	//WebUI.delay(2)
	WebUI.click(findTestObject('ParaBank/Registration/Register Finally'))
	WebUI.delay(2)
	WebUI.click(findTestObject('ParaBank/Registration/Logout'))
	WebUI.delay(2)
	WebUI.click(findTestObject('ParaBank/Registration/Register'))
	WebUI.delay(2)
	}
	WebUI.closeBrowser()
	

