package fms;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTable;
import java.sql.*;	
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FoodMenu extends JFrame{ 

    
    private JTable table;
    private JLabel lblNewLabel;
    private JLabel lblJob;
    private JLabel lblName;
    private JLabel lblDepartment;
    private JLabel lblfid;

        public FoodMenu()
        {
            super("Viewing FoodMenu");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(245,205,220));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" View Food Menu");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.BLACK);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/food2.png"));
            Image z51 = z5.getImage().getScaledInstance(50, 45,Image.SCALE_DEFAULT);
            ImageIcon z511 = new ImageIcon(z51);
            JLabel lb1 = new JLabel();
            lb1.setIcon(z511);
            lb1.setBounds(5,0,50,50);
            p1.add(lb1);
            //l1.setIcon(jbii1);            
            l1.setBounds(60,0,720,50);
            Font font1 = new Font("SansSerif", Font.PLAIN, 20);
            
            
            JPanel p3 = new JPanel();
            p3.setBackground(Color.LIGHT_GRAY);
            p3.setBounds(0, 50, 720, 520);
            p3.setLayout(new BorderLayout());
            p3.setForeground(Color.BLUE);
            p3.setBackground(Color.WHITE);
           
                table = new JTable();    
                p3.add(table);
                String x[] = {"Food ID","Food Item","Food Type","Price","Calories"};
                String y[][] = new String[30][8];
                int i=0, j=0;
                try{
                    conn c = new conn();
                    String s1 = "select * from food order by ftype";
                    ResultSet rs = c.s.executeQuery(s1);
                    while(rs.next()){
                        y[i][j++] = rs.getString("fid");
                        y[i][j++] = rs.getString("fname");
                        String qw = new String(rs.getString("ftype"));
                        int qw1 = Integer.parseInt(qw);
                        //boolean bool = (qw1 == 1);
                        if(qw1 == 1)
                        {
                           y[i][j++] = "Primary Food"; 
                        }else if(qw1 == 2){
                            y[i][j++] = "Drink"; 
                        }else{
                            y[i][j++] = "Secondary Food"; 
                        }
                        y[i][j++] = rs.getString("price");
                        y[i][j++] = rs.getString("cal");
                        i++;
                        j=0;
                    }
                    table = new JTable(y,x);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                JScrollPane sp = new JScrollPane(table);
                p3.add(sp);
            
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(245,205,220));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
		
		JFrame frame = new JFrame("Food Menu - Kurger Bing");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(null);
                frame.setSize(720,650);
                frame.setLocation(690, 220);
                frame.setVisible(true);	
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		p2.add(btnExit);
		
            
	
            	
            

            

            p1.add(l1);
            
            frame.add(p1);
            frame.add(p2);
            frame.add(p3);

            
          
	}
        
    public static void main(String[] args){
        new FoodMenu();
    }   
}
