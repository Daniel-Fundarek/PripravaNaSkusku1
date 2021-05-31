package sk.stuba.fei.uim.oop.Shapes;

import lombok.Data;

import java.awt.*;
@Data
abstract public class Shape  {
    private int x;
    private int y;
    private int x2;
    private int y2;
    private Color color;

    public Shape(int x, int y, int x2, int y2, Color color) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public abstract void paintShape(Graphics g);
    public abstract boolean isCursorInside(int x , int y);
}
