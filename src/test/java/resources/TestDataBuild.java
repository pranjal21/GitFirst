package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddserialPlace;
import pojo.Location;

public class TestDataBuild {
	
	public  AddserialPlace addPlacePayload()
	{
		AddserialPlace p = new AddserialPlace();
		p.setAccuracy(50);
		p.setAddress("noida");
		p.setLanguage("English");
		p.setName("Pranjal");
		p.setPhone_number("12345");
		p.setWebsite("www.test.com");
		
		
		List<String> mylist = new ArrayList();
		mylist.add("pranjal");
		mylist.add("shoe");
		p.setTypes(mylist);
		
		Location l = new Location();
		l.setLat(-38.383484);
		l.setLng(33.427361);
		p.setLocation(l);
		
		return p;
	}

}
