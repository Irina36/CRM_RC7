package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(WebDriver driver) {

    super(driver);
  }

  public void login(String username, String password, String language, String code) {
    type(By.id("loginform-username"), username);
    type(By.id("loginform-password"), password);
    select(By.id("loginform-language"), language );

    if (isElementPresent(By.id("loginform-verify_code"))) {
      type(By.id("loginform-verify_code"), code);
    }
    driver.findElement(By.id("login-submit")).click();
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
