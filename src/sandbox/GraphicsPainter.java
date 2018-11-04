package sandbox;

import javax.swing.*;
import java.awt.*;

public class GraphicsPainter extends JFrame {

    public GraphicsPainter(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawLine(100,100,200,200);
        g.setColor(Color.WHITE);
        g.fillOval(100, 100, 200, 150);
        g.drawString("Привет, мир!", 400, 200);
    }

    public static void main(String[] args) {
        JFrame window  = new GraphicsPainter("Painter");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.getContentPane().setBackground(Color.BLACK);
        window.setVisible(true);
    }
}
