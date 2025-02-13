import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TellerGUI {
    private JFrame jf;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private TextField tf1;
    private TextField tf2;
    private JLabel l1;
    private JLabel l2;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private int balance;
    
    public TellerGUI() {
        jf = new JFrame("Teller GUI");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        balance = 6000;
        tf1 = new TextField(String.valueOf(balance));
        tf1.setEditable(false);
        tf2 = new TextField();
        l1 = new JLabel("Balance");
        l2 = new JLabel("Amount");
        b1 = new JButton("Deposit");
        b2 = new JButton("Withdraw");
        b3 = new JButton("Exit");

        jf.setLayout(new GridLayout(4, 0));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(300,200);
        
        p1.setLayout(new GridLayout(1, 1));
        p1.add(l1);
        p1.add(tf1);
        
        p2.setLayout(new GridLayout(1, 1));
        p2.add(l2);
        p2.add(tf2);
        
        p3.setLayout(new FlowLayout());
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);
        
        jf.add(p1);
        jf.add(p2);
        jf.add(p3);
        jf.add(p4);
        jf.setVisible(true);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });
        
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });
    }
    private void deposit() {
            double amount = Double.parseDouble(tf2.getText());
                balance += amount;
                tf1.setText(String.valueOf(balance));
                tf2.setText("");
    }
    
    private void withdraw() {
            double amount = Double.parseDouble(tf2.getText());
            if (amount <= balance) {
                balance -= amount;
                tf1.setText(String.valueOf(balance));
                tf2.setText("");
            } else {
                JOptionPane.showMessageDialog(jf, "เงินไม่พอไอควาย!");
            }
    }
    
    public static void main(String[] args) {
        new TellerGUI();
    }
} 