package customersearch;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Customer {

  private String name;
  private Gender gender;
  private Size size;
  private LocalDate birthday;
    
  public Customer createName(String name){
    this.name=name;
    return this;
  }
    
  public Customer createGender(Gender gender){
    this.gender = gender;
    return this;
  }
    
  public Customer createSize(Size size){
    this.size = size;
    return this;
  }
    
  public Customer createBirthday(
       int year, int month, int day){

     this.birthday=
       createDatefromData(year, month, day);
     
     return this;
  }
 
  //整数の年・月・日からLocalDateオブジェクトを得る
  public LocalDate createDatefromData(
       int year, int month, int day){

    Month mymonth = Month.of(month);
    LocalDate birthday = LocalDate.of(
                        year, mymonth, day);
    return birthday;
  }
    
  //LocalDateのオブジェクトから文字列を得る
  public String printBirthday(LocalDate localdate){
 
    DateTimeFormatter formatter =
      DateTimeFormatter.ofLocalizedDate(
        FormatStyle.MEDIUM).withLocale(Locale.JAPAN);
        
    return localdate.format(formatter);       
  }
  
  //誕生日から年齢を計算
  public int getAge(){
  
    Period p = Period.between(birthday, LocalDate.now());
    return p.getYears();
  
  }
  
  public String getName() {
    return name;
  }

  public Gender getGender() {
    return gender;
  }

  public Size getSize() {
    return size;
  }

  public LocalDate getBirthday() {
    return birthday;
  }
  
  
    
  //一覧を作成する
  public static List<Customer> listCustomers(){
    
    List<Customer> customerList = new ArrayList<>();
        
    customerList.add(new Customer()
     .createName("サカモトシュンタロウ")
      .createGender(Gender.MAN).createSize(Size.LARGE)
      .createBirthday(1982, 8, 26));
        
    customerList.add(new Customer()
     .createName("タカサゴユミコ")
      .createGender(Gender.WOMAN).createSize(Size.MIDDLE)
      .createBirthday(1990, 4, 7));
        
    customerList.add(new Customer()
      .createName("アリマエイジロウ")
      .createGender(Gender.MAN).createSize(Size.MIDDLE)
      .createBirthday(1975, 10, 12));
        
    customerList.add(new Customer()
      .createName("ナガシマエイコ")
      .createGender(Gender.WOMAN).createSize(Size.SMALL)
      .createBirthday(1995, 6, 22));
        
    customerList.add(new Customer()
      .createName("コサカヒロコ")
      .createGender(Gender.WOMAN).createSize(Size.MIDDLE)
      .createBirthday(1965, 12, 11));
        
    customerList.add(new Customer()
      .createName("イリサワミツヲ")
      .createGender(Gender.MAN).createSize(Size.XLARGE)
      .createBirthday(1987, 2, 28));
        
    return customerList;
  }
}