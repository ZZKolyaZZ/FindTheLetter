package game;

public interface IGameVisualizer {

    void showTask(String ch);

    void showLvl(int lvl);

    void lvlUp(boolean show);

    void showScores(int scores);

    void showAnswer(String answer, boolean right);

}
