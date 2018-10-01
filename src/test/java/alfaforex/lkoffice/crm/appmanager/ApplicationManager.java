package alfaforex.lkoffice.crm.appmanager;

import alfaforex.lkoffice.crm.generators.CustomerDataGenerator;
import alfaforex.lkoffice.crm.model.CustomerData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver driver;

  private  SessionHelper sessionHelper;
  private  NavigationHelper navigationHelper;
  private  CustomerHelper customerHelper;

  public void init() {
    System.setProperty("webdriver.gecko.driver", "/home/irina_okhotina/Документы/Projects/pageobjectseleniumtest/drivers/geckodriver");
    System.setProperty("webdriver.chrome.driver", "/home/irina_okhotina/Документы/Projects/pageobjectseleniumtest/drivers/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://office-lk-rc7-dev.alfaforex.com/index/login");
    customerHelper = new CustomerHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("Alena", "QWEasd123", "Russian", "test");
  }

  public void stop() {
    driver.quit();
  }

  public CustomerHelper customer() {
    return customerHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }
}
