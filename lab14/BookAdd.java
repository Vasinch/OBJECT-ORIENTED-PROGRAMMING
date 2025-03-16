package test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BookAdd {
    private JFrame jf;
    private JPanel jp1,jp2,jp3,jp4;
    private JTextField jtf1,jtf2;
    private JLabel jln,jlp,jlt;
    private JComboBox<String> jcb;
    private JButton jb;

    public BookAdd(ArrayList<Book> list, BookView bookView) {
        jf = new JFrame("BookAdd");
        jln = new JLabel(" name");
        jlp = new JLabel(" price");
        jlt = new JLabel(" Type");
        jcb = new JComboBox<>();
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jb = new JButton("Insert");
        jb.addActionListener(e -> addBook(list, bookView));
        jcb = new JComboBox<>();
        jcb.addItem("General");
        jcb.addItem("Computer");
        jcb.addItem("Math&Sci");
        jcb.addItem("Photo3");

        jb.addActionListener(e -> addBook(list, bookView));

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        
        jp1.setLayout(new GridLayout(1,2));
        jp1.add(jln);
        jp1.add(jtf1);
        
        jp2.setLayout(new GridLayout(1,2));
        jp2.add(jlp);
        jp2.add(jtf2);
        
        jp3.setLayout(new GridLayout(1,2));
        jp3.add(jlt);
        jp3.add(jcb);
        
        jp4.add(jb);
        
        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);
        jf.setLayout(new GridLayout(4,1));
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
    }

    private void addBook(ArrayList<Book> list, BookView bookView) {
        try {
            String name = jtf1.getText().trim();
            double price = Double.parseDouble(jtf2.getText().trim());
            String type = jcb.getSelectedItem().toString();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Please enter a book name.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            list.add(new Book(name, price, type));
            bookView.showList(list.size() - 1);
            JOptionPane.showMessageDialog(jf, "Done it.");
            jf.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jf, "Invalid price format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}