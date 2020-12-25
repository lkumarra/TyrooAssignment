package com.tyroo.API;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.tyroo.constants.APIConstants;
import com.tyroo.constants.Constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ImdbBaseAPI {

	static RequestSpecification req = null;
	static PrintStream requestlog = null;
	static PrintStream responselog = null;

	/**
	 * Add the Request information into ReLogs.txt file.
	 */
	private PrintStream printRequestLogs() {
		if (requestlog == null) {
			try {
				requestlog = new PrintStream(new FileOutputStream(Constants.ReqFilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return requestlog;
		}
		return requestlog;
	}

	/**
	 * Add the Response logs to ResLogs.txt file
	 */
	private PrintStream printResponseLogs() {
		if (responselog == null) {
			try {
				responselog = new PrintStream(new FileOutputStream(Constants.ResFilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return responselog;
		}
		return responselog;
	}
	
	/**
	 * Build Request specification by adding all required information such as Base URI, Base Path etc.
	 * @return Request Specification
	 */
	public RequestSpecification getRequestSpecification() {
		return new RequestSpecBuilder().setBaseUri(APIConstants.Base_URI.getResource())
				.setBasePath(APIConstants.Base_Path.getResource()).setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(this.printRequestLogs()))
				.addFilter(ResponseLoggingFilter.logResponseTo(this.printResponseLogs()))
				.addHeader(APIConstants.AuthKey.getResource(), APIConstants.AuthKeyValue.getResource()).build();
	}
	
}
