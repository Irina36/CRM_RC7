package alfaforex.lkoffice.crm.tests;

import alfaforex.lkoffice.crm.appmanager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @BeforeSuite
  public void setUp() throws IOException {
    app.init();
  }

  @AfterSuite
  public void tearDown()  {
    app.stop();
  }

}
