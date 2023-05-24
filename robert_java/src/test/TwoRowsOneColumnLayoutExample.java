package test;

import javax.swing.*;
import java.awt.*;

public class TwoRowsOneColumnLayoutExample extends JFrame {

    public TwoRowsOneColumnLayoutExample() {
        setTitle("Two Rows One Column Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Create label for the first row
        JLabel label = new JLabel("This is the label");

        // Create panel for the second row
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.GRAY);

        // Add components to the frame using GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(label, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panel, gbc);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TwoRowsOneColumnLayoutExample example = new TwoRowsOneColumnLayoutExample();
            example.setVisible(true);
        });
    }
}
