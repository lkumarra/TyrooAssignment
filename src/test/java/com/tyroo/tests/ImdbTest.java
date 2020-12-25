package com.tyroo.tests;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tyroo.API.ImdbTitleAPI;
import com.tyroo.UI.ImdbBasePage;
import com.tyroo.UI.ImdpHomePage;
import com.tyroo.Utilities.APIUtilities;
import com.tyroo.constants.UIConstants;

import io.restassured.response.Response;

public class ImdbTest {

	static Response response;
	static APIUtilities utilities;
	static ImdpHomePage homePage;

	@BeforeMethod
	public void setUp() {
		// Creating the object of title api class.
		ImdbTitleAPI titleApi = new ImdbTitleAPI();
		// Creating the object of utilities class.
		utilities = new APIUtilities();
		// Getting the response by entering the query parameter.
		response = titleApi.getResponse("q", "game of thrones");
		// Performing initialization.
		ImdbBasePage.initialization(UIConstants.url);
		// Creating the object ImdpHomePage class.
		homePage = new ImdpHomePage();
		// Searching for "game of thrones" in Imdb homepage.
		homePage.serachInImdb("game of thrones");
		// Clicking on Search Button.
		homePage.clickOnSearchButton();
	}

	@Test
	public void verifyApiAndUIResults() {
		// Storing the result into list after searching.
		List<String> list = homePage.getListofSerachResults();
		for (int i = 0; i < 3; i++) {
			// Storing the results into string after replacing the unsed characters.
			String[] array = list.get(i).replace(" (", "_").replace(")_", "_").replace(")", "").split("_");
			// Verifying the title by comparing the API and UI results.
			utilities.verifyEquals(utilities.getJsonPathValue(response, "results[" + i + "].title"), array[0]);
			// Verifying the year by comparing the API and UI results.
			utilities.verifyEquals(utilities.getJsonPathValue(response, "results[" + i + "].year"), array[1]);
			// Verifying the titleType by comparing the API and UI results.
			utilities.verifyEquals(utilities.getJsonPathValue(response, "results[" + i + "].titleType"), array[2]);
		}
	}

	@AfterMethod
	public void tearDown() {
		// Performing teardown after the completation of execution.
		ImdbBasePage.tearDown();
	}

}
