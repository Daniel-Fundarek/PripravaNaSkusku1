package sk.stuba.fei.uim.oop;

import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;

public class MyFrame extends JFrame implements ActionListener, ItemListener {
    private Color color;
    private String shape = "";
    JLabel label = new JLabel();
    MyCanvas canvas = new MyCanvas();
    JPanel panel = new JPanel();
    public MyFrame(String title) throws HeadlessException {
        super(title);

        panel.setLayout(new BorderLayout());
        panel.add(canvas,BorderLayout.CENTER);

        JButton plusButton = new JButton("Plus");
        JButton lineButton = new JButton("Line");

        Choice choice = new Choice();

        choice.add("RED");
        choice.add("BLUE");
        choice.add("YELLOW");
        choice.add("GREEN");
        choice.add("BLACK");
        choice.add("PINK");
        choice.addItemListener(this);

        var buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout(1,4));
        buttonPanel.add(lineButton);
        buttonPanel.add(plusButton);
        buttonPanel.add(label);
        label.setForeground(Color.RED);
        label.setText("RED");
        buttonPanel.add(choice);
        lineButton.addActionListener(this);
        plusButton.addActionListener(this);

        panel.add(buttonPanel,BorderLayout.NORTH);

        this.add(panel);

        JButton stateButton = new JButton("Paint/click");
        stateButton.addActionListener(this);
        this.add(stateButton,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 550);
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Paint/click")){
            canvas.setPaintOnCan(!canvas.getPaintOnCan());
            System.out.println(canvas.getPaintOnCan());
        }
        else {
            shape = e.getActionCommand();
            System.out.println(shape);
            canvas.setShape(shape);
        }
    }

    @SneakyThrows
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getItem());
        Field field = Class.forName("java.awt.Color").getField((String) e.getItem());
        color = (Color)field.get(null);
        canvas.setColor(color);
        System.out.println(color);
        label.setForeground(color);
        label.setText((String) e.getItem());

    }
}
