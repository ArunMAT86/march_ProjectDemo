package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.BasePage;
import PageObjects.HomePage;

public class TC_AccountRegTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"})
	void test_accountReg() {
		
		logger.info("****Startin Test****");
		
		try
		{
		
		HomePage hp= new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("****click****");
		
		hp.clickRegister();
		
		logger.info("****my account****");
		
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		
          regpage.setFirstname(randomeString().toUpperCase());
		
		regpage.setLastname(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");
		
		regpage.setTelephone(randomeNumber());
		
		//String password= randomAlphaNumeric();
		
		regpage.setPassword("qwe@123");
		
		regpage.setConfirmPassword("qwe@123");
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
          String confmsg=regpage.getConfirmationMsg();
		
		System.out.println(confmsg);
		
		logger.info("****validation****");
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!","ERROR");
		
	}
	
	catch(Exception e) {
		
		logger.error("**** Test failed****");
		
		Assert.fail();
	}
	
		logger.info("****Finished****");

}
	
}
