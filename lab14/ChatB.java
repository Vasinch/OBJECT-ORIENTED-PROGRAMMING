/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author vasin
 */
public class ChatB implements ActionListener {
    private JFrame jf;
    private JPanel jp1,jp2;
    private JTextArea jtab;
    private JTextField jtfb;
    private JButton jb;
    private ChatA CA;
    private List<String> chatHistory;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
    
    public ChatB(ChatA A,List<String> chatHistory){
        this.chatHistory = chatHistory;
        CA = A;
        jf = new JFrame("ChatB");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jtab = new JTextArea(10,40);
        jtfb = new JTextField(35);
        jb = new JButton("send");
        jb.addActionListener(this);
        jtab.setEditable(false);
        
        JScrollPane scrollpane = new JScrollPane(jtab);
        jp1.add(scrollpane);
        
        jp2.add(jtfb);
        jp2.add(jb);
        
        jf.add(jp1,BorderLayout.CENTER);
        jf.add(jp2,BorderLayout.SOUTH);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
//        updateChat();
        
    }
    public JTextArea getjtab(){
        return jtab;
    }
    
    public void setjtfb(JTextArea jtf){
        this.jtab = jtf;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jb)) {
            chatHistory.add("["+LocalDateTime.now().format(formatter) +"]"+"B: " + jtfb.getText()); // Add message to shared history
            updateChat(); // Refresh chat history
            CA.updateChat(); // Notify ChatA to refresh
            jtfb.setText("");
        }
    }
    
    public void updateChat() {
        jtab.setText(String.join("\n", chatHistory));
        }
    }
