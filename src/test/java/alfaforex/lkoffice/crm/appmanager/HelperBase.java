package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HelperBase {
  WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void select(By locator, String text) {
    driver.findElement(locator).click();
    new Select(driver.findElement(locator)).selectByVisibleText(text);
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  protected void actionsMouse(By locator) {
    WebElement submitCreateCustomer =  driver.findElement(locator);
    Actions actions = new Actions(driver);
    actions.moveToElement(submitCreateCustomer);
    actions.click(submitCreateCustomer).perform();
  }
}
