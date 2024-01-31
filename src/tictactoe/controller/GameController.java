package tictactoe.controller;

import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.types.GameState;
import tictactoe.strategy.winning.GameWinningRule;
import tictactoe.strategy.winning.GameWinningRule;

import java.util.List;

public class GameController {
    /**
     * 1. startGame()
     * 2. move()
     * 3. undo()
     * 4. displayBoard()
     * 5. getWinnerName()
     */

    public void makeMove(Game game) throws Exception {
        game.makeMove();
    }
    public void  undo(Game game){
        game.undo();
    }

    // when unser wants to start game
    public Game startGame(List<Player> players, List<GameWinningRule> winingRules, Integer dimension){



        return Game.getGameBuilder()
                .setPlayers(players)
                .setWinningStartegies(winingRules)
                .setDimension(dimension)
                .build();
    }

    public void printBoard(Game game){
        game.printBoard();
    }

    public Player getWinner(Game game){

        return game.getWinnerPlayer();
    }

    public GameState getGameState(Game game){

        return game.getGameState();
    }
}
