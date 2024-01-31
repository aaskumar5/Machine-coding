package tictactoe.model;

import tictactoe.model.types.CellState;
import tictactoe.model.types.GameState;
import tictactoe.model.types.PlayerType;
import tictactoe.strategy.winning.GameWinningRule;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players; // YES
    Board board; // NO
    List<Move> playerMoves; // ? for UNDO NO
    Player winnerPlayer; // NO
    GameState gameState; // NO
    Integer nextPlayerIndex; // NO
    List<GameWinningRule> winingRules; // YES

    private Game(List<Player> players, int dimension, List<GameWinningRule> winningStartegies) {
        this.players = players;
        this.board = new Board(dimension);
        this.playerMoves = new ArrayList<>();
        // this.winnerPlayer =
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winingRules = winningStartegies;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getPlayerMoves() {
        return playerMoves;
    }

    public void setPlayerMoves(List<Move> playerMoves) {
        this.playerMoves = playerMoves;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public void setWinnerPlayer(Player winnerPlayer) {
        this.winnerPlayer = winnerPlayer;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Integer getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(Integer nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public static Builder getGameBuilder(){
        return new Builder();
    }

    public void makeMove() throws Exception {
        // S1 : I need index for player for which move has to br done
        // S2 : ask player to make a move
        // S3 : validate the move
        // S4 : update the cell on board
        // S5 : update nextPlayerTurn index
        // S6 : CheckWinner

        Player currPlayer = players.get(nextPlayerIndex);
        Move currMove = currPlayer.makeMove();

        if (!validateMove(currMove)){
            throw new Exception();
        }

        int row = currMove.getCell().getRow();
        int col = currMove.getCell().getCol();

        Cell cellToBeUpdated = getBoard().getCells().get(row).get(col);
        cellToBeUpdated.setCellState(CellState.FILLED);
        cellToBeUpdated.setPlayer(currMove.getPlayer());

        currMove.setCell(cellToBeUpdated);
        playerMoves.add(currMove);

        nextPlayerIndex++;
        nextPlayerIndex %= players.size();

        if(checkWinner(board,currMove)){ // WON
            gameState = GameState.END;
            winnerPlayer = currPlayer;
        } else if(playerMoves.size() == board.getSize()*board.getSize()) {
            gameState = GameState.DRAW;

        }


    }

    private boolean checkWinner(Board board, Move currMove) {
        for(GameWinningRule rule: winingRules) {
            if(rule.checkWinner(board,currMove)){
                return true;
            }
        }
        return false;
    }

    private boolean validateMove(Move currMove){
        // what ?
        if(currMove.getCell().getCellState().equals(CellState.FILLED)) {
            return false;
        }

        int row = currMove.getCell().getRow();
        int col = currMove.getCell().getCol();

        if (row >= board.getSize()){
            return false;
        }
        if (col >= board.getSize()){
            return false;
        }
        return true;
    }

    public void undo() {
    }

    public void printBoard() {
        board.printBoard();
    }


    // players : n-1
    // bots: all players should not be bots

    public static class Builder { // Inner static class
        // only add attributes which I can take from clients
        private List<Player> players;
        private List<GameWinningRule> winningStartegies;
        private int dimension;
        private Builder (){
            this.players = new ArrayList<>();
            this.winningStartegies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStartegies(List<GameWinningRule> winningStartegies) {
            this.winningStartegies = winningStartegies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Game build(){
            // validate
            // create new object
            validate();

            return new Game(players,dimension,winningStartegies);
        }

        public void validate() throws Exception {
            // no of bots
            int botCount =0;
            for (Player p : players) {
                if (p.getType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount == players.size()){
                throw new Exception();
            }

            if(players.size()-1 != dimension){
                throw new Exception();
            }
        }
    }
}
