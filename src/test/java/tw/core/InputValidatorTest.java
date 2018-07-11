package tw.core;

import org.junit.jupiter.api.Test;
import tw.validator.InputValidator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class InputValidatorTest {
    @Test
    public void should_return_true_when_a_right_num() throws Exception {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3 4";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(true));
    }

    @Test
    public void should_return_false_when_given_a_non_Four_digits() throws Exception {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));
    }

    @Test
    public void should_return_false_when_given_a_Four_digits_and_one_digit_exceed_ten() throws Exception {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3 10";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));
    }

    @Test
    public void should_return_false_when_given_a_Four_digits_and_two_digit_are_same() throws Exception {
        //given
        InputValidator inputValidator = new InputValidator();
        String num = "1 2 3 1";
        //whens
        Boolean isValidated = inputValidator.validate(num);
        //then
        assertThat(isValidated, is(false));
    }
}
