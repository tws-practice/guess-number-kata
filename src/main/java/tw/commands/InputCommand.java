package tw.commands;

import tw.core.Answer;

import java.io.IOException;

/**
 * Created by jxzhong on 2017/5/19.
 */
public interface InputCommand {
    Answer input() throws IOException;
}
