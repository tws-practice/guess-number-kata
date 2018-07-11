package tw.controllers;

import com.google.inject.Inject;
import tw.core.Game;
import tw.commands.InputCommand;
import tw.core.exception.OutOfGuessCountException;
import tw.core.model.GuessResult;
import tw.views.GameView;

import java.io.IOException;

/**
 * Created by jxzhong on 2017/5/19.
 */
public class GameController {
    private final Game game;
    private final GameView gameView;

    @Inject
    public GameController(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;
    }

    public void beginGame() throws IOException {
        gameView.showBegin();
    }

    public void play(InputCommand command) throws IOException, OutOfGuessCountException {

        if (game.checkCoutinue()) {
            GuessResult guessResult = game.guess(command.input());
            gameView.showGuessResult(guessResult);
            gameView.showGuessHistory(game.guessHistory());
            play(command);
        } else {
            gameView.showGameStatus(game.checkStatus());
        }
    }

}
