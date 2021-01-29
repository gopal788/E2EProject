package ToolsQA;
import java.awt.AWTException;   
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import PageObjects.LoginPageElements;
public class Anthem_LoginTestScenarios extends baseclass
{
	public WebDriver driver;
	public WebDriverWait wait;
	public static Logger log=LogManager.getLogger(baseclass.class.getName());
	@Test
	public void TC_1_VerifyHomePageLoaded() throws IOException
	{   
		driver=initializebrowsers();
		Reporter.log("Launching browser");
		log.info("Launching browser");
		driver.get(prop.getProperty("url"));
		//driver.get("http://ent-prm-tweb02.itocservices.com/AnthemDcc/login");
		Reporter.log("Anthem login page loaded");
		log.info("Anthem login page loaded");
		LoginPageElements obj=new LoginPageElements(driver);
		obj.usernamefield("GopalM");
		Reporter.log("Entered username");
		log.info("Entered username");
		obj.passwordfield("123@Gopal");
		Reporter.log("Entered password");
		log.info("Entered password");
		obj.LoginButton();
		Reporter.log("Clicked on login_Button");
		log.info("Clicked on login_Button");
		driver.close();
	}
	@Test
	public void TC_2_SignUpPage() throws IOException, InterruptedException 
	{
		driver=initializebrowsers();
		Reporter.log("Launching browser");
		log.info("Launching browser");
		driver.get(prop.getProperty("url"));
		driver.get("http://ent-prm-tweb02.itocservices.com/AnthemDcc/login");
		Reporter.log("Anthem login page loaded");
		log.info("Anthem login page loaded");
		LoginPageElements obj=new LoginPageElements(driver);
		obj.SignButton();
		Reporter.log("Clicked on SignUpbutton");
		log.info("Clicked on SignUpbutton");
		Assert.assertTrue(obj.UserRegistartionPage().isDisplayed(), "User Registration is not visible");
		Reporter.log("Verified registration page");
		log.info("Verified registration page");
		Assert.assertTrue(obj.FirstNameFieldVerified().isDisplayed(), "First Name field did not display ");
		Reporter.log("Verified employee First Name field");
		log.info("Verified employee First Name field");
		Assert.assertTrue(obj.LastNameFieldVerified().isDisplayed(), "Last Name field did not display");
		Reporter.log("Verified employee last Name field");
		log.info("Verified employee last Name field");
		Assert.assertTrue(obj.UserDomainID().isDisplayed(), "UserDomainID field did not display");
		Reporter.log("Verified domain Id field");
		log.info("Verified domain Id field");
		Assert.assertTrue(obj.EmployeeEmailAddress().isDisplayed(), "EmployeeEmailAddress field did not display");
		Reporter.log("Verified email Id field");
		log.info("Verified email Id field");
		Assert.assertTrue(obj.CreatePassword().isDisplayed(), "Create Password field did not display");
		Reporter.log("Verified password Field.");
		log.info("Verified password Field.");
		Assert.assertTrue(obj.ConfirmPassword().isDisplayed(), "Confirm Password field did not display");
		Reporter.log("Verified confirm Password Field");
		log.info("Verified confirm Password Field");
		Assert.assertTrue(obj.SelectRoles().isDisplayed(), "Select roles field did not display");
		Reporter.log("Verified select Role Drop Down");
		log.info("Verified select Role Drop Down");
		Thread.sleep(1000);
		Assert.assertTrue(obj.SelectRoleasBasicUser().isDisplayed(), "Select roles as basic user field did not display");
		obj.SelectRoleasBasicUser().click();
		Reporter.log("Selected role from drop down.");
		log.info("Selected role from drop down.");
		Assert.assertTrue(obj.CostCenterID().isDisplayed(), "Cost Center ID did not display");
		Reporter.log("Verified cost Centre Id Field.");
		log.info("Verified cost Centre Id Field.");
		Assert.assertTrue(obj.AddCostCenter_Button().isDisplayed(), "Add CostCenter_Button did not display");
		Reporter.log("Verified add Cost Centre Button.");
		log.info("Verified add Cost Centre Button.");
		driver.close();
	}
	@Test
	public void TC_3_PlaceNewOrderForBulk() throws IOException, AWTException
	{
		driver=initializebrowsers();
		Reporter.log("Launching browser");
		log.info("Launching browser");
		driver.get(prop.getProperty("url"));
		driver.get("http://ent-prm-tweb02.itocservices.com/AnthemDcc/login");
		Reporter.log("Anthem login page loaded");
		log.info("Anthem login page loaded");
		LoginPageElements obj=new LoginPageElements(driver);
		obj.usernamefield("GopalM");
		Reporter.log("Entered username");
		log.info("Entered username");
		obj.passwordfield("123@Gopal");
		Reporter.log("Entered password");
		log.info("Entered password");
		obj.LoginButton();
		Reporter.log("Clicked on login_Button");
		log.info("Clicked on login_Button");
		Assert.assertTrue(obj.VerifyName().isDisplayed(), "UserName Text did not display");
		System.out.println(obj.VerifyName().getText());
		Reporter.log("UserName Text is displayed");
		log.info("UserName Text is displayed");
		Assert.assertTrue(obj.PlaceaNewOrder().isDisplayed(), "Place New Order button didn't verified and click");
		Reporter.log("Clicked on Place New Order_Button");
		log.info("Clicked on Place New Order_Button");
		Assert.assertTrue(obj.ProcessPODBulk().isDisplayed(), "POD_Bulk did not display");
		Reporter.log("POD_Bulk option has displayed and processed");
		log.info("POD_Bulk option has displayed and processed");
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title-mandatory']")));
		//Assert.assertTrue(obj.ChooseFiles().isDisplayed(), "ChooseFiles Option didn't display");
		obj.ChooseFilesVerifyandUpload();
		Reporter.log("ChooseFile Option has verfied and Letter File Uploaded Successfully");
		log.info("ChooseFile Option has verfied and Letter File Uploaded Successfully");
	    obj.ScrollDown(driver);
	    obj.FillAllFieldsInReturnAddress();
	    obj.ScrollDown(driver);
	    obj.Navigatetonextpage();
	}

}
