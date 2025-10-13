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

CustomKeywords.'paraBank.ParaBankRegistration.RegisterHyperlink'()

not_run: CustomKeywords.'paraBank.ParaBankRegistration.fillUserDetailsFromDataFile'()

not_run: CustomKeywords.'paraBank.ParaBankRegistration.UserDetails'(1)

not_run: CustomKeywords.'paraBank.ParaBankRegistration.UserDetails'(2)

not_run: CustomKeywords.'paraBank.ParaBankRegistration.UserDetails'(1, 2)

//for (def rowNum = 1; rowNum <= findTestData('ParaBank-Registration').getRowNumbers(); rowNum++) {
//    WebUI.setText(findTestObject('ParaBank/Registration/First Name'), findTestData('ParaBank-Registration').getValue(1, 
//            rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/Last Name'), findTestData('ParaBank-Registration').getValue(2, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/Address'), findTestData('ParaBank-Registration').getValue(3, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/City'), findTestData('ParaBank-Registration').getValue(4, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/State'), findTestData('ParaBank-Registration').getValue(5, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/Zip Code'), findTestData('ParaBank-Registration').getValue(6, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/Phone'), findTestData('ParaBank-Registration').getValue(7, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/SSN'), findTestData('ParaBank-Registration').getValue(8, rowNum))
//
//    WebUI.setText(findTestObject('ParaBank/Registration/Username'), findTestData('ParaBank-Registration').getValue(9, rowNum))
//
//    WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Password'), findTestData('ParaBank-Registration').getValue(10, rowNum))
//
//    WebUI.setEncryptedText(findTestObject('ParaBank/Registration/Confirm'), findTestData('ParaBank-Registration').getValue(11, rowNum))

// Load the Excel data file
def testData = findTestData('ParaBank-Registration')

for (int rowNum = 1; rowNum <= testData.getRowNumbers(); rowNum++) {
    // Read variables from Excel
    String FirstName = testData.getValue('FirstName', rowNum)

    String LastName = testData.getValue('LastName', rowNum)

    String Address = testData.getValue('Address', rowNum)

    String City = testData.getValue('City', rowNum)

    String State = testData.getValue('State', rowNum)

    String ZipCode = testData.getValue('ZipCode', rowNum)

    String Phone = testData.getValue('Phone', rowNum)

    String SSN = testData.getValue('SSN', rowNum)

    String Username = testData.getValue('Username', rowNum)

    String Password = testData.getValue('Password', rowNum)

    String Confirm = testData.getValue('Confirm', rowNum)

    WebUI.delay(1)

    CustomKeywords.'paraBank.ParaBankRegistration.UserDetails'(FirstName, LastName, Address, City, State, ZipCode, Phone, 
        SSN, Username, Password, Confirm)

    WebUI.click(findTestObject('ParaBank/Registration/Register Finally'))

    WebUI.delay(1)

    WebUI.click(findTestObject('ParaBank/Registration/Logout'))

    WebUI.delay(1)

    WebUI.click(findTestObject('ParaBank/Registration/Register'))

    WebUI.delay(1)
}

CustomKeywords.'paraBank.ParaBankRegistration.closeBrowser'()

