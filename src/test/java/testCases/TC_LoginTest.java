package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;

public class TC_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		
		
		try {
		
		logger.info("*****Test Started****");
		
		HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(rb.getString("email"));
		
		lp.setPassword(rb.getString("password"));
		
		lp.clickLogin();
		
		MyAccountPage mcc= new MyAccountPage(driver);
		
		boolean targetpage=mcc.isMyAccountPageExists();
		
		Assert.assertEquals(targetpage,true);
		
		
		
	}
	catch(Exception e) {
		
		
		Assert.fail();
	}
	
	logger.info("***Login test finished*****");
	
	

}
	
}
