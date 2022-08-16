package stepDefinitions;


import static org.junit.Assert.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resource.APIresources;
import resource.TestData;
import resource.Utils;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StepDefinition extends Utils {
	RequestSpecification req;
	ResponseSpecification resspec;
	Response response ;
	TestData data = new TestData();
	static String place_id;

	@Given("Add Place payload")
	public void add_place_payload() throws IOException {
		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.build();
		req = given().spec(RequestSpecification()).body(data.AddPlacePayload());
				}
	@When("user calls {string} with post http request")
	public void user_calls_with_post_http_request(String string) {
		response = req.when().post("/maps/api/place/add/json")
				.then().spec(resspec).extract().response();
			   
	}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
		String rew = response.asString();
		System.out.println(rew);
	 
	}
	@Then ("{string} in response body is {string}")
	public void in_response_body_is(String Keyvalue, String value) {
assertEquals(getJsonpath(response,Keyvalue), value);
}
	@Given("Add Place payload with {string} {string} {string}")
	public void add_place_payload_with(String Name, String Location, String Address) throws IOException {
	resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
			  .build();
		req = given().spec(RequestSpecification()).body(data.AddPlacePayload1(Name,Location,Address));  
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		//constructor will be called with value of resource which we pass
		APIresources resourceApi = APIresources.valueOf(resource);
		System.out.println(resourceApi.GetResource());
		if(method.equalsIgnoreCase("POST")) {
			response = req.when().post(resourceApi.GetResource());
			}else if (method.equalsIgnoreCase("GET")) {
				response = req.when().get(resourceApi.GetResource());
			}else if(method.equalsIgnoreCase("DELETE")){
				response = req.when().delete(resourceApi.GetResource());
				}
		}
//	@Then("verify place_Id created maps to {string} using {string}")
	//public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {	
	place_id = getJsonpath(response,"place_id");
		req = given().spec(RequestSpecification()).queryParam("place_id", place_id );
		user_calls_with_http_request(resource, "GET");// existing steps def method used
		String actualname = getJsonpath(response,"name");
		assertEquals(actualname,expectedname);
	   
	}

@Given("DeletePlace Payload")
public void delete_place_payload() throws IOException {
	req =given().spec(RequestSpecification()).body(data.DeleteApiPayload(place_id));
    
}

}