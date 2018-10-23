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

  public void customerCardPage() {
    WebElement tableElement = driver.findElement(By.xpath("//table[@class=\"table table-bordered table-striped table-condensed\"]/tbody"));
    Table table = new Table(tableElement);
    WebElement valueFromCell = table.getVaueFromCell(1, 2);
    valueFromCell.click();
  }

  public void customerPersonalInfo() { driver.findElement((By.xpath("//*[@id=\"customer\"]/li[1]/a")));
  }

  public void customerProfile() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[2]/a")).click();
  }

  public void customerVerification() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[3]/a")).click();
  }

  public void customerDocuments() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[4]/a")).click();
  }


  public void customerAccounts() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[5]/a")).click();
  }

  public void customerPayments() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[6]/a")).click();
  }

  public void customerTickets() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[7]/a")).click();
  }

  public void customerSettings() {
    driver.findElement(By.xpath("//*[@id=\"customer\"]/li[8]/a")).click();
  }

}
