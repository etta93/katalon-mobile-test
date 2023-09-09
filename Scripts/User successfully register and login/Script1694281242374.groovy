import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
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
import io.appium.java_client.AppiumDriver as AppiumDriver
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.internal.PathUtil
import internal.GlobalVariable


'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AppPath, RunConfiguration.getProjectDir())

Mobile.startApplication(appPath, true)

Mobile.verifyElementExist(findTestObject('Object Repository/Application/App Login/android.widget.TextView - Login  Registration Example'), 
    0)

Mobile.tap(findTestObject('Object Repository/Application/App Login/android.widget.Button - REGISTER'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Application/App Login/android.widget.TextView - PLEASE REGISTER'), 
    0)

Mobile.sendKeys(findTestObject('Object Repository/Application/App Login/android.widget.EditText (2)'), 'eta')

Mobile.sendKeys(findTestObject('Object Repository/Application/App Login/android.widget.EditText (3)'), '123456')

Mobile.sendKeys(findTestObject('Object Repository/Application/App Login/android.widget.EditText (4)'), '123456')

Mobile.tap(findTestObject('Object Repository/Application/App Login/android.widget.Button - CREATE'), 0)

Mobile.tap(findTestObject('Object Repository/Application/App Login/android.widget.Button - CREATE'), 0)

AppiumDriver<?> driver = MobileDriverFactory.getDriver()

def toast = driver.findElementByXPath('//android.widget.Toast[@text="Account Successfully Created "]')

if (toast == null) {
    KeywordUtil.markFailed('ERROR: Toast object not found!')
}

Mobile.pressBack()

Mobile.sendKeys(findTestObject('Object Repository/Application/App Login/android.widget.EditText (5)'), 'eta')

Mobile.sendKeys(findTestObject('Object Repository/Application/App Login/android.widget.EditText (6)'), '123456')

Mobile.tap(findTestObject('Object Repository/Application/App Login/android.widget.Button - LOGIN (1)'), 0)

Mobile.tap(findTestObject('Application/App Login/android.widget.Button - LOGIN (1)'), 0)

Mobile.getText(findTestObject('Object Repository/Application/App Login/android.widget.TextView - You have sucessfully logged in )'), 
    0)

Mobile.getText(findTestObject('Object Repository/Application/App Login/android.widget.TextView - YAAY'), 0)

Mobile.closeApplication()

