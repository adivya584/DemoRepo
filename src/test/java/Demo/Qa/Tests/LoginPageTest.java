package Demo.Qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Demo.Qa.Pages.DashboardPage;
import Demo.Qa.Pages.LoginPage;
import Demo.Qa.TestBase.TestBase;
import Demo.Qa.Util.Util;

public class LoginPageTest extends TestBase{
	String sheetName = "Sheet1";
	LoginPage login;
	DashboardPage dashboardPage;
	
	public LoginPageTest(){
		super();
	}
	
	@DataProvider
	public Object[][] getLoginTestData(){
		Object data[][] = Util.getTestData(sheetName);
		return data;
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
	public void LoginPageTitleTest()
	{
		String title=login.validateTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	@Test(dataProvider="getLoginTestData")
	public void LoginTest(String UserName,String Password)
	{
		login.Login(UserName,Password);
		String currentDir = System.getProperty("user.dir");
		System.out.println("User Dir: "+currentDir);
	}
}
