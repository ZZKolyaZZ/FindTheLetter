package sandbox;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LineDrawer extends JFrame{

    private static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Line {
        private final int x1,y1,x2,y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    private final List<Line> lines;
    private Line red;

    public LineDrawer(String title) throws HeadlessException {
        super(title);
        lines  = new ArrayList<>();
        red = null;
    }

    public void addLine(Line line) {
        this.lines.add(line);
    }

    public void redLine(Line line) {
        red = line;
    }

    public void removeRed() {
        red = null;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        for(Line line : lines) {
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
        if (red != null) {
            g.setColor(Color.RED);
            g.drawLine(red.x1, red.y1, red.x2, red.y2);
        }
    }

    public static void main(String[] args) {
        LineDrawer window  = new LineDrawer("Painter");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.getContentPane().setBackground(Color.BLACK);
        Point p = new Point(0,0);
        window.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                p.x = e.getX();
                p.y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                window.removeRed();
                window.addLine(new Line(p.x,p.y,e.getX(), e.getY()));
                window.repaint(0,0,0,window.getWidth(), window.getHeight());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        window.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //window.addLine(new Line(p.x,p.y,e.getX(), e.getY()));
                window.redLine(new Line(p.x, p.y, e.getX(), e.getY()));
                window.repaint(0,0,0,window.getWidth(), window.getHeight());
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        window.setVisible(true);
    }
}
