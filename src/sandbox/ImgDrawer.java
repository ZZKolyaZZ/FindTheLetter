package sandbox;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;

public class ImgDrawer extends JFrame{

    BufferedImage img;
    int x;
    int y;

    public ImgDrawer(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            g.drawImage(img, x, y, null);
        }

    }

    public static void main(String[] args) {
        ImgDrawer window  = new ImgDrawer("Painter");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 400);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.getContentPane().setBackground(Color.BLACK);
        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.y-= 40;
                window.repaint(0, 0, 0, window.getWidth(), window.getHeight());
                if(window.y <= 0) {
                    window.y = 0;
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        BufferedImage img = null;
        try {
            Path path = Paths.get(".");
            System.out.println(path.toAbsolutePath());
            img = ImageIO.read(new File("resources\\128.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.img = img;

        window.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                window.x = e.getX();
                window.y = e.getY();
                timer.start();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        window.setVisible(true);
    }
}
