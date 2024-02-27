import Controller.GameController;
import Model.*;
import Service.WinningStrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char replayy = 'Y';
        while(replayy == 'Y' || replayy == 'y') {
            GameController gameController = new GameController();
            int id = 1;
            List<Player> players = new ArrayList<>();
            Scanner scn = new Scanner(System.in);
            System.out.println("Welcome to the Game of Tic Tac Toe");
            System.out.println("Please enter the dimension of the Board");
            int dimension = scn.nextInt();
            System.out.println("Do you want a bot in the game ? (Y / N)");
            String ans = scn.next();
            if (ans.equalsIgnoreCase("Y")) {
                Player bot = new Bot(id++, '$', BotDifficultyLevel.HARD);
                players.add(bot);
            }
            while (id < dimension) {
                System.out.println("Enter the name of the player");
                String name = scn.next();
                System.out.println("Enter the symbol of the player");
                char symbol = scn.next().charAt(0);
                Player newPlayer = new Player(id++, name, symbol, PlayerType.HUMAN);
                players.add(newPlayer);
            }
            Collections.shuffle(players);
            Game game = gameController.createGame(dimension, players, WinningStrategyName.ORDERONEWINNINGSTRATEGY);
            int playerIndex = -1;
            while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
                System.out.println("Current Board Status");
                gameController.displayBoard(game.getCurrentBoard());
                playerIndex++;
                playerIndex = playerIndex % players.size();
                Player currentPlayer = players.get(playerIndex);
                game.setCurrentPlayer(currentPlayer);
                //This is a make move logic
                Move movePlayed = gameController.makeMove(game,currentPlayer);
                game.getMoves().add(movePlayed);
                game.getBoardStates().add(game.getCloneOfCurrentBoard(game.getCurrentBoard()));
                Player winner = gameController.checkWinner(game, movePlayed);


                if(game.getCurrentPlayer().getPlayerType().equals(PlayerType.HUMAN))
                {
                    System.out.println("Do you want to undo the last played move ? (Y/N)");
                    String isUndo = scn.next();
                    if(isUndo.equalsIgnoreCase("Y"))
                    {
                       game = gameController.undoMove(game, movePlayed);

                        Move newMovePlayed = gameController.makeMove(game, players.get(playerIndex));
                        game.getMoves().add(newMovePlayed);
                        game.getBoardStates().add(game.getCloneOfCurrentBoard(game.getCurrentBoard()));
                        winner = gameController.checkWinner(game, movePlayed);
                    }
                }

                if (winner != null) {
                    System.out.println(" Winner is : " + winner.getName());
                    break;
                }
                if (game.getMoves().size() == game.getCurrentBoard().getDimension() * game.getCurrentBoard().getDimension()) {
                    System.out.println("Game is DRAW");
                    break;
                }
            }
            System.out.println("Final Board Status");
            gameController.displayBoard(game.getCurrentBoard());
            System.out.println("Do You want a Replay ? (Y/N");
            String replay = scn.next();
            if(replay.equalsIgnoreCase("Y"))
            {
                gameController.replayGame(game);
            }
            System.out.println("Do you want to play again ? (Y/N)");
            replayy = scn.next().charAt(0);
        }
    }


}
