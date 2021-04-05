package com.restassured.automation;
import java.util.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestGetAndPost {

	@Test
	public void TestGet() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].first_name", equalTo("Lindsay")).
			body("data.first_name", hasItems("Rachel", "George","Michael")); //Checking without index and checking for multiple names
	}
	
	@Test
	public void TestPost() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Sadhu");
//		map.put("job", "SE");
//		
//		System.out.println(map);
//		
//		//In order to have the above map in json format convert it to JSON Object
//		JSONObject reqbody = new JSONObject(map);
//		System.out.println(reqbody.toJSONString());
		
		//Instead of using map we can use JSONObject directly
		JSONObject reqbody = new JSONObject();
		reqbody.put("name", "Sadhu");
		reqbody.put("job", "SE");
		
		baseURI = "https://reqres.in/api";
		given().
		header("content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(reqbody.toJSONString()).
		when().
			post("/user").
		then().
			statusCode(201).log().all();
		
		
	}
}
