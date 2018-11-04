package game.label;

import game.GameManager;
import game.IGameVisualizer;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PSymbol {
    private JLabel JLabel1;
    private JLabel pressed;
    private JLabel task;
    private JPanel panel;
    private JLabel scores_label;
    private JLabel level;
    private JLabel lchange;

    public PSymbol() {

        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    public void registerGameManager(GameManager manager) {
        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (c == 'ё' || c == 'Ё') {
                    manager.nextLevel();
                    return;
                }
                manager.answer(c);
            }
        });
    }

    public static void main(String[] args) {
        PSymbol app = new PSymbol();
        IGameVisualizer vizualizer = new PSymbolGameVizualizer(app.pressed, app.task, app.scores_label, app.level, app.lchange);
        GameManager manager = new GameManager(vizualizer);
        app.registerGameManager(manager);

        manager.init();

        JFrame window  = new JFrame("Нажми на букву!");
        window.setContentPane(app.panel);
        window.setFocusable(false);
        app.task.setFocusable(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }
}
