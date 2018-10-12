package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

  public SessionHelper(WebDriver driver) {

    super(driver);
  }

  public void login(String username, String password, String language, String code) {
    typeText(By.id("loginform-username"), username);
    typeText(By.id("loginform-password"), password);
    select(By.id("loginform-language"), language );

    if (isElementPresent(By.id("loginform-verify_code"))) {
      typeText(By.id("loginform-verify_code"), code);
    }
    actionsMouse(By.xpath("//*[@id=\"login-submit\"]"));
  }

}
