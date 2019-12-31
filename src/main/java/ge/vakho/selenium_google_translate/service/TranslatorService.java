package ge.vakho.selenium_google_translate.service;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ge.vakho.selenium_google_translate.controller.model.Language;
import ge.vakho.selenium_google_translate.property.SeleniumProperties;
import ge.vakho.selenium_google_translate.property.TranslatorProperties;

@Service
public class TranslatorService {

	private final TranslatorProperties translatorProperties;
	private final SeleniumProperties seleniumProperties;

	private WebDriver driver;
	private WebDriverWait wait;
	private ExecutorService executorService = Executors.newSingleThreadExecutor();

	@Autowired
	public TranslatorService(TranslatorProperties translatorProperties, SeleniumProperties seleniumProperties) {
		this.translatorProperties = translatorProperties;
		this.seleniumProperties = seleniumProperties;
	}

	@PostConstruct
	public void initialize() {
		// Initialize web driver...
		switch (seleniumProperties.getWebDriverType()) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver", seleniumProperties.getWebDriverPath());
			driver = new ChromeDriver();
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", seleniumProperties.getWebDriverPath());
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("intl.accept_languages", "en");
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			FirefoxOptions options = new FirefoxOptions(capabilities);
			driver = new FirefoxDriver(options);
			break;
		default:
			throw new IllegalArgumentException("Unknown driver type!");
		}
		wait = new WebDriverWait(driver, 10);
	}

	@PreDestroy
	public void destroy() {
		// Quit this driver and close every associated window
		driver.quit();
	}

	public String translate(Language from, Language to, String text) throws InterruptedException, ExecutionException {
		checkArgument(from != null, "The source language shouldn't be null!");
		checkArgument(text != null && !text.trim().isEmpty(), "The text shouldn't be empty or null!");
		checkArgument(to != Language.DETECT_LANGUAGE, "The destination language can't be of value: %s!", to.name());

		// Perform action in single threaded pool
		Future<String> result = executorService.submit(new TranslatorAction(from, to, text, driver, wait, translatorProperties, seleniumProperties));

		// Wait for the computation to complete
		return result.get();
	}
}