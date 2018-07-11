package tw.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.generator.RandomIntGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by jxzhong on 2017/5/18.
 */
public class RandomIntGeneratorTest {

    private RandomIntGenerator randomIntGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        this.randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_get_4_digits_numstr_and_every_digit_less_than_10() throws Exception {
        //given
        //when
        String numStr = randomIntGenerator.generateNums(9, 4);
        //then
        assertThat(numStr.length(), is(7));

    }

    @Test()
    public void should_throw_exception_when_dufutmax_less_than_numbersOfNeed() throws Exception {

        //given
        //when
        assertThrows(IllegalArgumentException.class, ()->randomIntGenerator.generateNums(4, 5));
    }
}