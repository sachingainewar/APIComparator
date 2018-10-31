package Assignment.GoJEK;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LocalObject {
	private static final ThreadLocal<ObjectMapper> APIobject = new ThreadLocal<ObjectMapper>();

	public static ObjectMapper getInstance() {

		return new ObjectMapper();
	}

}
