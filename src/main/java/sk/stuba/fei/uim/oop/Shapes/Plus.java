package sk.stuba.fei.uim.oop.Shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class Plus extends Shape{
    int x,y,width,length;
    private ArrayList<java.awt.Shape> shape = new ArrayList<>();
    public Plus(int x, int y, int x2, int y2, Color color) {
        super(x, y, x2, y2, color);
        this.x= getX();
        this.y= getY();
        this.width = getX2();
        this.length = getY2();

    }


    @Override
    public void paintShape(Graphics g) {
        x= getX();
        y= getY();
        width = abs(getX2()-getX());
        length = abs(getY2()-getY());
        if(width<length) {
            length = width;
        }
        else{
            width = length;
        }
        g.setColor(getColor());
        g.fillRect(x+width/3,y,width/3,length);
        g.fillRect(x,y+length/3,width,length/3);
        shape.removeAll(shape);
        shape.add(new Rectangle(x+width/3,y,width/3,length));
        shape.add(new Rectangle(x,y+length/3,width,length/3));
    }
    @Override
    public boolean isCursorInside(int x , int y){
        for (java.awt.Shape rect: shape){
            if(rect.contains(x,y)){
                return true;
            }
        }
        return false;

    }

}
