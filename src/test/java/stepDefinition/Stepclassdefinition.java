package stepDefinition;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import pojo.AddserialPlace;
import pojo.Location;
import resources.TestDataBuild;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Stepclassdefinition {
	
	RequestSpecification res;
	RequestSpecification req;
	ResponseSpecification responsespec;
	 Response response;
		TestDataBuild DB = new TestDataBuild();

@Given("the Add Place payload")
public void the_add_place_payload() {

	
	 responsespec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	 res = given().spec(req).body(DB.addPlacePayload());

}
@When("the user calls {string} with a POST request")
public void the_user_calls_with_a_post_request(String string) {
   
	  response= res.when().post("/maps/api/place/add/json").then().spec(responsespec).extract().response();
	
	
}
@Then("the API call succeeds with status code {int}")
public void the_api_call_succeeds_with_status_code(Integer int1) {
	
	assertEquals(response.getStatusCode(), 200);
    
}

@Then("{string} in the response body is {string}")
public void in_the_response_body_is(String string, String string2) {

	String data = response.asString();
	JsonPath path = new JsonPath(data);
	path.get(string).toString().equalsIgnoreCase(string2);
	
}

}
