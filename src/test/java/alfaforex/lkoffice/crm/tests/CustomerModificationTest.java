package alfaforex.lkoffice.crm.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CustomerModificationTest extends TestBase{

  @Test (groups = {"CardCustomer"})
  public void modifyCustomerPersonalData () throws InterruptedException {
    app.customer().initUpdateButton();
    app.customer().modifyPersonalData();
    String textModify = app.customer().getTextModify();
    assertEquals(textModify, "Австралия");
  }

}
