/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooplab13;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author vasin
 */
public class MyTimer2 extends JLabel implements Runnable {

    private int hours = 0, minutes = 0, seconds = 0;
    private boolean running = true;

    public MyTimer2() {
        setFont(new Font("Arial", Font.BOLD, 30));
        setHorizontalAlignment(SwingConstants.CENTER);
        updateTimeLabel();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000); // Wait for 1 second
                incrementTime();
                updateTimeLabel();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Increase time by 1 second
    private void incrementTime() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
    }

    // Format and update label text
    private void updateTimeLabel() {
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        setText(time);
    }

    // Stop the timer
    public void stopTimer() {
        running = false;
    }
}
