package com.tyroo.API;

import static io.restassured.RestAssured.given;

import com.tyroo.constants.APIConstants;

import io.restassured.response.Response;

public class ImdbTitleAPI extends ImdbBaseAPI {
	
	/**
	 * Return the resonse after resolving the query parameter.
	 * @param query queru name.
	 * @param queryValue query value.
	 * @return Response 
	 */
	public Response getResponse(String query, String queryValue) {
		return given().spec(this.getRequestSpecification()).queryParam(query, queryValue).get(APIConstants.Endpoint.getResource());
	}

}
