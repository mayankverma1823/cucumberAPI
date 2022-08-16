package resource;

public enum APIresources {
	AddPlaceAPI("/maps/api/place/add/json"),
	GetPlaceAPI("maps/api/place/get/json"),
	DeletePlaceAPI("maps/api/place/delete/json");
	private String resource;
	
// This is constructor created to pass the value of resource to main class instead of local
APIresources(String resource) {
	this.resource=resource;
}
// And now we should create one method to get this resource value to other classes

public String GetResource() {
	return resource;
}
}
