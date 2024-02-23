package Model;

import java.util.Scanner;

public class Player {
    int id;
    String name;
    char symbol;
    PlayerType playerType;

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row index of the move");
        int row = sc.nextInt();
        System.out.println("Enter the column index of the move");
        int column = sc.nextInt();

        Cell lastPlayedCell = board.getMatrix().get(row).get(column);
        lastPlayedCell.setCellState(CellState.FULL);
        lastPlayedCell.setPlayer(this);

        return new Move(lastPlayedCell,this);
    }
}
