package ToolsQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Verifygmailtitle
{
	@Test
	public void Verifygmailtitle_TastcaseID()
	{
		System.setProperty("webdriver.chrome.driver", "D://browserDrivers//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://hirepro.in/");
		WebElement ele=driver.findElement(By.xpath("//a[@title='About Us']"));
		String title=ele.getText();
		System.out.print(title);
	}

}
