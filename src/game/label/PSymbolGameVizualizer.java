package game.label;

import game.IGameVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class PSymbolGameVizualizer implements IGameVisualizer {

    private JLabel pressed;
    private JLabel task;
    private JLabel scores_label;
    private JLabel level;
    private JLabel lchange;

    public PSymbolGameVizualizer(JLabel pressed, JLabel task, JLabel scores_label, JLabel level, JLabel lchange) {
        this.pressed = pressed;
        this.task = task;
        this.scores_label = scores_label;
        this.level = level;
        this.lchange = lchange;
    }

    @Override
    public void showTask(String ch) {
        if  (ch.equals(" ")){
            task.setText("пробел");
            return;
        }
        task.setText(ch);
    }

    @Override
    public void showLvl(int lvl) {
        level.setText("уровень: " + lvl);
    }

    @Override
    public void lvlUp(boolean show) {
        lchange.setVisible(show);
    }

    @Override
    public void showScores(int scores) {
        scores_label.setText(String.valueOf(scores));
    }

    @Override
    public void showAnswer(String answer, boolean right) {
        if  (answer.equals(" ")){
            pressed.setText("пробел");
        } else {
            pressed.setText(answer);
        }

        Color old = new Color(0,0,0);
        Color color = getColor(right);
        Timer timer = new Timer(100, new ActionListener() {

            private int frame = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame++ % 2 == 0) {
                    pressed.setForeground(color);
                } else {
                    pressed.setForeground(old);
                }
                if (frame >= 6) {
                    ((Timer) e.getSource()).stop();
                    pressed.setForeground(old);
                    pressed.setText(". . .");
                }
            }
        });
        timer.start();
    }

    private Color getColor(boolean right) {
        return right? new Color(0, 127, 0): new Color(255, 0, 0);
    }
}
