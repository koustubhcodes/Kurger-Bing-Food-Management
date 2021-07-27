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

public class SearchOrdersK extends JFrame{ 

    
    private JTable table;
    JLabel l11, l12, l13, l14, l15, l16;

        public SearchOrdersK()
        {
            super("Search Orders");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(238,64,23));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Search Orders");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.WHITE);
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
           
            JLabel SearchE = new JLabel("Search Order No");
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
            p4.setLayout(new GridLayout(7,2));
            p4.setForeground(Color.BLUE);
            p4.setBackground(Color.WHITE);
            
                        
            JLabel lab2 = new JLabel("Customer Name");
            lab2.setFont(new Font("Arial", Font.PLAIN, 20));  
            lab2.setHorizontalAlignment(JLabel.CENTER);
            lab2.setPreferredSize(new Dimension(220,50));
            p4.add(lab2);
            l12 = new JLabel();   
            l12.setFont(font1);
            p4.add(l12);
            
            JLabel lab3 = new JLabel("Primary Food");
            lab3.setFont(new Font("Arial", Font.PLAIN, 20));  
            lab3.setHorizontalAlignment(JLabel.CENTER);
            lab3.setPreferredSize(new Dimension(220,50));
            p4.add(lab3);
            l13 = new JLabel();
            l13.setFont(font1);
            p4.add(l13);
            
            JLabel lab4 = new JLabel("Drink");
            lab4.setFont(new Font("Arial", Font.PLAIN, 20));  
            lab4.setHorizontalAlignment(JLabel.CENTER);
            lab4.setPreferredSize(new Dimension(220,50));
            p4.add(lab4);
            l14 = new JLabel();
            l14.setFont(font1);
            p4.add(l14);
            
            JLabel lab5 = new JLabel("Secondary Food");
            lab5.setFont(new Font("Arial", Font.PLAIN, 20));  
            lab5.setHorizontalAlignment(JLabel.CENTER);
            lab5.setPreferredSize(new Dimension(220,50));
            p4.add(lab5);
            
            l15 = new JLabel();
            l15.setFont(font1);
            p4.add(l15);
            
            
            
            JLabel date = new JLabel("Date");
            date.setFont(new Font("Arial", Font.PLAIN, 20));  
            date.setHorizontalAlignment(JLabel.CENTER);
            date.setPreferredSize(new Dimension(220,50));
            p4.add(date);	
            JLabel label5 = new JLabel(); 
            label5.setPreferredSize(new Dimension(220,50));
            label5.setFont(font1);
            p4.add(label5);
            
            JLabel timeO = new JLabel("Time");
            timeO.setFont(new Font("Arial", Font.PLAIN, 20));  
            timeO.setHorizontalAlignment(JLabel.CENTER);
            timeO.setPreferredSize(new Dimension(220,50));
            p4.add(timeO);	
            JLabel label6 = new JLabel(); 
            label6.setPreferredSize(new Dimension(220,50));
            label6.setFont(font1);
            p4.add(label6);
            
            JLabel ostatus = new JLabel("Status");
            ostatus.setFont(new Font("Arial", Font.PLAIN, 20));  
            ostatus.setHorizontalAlignment(JLabel.CENTER);
            ostatus.setPreferredSize(new Dimension(220,50));
            p4.add(ostatus);	
            JLabel label7 = new JLabel(); 
            label7.setPreferredSize(new Dimension(220,50));
            label7.setFont(font1);
            p4.add(label7);
                           
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(238,64,23));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
                JButton btnSearchData = new JButton("Search Data");
		btnSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    String tempq = textField_1.getText();
                                    conn c = new conn();
                                    String displayCustomersql = "select cname, pfood, drink, sfood, odate, otime, status from orders where oid = '"+tempq+"'";
                                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                                    if(rs.next()==false)
                                    {
                                        JOptionPane.showMessageDialog(rootPane,"Sorry Record Not Found");
                                    }else{
                                        //l11.setText(rs.getString("ename"));
                                        l12.setText(rs.getString("cname"));
                                        l13.setText(rs.getString("pfood"));
                                        l14.setText(rs.getString("drink"));
                                        l15.setText(rs.getString("sfood"));
                                        //l11.setText(rs.getString("tprice"));
                                        label5.setText(rs.getString("odate"));
                                        label6.setText(rs.getString("otime"));
                                        //label7.setText(rs.getString("status"));
                                        if(rs.getString("status").equals("1"))
                                        {
                                           label7.setText("New Order"); 
                                           
                                        }else if(rs.getString("status").equals("2")){
                                            label7.setText("Served"); 
                                        }
                                        else if(rs.getString("status").equals("3")){
                                            label7.setText("Preparing"); 
                                        }
                                        else if(rs.getString("status").equals("4")){
                                            label7.setText("Cancelled"); 
                                        }
                                    }
                                                                        
                                    JButton editEmp = new JButton("Update Order Status");
                                    editEmp.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e){
                                            try{
                                                new UpdateOrders(tempq).setVisible(true);
                                                setVisible(false);
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
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bill().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		p2.add(btnExit);
		
            
	
            	
            

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(720,650);
            frame.setLocation(690, 220);
            frame.setVisible(true);	

            p1.add(l1);
            
            frame.add(p1);
            frame.add(p2);
            frame.add(p3);
            frame.add(p4);

            
          
	}
        
    public static void main(String[] args){
        new SearchOrdersK();
    }   
}