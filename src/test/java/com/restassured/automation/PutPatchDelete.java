package com.restassured.automation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDelete {

	@Test
	public void TestPut() {

		JSONObject reqbody = new JSONObject();
		reqbody.put("name", "Sadhu");
		reqbody.put("job", "SE");
		
		baseURI = "https://reqres.in";
		given().
		header("content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(reqbody.toJSONString()).
		when().
			put("/api/users/2").
		then().
			statusCode(200).log().all();
}
	
	@Test
	public void TestPatch() {

		JSONObject reqbody = new JSONObject();
		reqbody.put("name", "Sadhu2");
		reqbody.put("job", "SE2");
		
		baseURI = "https://reqres.in";
		given().
		header("content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(reqbody.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).log().all();
}
	
	@Test
	public void TestDelete() {
		baseURI = "https://reqres.in";
		
		//Optional given().
		when().
			delete("/api/users/2").
		then().
			statusCode(204).log().all();
}
}
