package color_memory;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    public MyPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        int x = Main.COLORS.length / 2;
        int y = Main.COLORS.length / 2;

        setLayout(new GridLayout(x, y));
        for (int i = 0; i < x * y; i++) {
            JButton button = new JButton();
            Color color = Main.COLORS[i];
            button.setBackground(color);
            button.setPreferredSize(new Dimension(250, 250));
            final int idx = i;
            button.addActionListener(e -> Main.onButtonClick(idx));

            add(button);
        }

        int delay_milliseconds = 500;

        Main.generateNewIndex();

        Main.timer = new Timer(delay_milliseconds, this);
        Main.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int tileIndex = Main.iteration / 2;
        if (Main.generatedTileIndexes.size() == tileIndex) {
            Main.generateNewIndex();
            return;
        }
        FlashButtonByIndex(Main.generatedTileIndexes.get(tileIndex));

        Main.iteration++;

        Main.reDisplayRound();
        // generatedTileIndexes: 1
        //

    }

    private void FlashButtonByIndex(int colorIndex) {
        Component comp = this.getComponent(colorIndex);
        Color activeColor = comp.getBackground();
        if (activeColor == Color.GRAY) {
            comp.setBackground(Main.COLORS[colorIndex]);
        } else {
            comp.setBackground(Color.GRAY);

        }
    }

}
