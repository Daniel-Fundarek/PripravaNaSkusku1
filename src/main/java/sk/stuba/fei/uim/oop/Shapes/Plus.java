package sk.stuba.fei.uim.oop.Shapes;

import java.awt.*;

import static java.lang.Math.abs;

public class Plus extends Shape{
    int x,y,width,length;

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

    }
}
