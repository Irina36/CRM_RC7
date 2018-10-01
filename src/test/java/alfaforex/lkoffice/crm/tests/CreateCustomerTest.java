package alfaforex.lkoffice.crm.tests;

import alfaforex.lkoffice.crm.model.CustomerData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class CreateCustomerTest extends TestBase{

  @DataProvider
  public Iterator<Object[]> validCustomersFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/customers.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<CustomerData> customers = gson.fromJson(json, new TypeToken<List<CustomerData>>() {}.getType()); // List<RepositoryData>.class
      return customers.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validCustomersFromJson")
  public void testCreateCustomer( CustomerData customer) throws InterruptedException {
    app.goTo().CustomerListPage();
    app.customer().create(customer);
    Thread.sleep(10000);
    List<WebElement> customerPage = app.customer().getCustomerCurdPage();
    Assert.assertTrue(!customerPage.isEmpty(), "Успешно сохранен");

  }

}
