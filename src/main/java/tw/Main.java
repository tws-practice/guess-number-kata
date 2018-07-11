package tw;

import com.google.inject.Injector;
import tw.commands.GuessInputCommand;
import tw.controllers.GameController;

import static com.google.inject.Guice.createInjector;

/**
 * Created by jxzhong on 2017/5/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Injector injector = createInjector(new GuessNumberModule());
        GameController gameController = injector.getInstance(GameController.class);

        gameController.beginGame();
        gameController.play(new GuessInputCommand());

    }
}
