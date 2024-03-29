package Model;

public class Cell implements Cloneable{
    int row;
    int column;
    CellState cellState;
    Player player;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellState = CellState.EMPTY;
        this.player = null;
    }

    public Cell clone()
    {
        return new Cell(0,0);
    }

    public void displayCell()
    {
        if(player == null)
            System.out.print("| |");
        else
            System.out.print("|"+player.getSymbol()+"|");
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
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
}
