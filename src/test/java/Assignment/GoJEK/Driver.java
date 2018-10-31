package Assignment.GoJEK;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Assignment.GoJEK.webService;

public class Driver extends Reader {

	@Test
	// public static void main(String[] args) {
	public static void maian() {
		// fileCollection();
		compare(urlFromFile1, urlFromFile2);

	}

	public static void compare(List<String> a1, List<String> a2) {
		try {
			for (String o : a1) {
				for (String o2 : a2) {
					JSONObject oResponse = webService.sendGet(o.trim());
					JSONObject o2Response = webService.sendGet(o2.trim());
					if (oResponse != null && o2Response != null) {
						int has = oResponse.hashCode();
						int has2 = o2Response.hashCode();
						ObjectMapper mapper = new ObjectMapper();

						LocalObject as = new LocalObject();
						JsonNode tree1 = as.getInstance().readTree(oResponse.toString());
						JsonNode tree2 = as.getInstance().readTree(o2Response.toString());
						//
						// JsonNode tree1 = mapper.readTree(oResponse.toString());
						// JsonNode tree2 = mapper.readTree(o2Response.toString());
						if (tree1.equals(tree2))
							System.out.println(o + "   equals   " + o2);
						else
							System.out.println(o + "    not equals   " + o2);

					}
					System.out.println("***  API is not valid . It returns null value **");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}