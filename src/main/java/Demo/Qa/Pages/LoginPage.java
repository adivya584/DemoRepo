package Demo.Qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Demo.Qa.TestBase.TestBase;

public class LoginPage extends TestBase{

	@FindBy(id="txtUsername")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(id="txtPassword")
	WebElement Password;
	
	@FindBy(id="btnLogin")
	WebElement LoginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public DashboardPage Login(String userName,String password)
	{
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		LoginButton.click();
		return new DashboardPage();
	}
	
	
}
