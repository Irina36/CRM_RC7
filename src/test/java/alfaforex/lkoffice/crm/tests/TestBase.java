package alfaforex.lkoffice.crm.tests;

import alfaforex.lkoffice.crm.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
  Logger logger = LoggerFactory.getLogger(TestBase.class);

  @BeforeSuite (alwaysRun = true)
  public void setUp() {
    app.init();
  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod(alwaysRun = true)
  public void logtestStart(Method m) {
    logger.info("Start test " + m.getName());
  }

  @AfterMethod (alwaysRun = true)
    public void logtestStop (Method m) {
      logger.info("Stop test " + m.getName());
    }

}
