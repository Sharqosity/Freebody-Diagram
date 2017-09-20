import javax.imageio.ImageIO;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by student on 9/15/17.
 */
public class Panel extends JPanel {

    private JButton clearButton = new JButton("Clear");
    private JButton undoButton = new JButton("Undo");
    private Image img;
    private ArrayList<Vector> vectors = new ArrayList<>();

    public Panel(){
        //adds mouse listener, find the methods at the bottom
        this.addMouseListener(new CustomMouseListener());

        //button that clears vectors in array list
        clearButton.addActionListener(e -> {
            vectors.clear();
            repaint();
        });                  //x, y, width, height
        clearButton.setBounds(25, 725, 75, 30);
        this.add(clearButton);

        //button that removes last vector in array
        undoButton.addActionListener(e -> {
            if (!vectors.isEmpty()) {
                vectors.remove(vectors.size()-1);
                repaint();
            }
        });
        undoButton.setBounds(125, 725, 75, 30);
        this.add(undoButton);

        //background
        try{
            img = ImageIO.read(new File("Res/Vector Meme.jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }

        //rad/deg combobox
        String[] dd = {"Radians", "Degrees"};
        JComboBox<String> selector = new JComboBox<String>(dd);
        selector.setBounds(20, 20, 101, 20);
        add(selector);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //background
        float opacity = 0.5f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
//        g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        //middle dot
        float o = 1f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g.fillOval(getWidth()/2-2, getHeight()/2-2, 5, 5);

        //anti-aliasing
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setRenderingHints(rh);

        //resultant (draw first so it appears under)
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.RED);
        Resultant().draw(g2);

        //vectors
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
        Vector res = new Vector(getWidth()/2 + sumxcomp, getHeight()/2 + sumycomp, getWidth()/2, getHeight()/2);
        return res;


    }



    class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            vectors.add(new Vector(e.getX(),e.getY(),getWidth()/2,getHeight()/2));
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