package Model;

import Service.BotPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "JARVIS", symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        return BotPlayingStrategyFactory.getBotPlayingStratrgy().makeMove(board,this);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
