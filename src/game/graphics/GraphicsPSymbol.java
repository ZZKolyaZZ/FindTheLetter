package game.graphics;

import game.GameManager;
import game.IGameVisualizer;
import game.label.PSymbol;

import javax.swing.*;
import java.awt.*;

public class GraphicsPSymbol {

    public static void main(String[] args) {
        PSymbol app = new PSymbol();
        IGameVisualizer vizualizer = new IGameVisualizer() {
            @Override
            public void showTask(String ch) {

            }

            @Override
            public void showLvl(int lvl) {

            }

            @Override
            public void lvlUp(boolean show) {

            }

            @Override
            public void showScores(int scores) {

            }

            @Override
            public void showAnswer(String answer, boolean right) {

            }
        };
        GameManager manager = new GameManager(vizualizer);
        app.registerGameManager(manager);

        manager.init();

        JFrame window  = new JFrame("Нажми на букву!");
        window.setFocusable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.getContentPane().setBackground(Color.BLACK);
        window.setUndecorated(true);
        window.setVisible(true);
    }

}
