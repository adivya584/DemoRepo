package Demo.Qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Demo.Qa.TestBase.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy(id="menu_pim_viewMyDetails")
	WebElement MyInfoButton;
	
	@FindBy(id="welcome")
	WebElement WelcomeLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement Logout;
	
	public DashboardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public MyInfoPage ClickOnMyInfoButton()
	{
		MyInfoButton.click();
		return new MyInfoPage();
	}
	
	public void Logout()
	{
		WelcomeLink.click();
		Logout.click();
	}
}
