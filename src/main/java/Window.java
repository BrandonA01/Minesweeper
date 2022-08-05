import javax.swing.*;
import java.awt.*;

public class Window {
    private static JFrame frame;
    private static String gameTitle;

    public Window(int width, int height, int gridSize, String title, Game game){
        frame = new JFrame();
        Window.gameTitle = title;
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}