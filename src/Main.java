import javax.swing.*;
import java.awt.*;

/**
 * Created by student on 9/15/17.
 */
public class Main {

    public Main() {

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Freebody Diagram Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0, 800, 800);

        Panel p = new Panel();
        p.setLayout(null);
        frame.add(p);
        frame.setResizable(false);

        frame.setVisible(true);

    }
    //hi

}
