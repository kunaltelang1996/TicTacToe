package Service.BotPlayingStrategy;

import Exception.GameOverException;

import Model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board, Player bot) {
        List<List<Cell>> matrix =board.getMatrix();
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix.size();j++)
            {
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY))
                {
                    matrix.get(i).get(j).setPlayer(bot);
                    matrix.get(i).get(j).setCellState(CellState.FULL);
                    return new Move(matrix.get(i).get(j), bot);
                }
            }
        }
        throw new GameOverException("There are no cell remaining in the board to play");
    }
}
