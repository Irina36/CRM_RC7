package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void CustomerListPage() {
    actionsMouse(By.linkText("Клиенты"));
    actionsMouse(By.linkText("Список клиентов"));


  }
}
