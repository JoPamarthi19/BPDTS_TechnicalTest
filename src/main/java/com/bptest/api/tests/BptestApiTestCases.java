package com.bptest.api.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bptest.api.requests.BptestApiRequests;
import com.bptest.api.utilities.ReadTestData;
import io.restassured.response.Response;

public class BptestApiTestCases {

	@Test
	public void verifygetAllCityUsers() {
		Response allUserByCity = BptestApiRequests
				.getAllCityUsers(ReadTestData.readProperty("testData.properties", "verifygetAllCityUsers_data_city"));
		List<String> allUserIds = allUserByCity.jsonPath().getList("id");
		Assert.assertEquals(
				Integer.parseInt(ReadTestData.readProperty("testData.properties",
						"verifygetAllCityUsers_expected_first_user_id".toString())),
				allUserIds.get(0), "User id veification failed");
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifygetAllCityUsers_expected_size"),
				String.valueOf(allUserIds.size()), "Number of records verification failed");

	}

	@Test
	public void verifygetInstrctions() {
		Response allInstrctions = BptestApiRequests.getInstructions();
		Assert.assertEquals(ReadTestData
				.readProperty("testData.properties", "verifygetInstrctions_expected_instrctions").replace("\"", ""),
				allInstrctions.jsonPath().get("todo"), "Instrction verification failed");
	}

	@Test
	public void verifygetUserId() {
		Response userDetails = BptestApiRequests
				.getAUserDetails(ReadTestData.readProperty("testData.properties", "verifygetUserId_input_id"));
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifygetUserId_expected_first_name"),
				userDetails.jsonPath().get("first_name"), "firs tname mismatch");
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifygetUserId_expected_last_name"),
				userDetails.jsonPath().get("last_name"), "last name mismatch");
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifygetUserId_expected_email"),
				userDetails.jsonPath().get("email"), "email id mismatch");
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifygetUserId_expected_ip_address"),
				userDetails.jsonPath().get("ip_address"), "ip_address mismatch");

	}

	@Test
	public void verifyAllUsers() {
		Response allUsers = BptestApiRequests.getAllUserDetails();
		List<String> allUserIds = allUsers.jsonPath().getList("id");
		List<String> allUserFirstNames = allUsers.jsonPath().getList("first_name");
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifyAllUsers_expected_id".toString()),
				String.valueOf(allUserIds.get(0)), "User id veification failed");
		Assert.assertEquals(
				ReadTestData.readProperty("testData.properties", "verifyAllUsers_expected_first_name".toString()),
				allUserFirstNames.get(0), "FirstName Verification failed");
		Assert.assertEquals(ReadTestData.readProperty("testData.properties", "verifyAllUsers_expected_size"),
				String.valueOf(allUserIds.size()), "Number of records verification failed");
	}
}
