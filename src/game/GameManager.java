package game;

public class GameManager {

    private IGameVisualizer form;

    private int scores = 0;
    private int lvl = 1;
    private int lvl_progress = 0;
    private boolean lvlUp = false;

    private RandomSymbol taskGenerator = new RandomSymbol(1);

    String currentTask;

    public GameManager(IGameVisualizer form) {
        this.form = form;
    }

    public void init() {
        nextTask();
        form.showLvl(lvl);
        form.showScores(scores);
        form.lvlUp(lvlUp);
    }

    public void nextLevel() {
        if (lvlUp){
            lvl++;
            lvlUp = false;
            lvl_progress = 0;
            taskGenerator = new RandomSymbol(lvl);

            form.lvlUp(lvlUp);
            form.showLvl(lvl);

            nextTask();
        }
    }

    public void answer(char ch) {
        String answer = Character.toString(ch).toUpperCase();
        boolean right = currentTask.equals(answer);
        form.showAnswer(answer, right);
        if (right) {
            scores++;
            form.showScores(scores);

            lvl_progress++;
            lvlUp = lvlUp();
            form.lvlUp(lvlUp);

            nextTask();
        }
    }

    private boolean lvlUp() {
        return lvl_progress >= lvl + 4 && lvl <= RandomSymbol.max_lvl();
    }

    private void nextTask() {
        currentTask = taskGenerator.nextChar();
        form.showTask(currentTask);
    }
}
