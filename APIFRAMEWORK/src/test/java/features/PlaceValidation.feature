Feature: Validating Place API's

Scenario: Verify if Place is being successfully added using AddPlaceAPI

Given Add Place payload
When user calls "AddPlaceAPI" with "POST" http request
Then the API call got success with status code 200
And "status" in response body is "OK"







