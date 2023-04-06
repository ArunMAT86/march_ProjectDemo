package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testCases.BaseClass;
import utilities.DataProviders;

public class TC_DataProviderTest extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String exp) {
		
		try  {
		logger.info("***start DDT****");
		
        HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email);
		
		lp.setPassword(password);
		
		lp.clickLogin();
		
        MyAccountPage mcc= new MyAccountPage(driver);
		
		boolean targetpage=mcc.isMyAccountPageExists();
		
		if(exp.equals("valid")) {
			
			if(targetpage==true) {
				
				mcc.clickLogout();
				Assert.assertTrue(true);
		
	}
			else {
				
				Assert.assertTrue(false);
			}
		
	}
		
		
		if(exp.equals("invalid")) {
			
			if(targetpage==true)
				
			mcc.clickLogout();
		
		Assert.assertTrue(true);
		
           }
			else{
				
				Assert.assertTrue(false);
			}
		
		}
		
		catch(Exception e) {
			
			Assert.fail();
			
		}
		
		logger.info("***finished DDT****");
			
}
    

}
    	 
    	 
    	 


