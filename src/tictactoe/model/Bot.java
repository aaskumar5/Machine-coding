package tictactoe.model;

import tictactoe.model.types.BotDifficultyLevel;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

//    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
//        this.botDifficultyLevel = botDifficultyLevel;
//    }
}
