package com.bridgelabz.qa.api_automation;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Rest_Api_Automation_Testing_Test {
	
	String token;
	String userId;
	String playlistId;
	String trackId="0CtZpaOhtzvLV3FfcsVpQo";

	@BeforeTest
	public void getToken() {
		token ="Bearer BQDAP7PM2MeoUJYTOvZQgnLeHA_Ka0enHBGiQs9rBPv-TT4EXvi7P_pNXHkK7V_Jqh7KGBBGe9VrkPdo4xg2k2TBh_IL6Zz2y_bffnvY_FwaZkmiSSw34c8CHINxuclAq9abZGBYAhqEmkl9-VsQITl1PTnL1D_709TrGNNSs_XEfyhws62SGCHzohKmvCLAFnCc0Fe4gc5r_ZWKm5UvOBkheUUwqABQ8_rfkNntEVknsw0A8WvB4AbjOB3-9BhLNJfAqMp8TNzvgSYGsHcuQlHUf53-GA";
	}
	
	@Test (priority=1)
	
	
	public void get_Current_User_Profile() {
		
		
		Response response = RestAssured.given()
				
				.contentType(ContentType.JSON)
		        .accept(ContentType.JSON)
		        .header("Authorization",token)
		        .when()
		        .get("https://api.spotify.com/v1/me");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
		String userId = response.path("id");
		System.out.println("Current user id is:" +userId);
		Assert.assertEquals("31k5eyofm5m5kjnk2l6qapwojlf4", userId);
		}
	
@Test (priority=2)
	
	public void get_User_Profile() {
		Response response = RestAssured.given()
				.contentType(ContentType.JSON)
		        .accept(ContentType.JSON)
		        .header("Authorization",token)
		        .when()
		        .get("https://api.spotify.com/v1/users/"+userId+"");
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
		}


@Test (priority=6)

public void get_current_users_Playlists() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .when()
	        .get("https://api.spotify.com/v1/me/playlists");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
	
}


@Test (priority=11)

    public void get_Playlists_cover_image() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .when()
	        .get("https://api.spotify.com/v1/playlists/"+playlistId+"/images");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}


@Test (priority=7)

public void get_Playlists_items() {
	
	
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("limit",  "2")
	        .when()
	        .get("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}


@Test (priority=8)

public void get_Playlist() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("limit", "2")
	        .when()
	        .get("https://api.spotify.com/v1/playlists/"+playlistId+"");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}


@Test  (priority=9)

public void get_users_Playlists() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("limit", "2")
	        .when()
	        .get("https://api.spotify.com/v1/users/"+userId+"/playlists");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}


@Test (priority=5)

public void add_items_to_playlist() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("uris","spotify:track:0CtZpaOhtzvLV3FfcsVpQo")
	        .queryParam("type", "track")
	        .when()
	        .post("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
	response.prettyPrint();
	response.then().assertThat().statusCode(201);
}


@Test (priority=3)

public void create_playlist() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .body("{\r\n"
                    + "  \"name\": \"Automation.Spotifyapp\",\r\n"
                    + "  \"description\": \"New playlist description\",\r\n"
                    + "  \"public\": false\r\n"
                    + "}")                 
	        .when()
	        .post("https://api.spotify.com/v1/users/31k5eyofm5m5kjnk2l6qapwojlf4/playlists");
	response.prettyPrint();
	response.then().assertThat().statusCode(201);
	playlistId = response.path("id");
	System.out.println("Automation.Spotifyapp playlist id is:" +playlistId);
}


@Test (priority=10)

public void update_playlist_items() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("uris","spotify:track:0CtZpaOhtzvLV3FfcsVpQo")
	        .queryParam("type", "track")
	        .body("{\r\n"
                    + "  \"range_start\": \"1\",\r\n"
                    + "  \"range_before\": \"3\",\r\n"
                    + "  \"range_length\": 2\r\n"
                    + "}")                 
	        .when()
	        .put("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
	response.prettyPrint();
	response.then().assertThat().statusCode(201);
}


@Test (priority=12)

public void change_playlist_details() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .body("{\r\n"
                    + " \"name\": \"Automation.Spotifyapp\",\r\n"
                    + " \"description\": \"updated playlist description\",\r\n"
                    + " \"public\":false\r\n"
                    + "}")               
	        .when()
	        .put("https://api.spotify.com/v1/playlists/"+playlistId+"");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}


@Test (priority=4)

public void search_for_item() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("q","spotify:track:0CtZpaOhtzvLV3FfcsVpQo")
	        .queryParam("type", "track")
	        .queryParam("limit", "2")
	        .when()
	        .get("https://api.spotify.com/v1/search");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}

@Test (priority=13)


public void get_tracks_audio_analysis() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)             
	        .when()
	        .get("https://api.spotify.com/v1/audio-analysis/"+trackId+"");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
	}


@Test (priority=14)


public void get_tracks_audio_features() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token) 
	        .queryParam("ids", trackId)
	        .when()
	        .get("https://api.spotify.com/v1/audio-features");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}

@Test (priority=15)


public void get_track_audio_features_by_Id() {
	Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)             
	        .when()
	        .get("https://api.spotify.com/v1/audio-features/"+trackId+"");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
}

@Test (priority=16)

public void get_several_tracks() {
	 Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .queryParam("ids", trackId)
	        .queryParam("ids","0CtZpaOhtzvLV3FfcsVpQo")
	        .when()
	        .get("https://api.spotify.com/v1/tracks");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
	
}

@Test  (priority=17)

public void get_tracks() {
	 Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .when()
	        .get("https://api.spotify.com/v1/tracks/"+trackId+"");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
	
}

@Test (priority=18)

public void remove_from_playlist() {
	 Response response = RestAssured.given()
			.contentType(ContentType.JSON)
	        .accept(ContentType.JSON)
	        .header("Authorization",token)
	        .body("{\r\n"
                    + " \"tracks\": [\r\n"
	        		+ "  {\r\n"
                    + " \"uri\": \"spotify:track:0CtZpaOhtzvLV3FfcsVpQo\",\r\n"
                    + " \"position\": [0]\r\n"
                    + " }\r\n"
                    + " ]\r\n"
                    + "}") 
	        .when()
	        .delete("https://api.spotify.com/v1/playlists/"+playlistId+"/tracks");
	response.prettyPrint();
	response.then().assertThat().statusCode(200);
	
}
}

