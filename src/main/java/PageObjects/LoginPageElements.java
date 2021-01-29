package PageObjects;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPageElements
{
	//Declaration
	@FindBy(xpath="//input[@placeholder='Enter Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Enter Password']") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement LogginButton;
	@FindBy(xpath="//a[text()='Sign Up']") WebElement SignUpbutton;
	@FindBy(xpath="//h3[text()='User Registration']") WebElement RegVerification;
	@FindBy(id="fname") WebElement FirstName;
	@FindBy(xpath="//input[@formcontrolname='lName']") WebElement LastName;
	@FindBy(id="empID") WebElement UsernameID;
	@FindBy(id="eemailid") WebElement EmailAddress;
	@FindBy(id="password") WebElement CreatePwd;
	@FindBy(id="cpassword") WebElement ConfirmPwd;
	@FindBy(xpath="//select[@formcontrolname='roles']") WebElement selectrole;
	@FindBy(xpath="//option[text()='Basic User']") WebElement Basicuser;
	@FindBy(id="costcenterid") WebElement CCID;
	@FindBy(xpath="//button[@type='button']") WebElement AddCC;
	@FindBy(xpath="//h6[text()=' Welcome Basic User']") WebElement VerifyUserName;
	@FindBy(xpath="//span[text()='Place a New Order']") WebElement PANOClick;
	@FindBy(xpath="//a[text()=' POD - Bulk ']") WebElement ClickPoDBulk;
	@FindBy(xpath="//label[@class='upload-file']") WebElement UploadFilesUpload;
	@FindBy(id="name") WebElement NameField;
	@FindBy(id="address1") WebElement address1Field;
	@FindBy(id="city") WebElement cityField;
	@FindBy(id="State") WebElement StateField;
	@FindBy(id="Zip") WebElement ZipField;
	@FindBy(xpath="//button[@type='submit']") WebElement NextButton;
	//Initilization
	public LoginPageElements(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
	//utilization
	public void usernamefield(String Text)
	{
		username.sendKeys(Text);
	}	
	public void passwordfield(String Text)
	{
		password.sendKeys(Text);	
	}
	public void LoginButton()
	{
		LogginButton.click();	
	}
	public void SignButton()
	{
		SignUpbutton.click();	
	}
	public WebElement UserRegistartionPage()
	{
		return RegVerification;	
	}
	public WebElement FirstNameFieldVerified()
	{
		return FirstName;	
	}
	public WebElement LastNameFieldVerified()
	{
		return LastName;
	}
	public WebElement UserDomainID()
	{
		return UsernameID;	
	}
	public WebElement EmployeeEmailAddress()
	{
		return EmailAddress;
	}
	public WebElement CreatePassword()
	{
		return CreatePwd;	
	}
	public WebElement ConfirmPassword()
	{
		return ConfirmPwd;
	}
	public WebElement SelectRoles()
	{
		return selectrole;
	}
	public WebElement SelectRoleasBasicUser()
	{
		return Basicuser;
	}
	public WebElement CostCenterID()
	{
		return CCID;
	}
	public WebElement  AddCostCenter_Button()
	{
		return AddCC;
	}
	public WebElement VerifyName()
	{
		return VerifyUserName;
	}
	public WebElement PlaceaNewOrder()
	{
		PANOClick.click();
		return PANOClick;
	}
	public WebElement ProcessPODBulk()
	{
		ClickPoDBulk.click();
		return ClickPoDBulk;
	}
	public void ChooseFilesVerifyandUpload() throws AWTException
	{
		 Robot robot=new Robot();
		 UploadFilesUpload.click();
		 robot.setAutoDelay(1000);
		 StringSelection stringselection=new StringSelection("D:\\Anthem_Files\\POD\\a.PdF");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		 robot.setAutoDelay(1000);
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 robot.setAutoDelay(1000);
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	}
	public void ScrollDown(WebDriver driver)
	{
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	public void FillAllFieldsInReturnAddress()
	{
		NameField.sendKeys("GopalM");
		address1Field.sendKeys("Tirumala Main Road");
		cityField.sendKeys("Tirupati");
		StateField.sendKeys("AP");
		ZipField.sendKeys("51750");
	}
	public void Navigatetonextpage()
	{
		NextButton.click();
	}
}
