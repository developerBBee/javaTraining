import javax.swing.*;

public class MyFrameLarge {
    public void start() {
        var frame = new JFrame("test");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Program exit if window closed.

        var text1 = new JTextField();
        frame.add("North", text1);

        var text2 = new JTextField();
        frame.add("South", text2);

        var button = new JButton("大文字");
        frame.add(button);

        button.addActionListener(ae -> {
            text2.setText(text1.getText().toUpperCase());
        });

        frame.setVisible(true);
    }
}
