package paraBank

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

import internal.GlobalVariable

public class ParaBankRegistration {

	@Keyword
	def RegisterHyperlink(){

		WebUI.openBrowser('')
		WebUI.navigateToUrl(GlobalVariable.ParaBank_Url)
		WebUI.click(findTestObject('ParaBank/Registration/Register'))
		WebUI.delay(1)
	}

	//@Keyword
	//def UserDetails (String FirstName, String LastName, String Address, String City, String State, String ZipCode, String Phone, String SSN) {

	//def UserDetails (String FirstName, String LastName, String Address, String City, String State, String ZipCode, String Phone, String SSN, String Username, String Password, String Confirm) {

	//		WebUI.setText(findTestObject('ParaBank/Registration/First Name'),findTestData("ParaBank-Registration").getValue(1,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/Last Name'),findTestData("ParaBank-Registration").getValue(2,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/Address'),findTestData("ParaBank-Registration").getValue(3,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/City'),findTestData("ParaBank-Registration").getValue(4,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/State'),findTestData("ParaBank-Registration").getValue(5,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/Zip Code'),findTestData("ParaBank-Registration").getValue(6,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/Phone'),findTestData("ParaBank-Registration").getValue(7,rowNum))
	//		WebUI.setText(findTestObject('ParaBank/Registration/SSN'),findTestData("ParaBank-Registration").getValue(8,rowNum))
	//
	//		WebUI.setText(findTestObject('ParaBank/Registration/Username'),findTestData("ParaBank-Registration").getValue(9,rowNum))
	//		WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Password'),findTestData("ParaBank-Registration").getValue(10,rowNum))
	//		WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Confirm'),findTestData("ParaBank-Registration").getValue(11,rowNum))
	//	}
	@Keyword
	def UserDetails (String FirstName, String LastName, String Address, String City, String State, String ZipCode, String Phone, String SSN, String Username, String Password, String Confirm) {

		WebUI.setText(findTestObject('ParaBank/Registration/First Name'),FirstName)
		WebUI.setText(findTestObject('ParaBank/Registration/Last Name'),LastName)
		WebUI.setText(findTestObject('ParaBank/Registration/Address'),Address)
		WebUI.setText(findTestObject('ParaBank/Registration/City'),City)
		WebUI.setText(findTestObject('ParaBank/Registration/State'),State)
		WebUI.setText(findTestObject('ParaBank/Registration/Zip Code'),ZipCode)
		WebUI.setText(findTestObject('ParaBank/Registration/Phone'),Phone)
		WebUI.setText(findTestObject('ParaBank/Registration/SSN'),SSN)

		WebUI.setText(findTestObject('ParaBank/Registration/Username'),Username)
		WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Password'),Password)
		WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Confirm'),Confirm)
		WebUI.delay(1)
		WebUI.click(findTestObject('ParaBank/Registration/Register Finally'))
		WebUI.delay(1)
		WebUI.click(findTestObject('ParaBank/Registration/Logout'))
		WebUI.delay(1)
		WebUI.click(findTestObject('ParaBank/Registration/Register'))
		WebUI.delay(1)
	}

	@Keyword
	def closeBrowser(){
		WebUI.closeBrowser()
	}
}
