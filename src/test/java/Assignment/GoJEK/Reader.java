package Assignment.GoJEK;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 
/**
 * Unit test for simple App.
 */
public class Reader {
	protected static Properties props;

	public static List<String> urlFromFile1 = new ArrayList<String>();
	public static List<String> urlFromFile2 = new ArrayList<String>();


	  public static List<String> readFileInList(String fileName)  
	  { 
	  
	    List<String> lines = Collections.emptyList(); 
	    
	
	    try
	    { 
	
	    	
	      lines = 
	       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	      
	    } 
	  
	    catch (IOException e) 
	    { 
	    	e.getMessage();
	      e.printStackTrace(); 
	    } 
	    return lines; 
	  } 

	  
//	 public static void main (String [] args ) {
	@BeforeTest  
	  public static void fileCollection()  {
	  String path1 =System.getProperty("user.dir")+"\\src\\test\\java\\Assignment\\resources\\filea1.txt";
	  String path2 =System.getProperty("user.dir")+"\\src\\test\\java\\Assignment\\resources\\filea2.txt";

	  
	  urlFromFile1 = readFileInList(path1); 
	  urlFromFile2 = readFileInList(path2); 

	  
	 
//	    Iterator<String> itr = urlFromFile1.iterator(); 
//	    while (itr.hasNext()) 
//	      System.out.println(itr.next()); 
//	    
//	    itr = urlFromFile2.iterator(); 
//	    while (itr.hasNext()) 
//	      System.out.println(itr.next());
	  } 
	}

