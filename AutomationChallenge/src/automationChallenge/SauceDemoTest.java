package automationChallenge;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;

public class SauceDemoTest {
    public String baseUrl = "https://www.saucedemo.com/";
    String driverPath = "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe";
    public WebDriver driver ; 
        
    @Test (priority=0, description = "1. Login with a valid user")
    public void loginWithValidUser() {

	  /*1. Log in with a valid user */
	  System.out.println("1. Login with a valid user"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();

	  String loginSuccess = "PRODUCTS";
	  String actualLoginSucces = driver.findElement(By.cssSelector("span.title")).getText();
	  
	  try {
		  Assert.assertEquals(actualLoginSucces, loginSuccess);
	  } catch (AssertionError e) {
		    System.out.println("1. Login with a valid user -> FAILED");
		    throw e;
	  } System.out.println("1. Login with a valid user -> DONE");
	  	    
	  driver.close();
    }
  
    @Test(priority=1, description = "2. Login with an invalid user")
    public void loginWithInvalidUser() {

	  /*2. Login with an invalid user */
	  System.out.println("2. Login with an invalid user"); 
	  System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);      
      driver.findElement(By.id("user-name")).sendKeys("username");
      driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.id("login-button")).click();

	  String loginInvalid = "Epic sadface: Username and password do not match any user in this service";
	  String actualLoginInvalid = driver.findElement(By.cssSelector("h3")).getText();
	  //System.out.println("span title"+actualTitle); 
	  
	  try {
		  Assert.assertEquals(actualLoginInvalid, loginInvalid);
	  } catch (AssertionError e) {
		    System.out.println("2. Login with an invalid user -> FAILED");
		    throw e;
	  } System.out.println("2. Login with an invalid user -> DONE");
	  
	  driver.close();
    }
 
    @Test (priority=2, description = "3. Logout from the home page")
    public void logOut() {

	  /*1. Log in with a valid user */
	  System.out.println("3. Logout from the home page"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();

	  driver.findElement(By.id("react-burger-menu-btn")).click();
	  driver.findElement(By.id("logout_sidebar_link")).click();
	  System.out.println("3. Logout from the home page -> DONE"); 
	  
	  driver.close();
    }
    
    @Test (priority=3, description = "4. Sort products by Price (low to high)")
    public void sortProducts() {
    	
	  /*4. Sort products by Price (low to high) */
	  System.out.println("4. Sort products by Price (low to high)"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();

	  WebElement element = driver.findElement(By.cssSelector("select.product_sort_container"));
	  Select sel = new Select(element); 
	  sel.selectByValue("lohi");
	  System.out.println("4. Sort products by Price (low to high) -> DONE"); 
	  driver.close();
    }
    
    @Test (priority=4, description = "5. Add multiple items to the shopping cart")
    public void addItems() {
    	
	  /*4. Sort products by Price (low to high) */
	  System.out.println("5. Add multiple items to the shopping cart"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();

	  driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	  driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
	  driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
	  
	  String cartSuccess = "YOUR CART";
	  String actualCartSucces = driver.findElement(By.cssSelector("span.title")).getText();
	  
	  try {
		  Assert.assertEquals(actualCartSucces, cartSuccess);
	  } catch (AssertionError e) {
		    System.out.println("5. Add multiple items to the shopping cart -> FAILED");
		    throw e;
	  } System.out.println("5. Add multiple items to the shopping cart -> DONE");
	  
	  driver.close();
 
    }

    @Test (priority=5, description = "6. Add the specific product ‘Sauce Labs Onesie’ to the shopping cart")
    public void addSpecificItem() {
    	
	  /*4. Sort products by Price (low to high) */
	  System.out.println("6. Add the specific product ‘Sauce Labs Onesie’ to the shopping cart"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();

	  driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
	  driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
	  
	  String cartSuccess = "YOUR CART";
	  String actualCartSucces = driver.findElement(By.cssSelector("span.title")).getText();
	  
	  try {
		  Assert.assertEquals(actualCartSucces, cartSuccess);
	  } catch (AssertionError e) {
		    System.out.println("6. Add the specific product ‘Sauce Labs Onesie’ to the shopping cart -> FAILED");
		    throw e;
	  } System.out.println("6. Add the specific product ‘Sauce Labs Onesie’ to the shopping cart -> DONE");
	  
	  driver.close();
    }

    @Test (priority=6, description = "7. Complete a purchase")
    public void completePurchase() {
    	
	  /*4. Sort products by Price (low to high) */
	  System.out.println("7. Complete a purchase"); 
      System.setProperty("webdriver.gecko.driver", driverPath);
      driver = new FirefoxDriver();
      driver.get(baseUrl);
      driver.findElement(By.id("user-name")).sendKeys("standard_user");
      driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();

	  driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
	  driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
	  driver.findElement(By.id("checkout")).click();
	  
      driver.findElement(By.id("first-name")).sendKeys("firstname");
      driver.findElement(By.id("last-name")).sendKeys("lastname");    
      driver.findElement(By.id("postal-code")).sendKeys("11520");
	  driver.findElement(By.id("continue")).click();
	  driver.findElement(By.id("finish")).click();
	  
	  
	  String confirmationSuccess = "CHECKOUT: COMPLETE!";
	  String actualConfirmationSucces = driver.findElement(By.cssSelector("span.title")).getText();
	  
	  try {
		  Assert.assertEquals(actualConfirmationSucces, confirmationSuccess);
	  } catch (AssertionError e) {
		    System.out.println("7. Complete a purchase -> FAILED");
		    throw e;
	  } System.out.println("7. Complete a purchase-> DONE");
	  
	  driver.close();
    }
}
