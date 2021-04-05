package com.restassured.automation;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.*;
public class TestGet {
	
	@Test
	public void TestMetis1() {
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		// If you define the import as static, then we can use get directly like given below
		Response response = get("https://reqres.in/api/users?page=2)");
		System.out.println(response.getStatusCode());
		
		//System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test
	//Duplicate of the above test case using different simpler format
	public void TestMetis2() {
		baseURI = "https://reqres.in";
		given().
			get("/api/users?page=2").
		then().
			statusCode(200).
			body("data[5].id", equalTo(12))
			.log().all();
				
	}

}
