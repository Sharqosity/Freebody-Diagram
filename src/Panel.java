import javax.imageio.ImageIO;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by student on 9/15/17.
 */
public class Panel extends JPanel {

    public Panel(){
        this.addMouseListener(new CustomMouseListener());

        try{
            img = ImageIO.read(new File("Res/Vector Meme.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Image img;
    ArrayList<Vector> vectors = new ArrayList<>();


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(img, 0, 0, null);
        g.fillOval(250, 350, 5, 5);
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setRenderingHints(rh);
        System.out.println(vectors.size());
        for (Vector v:vectors) {
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2));
//            g2.drawLine(v.ox,v.oy,v.x,v.y);
            v.draw(g2);
        }
    }
    public Vector Resultant(){
        double sumxcomp = 0;
        double sumycomp = 0;
        for (int i = 0; i < vectors.size(); i++) {
            sumxcomp += vectors.get(i).xComp;
            sumycomp += vectors.get(i).yComp;

        }
        Vector res = new Vector(sumxcomp, sumycomp, 400, 300);
        return res;

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