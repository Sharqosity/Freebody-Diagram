import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by student on 9/15/17.
 */
public class Panel extends JPanel{

    ArrayList<Vector> vectors = new ArrayList<>();

    public Panel() {
        this.addMouseListener(new CustomMouseListener());

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        System.out.println(vectors.size());
        for (Vector v:vectors) {
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(v.ox,v.oy,v.x,v.y);
        }
    }


    class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            vectors.add(new Vector(e.getX(),e.getY(),400,300));
            repaint();
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mouseExited(MouseEvent e) {
        }
    }

}