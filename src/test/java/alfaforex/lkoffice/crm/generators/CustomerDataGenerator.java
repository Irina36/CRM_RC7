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
        writer.write(String.format("%s;%s\n", customer.getFirstname(), customer.getLastname(), customer.getDateOfBirth(), customer.getBurthCountry(), customer.getPlaceOfBirth(), customer.getSex(), customer.getEmail(), customer.getPhone(), customer.getPassportNumber(), customer.getDateIssue(), customer.getIssueBy(), customer.getCitizenshipCountry(), customer.getCountry(), customer.getCity(), customer.getStreet(), customer.getHouse(), customer.getPass()));
      }
    }
  }

  private static List<CustomerData> generateCustomer(int count) {
    List<CustomerData> customers = new ArrayList<CustomerData>();
    for (int i = 0; i < count; i++) {
      customers.add(new CustomerData().withFirstname(String.format("Ирина", i))
              .withLastname(String.format("Охотина", i))
              .withDateOfBirth(String.format("1984-06-2%s", i))
              .withBurthCountry(String.format("Российская Федерация", i))
              .withPlaceOfBirth(String.format("Казань", i))
              .withSex(String.format("Женский", i))
              .withEmail(String.format("OkhotinaI%s@mail.ru", i))
              .withPhone(String.format("234567%s", i))
              .withPassportNumber(String.format("230%s", i))
              .withDateIssue(String.format("2015-06-1%s", i))
              .withIssueBy(String.format("OVD%s", i))
              .withCitizenshipCountry(String.format("Российская Федерация", i))
              .withCountry(String.format("Российская Федерация", i))
              .withCity(String.format("Казань", i))
              .withStreet(String.format("Мира", i))
              .withHouse(String.format("%s", i))
              .withPass(String.format("QWEasd123", i))

      );
    }
    return customers;
  }
}