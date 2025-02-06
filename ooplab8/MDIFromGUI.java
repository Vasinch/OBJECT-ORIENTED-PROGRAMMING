import java.awt.*;
import javax.swing.*;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class MDIFromGUI {
    private JFrame jf;
    private JDesktopPane dp;
    private JInternalFrame f1;
    private JInternalFrame f2;
    private JInternalFrame f3;
    private JMenuBar mb;
    private JMenu m1;
    private JMenu m2;
    private JMenu m3;
    private JMenu mn;
    private JMenuItem mo;
    private JMenuItem ms;
    private JMenuItem me;
    private JMenuItem mw;
    private JMenuItem mm;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    
    public MDIFromGUI() {
        jf = new JFrame("SubMenuItem Demo");
        dp = new JDesktopPane();
        f1 = new JInternalFrame("Application 01", true, true, true, true);
        f2 = new JInternalFrame("Application 02", true, true, true, true);
        f3 = new JInternalFrame("Application 03", true, true, true, true);
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");        
        mn = new JMenu("New");
        mo = new JMenuItem("Open");
        ms = new JMenuItem("Save");
        me = new JMenuItem("Exit");
        mw = new JMenuItem("Window");
        mm = new JMenuItem("Message");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setJMenuBar(mb);
        
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        
        m1.add(mn);
        m1.addSeparator();
        m1.add(mo);
        m1.addSeparator();
        m1.add(ms);
        m1.addSeparator();
        m1.add(me);
        m1.addSeparator();
        
        mn.add(mw);
        mn.addSeparator();
        mn.add(mm);

        f1.add(l1);
        f1.setSize(300, 300);
        f1.setLocation(200, 400);
        f1.setVisible(true);

        f2.add(l2);
        f2.setSize(300, 300);
        f2.setLocation(600, 200);
        f2.setVisible(true);

        f3.add(l3);
        f3.setSize(300, 300);
        f3.setLocation(1200, 400);
        f3.setVisible(true);

        dp.add(f1);
        dp.add(f2);
        dp.add(f3);

        dp.setBackground(Color.black);
        jf.add(dp, BorderLayout.CENTER);
        jf.setExtendedState(MAXIMIZED_BOTH);
        jf.setVisible(true);
    }
}