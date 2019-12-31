package ge.vakho.selenium_google_translate.controller.model;

import javax.validation.constraints.NotBlank;

public class TranslatorResponse {

	@NotBlank
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}