package sk.stuba.fei.uim.oop.Shapes;

import java.awt.*;
import java.awt.geom.Line2D;

import static java.lang.Math.round;

public class Line extends Shape{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;


    public Line(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);

    }

    @Override
    public void paintShape(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX(),getY(), getX2(), getY2());
    }
    @Override
    public boolean isCursorInside(int x , int y){
        double dist = Line2D.ptLineDist(getX(),getY(), getX2(), getY2(),x,y);
        System.out.println("distance "+ dist );
            if(round(dist)==0.0){
                return true;
            }
        return false;
    }
}
