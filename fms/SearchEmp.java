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

public class SearchEmp extends JFrame{ 

    
    private JTable table;
    JLabel l11, l12, l13, l14, l15;
    String a1,a2,a3,a4,a5;

        public SearchEmp()
        {
            super("Search Employee");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(245,205,220));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Search Employee");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.BLACK);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/viewemp.png"));
            Image z51 = z5.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
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
            p3.setBounds(0, 50, 720, 50);
            p3.setLayout(new FlowLayout());
            p3.setForeground(Color.BLUE);
            p3.setBackground(Color.WHITE);
           
            JLabel SearchE = new JLabel("Search Employee No");
            SearchE.setFont(new Font("Arial", Font.PLAIN, 20));  
            SearchE.setHorizontalAlignment(JLabel.CENTER);
            SearchE.setPreferredSize(new Dimension(240,30));
            p3.add(SearchE);
            JTextField textField_1 = new JTextField(); 
            textField_1.setPreferredSize(new Dimension(170,30));
            textField_1.setFont(font1);
            p3.add(textField_1);
            
            JPanel p4 = new JPanel();
            p4.setBackground(Color.LIGHT_GRAY);
            p4.setBounds(25, 100, 650, 470);
            p4.setLayout(new GridLayout(6,2));
            p4.setForeground(Color.BLUE);
            p4.setBackground(Color.WHITE);
            
            JLabel lab1 = new JLabel("Name");
            p4.add(lab1);
            l11 = new JLabel();
            p4.add(l11);
            
            JLabel lab2 = new JLabel("Age");
            p4.add(lab2);
            l12 = new JLabel();            
            p4.add(l12);
            
            JLabel lab3 = new JLabel("Gender");
            p4.add(lab3);
            l13 = new JLabel();
            p4.add(l13);
            
            JLabel lab4 = new JLabel("Job");
            p4.add(lab4);
            l14 = new JLabel();
            p4.add(l14);
            
            JLabel lab5 = new JLabel("Phone");
            p4.add(lab5);
            l15 = new JLabel();
            p4.add(l15);
                
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(245,205,220));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
                JButton btnSearchData = new JButton("Search Data");
		btnSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    String tempq = textField_1.getText();
                                    conn c = new conn();
                                    String displayCustomersql = "select ename,age,gender,job,phone from emp where eid = '"+tempq+"'";
                                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                                    if(rs.next()==false)
                                    {
                                        JOptionPane.showMessageDialog(rootPane,"Sorry Record Not Found");
                                    }else{
                                        l11.setText(rs.getString("ename"));
                                        l12.setText(rs.getString("age"));
                                        l13.setText(rs.getString("gender"));
                                        l14.setText(rs.getString("job"));
                                        l15.setText(rs.getString("phone"));
                                    }
                                    JButton deleteEmp = new JButton("Delete Employee");
                                    deleteEmp.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e){
                                            try{
                                                String displayCustomersql = "delete from emp where eid = '"+tempq+"'"; //insert delete query here
                                                c.s.executeUpdate(displayCustomersql);
                                                JOptionPane.showMessageDialog(rootPane,"Employee deleted");
                                                
                                            }
                                            catch(Exception e1){
                                                e1.printStackTrace();
                                            }
                                        }
                                    });
                                    deleteEmp.setBounds(350, 500, 120, 30);
                                    deleteEmp.setBackground(Color.BLACK);
                                    deleteEmp.setForeground(Color.WHITE);
                                    p2.add(deleteEmp);
                                    
                                    JButton editEmp = new JButton("Edit Employee");
                                    editEmp.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e){
                                            try{
                                                new UpdateEmp(tempq).setVisible(true);
                                            }
                                            catch(Exception e1){
                                                e1.printStackTrace();
                                            }
                                        }
                                    });
                                    editEmp.setBounds(350, 500, 120, 30);
                                    editEmp.setBackground(Color.BLACK);
                                    editEmp.setForeground(Color.WHITE);
                                    p2.add(editEmp);
                                }
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
			
		});
		btnSearchData.setBounds(350, 500, 120, 30);
                btnSearchData.setBackground(Color.BLACK);
                btnSearchData.setForeground(Color.WHITE);                
		p2.add(btnSearchData);
		
                
		JButton btnExit = new JButton("Back");
                JFrame frame = new JFrame("Search Employee - Kurger Bing");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(null);
                frame.setSize(720,650);
                frame.setLocation(690, 220);
                frame.setVisible(true);	
		btnExit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
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
            frame.add(p4);

            
          
	}
        
    public static void main(String[] args){
        new SearchEmp();
    }   
}