package stepDefenitions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("User navigate to CURA Healthcare Service")
	def User_navigate_to_CURA_Healthcare_Service() {
		WebUI.openBrowser('https://katalon-demo-cura.herokuapp.com/');
		WebUI.waitForPageLoad(30);
	}

	@When("User click Make Appointment button")
	def User_click_Make_Appointment_button() {
		WebUI.click(findTestObject('Page_CURA Healthcare Service_Login/a_Make Appointment'))
	}

	@Then("User can enter username (.*) and password (.*)")
	def User_can_enter_username_and_password(String username, String password) {
		WebUI.setText(findTestObject('Page_CURA Healthcare Service_Login/input_userName'), username)
		WebUI.setText(findTestObject('Page_CURA Healthcare Service_Login/input_password'), password)
	}

	@Then("User click login button")
	def User_click_login_button() {
		WebUI.click(findTestObject('Page_CURA Healthcare Service_Login/button_Login'))
	}

	@Then ("User should be able to login successfully")
	def User_should_be_able_to_login_successfully() {
		WebUI.click(findTestObject('Page_CURA Healthcare Service_Login/button_Login'))
		WebUI.verifyTextPresent('Make Appointment', false)
		WebUI.closeBrowser()
	}

	@Then("User can enter invalid username (.*) and invalid password (.*)")
	def User_can_enter_invalid_username_and_invalid_password(String invalid_username, String invalid_password) {
		WebUI.setText(findTestObject('Page_CURA Healthcare Service_Login/input_userName'), invalid_username)
		WebUI.setText(findTestObject('Page_CURA Healthcare Service_Login/input_password'), invalid_password)
	}

	@Then("User should NOT be able to login successfully")
	def User_should_NOT_be_able_to_login_successfully() {
		WebUI.verifyTextPresent('Login failed! Please ensure the username and password are valid.', false)
		WebUI.closeBrowser()
	}
}

