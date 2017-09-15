import java.awt.*;

/**
 * Created by student on 9/15/17.
 */
public class Vector {

    public int x, y, ox, oy;

    public Vector(int x, int y, int ox, int oy) {
        this.x = x;
        this.y = y;
        this.ox = ox;
        this.oy = oy;
    }

    public void draw(Graphics2D g2){
        g2.drawLine(ox, oy, x, y);
    }

    public double[] magDir(double xComp, double yComp){
        double[] magDir = new double[2];

        double mag = Math.sqrt(Math.pow(xComp,2) + Math.pow(yComp,2));
        magDir[0] = mag;

        double dir = Math.toDegrees(Math.atan2(yComp, xComp));
        magDir[1] = dir;

        return magDir;
    }

    public double[] Comp(double mag, double dir){
        double[] comp =new double[2];

        double xComp = mag*Math.cos(Math.toRadians(dir));
        comp[0] = xComp;
        double yComp = mag*Math.sin(Math.toRadians(dir));
        comp[1] = yComp;

        return comp;
    }


    //uneeded getters and setters because variables are public now
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public void setOx(int ox) {
//        this.ox = ox;
//    }
//
//    public void setOy(int oy) {
//        this.oy = oy;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public int getOx() {
//        return ox;
//    }
//
//    public int getOy() {
//        return oy;
//    }


}
