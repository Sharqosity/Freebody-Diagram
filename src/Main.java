import javax.swing.*;
import java.awt.*;

/**
 * Created by student on 9/15/17.
 */
public class Main {

    public Main() {

    }

    public static void main(String[] args) {
        int Width = 500;
        int Height = 700;
        JFrame frame = new JFrame("Freebody Diagram Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,Width,Height);

        Panel p = new Panel();
        frame.add(p);

        frame.setVisible(true);

    }
    //hi

}
