package ge.vakho.selenium_google_translate.controller.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Language {
	DETECT_LANGUAGE("Detect Language"), AFRIKAANS("Afrikaans"), ALBANIAN("Albanian"), AMHARIC("Amharic"),
	ARABIC("Arabic"), ARMENIAN("Armenian"), AZERBAIJANI("Azerbaijani"), BASQUE("Basque"), BELARUSIAN("Belarusian"),
	BENGALI("Bengali"), BOSNIAN("Bosnian"), BULGARIAN("Bulgarian"), CATALAN("Catalan"), CEBUANO("Cebuano"),
	CHICHEWA("Chichewa"), CHINESE("Chinese"), CORSICAN("Corsican"), CROATIAN("Croatian"), CZECH("Czech"),
	DANISH("Danish"), DUTCH("Dutch"), ENGLISH("English"), ESPERANTO("Esperanto"), ESTONIAN("Estonian"),
	FILIPINO("Filipino"), FINNISH("Finnish"), FRENCH("French"), FRISIAN("Frisian"), GALICIAN("Galician"),
	GEORGIAN("Georgian"), GERMAN("German"), GREEK("Greek"), GUJARATI("Gujarati"), HAITIAN_CREOLE("HAITIAN Creole"),
	HAUSA("Hausa"), HAWAIIAN("Hawaiian"), HEBREW("Hebrew"), HINDI("Hindi"), HMONG("Hmong"), HUNGARIAN("Hungarian"),
	ICELANDIC("Icelandic"), IGBO("Igbo"), INDONESIAN("Indonesian"), IRISH("Irish"), ITALIAN("Italian"),
	JAPANESE("Japanese"), JAVANESE("Javanese"), KANNADA("Kannada"), KAZAKH("Kazakh"), KHMER("Khmer"), KOREAN("Korean"),
	KURDISH_KURMANJI("KURDISH (KURMANJI)"), KYRGYZ("Kyrgyz"), LAO("Lao"), LATIN("Latin"), LATVIAN("Latvian"),
	LITHUANIAN("Lithuanian"), LUXEMBOURGISH("Luxembourgish"), MACEDONIAN("Macedonian"), MALAGASY("Malagasy"),
	MALAY("Malay"), MALAYALAM("Malayalam"), MALTESE("Maltese"), MAORI("Maori"), MARATHI("Marathi"),
	MONGOLIAN("Mongolian"), MYANMAR_BURMESE("MYANMAR (BURMESE)"), NEPALI("Nepali"), NORWEGIAN("Norwegian"),
	PASHTO("Pashto"), PERSIAN("Persian"), POLISH("Polish"), PORTUGUESE("Portuguese"), PUNJABI("Punjabi"),
	ROMANIAN("Romanian"), RUSSIAN("Russian"), SAMOAN("Samoan"), SCOTS_GAELIC("Scots Gaelic"), SERBIAN("Serbian"),
	SESOTHO("Sesotho"), SHONA("Shona"), SINDHI("Sindhi"), SINHALA("Sinhala"), SLOVAK("Slovak"), SLOVENIAN("Slovenian"),
	SOMALI("Somali"), SPANISH("Spanish"), SUNDANESE("Sundanese"), SWAHILI("Swahili"), SWEDISH("Swedish"),
	TAJIK("Tajik"), TAMIL("Tamil"), TELUGU("Telugu"), THAI("Thai"), TURKISH("Turkish"), UKRAINIAN("Ukrainian"),
	URDU("Urdu"), UZBEK("Uzbek"), VIETNAMESE("Vietnamese"), WELSH("Welsh"), XHOSA("Xhosa"), YIDDISH("Yiddish"),
	YORUBA("Yoruba"), ZULU("Zulu");

	private String langName;

	private Language(String langName) {
		this.langName = langName;
	}

	@JsonValue
	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}
}