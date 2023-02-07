package com.bridgelabz.qa.api_automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSenderOptions;
import io.restassured.specification.RequestSpecification;

public class Json_ServerTest {
	
  @Test
  public void get_all_post() {
	  Response response = RestAssured.get("http://localhost:3000/posts");
	  System.out.println("Response code: " +response.getStatusCode());
	  //JsonPath jsonPath = response.jsonPath();
	  //System.out.println("id: "+jsonPath.getInt("id[1]"));
	  response.prettyPrint();
	  Assert.assertEquals(response.getStatusCode(), 201);
  }



@Test
public void get_Specific_post() {
	  Response response = RestAssured.get("http://localhost:3000/posts/6");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void Create_post() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","aaplication/json");
	  JSONObject json = new JSONObject();
	  json.put("id", 3);
	  json.put("title", "the christmas pig");
	  json.put("author", "jk rowling");
	  requestSpecification.body(json.toJSONString());
	  Response response = RestAssured.get("http://localhost:3000/posts");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void put_Update_post() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","aaplication/json");
	  JSONObject json = new JSONObject();
	  json.put("id", 6);
	  json.put("title", "update post");
	  json.put("author", "typicode");
	  requestSpecification.body(json.toJSONString());
	  Response response = RestAssured.get("http://localhost:3000/posts/6");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void patch_Update_post() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","aaplication/json");
	  JSONObject json = new JSONObject();
	  json.put("id", 6);
	  //json.put("title", "update post");
	  json.put("author", "patch code");
	  requestSpecification.body(json.toJSONString());
	  Response response = RestAssured.get("http://localhost:3000/posts/6");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void delete_post() {
	  Response response = RestAssured.get("http://localhost:3000/posts/2");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void get_all_comment() {
	  Response response = RestAssured.get("http://localhost:3000/comments");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void get_specefic_comment() {
	  Response response = RestAssured.get("http://localhost:3000/comments/3");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void Create_comment() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","aaplication/json");
	  JSONObject json = new JSONObject();
	  json.put("body", "fifth comment");
	  json.put("postId", 3);
	  requestSpecification.body(json.toJSONString());
	  Response response = RestAssured.get("http://localhost:3000/comments");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void put_update_comment() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","aaplication/json");
	  JSONObject json = new JSONObject();
	  json.put("body", "first update comment");
	  json.put("postId", 2);
	  requestSpecification.body(json.toJSONString());
	  Response response = RestAssured.get("http://localhost:3000/comments/4");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void patch_Update_comment() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","aaplication/json");
	  JSONObject json = new JSONObject();
	  json.put("id", 4);
	  //json.put("title", "update post");
	  json.put("body", "first patch update for");
	  requestSpecification.body(json.toJSONString());
	  Response response = RestAssured.patch("http://localhost:3000/comments/4");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void delete_comment() {
	  Response response = RestAssured.get("http://localhost:3000/comments/2");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void get_All_commemt_for_particular_post() {
	  Response response = RestAssured.get("http://localhost:3000/comments/?postId=2");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void get_all_profile() {
	  Response response = RestAssured.get("http://localhost:3000/profile");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void Create_profile() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","application/json");
	  JSONObject json = new JSONObject();
	  json.put("name", "tester");
	  requestSpecification.body(json.toJSONString());
	  Response response = requestSpecification.post("http://localhost:3000/profile");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void put_update_profile() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","application/json");
	  JSONObject json = new JSONObject();
	  json.put("name", "testing");
	  requestSpecification.body(json.toJSONString());
	  Response response = requestSpecification.put("http://localhost:3000/profile");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}

@Test
public void patch_update_profile() {
	  RequestSpecification requestSpecification = RestAssured.given();
	  requestSpecification.header("Content-Type","application/json");
	  JSONObject json = new JSONObject();
	  json.put("name", "tested");
	  requestSpecification.body(json.toJSONString());
	  Response response = requestSpecification.patch("http://localhost:3000/profile");
	  System.out.println("Response code: " +response.getStatusCode());
	  response.prettyPrint();
}
}