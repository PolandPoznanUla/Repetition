package com.sda.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by RENT on 2017-07-01.
 */
public class Application {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hello world");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(3, 2);
        JPanel jPanel = new JPanel(layout);


        JTextField jTextField = new JTextField("Witam");
        JButton jButton = new JButton("Click it");
        jButton.addActionListener(e -> {
            String text = jTextField.getText();
            jButton.setText(text);
            jTextField.setText(" ");
            jFrame.repaint();
        });

        JTextField jTextField2 = new JTextField("Witam");
        JButton jButton2 = new JButton("Click it");
        jButton.addActionListener(e -> {
            String text = jTextField2.getText();
            jButton2.setText(text);
            jTextField2.setText(" ");
            jFrame.repaint();
        });

        JTextField jTextField3 = new JTextField("Witam");
        JButton jButton3 = new JButton("Click it");
        jButton.addActionListener(e -> {
            String text = jTextField3.getText();
            jButton3.setText(text);
            jTextField3.setText(" ");
            jFrame.repaint();
        });

        jPanel.add(jTextField);
        jPanel.add(jButton);
        jPanel.add(jTextField2);
        jPanel.add(jButton2);
        jPanel.add(jTextField3);
        jPanel.add(jButton3);

//        jFrame.getContentPane().add(jTextField
//);
        jFrame.getContentPane().add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
//        Thread.sleep(2000);
//        jTextField
//.setText("safgsafg");

    }
}
