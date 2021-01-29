package ToolsQA;
import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class baseclass
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializebrowsers() throws IOException
	{
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\52101569\\Desktop\\eclipse\\E2EProject\\src\\main\\java\\ToolsQA\\data.Properties");
		prop.load(fis);
		String browser_name= prop.getProperty("browser");
		if(browser_name.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://browserDrivers//chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else
		if(browser_name.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C://Users//Public//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		if(browser_name.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C://Users//Public//MicrosoftWebDriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	public static String getTakeScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot src=(TakesScreenshot)driver;
		File source=src.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
