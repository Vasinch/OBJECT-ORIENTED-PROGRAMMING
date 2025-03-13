/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ooplab13;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 * @author vasin
 */
public class Poring implements MouseListener {

    private JFrame fr;
    private JLabel lb, lbCount;

    public Poring(int count) {
        fr = new JFrame();
        lbCount = new JLabel(String.valueOf(count));
        fr.setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon("src/resource/raknarok.png");
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        lb = new JLabel(icon);
        fr.add(lb);
        fr.add(lbCount);

        lb.addMouseListener(this);

        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation((int) (Math.random() * (dimension.getWidth() - fr.getWidth())), (int) (Math.random() * (dimension.getHeight() - fr.getHeight())));
        fr.pack();
        fr.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        fr.dispose();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}