package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforescenario() throws IOException {
		if(StepDefinition.place_id==null) { 
	// called placeId with class since it is defined as static.
		StepDefinition sp = new StepDefinition();
		sp.add_place_payload_with("start", "hindi", "India");
		sp.user_calls_with_http_request("AddPlaceAPI", "POST");
		sp.verify_place_id_created_maps_to_using("start", "GetPlaceAPI");
		
	}
}}
