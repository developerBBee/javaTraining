import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MyLattice {
    public void start() {
        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        var g = image.createGraphics();
        for (int x = 0; x<12; x++) {
            for (int y = 0; y<12; y++) {
                if (x == y) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(26*x+150, 26*y+50, 25, 25);
            }
        }

        var frame = new JFrame("ŠiŽq");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
    }
}
