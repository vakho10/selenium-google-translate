package ge.vakho.selenium_google_translate.controller.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class TranslatorRequest {

	private Language from;

	@ApiModelProperty(example = "Georgian")
	@NotNull
	private Language to;

	@ApiModelProperty(example = "Hello, world!")
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

	@Override
	public String toString() {
		return "TranslatorRequest [from=" + from + ", to=" + to + ", text=" + text + "]";
	}
}