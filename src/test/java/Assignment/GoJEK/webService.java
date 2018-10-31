package Assignment.GoJEK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.JSONObject;

public class webService {
	private final static String USER_AGENT = "Mozilla/5.0";

	public static JSONObject sendGet(String url) {
		// SYSTEM.OUT.PRINTLN(URL.TRIM()+"*********");
		JSONObject jsonData = null;
		try {
			URL obj = new URL(url.trim());
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// System.out.println("\nSending 'GET' request to URL : " + url);
			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			int responseCode = con.getResponseCode();
			// System.out.println("Response Code : " + responseCode);
			BufferedReader in = null;
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result

			// System.out.println("Response - " + response);
			if (responseCode == 200 || responseCode == 404)
				jsonData = new JSONObject(response.toString());
			else
				return jsonData;
		} catch (Exception e) {
			System.out.println("Exception encouted during API call - ");
			e.printStackTrace();
			return jsonData;
		}
		return jsonData;
	}

	public static void main(String[] args) {
		sendGet(" https://reqres.in/api/users?page=3    ");
	}
}
