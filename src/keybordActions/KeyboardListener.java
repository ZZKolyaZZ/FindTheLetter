package keybordActions;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener {
    private JLabel label;
    private JPanel panel;

    public KeyboardListener() {
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                //label.setText(Character.toString(e.getKeyChar()));
            }

            @Override
            public void keyPressed(KeyEvent e) {
                label.setText(Character.toString(e.getKeyChar()) + " pressed");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText(Character.toString(e.getKeyChar()) + " released");
            }
        });
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        label.setFocusable(false);
    }

    public static void main(String[] args) {
        KeyboardListener app = new KeyboardListener();
        JFrame window  = new JFrame("Keyboard Listener");
        window.setContentPane(app.panel);
        window.setFocusable(false);
        app.label.setFocusable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);

    }
}
