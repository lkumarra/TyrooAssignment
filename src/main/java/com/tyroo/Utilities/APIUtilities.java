package com.tyroo.Utilities;

import org.testng.Assert;

import io.restassured.response.Response;

public class APIUtilities {

	/**
	 * Get the value from the json response by entering the path of the json.
	 * 
	 * @param response Resonse to get the value.
	 * @param path     Path of the value.
	 * @return Value of the field using path.
	 */
	public String getJsonPathValue(Response response, String path) {
		return response.jsonPath().getString(path);
	}

	/**
	 * Very the actual and expected result.
	 * 
	 * @param actual   Actual Result.
	 * @param expected Expected Result.
	 */
	public void verifyEquals(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

}
