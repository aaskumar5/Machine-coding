package tictactoe.model;

import tictactoe.model.types.GameState;

import java.util.List;

public class Game {
    List<Player> players;
    Board board;
    List<Move> playerMoves;
    Player winnerPlayer;
    GameState gameState;
    Integer nextPlayerIndex;

}
