/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooplab13;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author vasin
 */
public class MyFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Time");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        
        JPanel panel = new JPanel();
        panel.add(clock, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}