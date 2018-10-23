package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

  WebDriver driver;

  private  SessionHelper sessionHelper;
  private  NavigationHelper navigationHelper;
  private  CustomerHelper customerHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    System.setProperty("webdriver.gecko.driver", "/home/irina_okhotina/Документы/Projects/pageobjectseleniumtest/drivers/geckodriver");
    System.setProperty("webdriver.chrome.driver", "/home/irina_okhotina/Документы/Projects/pageobjectseleniumtest/drivers/chromedriver");
    if (browser.equals(BrowserType.CHROME) ) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.FIREFOX) ) {
      driver = new FirefoxDriver();
    } else  if (browser.equals(BrowserType.IE) ) {
      driver = new InternetExplorerDriver();
    }
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://office-lk-rc-dev.alfaforex.ru/index/login");
    customerHelper = new CustomerHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    sessionHelper.login("Tester", "QWEqwe123", "Russian", "test");
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
