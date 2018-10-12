package alfaforex.lkoffice.crm.model;

import java.io.File;

public class CustomerData {

  private  String lastname;
  private  String firstname;
  private  String dateOfBirth;
  private  String burthCountry;
  private  String placeOfBirth;
  private  String sex;
  private  String email;
  private  String phone;
  private  String passportNumber;
  private  String passportDateIssue;
  private  String passportIssueBy;
  private  String pass;
  private  String typeCustomer;
  private  String passportDepartmentCode;
  private  String snils;
  private  String innCountry;
  private  String innSourceType;
  private  String inn;
  private  String registration;
  private  String citizenshipAddress;
  private  String identityDocument;
  private  String documentConfirming;

  public CustomerData withTypeCustomer(String getTypeCustomer) {
    this.typeCustomer = getTypeCustomer;
    return this;
  }

  public CustomerData withPassportDepartmentCode(String passportDepartmentCode) {
    this.passportDepartmentCode = passportDepartmentCode;
    return this;
  }

  public CustomerData withSnils(String snils) {
    this.snils = snils;
    return this;
  }

  public CustomerData withInnCountry(String innCountry) {
    this.innCountry = innCountry;
    return this;
  }

  public CustomerData withInnSourceType(String innSourceType) {
    this.innSourceType = innSourceType;
    return this;
  }

  public CustomerData withRegistrationCountry (String registration) {
    this.registration = registration;
    return this;
  }

  public CustomerData withInn(String inn) {
    this.inn = inn;
    return this;
  }

  public CustomerData withCitizenshipAddress(String citizenshipAddress) {
    this.citizenshipAddress = citizenshipAddress;
    return this;
  }

  public CustomerData withIdentityDocument(String identityDocument) {
    this.identityDocument = identityDocument;
    return this;
  }

  public CustomerData withDocumentConfirming(String documentConfirming) {
    this.documentConfirming = documentConfirming;
    return this;
  }

  public CustomerData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public CustomerData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public CustomerData withDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

  public CustomerData withBurthCountry(String burthCountry) {
    this.burthCountry = burthCountry;
    return this;
  }

  public CustomerData withPlaceOfBirth(String placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
    return this;
  }

  public CustomerData withSex(String sex) {
    this.sex = sex;
    return this;
  }

  public CustomerData withEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerData withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public CustomerData withPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
    return this;
  }

  public CustomerData withPassportDateIssue(String dateIssue) {
    this.passportDateIssue = dateIssue;
    return this;
  }

  public CustomerData withPassportIssueBy(String issueBy) {
    this.passportIssueBy = issueBy;
    return this;
  }

  public CustomerData withPass(String pass) {
    this.pass = pass;
    return this;
  }

  public String getTypeCustomer() {
    return typeCustomer;
  }

  public String getLastname() {
    return lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public String getBurthCountry() {
    return burthCountry;
  }

  public String getPlaceOfBirth() {
    return placeOfBirth;
  }

  public String getSex() {
    return sex;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public String getPassportDateIssue() {
    return passportDateIssue;
  }

  public String getPassportIssueBy() {
    return passportIssueBy;
  }

  public String getSnils() { return snils; }

  public String getPass() {
    return pass;
  }

  public String getPassportDepartmentCode() {
    return passportDepartmentCode;
  }

  public String getInnCountry() {
    return innCountry;
  }

  public String getInnSourceType() {
    return innSourceType;
  }

  public String getInn() {
    return inn;
  }

  public String getRegistrationCountry() {
    return registration;
  }

  public String getCitizenshipAddress() {
    return citizenshipAddress;
  }

  public String getIdentityDocument() {
    return identityDocument;
  }

  public String getDocumentConfirming() {
    return documentConfirming;
  }
}
