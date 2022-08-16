package resource;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestData {

	public AddPlace AddPlacePayload() {
		AddPlace a = new AddPlace();
		a.setAccuracy(100);
		a.setAddress("data");
		a.setLanguage("data");
		a.setName("data");
		a.setPhone_number("003290320302");
		List<String>mylist = new ArrayList<String>();
		mylist.add("side road");
		mylist.add("tree road");
		a.setTypes(mylist);
		Location l = new Location();
		l.setLat(23.45);
		l.setLng(34.45);
		a.setLocation(l);
		a.setWebsite("www.google.com");
		return a;
	}
	
	
	public AddPlace AddPlacePayload1(String Name, String Language, String Address) {
		AddPlace b = new AddPlace();
		b.setAccuracy(100);
		b.setAddress(Address);
		b.setLanguage(Language);
		b.setName(Name);
		b.setPhone_number("003290320302");
		List<String>mylist = new ArrayList<String>();
		mylist.add("side road");
		mylist.add("tree road");
		b.setTypes(mylist);
		Location l = new Location();
		l.setLat(23.45);
		l.setLng(34.45);
		b.setLocation(l);
		b.setWebsite("www.google.com");
		return b;
	}
	public String DeleteApiPayload(String placeId) {
		return "{\r\n  \"place_id\":\""+placeId+"\"\r\n}";
		
	}
}
