package tw.core;

import com.google.inject.Inject;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.exception.OutOfGuessCountException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;

import java.util.ArrayList;
import java.util.List;

import static tw.core.GameStatus.CONTINUE;
import static tw.core.GameStatus.FAIL;
import static tw.core.GameStatus.SUCCESS;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Game {

    private static final int MAX_TIMES = 6;
    private final Answer actualAnswer;
    private final List<GuessResult> guessResults;
    private final String CORRECT_RESULT_STANDAR = "4A0B";

    @Inject
    public Game(AnswerGenerator answerGenerator) throws AnswerFormatIncorrectException {
        this.actualAnswer = answerGenerator.generate();
        this.guessResults = new ArrayList();
    }

    public GuessResult guess(Answer inputAnswer) throws OutOfGuessCountException {
        if (!checkCoutinue()) {
            throw new OutOfGuessCountException("Guess count cant over 6!");
        }
        final String result = actualAnswer.check(inputAnswer).getValue();
        GuessResult guessResult = new GuessResult(result, inputAnswer);
        guessResults.add(guessResult);
        return guessResult;
    }

    public List<GuessResult> guessHistory() {
        return guessResults;
    }

    public boolean checkCoutinue() {
        return this.checkStatus().equals(CONTINUE);
    }

    public String checkStatus() {
        String status;
        if (guessResults.size() >= MAX_TIMES) {
            status = FAIL;
        } else if (checkCorrectGuessResult()) {
            status = SUCCESS;
        } else {
            status = CONTINUE;
        }
        return status;
    }

    private boolean checkCorrectGuessResult() {
        return guessResults.stream().anyMatch(result -> result.getResult().contentEquals(CORRECT_RESULT_STANDAR));
    }
}
