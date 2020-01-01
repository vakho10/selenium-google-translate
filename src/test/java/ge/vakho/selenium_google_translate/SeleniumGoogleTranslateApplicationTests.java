package ge.vakho.selenium_google_translate;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ge.vakho.selenium_google_translate.controller.model.Language;
import ge.vakho.selenium_google_translate.service.TranslatorService;

@SpringBootTest
class SeleniumGoogleTranslateApplicationTests {

	@Autowired
	private TranslatorService translatorService;

	@Test
	void testTranslationService() throws InterruptedException, ExecutionException {
		
		String translatedText = translatorService.translate(Language.DETECT_LANGUAGE, //
				Language.GEORGIAN, //
				"Hello, world!");
		assertThat(translatedText).isNotBlank();
	}
}