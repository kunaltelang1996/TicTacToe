package Model;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "JARVIS", symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

}
