package sk.stuba.fei.uim.oop.Shapes;

import java.awt.*;

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
}
