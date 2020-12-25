package com.tyroo.constants;

public enum APIConstants {

	Base_URI("https://imdb8.p.rapidapi.com"), Base_Path("/title"), Endpoint("/find"), AuthKey("x-rapidapi-key"),
	AuthKeyValue("a15c00169emsh3e4b592b14a3caep13f1c8jsn26c5fad01353");

	private final String resource;

	APIConstants(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource.toString();
	}

}
