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
import java.text.SimpleDateFormat;

public class UpdateOrders extends JFrame{ 

    
    private JTable table;
    JTextField textField, textField_4;
    JLabel eno, l12, l13, l14, l15, l16, label5, label6;
    JComboBox c1, c2, c3, c4;
    int totalprice;

        public UpdateOrders(String tempq)
        {
            super("Edit Order");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(238,64,23));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Update Order Status");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.PINK);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/kitchen.png"));
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
            p3.setBounds(0, 50, 720, 50);
            p3.setLayout(null);
            p3.setForeground(Color.BLUE);
            p3.setBackground(Color.WHITE);
           
            JLabel SearchE = new JLabel("Updating Order No");
            SearchE.setFont(new Font("Arial", Font.BOLD, 20));  
            SearchE.setHorizontalAlignment(JLabel.CENTER);
            SearchE.setPreferredSize(new Dimension(240,30));
            SearchE.setBounds(5,5,240,30);
            p3.add(SearchE);
            JLabel eno = new JLabel(); 
            eno.setPreferredSize(new Dimension(170,30));
            eno.setFont(new Font("Arial", Font.BOLD, 20)); 
            eno.setForeground(Color.BLUE);
            eno.setBounds(250,5,240,30);
            eno.setText(tempq);
            p3.add(eno);
            
            JPanel p4 = new JPanel();
            p4.setBackground(Color.LIGHT_GRAY);
            p4.setBounds(25, 100, 650, 470);
            p4.setLayout(new GridLayout(8,2,25,25));
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
            label5 = new JLabel(); 
            label5.setPreferredSize(new Dimension(220,50));
            label5.setFont(font1);
            p4.add(label5);
            
            JLabel timeO = new JLabel("Time");
            timeO.setFont(new Font("Arial", Font.PLAIN, 20));  
            timeO.setHorizontalAlignment(JLabel.CENTER);
            timeO.setPreferredSize(new Dimension(220,50));
            p4.add(timeO);	
            label6 = new JLabel(); 
            label6.setPreferredSize(new Dimension(220,50));
            label6.setFont(font1);
            p4.add(label6);
                      
            JLabel ostatus = new JLabel("Status");
            ostatus.setFont(new Font("Arial", Font.PLAIN, 20));  
            ostatus.setHorizontalAlignment(JLabel.CENTER);
            ostatus.setPreferredSize(new Dimension(220,50));
            p4.add(ostatus);	
            String course3[] = {"New Order","Served","Preparing","Cancelled"};
            c4 = new JComboBox(course3);
            c4.setFont(new Font("Arial", Font.PLAIN, 20));
            c4.setBackground(Color.WHITE); 
            c4.setPreferredSize(new Dimension(220,50));
            p4.add(c4);
            
            fillData(tempq);
            
             
                
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(238,64,23));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
                JButton UpdateData = new JButton("Update Data");
		UpdateData.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                        
                        String temp1 = (String)c4.getSelectedItem();
                        String status = "1";
                        if(temp1.equals("New Order"))
                        {
                            status = "1";
                            
                        }else if(temp1.equals("Served"))
                        {
                            status = "2";
                            
                        }else if(temp1.equals("Preparing"))
                        {
                            status = "3";
                            
                        }else if(temp1.equals("Cancelled"))
                        {
                            status = "4";
                        }


                        String oid = tempq;
                        try {
                            conn c = new conn();
                            String str = "update orders set status = '"+status+"' where oid = '"+oid+"'";
                            System.out.println(str);
                            c.s.executeUpdate(str);
                            JOptionPane.showMessageDialog(null,"Order Updated");
                            setVisible(false);

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"Order Could Not Be Updated");
                            e.printStackTrace();
                        }
                    }
                });
		UpdateData.setBounds(350, 500, 120, 30);
                UpdateData.setBackground(Color.PINK);
                UpdateData.setForeground(Color.BLACK);                
		p2.add(UpdateData);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchEmp().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(510, 500, 120, 30);
                btnExit.setBackground(Color.PINK);
                btnExit.setForeground(Color.BLACK);
		p2.add(btnExit);
		
            
	
            	
            

            JFrame frame = new JFrame("Updating Order Status");
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
        public void fillData(String a){
                try{
                    conn c = new conn();
                    String str1 = "select cname, pfood, drink, sfood, odate, otime, status from orders where oid = '"+a+"'";
                    ResultSet rs = c.s.executeQuery(str1);
                    while(rs.next()){
                                        l12.setText(rs.getString("cname"));
                                        l13.setText(rs.getString("pfood"));
                                        l14.setText(rs.getString("drink"));
                                        l15.setText(rs.getString("sfood"));
                                        label5.setText(rs.getString("odate"));
                                        label6.setText(rs.getString("otime"));
                    }
                    

                    //c.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        
    public static void main(String[] args){
        new UpdateOrders("");
    }   
}