package ge.vakho.selenium_google_translate.controller.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TranslatorRequest {

	private Language from;
	
	@NotNull
	private Language to;
	
	@NotBlank
	private String text;

	public Language getFrom() {
		return from;
	}

	public void setFrom(Language from) {
		this.from = from;
	}

	public Language getTo() {
		return to;
	}

	public void setTo(Language to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}