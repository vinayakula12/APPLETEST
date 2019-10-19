package mytestapple.myapple;


import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import mytestapple.myapple.model.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

/**
 * This is MAVEN project created by VINAY AKULA to address/answer apple assignment.
 * Have used Jackson ObjectMapper class – to deserialize JSON string into Java objects.
 *  
 *  Created below 3 functions to address the assignment this functions:
 *  
 *  1)blueteslas:- Question 1: Print all the blue Teslas received in the web service response. Also print the notes
 *  
 *  
 *  2)LowPrice:- Question 2: Return all cars which have the lowest per day rental cost for both cases:
    				a. Price only
    				b. Price after discounts
    				
 *  3)highrevencar:-				b. Price after discounts
    Question 3: Find the highest revenue generating car. year over year maintenance cost + depreciation is the total expense per car for the full year for the rental car company.
    			The objective is to find those cars that produced the highest profit in the last year
    			
    Also created a sample input JSON file "/Users/vinay/git/APPLETEST/myapple/src/resources/Input.json" for ease of this assignment
    The models java files for each of JSON parameter is in the MODEL path
 *
 * Also wrote few unit test cases in Testappleassignment class at "/myapple/src/test/java/mytestapple/myapple/Testappleassignment.java"
 * 
 * All required test cases are passing as expected.
 */
public class Appleassignment 
{
	// Implementation of  Question 1: Print all the blue Teslas received in the web service response. Also print the notes
	
	public  void blueteslas() throws JsonParseException, JsonMappingException, IOException {
		InputStream	geek = new FileInputStream(new File("/Users/vinay/git/APPLETEST/myapple/src/resources/Input.json")); 
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    	VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
	TypeReference<List<Cars>> typeRef = new TypeReference<List<Cars>>() {};  
  	List<Cars> cars= mapper.readValue(geek, typeRef);
  for(Cars c:cars) {
    		
   		if ((c.getMetadata().getColor()).equalsIgnoreCase("Blue")  && (c.getMake()).equalsIgnoreCase("Tesla")) {
  		 System.out.println("Car Make is "+c.getMake()+" Car Color is "+c.getMetadata().getColor()+" Car Notes is " +c.getMetadata().getNotes());
  		}
 }
	}
	
	//Implementation of  Question 2: Return all cars which have the lowest per day rental cost for both cases:a. Price onlyb. Price after discounts
  public void LowPrice() throws JsonParseException, JsonMappingException, IOException {
		InputStream	geek = new FileInputStream(new File("/Users/vinay/Downloads/data.json")); 
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
  	VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
	TypeReference<List<Cars>> typeRef = new TypeReference<List<Cars>>() {};  
	List<Cars> cars= mapper.readValue(geek, typeRef);
	float minprice=1000;
	float priceafterdiscounts=1000;
for(Cars c:cars) {
	
 		float price=c.getPerdayrent().getPrice();
 		float discount=c.getPerdayrent().getDiscount();
 		 priceafterdiscounts=(price - discount);
 		
 		if(price<minprice) {
 			minprice=price;
 		}
 		
 		if(price<priceafterdiscounts) {
 			priceafterdiscounts=price;
 		}
 		
 		
}
System.out.println("The cars which have the lowest per day rental cost is "+minprice);
System.out.println("The cars which have the lowest per day rental cost after dicount is "+priceafterdiscounts);
	}
  
  
  //Implementation of Question 3: Find the highest revenue generating car. year over year maintenance cost + depreciation is the total expense per car for the full year for the rental car company.The objective is to find those cars that produced the highest profit in the last year
  public void highrevencar() throws JsonParseException, JsonMappingException, IOException {
		InputStream	geek = new FileInputStream(new File("/Users/vinay/Downloads/data.json")); 
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
   	VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
	TypeReference<List<Cars>> typeRef = new TypeReference<List<Cars>>() {};  
 	List<Cars> cars= mapper.readValue(geek, typeRef);
 	int maxprofit=100;
 for(Cars c:cars) {
	 float ytdExpense = (c.getMetrics().getYoymaintenancecost()+c.getMetrics().getDepreciation());
	 float price=c.getPerdayrent().getPrice();
		float discount=c.getPerdayrent().getDiscount();
		 float priceafterdiscounts = (price - discount);
		 float ytdRev = (c.getMetrics().getRentalcount().getYeartodate() *price);
		 float profit = ytdRev - ytdExpense;
		 if(profit>maxprofit) {
			 maxprofit=(int) profit;
	 		}
  		
}
 System.out.println("The highest revenue of the car is "+maxprofit);
	}
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {
    	
    	
    	Appleassignment cars=new Appleassignment();
    	
    	//Calling below required functions and getting the desired/required output
    	
    	cars.blueteslas();
    	cars.LowPrice();
    	cars.highrevencar();
    	
    
    }}

