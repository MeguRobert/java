package color_memory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main {

    public static int round = 1;
    public static int iteration = 0;
    public static boolean buttonIsGrey = false;

    public static Timer timer;
    static Random random = new Random();
    public static final Color[] COLORS = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW };

    public static ArrayList<Integer> generatedTileIndexes = new ArrayList<Integer>();
    public static ArrayList<Integer> clickedTileIndexes = new ArrayList<Integer>();

    public static JLabel roundLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }

    public static void generateNewIndex() {
        if (generatedTileIndexes.size() == round) {
            timer.stop();
            return;
        }
        generatedTileIndexes.add(random.nextInt(COLORS.length));
        // iteration++;
    }

    public static void onButtonClick(int index) {
        clickedTileIndexes.add(index);
        System.out.println(index);
        boolean sequenceWasClicked = clickedTileIndexes.size() == generatedTileIndexes.size();
        boolean clickedTilesMatches = true;

        for (int i = 0; i < clickedTileIndexes.size(); i++) {
            if (clickedTileIndexes.get(i) != generatedTileIndexes.get(i)) {
                clickedTilesMatches = false;
                break;
            }

        }

        if (!clickedTilesMatches) {
            System.out.println("You missed at ROUND " + round);
            clickedTileIndexes.clear();
            generatedTileIndexes.clear();
            System.exit(0);
            return;
        } else if (sequenceWasClicked && clickedTilesMatches) {
            startNextTurn();
        }

    }

    public static void startNextTurn() {
        System.out.println("Next turn");
        clickedTileIndexes.clear();
        round++;
        iteration = 0;
        generateNewIndex();
        buttonIsGrey = false;
        timer.restart();
    }

    public static void reDisplayRound() {
        roundLabel.setText("ROUND: " + round);
    }
}
