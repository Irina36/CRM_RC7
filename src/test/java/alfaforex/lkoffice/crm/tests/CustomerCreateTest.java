package alfaforex.lkoffice.crm.tests;

import alfaforex.lkoffice.crm.model.CustomerData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CustomerCreateTest extends TestBase{


  @DataProvider
  public Iterator<Object[]> dataCustomersFromJson() throws IOException {
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

  @Test (dataProvider = "dataCustomersFromJson")
  public void createCustomerValidData(CustomerData customer) throws InterruptedException {
     app.goTo().customerListPage();
     app.customer().create(customer);
     Thread.sleep(20000);
     Boolean curdCustomerPage = app.customer().isTextPresent("Успешно сохранен");
     assertTrue(curdCustomerPage);
     Thread.sleep(15000);
  }

  @Test (dataProvider = "dataCustomersFromJson")
  public void createCustomerUniqueEmail(CustomerData customer) throws InterruptedException {
    app.goTo().customerListPage();
    app.customer().create(customer);
    Boolean elementError = app.customer().isPresentElementError();
    String textUniqueEmail = app.customer().getTextUniqueEmail();
    assertTrue(elementError);
    assertEquals(textUniqueEmail, "Клиент с таким Email уже зарегистрирован");


  }
}
