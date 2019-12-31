package ge.vakho.selenium_google_translate.property;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties(prefix = "selenium")
@PropertySource("classpath:selenium.properties")
public class SeleniumProperties {

	@NotNull
	private WebDriverType webDriverType;

	@NotBlank
	private String webDriverPath;

	public WebDriverType getWebDriverType() {
		return webDriverType;
	}

	public void setWebDriverType(WebDriverType webDriverType) {
		this.webDriverType = webDriverType;
	}

	public String getWebDriverPath() {
		return webDriverPath;
	}

	public void setWebDriverPath(String webDriverPath) {
		this.webDriverPath = webDriverPath;
	}
}