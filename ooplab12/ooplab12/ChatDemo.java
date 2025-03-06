package ooplab12;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class ChatDemo implements ActionListener, WindowListener {

    private JFrame jf;
    private JTextArea jta;
    private JTextField jtf;
    private JButton jb1, jb2;
    private JPanel jp;
    private File file;

    public ChatDemo() {
        jf = new JFrame();
        jta = new JTextArea(20, 45);
        jtf = new JTextField(45);
        jb1 = new JButton("Submit");
        jb2 = new JButton("Reset");

        jtf.setLayout(new BorderLayout());
        jta.setEditable(false);
        jf.add(jta, BorderLayout.NORTH);
        jf.add(jtf, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(jb1);
        panel.add(jb2);
        jf.add(panel, BorderLayout.SOUTH);
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        //File
        file = new File("ChatDemo.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jf.addWindowListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sc = e.getSource();
        if (sc.equals(jb1)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss : ");
            jta.setText(jta.getText() + "\n" + dtf.format(LocalDateTime.now()) + jtf.getText());
        } else if (sc.equals(jb2)) {
            jta.setText("");
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        String txt = "";
        try ( FileReader fr = new FileReader(file)) {
//            char[] txt = new char[(int) file.length()];
//            fr.read(txt);
//            ta.setText(new String(txt));
            int tmp;
            while ((tmp = fr.read()) != -1) {
                txt += (char) tmp;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        jta.setText(txt);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try ( FileWriter fw = new FileWriter(file)) {
            fw.write(jta.getText());
        } catch (IOException exx) {
            exx.printStackTrace();
        }

    }
    @Override
    public void windowClosed(WindowEvent e){
    }
    
    @Override
    public void windowIconified(WindowEvent e){
    }
    
    @Override
    public void windowDeiconified(WindowEvent e){
    }
    
    @Override
    public void windowActivated(WindowEvent e){
    }
    
    @Override
    public void windowDeactivated(WindowEvent e){
    }
}