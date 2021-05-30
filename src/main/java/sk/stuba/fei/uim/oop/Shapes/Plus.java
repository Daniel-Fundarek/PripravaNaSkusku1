package sk.stuba.fei.uim.oop.Shapes;

import java.awt.*;

public class Plus extends Shape{
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Plus(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    void paintShape(Graphics g) {

    }
}
