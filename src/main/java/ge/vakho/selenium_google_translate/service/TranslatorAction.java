package ge.vakho.selenium_google_translate.service;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.concurrent.Callable;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import ge.vakho.selenium_google_translate.controller.model.Language;
import ge.vakho.selenium_google_translate.property.SeleniumProperties;
import ge.vakho.selenium_google_translate.property.TranslatorProperties;

public class TranslatorAction implements Callable<String> {

	private final WebDriver driver;
	private final WebDriverWait wait;
	private final TranslatorProperties translatorProperties;
	private final SeleniumProperties seleniumProperties;
	private final Language from;
	private final Language to;
	private final String text;

	public TranslatorAction(Language from, Language to, String text, WebDriver driver, WebDriverWait wait,
			TranslatorProperties translatorProperties, SeleniumProperties seleniumProperties) {
		this.from = from;
		this.to = to;
		this.text = text;
		this.driver = driver;
		this.wait = wait;
		this.translatorProperties = translatorProperties;
		this.seleniumProperties = seleniumProperties;
	}

	@Override
	public String call() throws Exception {

		// Load the root page
		driver.get(translatorProperties.getGoogleTranslateUrl());

		if (from != null && from != Language.DETECT_LANGUAGE) {
			// Wait for the 'sl-all' button to appear and click it
			wait.until(visibilityOfElementLocated(cssSelector("div.sl-more.tlid-open-source-language-list"))).click();

			// Wait for the input field 'sl_list-search-box', enter the source language's
			// name and click enter
			wait.until(visibilityOfElementLocated(cssSelector("#sl_list-search-box"))).sendKeys(from.getLangName(),
					Keys.ENTER);
		}

		// Wait for the 'tl-more' button to appear and click it
		wait.until(visibilityOfElementLocated(cssSelector("div.tl-more.tlid-open-target-language-list"))).click();

		// Wait for the input field 'sl_list-search-box', enter the source language's
		// name and click enter
		wait.until(visibilityOfElementLocated(cssSelector("#tl_list-search-box"))).sendKeys(to.getLangName(),
				Keys.ENTER);

		// Enter the text into 'source' text-area
		WebElement textArea = wait.until(visibilityOfElementLocated(cssSelector("#source")));
		String[] lines = text.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			textArea.sendKeys(lines[i]);
			if (i < lines.length - 1) {
				textArea.sendKeys(Keys.ENTER);
			}
		}

		// Copy the text from 'div.text-wrap.tlid-copy-target' element's child nodes
		return wait.until(visibilityOfElementLocated(cssSelector("div.text-wrap.tlid-copy-target"))).getText();
	}
}