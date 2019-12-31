package ge.vakho.selenium_google_translate.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ge.vakho.selenium_google_translate.controller.model.Language;
import ge.vakho.selenium_google_translate.controller.model.TranslatorRequest;
import ge.vakho.selenium_google_translate.controller.model.TranslatorResponse;
import ge.vakho.selenium_google_translate.service.TranslatorService;

@RestController
@RequestMapping("/translate")
public class TranslatorController {

	@Autowired
	private TranslatorService translatorService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TranslatorResponse> translate(@RequestBody @Valid TranslatorRequest request) throws InterruptedException, ExecutionException {
		
		if (request.getFrom() == null) {
			request.setFrom(Language.DETECT_LANGUAGE);
		}
		
		// Translate
		String translatedText = translatorService.translate(request.getFrom(), request.getTo(), request.getText());
		
		// Build and send back the response object
		TranslatorResponse response = new TranslatorResponse();
		response.setText(translatedText);
		return ResponseEntity.ok(response);
	}
}