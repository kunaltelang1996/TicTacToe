package Model;

import Exception.*;
import Service.WinningStrategy.WinningStrategy;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    Board currentBoard;
    List<Player> players;
    List<Move> moves;
    Player currentPlayer;
    GameStatus gameStatus;
    List<Board> boardStates;
    int noOfSymbols;
    WinningStrategy winningStrategy;

    public Game(Board currentBoard, List<Player> players, WinningStrategy winningStrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.moves = new ArrayList<>();
        this.currentPlayer = null;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.boardStates = new ArrayList<>();
        this.noOfSymbols = players.size();
        this.winningStrategy = winningStrategy;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public int getNoOfSymbols() {
        return noOfSymbols;
    }

    public void setNoOfSymbols(int noOfSymbols) {
        this.noOfSymbols = noOfSymbols;
    }

    public WinningStrategy getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(WinningStrategy winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public static class Builder{
        Board currentBoard;
        List<Player> players;
        WinningStrategy winningStrategy;
        int dimension;

        public Builder setCurrentBoard(Board currentBoard) {
            this.currentBoard = currentBoard;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public void ValidateNumbrOfPlayers()
        {
            if(players.size() < dimension-2 || players.size() >= dimension)
            {
                throw new InvalidNumberOfPlayersException("There can be only N-1 or N-2 Players in the game");
            }
        }

        public void ValidateBotCount()
        {
            long botCount = players.stream().filter(player -> player.getPlayerType().equals(PlayerType.BOT)).count();
            if(botCount > 1 || botCount < 0)
            {
                throw new InvalidBotCountException("There can be only one bot in the game");
            }
        }

        public void ValidateNoOfSymbols()
        {
            HashSet<Character> symbol = new HashSet<>();
            players.stream().forEach(player -> symbol.add(player.getSymbol()));
            if(symbol.size() != players.size())
            {
                throw new InvalidNoOfSymbolsException("There can only unique symbols for each player");
            }
        }

        public void ValidateDimension()
        {
            if(dimension < 3 || dimension > 10)
                throw new InvalidDimensionException("Please enter the dimension between 3 and 10");
        }

        public void validate()
        {
            ValidateDimension();
            ValidateBotCount();
            ValidateNoOfSymbols();
            ValidateNumbrOfPlayers();
        }

        public Game build()
        {
            validate();
            return new Game(new Board(dimension), players, winningStrategy);
        }
    }


}
