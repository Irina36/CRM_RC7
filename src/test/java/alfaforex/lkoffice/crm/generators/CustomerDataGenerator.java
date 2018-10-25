package alfaforex.lkoffice.crm.generators;

import alfaforex.lkoffice.crm.model.CustomerData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDataGenerator {

  @Parameter(names = "-c", description = "Repository count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {

    CustomerDataGenerator generator = new CustomerDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  public void run() throws IOException {
    List<CustomerData> customers = generateCustomer(count);
    if (format.equals("csv")) {
      saveAsCsv(customers, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(customers, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(customers, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJson(List<CustomerData> customers, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(customers);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<CustomerData> customers, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(CustomerData.class);

    String xml = xstream.toXML(customers);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<CustomerData> customers, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath()); // узнает относительный путь к файлу
    try (Writer writer = new FileWriter(file)) {
      for (CustomerData customer : customers) {
        writer.write(String.format("%s;%s\n", customer.getFirstname(), customer.getLastname(), customer.getDateOfBirth(), customer.getBurthCountry(), customer.getPlaceOfBirth(), customer.getSex(), customer.getEmail(), customer.getPhone(), customer.getPassportNumber()));
      }
    }
  }

  private static List<CustomerData> generateCustomer(int count) {
    List<CustomerData> customers = new ArrayList<CustomerData>();
    for (int i = 0; i < count; i++) {
      customers.add(new CustomerData().withTypeCustomer("Контрагент")
      .withFirstname(String.format("Ирина", i))
      .withLastname(String.format("Охотина", i))
      .withDateOfBirth(String.format("1984-06-2%s", i))
      .withBurthCountry(String.format("Российская Федерация", i))
      .withPlaceOfBirth(String.format("Казань", i))
      .withSex("Женский")
      .withEmail(java.util.UUID.randomUUID().toString() + "@gmail.com")
      .withPhone(String.format("234567%s", i))
      .withPassportNumber(String.format("1234567%s", i))
      .withPassportDateIssue(String.format("2015-06-1%s", i))
      .withPassportIssueBy(String.format("OVD%s", i))
      .withPassportDepartmentCode("136")
      .withSnils("136-001")
      .withInnCountry("Российская Федерация")
      .withInnSourceType("Отсутствует ИНН")
      .withInn("123456789")
      .withRegistrationCountry("Российская Федерация")
      .withCitizenshipAddress("РФ, г. Казань, ул. Мира, д.14")
      .withPass(String.format("QWEasd123", i))
      .withIdentityDocument(String.format("/home/irina_okhotina/Документы/Projects/java_pft/backoffice/src/test/resources/Doc%s.jpg", i+1))
      .withDocumentConfirming(String.format("/home/irina_okhotina/Документы/Projects/java_pft/backoffice/src/test/resources/Doc%s.jpg", i+1))
      );
    }
    return customers;
  }
}
