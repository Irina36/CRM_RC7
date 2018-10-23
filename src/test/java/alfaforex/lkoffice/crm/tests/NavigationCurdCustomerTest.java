package alfaforex.lkoffice.crm.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigationCurdCustomerTest extends TestBase {

  @Test(groups = {"CardCustomer"})
  public void customerProfile() {
    String acceptedAt = app.customer().getAcceptedAtPersonalInfo();
    app.goTo().customerProfile();
    String acceptedDataProfile = app.customer().getAcceptedDataProfile().substring(28,47);
    app.goTo().customerPersonalInfo();
    assertEquals(acceptedAt, acceptedDataProfile);
  }

  @Test (groups = {"CardCustomer"})
  public void customerVerification() {
    app.goTo().customerVerification();
    Boolean presentPageVerification = app.customer().isPresentPageVerification();
    assertTrue(presentPageVerification);
  }

  @Test (groups = {"CardCustomer"})
  public void customerDocuments() {
    app.goTo().customerDocuments();
    Integer preview = app.customer().isPresentDocumentsPreview();
    assertTrue(preview ==2);
  }


  @Test (groups = {"CardCustomer"})
  public void customerAccounts() throws InterruptedException {
    app.goTo().customerAccounts();
    Thread.sleep(3000);
    Boolean presentTextAccounts = app.customer().isTextPresent("Счета");
    assertTrue(presentTextAccounts);
  }

  @Test (groups = {"CardCustomer"})
  public void customerPayments() throws InterruptedException {
    app.goTo().customerPayments();
    Thread.sleep(3000);
    Boolean presentTextDeposits = app.customer().isTextPresent("Депозиты");
    Boolean presentTextWithdrawals = app.customer().isTextPresent("Вывод средств");
    Boolean presentTextInternalTransfers = app.customer().isTextPresent("Внутренний перевод средств");
    assertTrue(presentTextDeposits);
    assertTrue(presentTextWithdrawals);
    assertTrue(presentTextInternalTransfers);
  }

  @Test (groups = {"CardCustomer"})
  public void customerTickets() throws InterruptedException {
    app.goTo().customerTickets();
    Thread.sleep(3000);
    Boolean presentTextTickets = app.customer().isTextPresent("Тикеты");
    assertTrue(presentTextTickets);
  }

  @Test (groups = {"CardCustomer"})
  public void customerSettings() throws InterruptedException {
    app.goTo().customerSettings();
    Thread.sleep(3000);
    Boolean presentChangePassword = app.customer().isTextPresent("Смена пароля");
    Boolean presentFieldNewPassword = app.customer().isPresentFieldNewPassword();
    assertTrue(presentChangePassword);
    assertTrue(presentFieldNewPassword);
  }

}
