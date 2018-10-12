package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HelperBase {
  WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public void select(By locator, String text) {
    driver.findElement(locator).click();
    new Select(driver.findElement(locator)).selectByVisibleText(text);
    driver.findElement(locator).click();
  }

  public void typeText(By locator, String text) {
    driver.findElement(locator).click();
    /*driver.findElement(locator).clear();*/
    driver.findElement(locator).sendKeys(text);
  }

  public void actionsMouse(By locator) {
    WebElement submitCreateCustomer =  driver.findElement(locator);
    Actions actions = new Actions(driver);
    actions.moveToElement(submitCreateCustomer);
    actions.click(submitCreateCustomer).perform();
  }

  public void scroll(String coordinates) {
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript(coordinates);
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isTextPresent(String text) {
    try {
      return driver.findElement(By.tagName("body")).getText().contains(text);
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
