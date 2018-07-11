package tw.core.generator;

import org.junit.jupiter.api.Test;
import tw.core.Answer;
import tw.core.exception.AnswerFormatIncorrectException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class AnswerGeneratorTest {
    @Test()
    public void should_throw_OutOfRangeAnswerException_which_is_not_between_0_and_9() {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        assertThrows(AnswerFormatIncorrectException.class, answerGenerator::generate);

    }

    @Test
    public void should_get_radam_number() throws Exception {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(anyInt(), anyInt())).thenReturn("1 2 3 4");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        Answer answer = answerGenerator.generate();

        assertThat(answer, notNullValue());
        assertThat(answer.getIndexOfNum("4"), is(3));
    }
}
