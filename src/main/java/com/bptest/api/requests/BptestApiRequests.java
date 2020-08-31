package com.bptest.api.requests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import com.bptest.api.utilities.ReadConfig;

public class BptestApiRequests {

	/**
	 * Get Users of City
	 * 
	 * @param city
	 * @return Response
	 */
	public static Response getAllCityUsers(String city) {
		Response jsonRespone = given().contentType("application/json").when()
				.get(ReadConfig.baseUrl + ReadConfig.get_city_users_endpoint.replace("cityName", city));
		return jsonRespone;
	}

	/**
	 * Get Instruction
	 * 
	 * @return Response
	 */
	public static Response getInstructions() {
		Response jsonRespone = given().contentType("application/json").when()
				.get(ReadConfig.baseUrl + ReadConfig.get_instrcutions);
		return jsonRespone;
	}

	/**
	 * Get a user details
	 * 
	 * @param userId
	 * @return Response
	 */
	public static Response getAUserDetails(String userId) {
		Response jsonRespone = given().contentType("application/json").when()
				.get(ReadConfig.baseUrl + ReadConfig.get_users + userId);
		return jsonRespone;
	}

	/**
	 * Gives all users
	 * 
	 * @return Response
	 */
	public static Response getAllUserDetails() {
		Response jsonRespone = given().contentType("application/json").when()
				.get(ReadConfig.baseUrl + ReadConfig.get_all_users);
		return jsonRespone;
	}
}
