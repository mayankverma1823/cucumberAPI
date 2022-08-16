package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification baseurl;
	
	public io.restassured.specification.RequestSpecification RequestSpecification() throws IOException {
		if(baseurl==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		baseurl = new RequestSpecBuilder().setBaseUri(globalProperties("url")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return baseurl;
		}return baseurl;
	}
	
	public static String globalProperties(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\MayankWorkspace\\APIFRAMEWORK\\src\\test\\java\\resource\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	// We want o generalize response data and write one method to call in main class
	public String getJsonpath(Response response, String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		return js.getString(key).toString();
		}

}
