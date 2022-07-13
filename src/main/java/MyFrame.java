import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class MyFrame {
    boolean highspeed = false;

    public void start() {
        var f = new JFrame("test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program exit if window closed.

        f.setVisible(true);
        f.setSize(600, 400);
        f.setLocation(200, 200);
        var text = new JTextField();
        f.add("North", text);
        var btn = new JButton("Change High Speed Mode");
        f.add("Center", btn);
        f.validate();

        btn.addActionListener(ae -> {
            highspeed = !highspeed;
            if (highspeed) {
                btn.setText("Change Low Speed Mode");
            } else {
                btn.setText("Change High Speed Mode");
            }
        });

        System.out.println(Thread.currentThread().getName());
        getTask(f, new java.util.Timer(), 200, 200, text).run();
    }

    private TimerTask getTask(JFrame f, Timer t, int x, int y, JTextField txt) {
        return new TimerTask() {
            @Override
            public void run() {
                f.setLocation(x, y);
                System.out.println(f.getLocation());
                txt.setText(("[x=%d,y=%d]").formatted(x, y));
                System.out.println(txt.getText());
                int move = highspeed ? 20 : 10;
                int x2 = (x >= 1000) ? 200 : x+move;
                int y2 = (y >= 600) ? 200 : y+move;

                long delay = highspeed ? 500 : 1000;

                t.schedule(getTask(f, t, x2, y2, txt), delay);
            }
        };
    }
}
