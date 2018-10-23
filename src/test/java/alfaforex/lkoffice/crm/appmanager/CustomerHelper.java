package alfaforex.lkoffice.crm.appmanager;

import alfaforex.lkoffice.crm.model.CustomerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerHelper extends HelperBase{

  public CustomerHelper(WebDriver driver) {
    super(driver);
  }

  public void clickCreateCustomer() {
    actionsMouse(By.xpath("//*[@id=\"create-item\"]/span"));
  }

  public void fillCreateCustomerForm(CustomerData customerData) throws InterruptedException {

    select(By.xpath("//*[@id=\"customerrole-role_id\"]"), customerData.getTypeCustomer());

    typeText(By.id("lastNameReal"), customerData.getLastname());
    typeText(By.id("firstNameReal"), customerData.getFirstname());
    typeText(By.xpath("//*[@id=\"customerindividual-birth_date\"]"), customerData.getDateOfBirth());
    select(By.xpath("//*[@id=\"customerindividual-birth_country_id\"]"), customerData.getBurthCountry());
    typeText(By.id("customerindividual-place_of_birth"), customerData.getPlaceOfBirth());
    select(By.id("customerindividual-sex_id"), customerData.getSex());
    typeText(By.id("customer-email"), customerData.getEmail());
    typeText(By.id("customer-mobile_phone"), customerData.getPhone());
    typeText(By.xpath("//input[@id=\"customerindividual-passportnumber\"]"), customerData.getPassportNumber());
    typeText(By.xpath("//input[@id=\"customerindividual-passport_issue_date\"]"), customerData.getPassportDateIssue());
    typeText(By.xpath("//input[@id=\"customerindividual-passport_issued_by\"]"), customerData.getPassportIssueBy());
    Thread.sleep(2000);
    typeText(By.xpath("//input[@id=\"customerindividual-passport_department_code\"]"), customerData.getPassportDepartmentCode());
    typeText(By.id("customerindividual-snils"), customerData.getSnils());
    select(By.id("innform-country_id"), customerData.getInnCountry());
    select(By.id("innform-inn_source_type_id"), customerData.getInnSourceType());
    typeText(By.id("innform-inn"), customerData.getInn());
    select(By.id("customerindividual-registration_country_id"), customerData.getRegistrationCountry());
    typeText(By.id("customeraddress-citizenship_country_full_address"), customerData.getCitizenshipAddress());
    typeText(By.id("customer-password"), customerData.getPass());
    driver.findElement(By.xpath("//*[@id=\"customerfile-file-51\"]")).sendKeys(customerData.getIdentityDocument());
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id=\"customerfile-file-52\"]")).sendKeys(customerData.getDocumentConfirming());
  }

  public void create(CustomerData customerData) throws InterruptedException {
    clickCreateCustomer();
    fillCreateCustomerForm(customerData);
    scroll("scroll(0, 1000);");
    Thread.sleep(10000);
    submitCreateNewCustomer();
  }

  private void submitCreateNewCustomer() {
    actionsMouse(By.xpath("//*[@id=\"create-real-customer-form\"]/div[3]/button[1]"));
  }

  public String getTextUniqueEmail() {
    return driver.findElement(By.xpath("//div[@class=\"form-group field-customer-email required\"]//label[@id=\"customer-email-error\"]")).getText();
  }

  public Boolean isPresentElementError() {
    return driver.findElement(By.xpath("//div[@class=\"form-group field-customer-email required\"]//label[@id=\"customer-email-error\"]")).isEnabled();
  }

  public void initUpdateButton() throws InterruptedException {
    driver.findElement(By.xpath("//*[@id=\"top-navigation\"]/div[2]/a[1]")).click();
    Thread.sleep(3000);
  }

  public void modifyPersonalData() throws InterruptedException {
    select(By.id("customerindividual-registration_country_id"), "Австралия");
    scroll("scroll(0, 10000);");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id=\"backend_customer_form\"]/tbody/tr[14]/td/button[1]")).click();
    Thread.sleep(5000);
  }

  public String getTextModify() {
    return driver.findElement(By.xpath("//div[@id=\"customerindividual-registration_country_id-cont-cont\"]/div[1]")).getText();
  }

  public String getAcceptedAtPersonalInfo() {
    WebElement tableElement = driver.findElement(By.xpath("//div[@class=\"row\"]/div[2]/table[@id=\"w0\"]"));
    WebElement elementHeading = tableElement.findElement(By.xpath(".//tr[11]/th[text()=\"Дата принятия\"]"));
    WebElement elementCell = elementHeading.findElement(By.xpath(".//following-sibling::td"));
    return elementCell.getText();
  }

  public String getAcceptedDataProfile() {
    return driver.findElement(By.xpath("//*[@id=\"customer-tab-profile-form\"]/div[1]/div[2]")).getAttribute("textContent");
  }

  public Boolean isPresentPageVerification() {
    return isElementPresent(By.xpath("//div[@id=\"w0\"]//table[@class=\"table table-bordered table-striped\"]\n"));
  }

  public Integer isPresentDocumentsPreview() {
    return driver.findElements(By.xpath(".//img")).size();
  }

  public Boolean isPresentFieldNewPassword()  {
    return isElementPresent(By.xpath("//*[@id=\"customerchangepasswordform-password\"]"));
  }
}
