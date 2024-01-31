package tictactoe.model;

import tictactoe.model.types.PlayerType;

import java.util.Scanner;

public class Player {
    String name;
    Integer id;
    Symbol symbol;
    PlayerType type;
    Scanner scanner;

    public Player(String name, Integer id, Symbol symbol, PlayerType type, Scanner scanner) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.type = type;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move makeMove( ) {
        System.out.println("Please specify the row where you want to move: \n");
        int row = this.scanner.nextInt();

        System.out.println("Please specify the column where you want to move: \n");
        int col = this.scanner.nextInt();
        return new Move(new Cell(row,col),this);
    }
}
