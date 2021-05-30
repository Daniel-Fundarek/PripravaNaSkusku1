package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.Shapes.Line;
import sk.stuba.fei.uim.oop.Shapes.Plus;
import sk.stuba.fei.uim.oop.Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static java.lang.Math.abs;

public class MyCanvas extends Canvas implements MouseMotionListener, MouseListener {
    public ArrayList<Shape> obj = new ArrayList<>();
    Shape actualShape;
    @Setter
    private Color color = Color.RED;
    @Getter@Setter
    private Boolean paintOnCan = true;
    @Setter
    private String shape ="Line";
    int x =0, y= 0;

    public MyCanvas() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if(!paintOnCan){
            int xxx = e.getX();
            int yyy = e.getY();
            System.out.println("x: "+ xxx +" y: " + yyy);
            for (int i = obj.size()-1;i>=0;i--){
                int x1= obj.get(i).getX();
                int x2= obj.get(i).getX2();
                int y1 = obj.get(i).getY();
                int y2 = obj.get(i).getX();
                int width = abs(x1-x2);
                int length = abs(y1-y2);


                System.out.println("x1  " +x1+" x2 "+x2 + " y1 "+ y1 + " y2 "+ y2);
                if((x1+width/3) <= xxx && xxx<= (x2-width/3) && y1 <= yyy && y2>= yyy){
                    obj.get(i).setColor(color);
                    break;
                }
                if((y1+length/3) <= yyy && yyy<= (y2-length/3) && x1 <= xxx && x2>= xxx){
                    obj.get(i).setColor(color);
                    break;
                }

                /*
                if(obj.get(i).getX()< xxx && xxx< obj.get(i).getX2()){
                    if(obj.get(i).getY()< yyy && yyy< obj.get(i).getY2()){
                        obj.get(i).setColor(color);

                    break;
                    }
                }*/
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        x = e.getX();
        y = e.getY();
        if(paintOnCan) {
            if (shape.equals("Line")) {
                actualShape = new Line(x, y, x + 1, y + 1, color);


            } else {
                actualShape = new Plus(x, y, x + 1, y + 1, color);

            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(paintOnCan) {
            obj.add(actualShape);
            repaint();
            actualShape = null;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(actualShape !=null){
            int dx = e.getX();
            int dy = e.getY();
            if(shape.equals("Plus")) {
                int width = abs(dx-this.x);
                int length = abs(dy-this.y);
                if (width<length){
                    length = width;
                }
                if (dx > this.x && dy < this.y) {

                    actualShape.setX2(this.x+length);
                    actualShape.setY2(this.y);
                    actualShape.setX(this.x);
                    actualShape.setY(this.y-length);

                } else if (dx < this.x && dy < this.y) {
                    actualShape.setX(this.x-length);
                    actualShape.setY(this.y-length);
                    actualShape.setX2(this.x);
                    actualShape.setY2(this.y);
                } else if (dx < this.x && dy > this.y) {
                    actualShape.setX2(this.x);
                    actualShape.setY2(this.y+length);
                    actualShape.setX(this.x-length);
                    actualShape.setY(this.y);
                } else {
                    actualShape.setX2(dx);
                    actualShape.setY2(dy);
                }
            }
            else{
                actualShape.setX2(dx);
                actualShape.setY2(dy);
            }
            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        for (Shape a: obj){
            a.paintShape(g);
        }
        if(actualShape != null){
            actualShape.paintShape(g);
        }
    }
}
