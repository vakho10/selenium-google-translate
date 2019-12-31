package ge.vakho.selenium_google_translate.property;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Validated
@Configuration
@ConfigurationProperties(prefix = "translator")
@PropertySource("classpath:translator.properties")
public class TranslatorProperties {

	@NotBlank
	private String googleTranslateUrl;

	public String getGoogleTranslateUrl() {
		return googleTranslateUrl;
	}

	public void setGoogleTranslateUrl(String googleTranslateUrl) {
		this.googleTranslateUrl = googleTranslateUrl;
	}
}