package Controller;

import Model.*;
import Service.WinningStrategy.WinningStrategy;
import Service.WinningStrategy.WinningStrategyFactory;
import Service.WinningStrategy.WinningStrategyName;

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

    public void displayBoard(Game game)
    {
         game.getCurrentBoard().displayBoard();
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

}
