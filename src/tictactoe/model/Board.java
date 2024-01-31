package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> cells;
    Integer size;

    public Board(int dimension) {
        cells = new ArrayList<>();
        for(int i=0;i<=dimension;i++){
            cells.add(new ArrayList<>());
            for(int j=0;j<dimension;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void printBoard() {
        for(List<Cell> row : cells){
            for(Cell cell: row){
                // I will print the cell
                cell.display();
            }
        }
    }
}
