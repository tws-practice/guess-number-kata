package tw.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tw.core.Answer;
import tw.core.Game;
import tw.commands.InputCommand;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GameControllerTest {

    @Mock
    private GameView mockGameView;
    @Mock
    private InputCommand mockCommand;
    @Mock
    private AnswerGenerator mockGenerator;
    @Mock
    private Game game;

    private Answer correctAnswer;
    private Answer errorAnswer;
    private GameController gameController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        correctAnswer = Answer.createAnswer("1 2 3 4");
        errorAnswer = Answer.createAnswer("1 2 5 6");

        when(mockGenerator.generate()).thenReturn(correctAnswer);
//        game = new Game(mockGenerator);
        gameController = new GameController(game, mockGameView);
    }

    @Test
    public void should_display_guess_result_when_call_controller_play() throws IOException {
        //given
        when(mockCommand.input()).thenReturn(correctAnswer);
        when(game.guessHistory()).thenReturn(new ArrayList<>());
        when(game.checkStatus()).thenReturn("");
        when(game.checkCoutinue()).thenReturn(true, false);
        when(game.guess(errorAnswer)).thenReturn(new GuessResult("", errorAnswer));
        GameController gameController = new GameController(game, mockGameView);

        //when
        gameController.play(mockCommand);

        //then
        verify(mockGameView).showGuessResult(any());
        verify(mockGameView).showGuessHistory(anyList());
        verify(mockGameView).showGameStatus(anyString());
    }

    @Test
    public void should_display_end_result_when_game_failde() throws IOException {
        //given
        when(mockCommand.input()).thenReturn(errorAnswer);
        when(game.checkStatus()).thenReturn("");
        when(game.checkCoutinue()).thenReturn(false);
        GameController gameController = new GameController(game, mockGameView);

        //when
        gameController.play(mockCommand);

        //then
        verify(mockGameView).showGameStatus(anyString());
    }

    @Test
    public void should_begin_guess_game_when_call_begin_game() throws Exception {
        //given
        //when
        gameController.beginGame();

        //then
        verify(mockGameView).showBegin();

    }
}

