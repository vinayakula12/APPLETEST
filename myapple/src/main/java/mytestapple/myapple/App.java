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
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, IOException
    {
    	ObjectMapper mapper = new ObjectMapper();
    	//mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	InputStream	geek = new FileInputStream(new File("/Users/vinay/Downloads/data.json")); 
    	
    	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    	mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    	//VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY);
    	TypeReference<List<Cars>> typeRef = new TypeReference<List<Cars>>() {};  
    	List<Cars> cars= mapper.readValue(geek, typeRef);
    	
    	
  //  	Question 1: Print all the blue Teslas received in the web service response. Also print the notes
    	for(Cars c:cars) {
    		
    		if ((c.getMetadata().getColor()).equalsIgnoreCase("Blue")  && (c.getMake()).equalsIgnoreCase("Tesla")) {
    		System.out.println("Car Make is "+c.getMake()+" Car Color is "+c.getMetadata().getColor()+" Car Notes is " +c.getMetadata().getNotes());
    		}
    	}
}
}
