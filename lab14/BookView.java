package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class BookView implements WindowListener, Serializable {
    private ArrayList<Book> list;
    private JFrame jf;
    private JPanel jp1,jp2,jp3,jp4,jp5;
    private JLabel jln,jlp,jlt;
    private JTextField jtf1,jtf2,jtf0;
    private JComboBox jcb;
    private JButton jbl,jbr,jba,jbu,jbd;

    public BookView() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jln = new JLabel("Name");
        jlp = new JLabel("Price");
        jlt = new JLabel("Type");
        jf = new JFrame("Book View");

        // Input Fields
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf0 = new JTextField("0", 5);
        jtf0.setEditable(false);

        jcb = new JComboBox<>();
        jcb.addItem("General");
        jcb.addItem("Computer");
        jcb.addItem("Math&Sci");
        jcb.addItem("Photo3");

        jbl = new JButton("<<<");
        jbl.addActionListener(e -> showList(getIndex() - 1));
        jbr = new JButton(">>>");
        jbr.addActionListener(e -> showList(getIndex() + 1));

        jba = new JButton("Add");
        jba.addActionListener(e -> new BookAdd(list, this));
        jbu = new JButton("Update");
        jbu.addActionListener(e -> updateBook());
        jbd = new JButton("Delete");
        jbd.addActionListener(e -> deleteBook());
       
        jtf1.setEditable(false);
        jtf2.setEditable(false);

        jp1.setLayout(new GridLayout(1,2));
        jp1.add(jln);
        jp1.add(jtf1);
        
        jp2.setLayout(new GridLayout(1,2));
        jp2.add(jlp);
        jp2.add(jtf2);
        
        jp3.setLayout(new GridLayout(1,2));
        jp3.add(jlt);
        jp3.add(jcb);

        jp4.add(jbl);
        jp4.add(jtf0);
        jp4.add(jbr);
        
        jp5.add(jba);
        jp5.add(jbu);
        jp5.add(jbd);
        
        jf.setLayout(new GridLayout(5,1));
        jf.add(jp1);
        jf.add(jp2);
        jf.add(jp3);
        jf.add(jp4);
        jf.add(jp5);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.addWindowListener(this);
        jf.setVisible(true);
        loadData();
    }

    private int getIndex() {
        try {
            return Integer.parseInt(jtf0.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void showList(int index) {
        if (index >= 0 && index < list.size()) {
            Book book = list.get(index);
            jtf1.setText(book.getName());
            jtf2.setText(String.valueOf(book.getPrice()));
            jcb.setSelectedItem(book.getType());
            jtf0.setText(String.valueOf(index));
        }
    }

    private void updateBook() {
        int index = getIndex();
        if (index >= 0 && index < list.size()) {
                double price = Double.parseDouble(jtf2.getText().trim());
                list.set(index, new Book(jtf1.getText(), price, jcb.getSelectedItem().toString()));
                showList(index);
                JOptionPane.showMessageDialog(jf, "Done it.");
        }
    }

    private void deleteBook() {
        int index = getIndex();
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            showList(Math.max(0, index - 1));
            JOptionPane.showMessageDialog(jf, "Done it.");
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Book.data"))) {
            list = (ArrayList<Book>) in.readObject();
            if (!list.isEmpty()) showList(0);
        } catch (Exception e) {
            list = new ArrayList<>();
        }
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Book.data"))) {
            out.writeObject(list);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(jf, "Failed to save data!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override public void windowClosing(WindowEvent e) { saveData(); }
    @Override public void windowOpened(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}

    public static void main(String[] args) {
        new BookView();
    }
}