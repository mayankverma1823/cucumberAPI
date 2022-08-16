Feature: Validating Place API's with data

@AddPlace @Regression
Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI with different data
Given Add Place payload with "<name>" "<Language>" "<Address>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And verify place_Id created maps to "<name>" using "GetPlaceAPI"

Examples:
   | name | Language |Address |
   |Yar   | Hindi	 |bihar   |
  # |meet  | english  | UP     |
  
@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working
 
Given DeletePlace Payload
When  user calls "DeletePlaceAPI" with "POST" http request 
Then  the API call got success with status code 200   
And  "status" in response body is "OK"
 
 
   
