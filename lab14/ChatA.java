/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vasin
 */
public class ChatA implements ActionListener{
    private JFrame jf;
    private JPanel jp1,jp2;
    private JTextArea jta;
    private JTextField jtf;
    private JButton jb;
    private ChatB CB;
    private List<String> chatHistory;

    public ChatA(List<String> chatHistory){
        this.chatHistory = chatHistory;
        jf = new JFrame("ChatA");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jta = new JTextArea(10,40);
        jtf = new JTextField(35);
        jb = new JButton("send");
        jb.addActionListener(this);
        jta.setEditable(false);
        
        JScrollPane scrollpane = new JScrollPane(jta);
        jp1.add(scrollpane);
        
        jp2.add(jtf);
        jp2.add(jb);
        
        jf.add(jp1,BorderLayout.CENTER);
        jf.add(jp2,BorderLayout.SOUTH);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
        updateChat();
        
    }
    
    public void setChatB(ChatB chatB) {
        this.CB = chatB;
    }
        
    public static void main(String[] args) {
        List<String> chatHistory = new ArrayList<>(); // Shared chat history

        ChatA chatA = new ChatA(chatHistory); // Create ChatA
        ChatB chatB = new ChatB(chatA, chatHistory); // Create ChatB with shared history
        chatA.setChatB(chatB); 
    }
    
    public JTextArea getjta(){
        return jta;
    }
    public void setjtfb(JTextArea jtfB){
        this.jta = jtfB;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jb)) {
            chatHistory.add("A: " + jtf.getText()); // Add message to shared history
            updateChat(); // Refresh chat history
            CB.updateChat(); // Notify ChatB to refresh
            jtf.setText("");
        }
    }
    public void updateChat() {
        jta.setText(""); // Clear and reload chat
        for (String message : chatHistory) {
            jta.append(message + "\n");
        }
    }
}
