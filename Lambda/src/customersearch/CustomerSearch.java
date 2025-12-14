package customersearch;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerSearch {
   
 public static void main(String[] args) {
           
   List<Customer> customers = Customer.listCustomers();
   // TEST1    
    if(args.length > 0){
      switch(args[0]) {
      case "under":
    	  System.out.println("35以下最高齢");
    	  customers.stream().sorted((c1, c2) -> {
	    	  if(c1.getAge() > c2.getAge()) {
	    		  return 1;
	    	  } else if (c1.getAge() < c2.getAge()){
	    		  return -1;
	    	  } else {
	    		  return 0;
	    	  }
    	  }
    	  ).filter(c -> c.getAge() > 30).findFirst().ifPresent(c -> System.out.println(c.getName()));//  forEach(c -> System.out.println(c.getName() + c.getAge()));
    	  
    	  break;
      case "filter":
    	  customers.stream().filter(c -> (c.getAge() > 29) && (c.getAge() < 40)).forEach(CustomerPrinter::printNameAndAge);
    	  break;
      case "sorted":
    	  customers.stream().sorted((c1, c2) -> c2.getName().compareTo(c1.getName())).forEach(c -> System.out.println(c.getName()));
    	  break;
      case "collect":
    	  List<Customer> men = customers.stream().filter((c) -> c.getGender() == Gender.MAN).collect(Collectors.toList());
    	  List<Customer> women = customers.stream().filter(c -> c.getGender() == Gender.WOMAN).collect(Collectors.toList());
    	  
    	  System.out.println("女一覧");
    	  women.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(c -> System.out.println(c.getName()));
    	  
    	  System.out.println("女一覧先頭");
    	  women.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).findFirst().ifPresent(c -> System.out.println(c.getName()));
    	  
    	  System.out.println("男一覧");
    	  men.stream().sorted((c1, c2) -> c1.getName().compareTo(c2.getName())).forEach(c -> System.out.println(c.getName()));
    	  

    	  break;
      case "anymatch":
    	  if(customers.stream().anyMatch(c -> c.getAge() < 40)) {
    		  System.out.println("成人企画中止");
    	  } else {
    		  System.out.println("問題なし");
    	  }
    	  break;
      case "count":
    	  for(Size size : Size.values()) {
    		  long count = customers.stream().filter(c -> c.getSize() == size).count();
    		  System.out.println(size.toString() + ":" + count);
    		  
    	  }
    	  break;
      case "sum":
        	HashMap<Size, Integer> pointMap = new HashMap<>();
          	pointMap.put(Size.SMALL, 1);
          	pointMap.put(Size.MIDDLE, 3);
          	pointMap.put(Size.LARGE, 5);
          	pointMap.put(Size.XLARGE, 10);
          	
          	int allsum = customers.stream().mapToInt(c -> {
          		return pointMap.get(c.getSize());
          	}).sum();
          	
          	System.out.println("発生したポイント総計：" + allsum);
          	
    break;
      }
    }
       
    else{
      customers.forEach(CustomerPrinter::printCustomer);
    }
 }   
}
