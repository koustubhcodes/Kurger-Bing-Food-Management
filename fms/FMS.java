package fms;

import javax.swing.*;

public class FMS extends JFrame{
    
    FMS(){
        setBounds(300,300,1365,565);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/dot.png"));
        JLabel l1 = new JLabel(i1);
        
        l1.setBounds(0,0,1366,565);
        add(l1);
        
        
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new FMS().setVisible(true);
    }
    
}
