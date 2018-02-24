import beans.YandexSpellerAnswer;
import core.YandexSpellerApi;
import org.junit.Test;

import java.util.List;

import static core.YandexSpellerConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestYandexSpellerJSON {

    private String wrongNumberOfAnswers = "expected number of answers is wrong.";
    private String answerDoesNotContainExpectedResult = "answer doesn't contain expected word.";


    @Test
    public void optionsValueIgnoreDigits() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITH_DIGITS)
                                .options("2")
                                .callApi());
        assertThat(wrongNumberOfAnswers, answers.isEmpty());
    }

    @Test
    public void optionsValueNotIgnoreDigits() {
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITH_DIGITS)
                                .options("0")
                                .callApi());
        assertThat(wrongNumberOfAnswers, !answers.isEmpty());
    }

    @Test
    public void findDoubleLetters(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITH_DOUBLED_LETTERS)
                                .options("0")
                                .callApi());
        assertThat(answerDoesNotContainExpectedResult, answers.get(0).s.contains("канат"));
    }

    @Test
    public void findUnnecessaryLetter(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITH_UNNECESSARY_LETTER)
                                .options("0")
                                .callApi());
        assertThat(wrongNumberOfAnswers, !answers.isEmpty());
        assertThat(answerDoesNotContainExpectedResult, answers.get(0).s.contains("кабан"));
    }

    @Test
    public void optionsValueIgnoreURL(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(STRING_WITH_URL)
                                .options("4")
                                .callApi());
        assertThat(wrongNumberOfAnswers, answers.isEmpty());
    }

    @Test
    public void optionsValueNotIgnoreURL(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(STRING_WITH_EMAIL)
                                .options("0")
                                .callApi());
        assertThat(wrongNumberOfAnswers, !answers.isEmpty());
    }

    @Test
    public void optionsValueNotIgnoreCapitalisation(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(STRING_WITH_CAPITALISATION)
                                .options("0")
                                .callApi());
        assertThat(wrongNumberOfAnswers, !answers.isEmpty());
    }

    @Test
    public void optionsValueIgnoreCapitalisation(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(STRING_WITH_CAPITALISATION)
                                .options("512")
                                .callApi());
        assertThat(wrongNumberOfAnswers, answers.isEmpty());
    }

    @Test
    public void optionsFindRepeatWords(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(STRING_WITH_REPEAT_WORDS)
                                .options("8")
                                .callApi());
        assertThat(wrongNumberOfAnswers, answers.size(), equalTo(3));
    }

    @Test
    public void findMissedDash(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITHOUT_DASH)
                                .options("0")
                                .callApi());
        assertThat(answerDoesNotContainExpectedResult, answers.get(0).s.contains("кого-нибудь"));
    }

//    @Test
    public void sendOptionsMaxInteger(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITHOUT_DASH)
                                .options("2147483647")
                                .callApi());
    }

//    @Test
    public void sendOptionsMinInteger(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITHOUT_DASH)
                                .options("-2147483648")
                                .callApi());
    }

//    @Test
    public void sendOptionsMinxInteger(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITHOUT_DASH)
                                .options("#ff")
                                .callApi());
    }

//    @Test
    public void sendWrongLanguage(){
        List<YandexSpellerAnswer> answers =
                YandexSpellerApi.getYandexSpellerAnswers(
                        YandexSpellerApi.with().
                                text(WORD_WITHOUT_DASH)
                                .language(Languages.BY)
                                .callApi());
    }
}
