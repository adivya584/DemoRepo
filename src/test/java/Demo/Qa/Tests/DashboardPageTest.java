package Demo.Qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Demo.Qa.Pages.DashboardPage;
import Demo.Qa.Pages.LoginPage;
import Demo.Qa.TestBase.TestBase;

public class DashboardPageTest extends TestBase {
	LoginPage login;
	DashboardPage dashboardPage;

	public DashboardPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		initialization();
		login=new LoginPage();
		dashboardPage=new DashboardPage();
	}
	@AfterClass
	public void tearDown()
	{
		dashboardPage.Logout();
		driver.close();
	}	
	@Test
	public void DashboardPageTitleTest()
	{
		String title=login.validateTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test
	public void CliclOnMyInfo()
	{
		dashboardPage.ClickOnMyInfoButton();
	}

}
