package sk.stuba.fei.uim.oop.Shapes;

import lombok.Data;

import java.awt.*;
@Data
abstract public class Shape  {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Shape(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    abstract void paintShape(Graphics g);
}
