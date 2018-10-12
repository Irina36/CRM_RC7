package alfaforex.lkoffice.crm.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void customerListPage() {
    actionsMouse(By.linkText("Клиенты"));
    actionsMouse(By.linkText("Список клиентов"));
  }

  public void customerCurdPage() {
    WebElement tableElement = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped table-condensed\"]/tbody"));
    Table table = new Table(tableElement);
    WebElement valueFromCell = table.getVaueFromCell(1, 2);
    valueFromCell.click();
  }
}
