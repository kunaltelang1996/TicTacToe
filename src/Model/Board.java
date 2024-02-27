package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> matrix;
    int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        matrix = new ArrayList<>();
        for(int i=0;i<dimension;i++)
        {
            matrix.add(new ArrayList<>());
                    for(int j =0 ;j<dimension;j++)
                    {
                        matrix.get(i).add(new Cell(i,j));
                    }
        }
    }

    public Board(Board originalBoard) {
        this.dimension = originalBoard.getDimension();
        this.matrix = new ArrayList<>();

        for (int i = 0; i < originalBoard.getDimension(); i++)
        {
            this.matrix.add(new ArrayList<>());
            for(int j = 0;j<originalBoard.getDimension();j++)
            {
                Cell cell = originalBoard.getMatrix().get(i).get(j);
                Cell cloneCell = originalBoard.getMatrix().get(i).get(j).clone();
                cloneCell.setRow(cell.getRow());
                cloneCell.setColumn(cell.getColumn());
                cloneCell.setPlayer(cell.getPlayer());
                cloneCell.setCellState(cell.getCellState());

                this.matrix.get(i).add(cloneCell);
            }
        }
    }

    public void displayBoard()
    {
        for(int i=0;i<dimension;i++)
        {
            List<Cell> cells = matrix.get(i);
            for(Cell cell : cells)
            {
                cell.displayCell();
            }
            System.out.println();
        }

    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
}
