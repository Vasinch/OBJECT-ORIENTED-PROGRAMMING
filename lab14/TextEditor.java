/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab14;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author vasin
 */
public class TextEditor implements ActionListener {
    private JFrame jf;
    private JMenuBar jmb;
    private JMenu jm;
    private JMenuItem jmi1,jmi2,jmi3,jmi4;
    private JTextArea jta;
    
    public TextEditor(){
        jf = new JFrame("My Text Editor");
        jmb = new JMenuBar();
        jm = new JMenu("File");
        jmi1 = new JMenuItem("New");
        jmi2 = new JMenuItem("Open");
        jmi3 = new JMenuItem("Save");
        jmi4 = new JMenuItem("Close");
        jta = new JTextArea();
        
        jmi1.addActionListener(this);
        jmi2.addActionListener(this);
        jmi3.addActionListener(this);
        jmi4.addActionListener(this);
        
        jmb.add(jm);
        jm.add(jmi1);
        jm.add(jmi2);
        jm.add(jmi3);
        jm.addSeparator();
        jm.add(jmi4);
        
        jf.setJMenuBar(jmb);
        jf.add(jta);
        jf.setSize(400,300);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(3);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmi1) {
            jta.setText("");
        } else if (e.getSource() == jmi2) {
            openFile();
        } else if (e.getSource() == jmi3) {
            saveFile();
        } else if (e.getSource() == jmi4) {
            System.exit(0);
        }
    }
    
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(jf) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                jta.read(reader, null);
            } catch (IOException ex) {
                showMessage("Error opening file.");
            }
        }
    }

    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(jf) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                jta.write(writer);
            } catch (IOException ex) {
                showMessage("Error saving file.");
            }
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(jf, message);
    }

      
    public static void main(String[] args) {
        new TextEditor();
    }
}
