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
    Color color;
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
        choice.addItemListener(this);

        var buttonPanel = new JPanel();
        buttonPanel.setLayout( new GridLayout(1,4));
        lineButton.setName("1");
        buttonPanel.add(lineButton);
        buttonPanel.add(plusButton);
        buttonPanel.add(label);
        buttonPanel.add(choice);
        lineButton.addActionListener(this);
        plusButton.addActionListener(this);

        panel.add(buttonPanel,BorderLayout.NORTH);

        this.add(panel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550, 550);
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var action = e.getActionCommand();
        System.out.println(action);
        if (action == " Plus"){
            // plus v canvase
        }
        else{
            // line v canvase
        }


    }

    @SneakyThrows
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getItem());
        Field field = Class.forName("java.awt.Color").getField((String) e.getItem());
        color = (Color)field.get(null);
        System.out.println(color);
        label.setForeground(color);
        label.setText((String) e.getItem());

    }
}
