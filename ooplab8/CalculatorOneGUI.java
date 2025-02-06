import java.awt.*;
import javax.swing.*;

public class CalculatorOneGUI {
    public JFrame jf;
    public JPanel jp1,jp2;
    public JButton jb1,jb2,jb3,jb4;
    public JTextField jtf1,jtf2,jtf3;
    
    public CalculatorOneGUI(){
        jf = new JFrame("เครื่องคิดลข");
        jp1 = new JPanel();
        jp2  = new JPanel();
        jb1 = new JButton("บวก");
        jb2 = new JButton("ลบ");
        jb3 = new JButton("คูณ");
        jb4 = new JButton("หาร");
        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jtf3 = new JTextField();
        
        jf.setSize(500,200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  
        jp1.setLayout(new GridLayout(4,1));
        jp1.add(jtf1);
        jp1.add(jtf2);
        jp1.add(jp2);
        jp1.add(jtf3);
        
        jp2.setLayout(new FlowLayout());
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);

        jf.add(jp1);
        jf.setVisible(true);
    }
}