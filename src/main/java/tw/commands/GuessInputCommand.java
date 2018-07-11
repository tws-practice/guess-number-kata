package tw.commands;

import tw.core.Answer;
import tw.validator.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GuessInputCommand implements InputCommand {

    private BufferedReader bufferedReader;

    {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public GuessInputCommand() {
    }

    @Override
    public Answer input() throws IOException {
        System.out.println("------Please input your answer as x x x x , x <10 ------");
        String input = bufferedReader.readLine();
        Answer answer = null;
        if (new InputValidator().validate(input)) {
            answer = Answer.createAnswer(input);
        } else {
            answer = input();
        }
        return answer;
    }
}
