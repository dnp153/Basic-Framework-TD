package tests;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

public class LoginTest {
  
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  
  @Test(priority = 1)
  public void loginWithWrongUsernameAndPassword() throws InterruptedException {
	  
	  lp.login(df.wrongUserName, df.wrongPassword);
	  
	  Assert.assertEquals(lp.readError(), df.genericErr);
	  
  }
  
  @Test(priority = 2)
  public void loginWithInvalidUsernameAndPassword() throws InterruptedException {
	  
	  lp.login(df.invalidUserName, df.wrongPassword);

	  Assert.assertEquals(lp.readError(), df.genericErr);
  }
  
  @Test(priority = 3)
  public void loginWithEmptyUsernameAndPassword() throws InterruptedException {
 
	  lp.login("", df.wrongPassword);

	  Assert.assertEquals(lp.readError(), df.emptyEmailErr);
	  
  }
  
  @Test(priority = 4)
  public void loginWithUsernameAndEmptyPassword() throws InterruptedException {
 
	  lp.login(df.wrongUserName, "");

	  Assert.assertEquals(lp.readError(), df.emptyPasswordErr);
	  
  }

}
