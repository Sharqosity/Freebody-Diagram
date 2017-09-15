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
        frame.setBounds(0,0,500,700);

        Panel p = new Panel();
        frame.add(p);

        frame.setVisible(true);

    }

}
