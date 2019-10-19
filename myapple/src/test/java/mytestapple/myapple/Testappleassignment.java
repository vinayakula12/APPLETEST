package mytestapple.myapple;

import java.io.IOException;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;



public class Testappleassignment {
	Appleassignment tester = new Appleassignment(); 
	
	//Test for print all the blue Teslas received in the web service response. Also print the notes
	@Test
    public void testforblueteslas() throws JsonParseException, JsonMappingException, IOException {
		tester.blueteslas();
		
	}
	
	//Test for Return all cars which have the lowest per day rental cost for both cases: Price only and Price after discounts
	@Test
    public void testforlowpricewithandwithoutdiscoun() throws JsonParseException, JsonMappingException, IOException {
		tester.LowPrice();
		
	}
	
	//Test for Find the highest revenue generating car. year over year maintenance cost + depreciation is the total expense per car for the full year for the rental car company. The objective is to find those cars that produced the highest profit in the last year
	@Test
    public void testforhighrevenuecars() throws JsonParseException, JsonMappingException, IOException {
		tester.highrevencar();
		
	}
        
        
        
    }
