package core;

public class YandexSpellerConstants {

    //useful constants for API under test
    public static final String YANDEX_SPELLER_API_URI = "https://speller.yandex.net/services/spellservice.json/checkText";
    public static final String PARAM_TEXT = "text";
    public static final String PARAM_OPTIONS = "options";
    public static final String PARAM_LANG = "lang";

    public static final String WORD_WITHOUT_DASH = "когонибудь";
    public static final String WORD_WITH_DOUBLED_LETTERS = "каннат";
    public static final String WORD_WITH_UNNECESSARY_LETTER = "канба1н";
    public static final String WORD_WITH_DIGITS = "zer0";
    public static final String STRING_WITH_URL = "Перейдите по ссылке https://tech.yandex.ru/speller/";
    public static final String STRING_WITH_EMAIL = "Напишите нам на support@epam.com";
    public static final String STRING_WITH_CAPITALISATION = "London is the capital of GREAT BRITAIN";
    public static final String STRING_WITH_REPEAT_WORDS = "скажите нам нам, как сдать сдать домашнее задание задание";


    public enum Languages {
        RU("ru"),
        UK("uk"),
        EN("en"),
        BY("by");
        String languageCode;

        private Languages(String lang) {
            this.languageCode = lang;
        }
    }
}
