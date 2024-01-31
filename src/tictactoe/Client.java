package tictactoe;

import tictactoe.controller.GameController;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.Symbol;
import tictactoe.model.types.GameState;
import tictactoe.model.types.PlayerType;
import tictactoe.strategy.winning.ColumnWinningRule;
import tictactoe.strategy.winning.GameWinningRule;
import tictactoe.strategy.winning.RowWinningRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        // user's perspective
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Ashish",1,new Symbol('X'), PlayerType.HUMAN,sc));
        players.add(new Player("Delta",2,new Symbol('O'), PlayerType.HUMAN,sc));

        List<GameWinningRule> rules = new ArrayList<>();
        rules.add(new RowWinningRule());
        rules.add(new ColumnWinningRule());


        Game game = gameController.startGame(players,rules,3);

        while(game.getGameState().equals(GameState.IN_PROGRESS)) {

            // displayBoard
            // find out player with nextTurn
            // ask player to make a move

            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if(game.getGameState().equals(GameState.DRAW)){
            System.out.println("Game is DRAW..");
        }

        if(game.getGameState().equals(GameState.END)) {
            System.out.println("Game is won by Player: "+ gameController.getWinner(game).getName());
        }

    }

}
