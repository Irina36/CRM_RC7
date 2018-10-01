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
    actionsMouse(By.xpath("//*[@id='create-item']"));
  }

  public void fillCreateCustomerForm(CustomerData customerData) {

    type(By.id("lastNameReal"), customerData.getLastname());
    type(By.id("firstNameReal"), customerData.getFirstname());
    type(By.xpath("//*[@id=\"customerindividual-birth_date\"]"), customerData.getDateOfBirth());
    select(By.xpath("//*[@id=\"customerindividual-birth_country_id\"]"), customerData.getBurthCountry());
    type(By.id("customerindividual-place_of_birth"), customerData.getPlaceOfBirth());
    select(By.id("customerindividual-sex_id"), customerData.getSex());
    type(By.id("customer-email"), customerData.getEmail());
    type(By.id("customer-mobile_phone"), customerData.getPhone());
    type(By.id("customerindividual-passportnumber"), customerData.getPassportNumber());
    type(By.xpath("//*[@id=\"customerindividual-passport_issue_date\"]"), customerData.getDateIssue());
    type(By.id("customerindividual-passport_issued_by"), customerData.getIssueBy());
    select(By.id("customerindividual-citizenship_country_id"), customerData.getCitizenshipCountry());
    select(By.id("customerindividual-country_id"), customerData.getCountry());
    type(By.id("customerindividual-city"), customerData.getCity());
    type(By.id("customerindividual-street"), customerData.getStreet());
    type(By.id("customerindividual-house"), customerData.getHouse());
    type(By.id("customer-password"), customerData.getPass());
  }


  public void create(CustomerData customerData) {
    clickCreateCustomer();
    fillCreateCustomerForm(customerData);
    submitCreateNewCustomer();
  }

  private void submitCreateNewCustomer() {
    actionsMouse(By.xpath("//*[@id=\"create-real-customer-form\"]/div[2]/button[1]"));
  }

  public List<WebElement> getCustomerCurdPage() {
     return driver.findElements(By.xpath("//*[@id=\"w11\"]"));
  }

/*  private void calendarData(By locator) {
      WebElement dateOfBirthElement = driver.findElement(locator);
      dateOfBirthElement.click();
      Calendar calDateOfBirth = new Calendar (dateOfBirthElement, driver);
      WebElement dataOfBurth = calDateOfBirth.getVaueFromCell(2,2);
     dataOfBurth.click();
  }*/

}
