package tictactoe.model;

import tictactoe.model.types.CellState;

public class Cell {
    Integer row;
    Integer col;
    CellState cellState;
    Player player;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void display(){
        if(getPlayer() == null){
            System.out.println("| - |");
        }else {
            System.out.println("| "+ getPlayer().getSymbol().getPlayerSymbol()+ " |");
        }
    }
}
