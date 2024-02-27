package Service.WinningStrategy;

import Model.Board;
import Model.Move;
import Model.Player;

public interface WinningStrategy {

    Player CheckWinner(Board board, Move lastMove);
    void undoLastMove(Board board, Move lastMove);
}
