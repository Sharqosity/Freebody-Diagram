import javax.swing.*;

/**
 * Created by student on 9/15/17.
 */
public class Main {

    public Main() {

    }

    public static void main(String[] args) {
        int width = 1000;
        int height = 800;
        JFrame frame = new JFrame("Freebody Diagram Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,width,height);

        Panel p = new Panel();
        frame.add(p);
        p.setLayout(null);
        p.setFocusable(true);
        p.grabFocus();

        frame.setVisible(true);
        frame.setResizable(false);

    }
    //hi
    //

}
