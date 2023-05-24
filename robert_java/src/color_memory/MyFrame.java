package color_memory;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyPanel panel;

    public MyFrame() {
        super("Color Memory");
        panel = new MyPanel();
        JPanel wrapper = new JPanel();
        Main.roundLabel = new JLabel();

        wrapper.add(Main.roundLabel);
        wrapper.add(panel);
        setPreferredSize(new Dimension(500, 650));

        add(wrapper);
        pack();
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
