package com.tyroo.UI;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdpHomePage extends ImdbBasePage {

	/**
	 * Search Box webelement.
	 */
	@FindBy(xpath = "//input[@id='suggestion-search']")
	public WebElement searchBox;

	/**
	 * Search Button webelement.
	 */
	@FindBy(xpath = "//button[@id='suggestion-search-button']")
	public WebElement searchButton;

	/**
	 * List of webelements of search result.
	 */
	@FindAll({ @FindBy(xpath = "//tbody//td[@class = 'result_text' ]") })
	public List<WebElement> title;

	/**
	 * Initialize the page factory.
	 */
	public ImdpHomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Enter the value into search box to search.
	 * 
	 * @param searchValue
	 */
	public void serachInImdb(String searchValue) {
		searchBox.sendKeys(searchValue);
	}

	/**
	 * Perform click operation on search button.
	 */
	public void clickOnSearchButton() {
		searchButton.click();
	}

	/**
	 * Return the list of text of the search results.
	 * 
	 * @return List of text of search results.
	 */
	public List<String> getListofSerachResults() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < title.size(); i++) {
			list.add(title.get(i).getText());
		}
		return list;
	}
}
