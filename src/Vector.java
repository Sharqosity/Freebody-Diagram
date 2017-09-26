import java.awt.*;

/**
 * Created by student on 9/15/17.
 */
public class Vector {

    public double x, y, ox, oy, xComp, yComp;

    public Vector(double x, double y, double ox, double oy) {
        this.x = x;
        this.y = y;
        this.ox = ox;
        this.oy = oy;
        this.xComp = this.x - this.ox;
        this.yComp = this.y - this.oy;
    }

    public void draw(Graphics2D g2){
        g2.drawLine((int)(Math.round(ox)), (int)(Math.round(oy)), (int)(Math.round(x)), (int)(Math.round(y)));
    }


    public double dir(){
        double dir = (Math.toDegrees(-Math.atan2(yComp, xComp)));
        return dir;
    }
    public double mag(){
        double mag = (Math.sqrt(Math.pow(xComp,2) + Math.pow(yComp,2)));

        return mag;
    }

    public void reComp() {
        this.xComp = this.x - this.ox;
        this.yComp = this.y - this.oy;
    }




//    public double[] Comp(double mag, double dir){
//        double[] comp =new double[2];
//
//        double xComp = mag*Math.cos(Math.toRadians(dir));
//        comp[0] = xComp;
//        double yComp = mag*Math.sin(Math.toRadians(dir));
//        comp[1] = yComp;
//
//        return comp;
//    }

    public double calcX(double mag, double dir){
        double xComp = mag*Math.cos(Math.toRadians(dir));
        return xComp;
    }

    public double calcY(double mag, double dir){
        double yComp = mag*Math.sin(Math.toRadians(dir));
        return yComp;
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
