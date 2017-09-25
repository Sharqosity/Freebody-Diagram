import javax.imageio.ImageIO;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class Panel extends JPanel {

    private JButton clearButton = new JButton("Clear");
    private JButton undoButton = new JButton("Undo");
    private JTextArea in;
    private Image img;
    private String testin;
    private ArrayList<Vector> vectors = new ArrayList<>();
    private Vector previewVector;

    private Graphics2D g2;

    public Panel() {
        in = new JTextArea();
        in.setBounds(25, 60, 100, 20);
        in.getDocument().putProperty("filterNewlines", Boolean.TRUE);
        add(in);

        // adds key listener
        in.addKeyListener(new CustomKeyListener());

        previewVector = new Vector(0, 0, getWidth() / 2, getHeight() / 2);

        //adds mouse listener, find the methods at the bottom
        this.addMouseListener(new CustomMouseListener());
        this.addMouseMotionListener(new CustomMouseMotion());

        //button that clears vectors in array list
        clearButton.addActionListener(e -> {
            vectors.clear();
            repaint();
        });                  //x, y, width, height
        clearButton.setBounds(300, 20, 75, 20);
        this.add(clearButton);

        //button that removes last vector in array
        undoButton.addActionListener(e -> {
            if (!vectors.isEmpty()) {
                vectors.remove(vectors.size() - 1);
                repaint();
            }
        });
        undoButton.setBounds(375, 20, 75, 20);
        this.add(undoButton);

        //background
        try {
            img = ImageIO.read(new File("Res/Vector Meme.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //rad/deg combobox
        String[] dd = {"Radians", "Degrees"};
        JComboBox<String> selector = new JComboBox<>(dd);
        selector.setBounds(20, 20, 101, 20);
        add(selector);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g;

        // we have to update the vector origin here because reasons
        previewVector.ox = getWidth() / 2;
        previewVector.oy = getHeight() / 2;

        //background
        float opacity = 0.5f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);

        //middle dot
        float o = 1f;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, o));
        g.fillOval(getWidth() / 2 - 2, getHeight() / 2 - 2, 5, 5);

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
        for (Vector v : vectors) {
            g2.setColor(Color.black);
            g2.setStroke(new BasicStroke(2));
//            g2.drawLine(v.ox,v.oy,v.x,v.y);
            v.draw(g2);
        }

        //draw preview vector
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        previewVector.draw(g2);
        //recompute the comps because we need to do that
        previewVector.reComp();
        // draws preview resultant in green
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.GREEN);
        previewResultant().draw(g2);
    }

    private Vector Resultant() {
        double sumxcomp = 0;
        double sumycomp = 0;
        for (int i = 0; i < vectors.size(); i++) {
            sumxcomp += vectors.get(i).xComp;
            sumycomp += vectors.get(i).yComp;

        }
        return new Vector(getWidth() / 2 + sumxcomp, getHeight() / 2 + sumycomp, getWidth() / 2, getHeight() / 2);


    }

    private Vector previewResultant() {
        double sumxcomp = 0;
        double sumycomp = 0;
        for (int i = 0; i < vectors.size(); i++) {
            sumxcomp += vectors.get(i).xComp;
            sumycomp += vectors.get(i).yComp;

        }
        sumxcomp += previewVector.xComp;
        sumycomp += previewVector.yComp;
        return new Vector(getWidth() / 2 + sumxcomp, getHeight() / 2 + sumycomp, getWidth() / 2, getHeight() / 2);
    }

    private class CustomMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            requestFocus();
            vectors.add(new Vector(e.getX(), e.getY(), getWidth() / 2, getHeight() / 2));
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

    private class CustomKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_ENTER) { // gets input text and clears textarea
                testin = in.getText();
                String[] parts = testin.split(", ");

                Vector v = new Vector(Double.parseDouble(parts[0]) + getWidth() / 2, -Double.parseDouble(parts[1]) + getHeight() / 2, getWidth() / 2, getHeight() / 2);
                vectors.add(v);
                e.consume();
                requestFocus();
                repaint();
                in.setText("");

            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


    private class CustomMouseMotion implements MouseMotionListener {

        public void mouseMoved(MouseEvent e) {
            previewVector.x = e.getX();
            previewVector.y = e.getY();
            repaint();
        }

        public void mouseDragged(MouseEvent e) {

        }
    }

}