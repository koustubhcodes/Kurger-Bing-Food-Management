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

public class SearchOrders extends JFrame{ 

    
    private JTable table;
    JLabel l11, l12, l13, l14, l15, l16;

        public SearchOrders()
        {
            super("Search Orders");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(228,142,88));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Search Orders");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.WHITE);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/search.png"));
            Image z51 = z5.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT);
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
            
            JLabel lab1 = new JLabel("Price");
            lab1.setFont(new Font("Arial", Font.PLAIN, 20));  
            lab1.setHorizontalAlignment(JLabel.CENTER);
            lab1.setPreferredSize(new Dimension(220,50));
            p4.add(lab1);
            
            l11 = new JLabel();
            l11.setFont(font1);
            p4.add(l11);
            
            /*JLabel lab6 = new JLabel("Calories");
            lab6.setFont(new Font("Arial", Font.PLAIN, 20));  
            lab6.setHorizontalAlignment(JLabel.CENTER);
            lab6.setPreferredSize(new Dimension(220,50));
            p4.add(lab6);
            l16 = new JLabel();
            p4.add(l16);*/
            
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
            
                
                JButton btnExit = new JButton("Back");           
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(228,142,88));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
                JButton btnSearchData = new JButton("Search Data");
                JFrame frame = new JFrame("Search Orders - Kurger Bing");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(null);
                frame.setSize(720,650);
                frame.setLocation(690, 220);
                frame.setVisible(true);
		btnSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    String tempq = textField_1.getText();
                                    conn c = new conn();
                                    String displayCustomersql = "select cname, pfood, drink, sfood, tprice, odate, otime from orders where oid = '"+tempq+"'";
                                    ResultSet rs = c.s.executeQuery(displayCustomersql);
                                    if(rs.next()==false)
                                    {
                                        JOptionPane.showMessageDialog(rootPane,"Sorry Record Not Found");
                                    }else{
                                        p2.remove(btnExit);
                                        JOptionPane.showMessageDialog(rootPane,"Order Found");
                                        
                                        //l11.setText(rs.getString("ename"));
                                        l12.setText(rs.getString("cname"));
                                        l13.setText(rs.getString("pfood"));
                                        l14.setText(rs.getString("drink"));
                                        l15.setText(rs.getString("sfood"));
                                        l11.setText(rs.getString("tprice"));
                                        label5.setText(rs.getString("odate"));
                                        label6.setText(rs.getString("otime"));
                                    }
                                    JButton btnExit1 = new JButton("Back");
                                    btnExit1.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                    frame.dispose();
                                                    new SearchOrders().setVisible(true);
                                            }
                                    });
                                    btnExit1.setBounds(510, 500, 120, 30);
                                    btnExit1.setBackground(Color.BLACK);
                                    btnExit1.setForeground(Color.WHITE);
                                    p2.add(btnExit1);
                                    JButton deleteEmp = new JButton("Delete Order");
                                    deleteEmp.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e){
                                            try{
                                                String displayCustomersql = "delete from orders where oid = '"+tempq+"'"; //insert delete query here
                                                c.s.executeUpdate(displayCustomersql);
                                                JOptionPane.showMessageDialog(rootPane,"Order deleted");
                                                
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
                                    
                                    JButton editEmp = new JButton("Edit Order");
                                    editEmp.addActionListener(new ActionListener(){
                                        public void actionPerformed(ActionEvent e){
                                            try{
                                                new EditOrder(tempq).setVisible(true);
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
            frame.add(p4);

            
          
	}
        
    public static void main(String[] args){
        new SearchOrders();
    }   
}