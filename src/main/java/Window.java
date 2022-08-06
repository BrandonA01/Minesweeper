import javax.swing.*;
import java.awt.*;

public class Window {
    private static JFrame frame;
    private static String gameTitle;

    public Window(int width, int height, int X, int Y, String title, Game game, NextSpaces nextSpaces){
        frame = new JFrame();
        Window.gameTitle = title;
        frame.setTitle(gameTitle);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new Board(new GridLayout(X, Y), nextSpaces);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}