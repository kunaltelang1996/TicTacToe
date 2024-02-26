package Service.WinningStrategy;

import Model.Board;
import Model.Move;
import Model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy{

    private int dimension;
    private List<HashMap<Character, Integer>> rowList; // index in the list will correspond to the row number for hashmap identification
    private List<HashMap<Character, Integer>> columnList; // index in the list will correspond to the col number for hashmap identification
    private HashMap<Character, Integer> leftDiagonal;
    private HashMap<Character, Integer> rightDiagonal;
    private HashMap<Character, Integer> corner;

    public OrderOneWinningStrategy(int dimension, List<HashMap<Character, Integer>> rowList, List<HashMap<Character, Integer>> columnList, HashMap<Character, Integer> leftDiagonal, HashMap<Character, Integer> rightDiagonal, HashMap<Character, Integer> corner) {
        this.dimension = dimension;
        this.rowList = new ArrayList<>();
        this.columnList = new ArrayList<>();
        this.leftDiagonal = new HashMap<>();
        this.rightDiagonal = new HashMap<>();
        this.corner = new HashMap<>();
        for(int i=0;i<dimension;i++)
        {
            rowList.add(new HashMap<>());
            columnList.add(new HashMap<>());
        }
    }

    @Override
    public Player CheckWinner(Board board, Move lastMove) {
        Player player =lastMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastMove.getCell().getRow();
        int column = lastMove.getCell().getColumn();

//        boolean winner =



        return null;
    }

    private boolean checkRightDiagonal(int row, int column)
    {
        return ((row + column) == (dimension - 1));
    }

    private boolean checkLeftDiagonal(int row, int column)
    {
        return row == column;
    }

    private boolean checkCorner(int row, int column)
    {
        return true;
    }
}
