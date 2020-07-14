package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		logger.info("providing customer details...");
		
		addcust.clickAddNewCustomer();
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1988");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("Pune");
		addcust.custstate("MH");
		addcust.custpinno("411236");
		addcust.custtelephoneno("8612588515");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started...");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case is passed...");
		}
		else
		{
			logger.info("test case is failed...");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}