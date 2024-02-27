package Controller;

import Model.*;
import Service.WinningStrategy.WinningStrategy;
import Service.WinningStrategy.WinningStrategyFactory;
import Service.WinningStrategy.WinningStrategyName;

import java.util.HashMap;
import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> players, WinningStrategyName name)
    {
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategy(WinningStrategyFactory.getWinningStrategy(name,dimension))
                .build();

    }

    public void displayBoard(Board board)
    {
         board.displayBoard();
    }

    public GameStatus getGameStatus(Game game)
    {
        return game.getGameStatus();
    }

    public Move makeMove(Game game, Player player)
    {
        return player.makeMove(game.getCurrentBoard());
    }

    public Player checkWinner(Game game, Move lastPlayedMove)
    {
        return game.getWinningStrategy().CheckWinner(game.getCurrentBoard(), lastPlayedMove);
    }

    public Game undoMove(Game game, Move lastMovePlayed)
    {
        List<Move> moves = game.getMoves();
        List<Board> boards = game.getBoardStates();

        moves.remove(moves.size() - 1);
        boards.remove(boards.size() - 1);
        lastMovePlayed.getCell().setCellState(CellState.EMPTY);
        lastMovePlayed.getCell().setPlayer(null);
        game.getWinningStrategy().undoLastMove(game.getCurrentBoard(), lastMovePlayed);

       return game;
    }

    public void replayGame(Game game)
    {
        List<Move> moves = game.getMoves();
        List<Board> boards = game.getBoardStates();
        for(int i= 0;i< moves.size();i++)
        {
            System.out.println("Player : " + moves.get(i).getPlayer().getName());
            System.out.println("Move : Row -> "+ moves.get(i).getCell().getRow());
            System.out.println("Move : Column -> "+ moves.get(i).getCell().getColumn());
            displayBoard(boards.get(i));
        }
    }

}
