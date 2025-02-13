import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalculatorTwoGUI {
    public JFrame jf;
    public JPanel jp;
    public JTextField jt;
    public JButton b1;
    public JButton b2;
    public JButton b3;
    public JButton b4;
    public JButton b5;
    public JButton b6;
    public JButton b7;
    public JButton b8;
    public JButton b9;
    public JButton b10;
    public JButton b11;
    public JButton b12;
    public JButton b13;
    public JButton b14;
    public JButton b15;
    public JButton b16;
    
    private String operator;
    private double num1, num2, result;
    
    public CalculatorTwoGUI(){
        jf = new JFrame("My Calculator");
        jp = new JPanel();
        jt = new JTextField();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("0");
        b11 = new JButton("+");
        b12 = new JButton("-");
        b13 = new JButton("x");
        b14 = new JButton("/");
        b15 = new JButton("c");
        b16 = new JButton("=");
        
        jf.add(jt,BorderLayout.NORTH);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);
        jp.setLayout(new GridLayout(4,4));
        
        jp.add(b7);
        jp.add(b8);
        jp.add(b9);
        jp.add(b11);
        
        jp.add(b4);
        jp.add(b5);
        jp.add(b6);
        jp.add(b12);
        
        jp.add(b1);
        jp.add(b2);
        jp.add(b3);
        jp.add(b13);
        
        jp.add(b10);
        jp.add(b15);
        jp.add(b16);
        jp.add(b14);
        
        jf.add(jp);
        jf.setVisible(true);
        
        b1.addActionListener(e -> jt.setText(jt.getText() + "1"));
        b2.addActionListener(e -> jt.setText(jt.getText() + "2"));
        b3.addActionListener(e -> jt.setText(jt.getText() + "3"));
        b4.addActionListener(e -> jt.setText(jt.getText() + "4"));
        b5.addActionListener(e -> jt.setText(jt.getText() + "5"));
        b6.addActionListener(e -> jt.setText(jt.getText() + "6"));
        b7.addActionListener(e -> jt.setText(jt.getText() + "7"));
        b8.addActionListener(e -> jt.setText(jt.getText() + "8"));
        b9.addActionListener(e -> jt.setText(jt.getText() + "9"));
        b10.addActionListener(e -> jt.setText(jt.getText() + "0"));

        b11.addActionListener(e -> setOperator("+"));
        b12.addActionListener(e -> setOperator("-"));
        b13.addActionListener(e -> setOperator("x"));
        b14.addActionListener(e -> setOperator("/"));
        
        b15.addActionListener(e -> jt.setText(""));
        b16.addActionListener(e -> calculateResult());
    }
    
    private void setOperator(String op) {
        operator = op;
        num1 = Double.parseDouble(jt.getText());
        jt.setText("");
    }
    
    private void calculateResult() {
        num2 = Double.parseDouble(jt.getText());
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "x":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        jt.setText(String.valueOf(result));
    }
    
    public static void main(String[] args) {
        new CalculatorTwoGUI();
    }
}
