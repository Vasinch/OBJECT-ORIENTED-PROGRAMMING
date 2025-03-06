package ooplab122;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;

public class StudentView implements ActionListener, WindowListener {

    private JFrame jf;
    private JPanel jp, jp2;
    private JLabel jl1, jl2, jl3;
    private JTextField jtf1, jtf2, jtf3;
    private JButton jb1, jb2;
    private File file;
    private Student ns;

    public StudentView() {
        ns = new Student();
        jf = new JFrame();
        jp = new JPanel();

        jl1 = new JLabel(" ID :");
        jl2 = new JLabel(" Name :");
        jl3 = new JLabel(" Money :");
        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField(String.valueOf(ns.getMoney()));

        jtf3.setEditable(false);

        jp.setLayout(new GridLayout(3, 2));

        jp.add(jl1);
        jp.add(jtf1);
        jp.add(jl2);
        jp.add(jtf2);
        jp.add(jl3);
        jp.add(jtf3);

        jf.add(jp, BorderLayout.NORTH);

        jp2 = new JPanel();
        jb1 = new JButton("Deposit");
        jb2 = new JButton("Withdraw");

        jp2.setLayout(new FlowLayout());
        jp2.add(jb1);
        jp2.add(jb2);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jf.add(jp2, BorderLayout.CENTER);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

        //File
        file = new File("StudentM.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jf.addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jb1)) {
            ns.setMoney(ns.getMoney() + 100);
            jtf3.setText(String.valueOf(ns.getMoney()));
        } else if (e.getSource().equals(jb2)) {
            if (ns.getMoney() <= 0) {
                ns.setMoney(0);
            } else if (ns.getMoney() >= 100) {
                ns.setMoney(ns.getMoney() - 100);
                jtf3.setText(String.valueOf(ns.getMoney()));
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try ( FileInputStream fi = new FileInputStream(file);  ObjectInputStream oip = new ObjectInputStream(fi);) {
            ns = (Student) oip.readObject();
            if (ns == null) {
                ns = new Student();
                ns.setID(-1);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        if (ns.getID() == -1) {
            jtf1.setText("");
        } else {
            jtf1.setText(String.valueOf(ns.getID()));
        }
        jtf2.setText(ns.getName());
        jtf3.setText(String.valueOf(ns.getMoney()));
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (jtf1.getText().equals("")) {
            ns.setID(-1);
        } else {
            ns.setID(Integer.parseInt(jtf1.getText()));
        }
        ns.setName(jtf2.getText());
        ns.setMoney(Integer.parseInt(jtf3.getText()));
        try ( FileOutputStream fo = new FileOutputStream(file);  ObjectOutputStream oout = new ObjectOutputStream(fo);) {
            oout.writeObject(ns);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }
}
