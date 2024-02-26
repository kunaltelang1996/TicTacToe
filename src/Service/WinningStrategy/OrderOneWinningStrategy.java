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

    public OrderOneWinningStrategy(int dimension) {
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

        boolean winner = (checkCorner(row,column) && CornerWinnerCheck(symbol, this.corner)
                || (populateHashMap(symbol,rowList.get(row)))
                || (populateHashMap(symbol,columnList.get(column)))
                || (checkLeftDiagonal(row, column) && populateHashMap(symbol, this.leftDiagonal))
                || (checkRightDiagonal(row, column) && populateHashMap(symbol, this.rightDiagonal)));

        if(winner)
        {
            return player;
        }else
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
        boolean b = (
                ((row == 0) && (column == 0))
                        || ((row == 0 && column == dimension - 1))
                        || ((row == (dimension - 1)) && (column == 0))
                        || ((row == (dimension - 1)) && (column == (dimension - 1)))
        );

        return b;
    }

    public boolean populateHashMap(char symbol, HashMap<Character, Integer> hashMap)
    {
        if(hashMap.containsKey(symbol))
        {
            hashMap.put(symbol,hashMap.get(symbol) + 1);
            return hashMap.get(symbol) == dimension;
        }else
        {
            hashMap.put(symbol,1);
        }
        return false;
    }

    public boolean CornerWinnerCheck(char symbol, HashMap<Character, Integer> hashMap)
    {
        if (hashMap.containsKey(symbol))
        {
            hashMap.put(symbol, hashMap.get(symbol) + 1);
            return hashMap.get(symbol) == 4;
        }else
        {
            hashMap.put(symbol, 1);
        }
        return false;
    }
}
