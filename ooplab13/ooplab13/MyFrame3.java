/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooplab13;

import javax.swing.*;

/**
 *
 * @author vasin
 */
public class MyFrame3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer Program (Pause/Resume)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Create and add timer
        MyTimer3 timerLabel = new MyTimer3();
        frame.add(timerLabel);

        // Start the timer thread
        Thread timerThread = new Thread(timerLabel);
        timerThread.start();

        frame.setVisible(true);
    }
}
