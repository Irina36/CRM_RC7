package alfaforex.lkoffice.crm.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CustomerModificationTest extends TestBase{

  @Test
  public void modifyCustomerPersonalData () throws InterruptedException {
    app.goTo().customerListPage();
    Thread.sleep(3000);
    app.goTo().customerCurdPage();
    Thread.sleep(3000);
    app.customer().initUpdateButton();
    app.customer().modifyPersonalData();
    String textModify = app.customer().getTextModify();
    assertEquals(textModify, "Австралия");
  }
}
