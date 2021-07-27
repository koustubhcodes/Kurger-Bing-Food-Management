package fms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;

public class NewOrd extends JFrame{ 

    
    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    JLabel label4;
    JComboBox c1, c2, c3;
    String course1[], course2[], course3[];
    int totalprice, totalcaloriess;

        public NewOrd()
        {
            super("Add Employee");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(228,142,88));
            p1.setBounds(0, 0, 240, 650);
            p1.setLayout(null);
            JLabel l1 = new JLabel("   New Order");
            l1.setFont(new Font("Arial", Font.BOLD, 32));
            l1.setForeground(Color.WHITE);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/food2.png"));
            Image z51 = z5.getImage().getScaledInstance(220, 220,Image.SCALE_DEFAULT);
            ImageIcon z511 = new ImageIcon(z51);
            JLabel lb1 = new JLabel();
            lb1.setIcon(z511);
            lb1.setBounds(8,0,240,240);
            p1.add(lb1);
            //l1.setIcon(jbii1);            
            l1.setBounds(0,150,240,240);
            Font font1 = new Font("SansSerif", Font.PLAIN, 20);
            
            
            JPanel p3 = new JPanel();
            p3.setBackground(Color.LIGHT_GRAY);
            p3.setBounds(245, 5, 450, 600);
            p3.setLayout(new GridLayout(12,2,20,25));
            p3.setForeground(Color.BLUE);
            p3.setBackground(Color.WHITE);
            
            
            
            JLabel f11;
            Random ran = new Random();
            long first = (ran.nextLong() % 10000000);
            f11 = new JLabel(); 
            String oid1 = (""+Math.abs(first));
            f11.setText(oid1);
            f11.setFont(new Font("Arial", Font.PLAIN, 20));
            JLabel OID = new JLabel("Order ID");
            OID.setFont(new Font("Arial", Font.PLAIN, 20));
            OID.setPreferredSize(new Dimension(220,50));
            OID.setHorizontalAlignment(JLabel.CENTER); 
            p3.add(OID);
            p3.add(f11);
           
            JLabel Name = new JLabel("Customer Name");
            Name.setFont(new Font("Arial", Font.PLAIN, 20));
            Name.setPreferredSize(new Dimension(220,50));
            Name.setHorizontalAlignment(JLabel.CENTER); 
            p3.add(Name);
            textField = new JTextField(); 
            textField.setPreferredSize(new Dimension(220,50));
            textField.setFont(font1);
            p3.add(textField);
		
            
			
            JLabel PFood = new JLabel("Primary Food");
            PFood.setFont(new Font("Arial", Font.PLAIN, 20));    
            PFood.setHorizontalAlignment(JLabel.CENTER);        
            p3.add(PFood);			
            //String course3[] = {""};
            c3 = new JComboBox();
            c3.setFont(new Font("Arial", Font.PLAIN, 20));
            c3.setBackground(Color.WHITE); 
            c3.setPreferredSize(new Dimension(220,50));
            p3.add(c3);
            
            JLabel Drink = new JLabel("Drink");
            Drink.setFont(new Font("Arial", Font.PLAIN, 20)); 
            Drink.setHorizontalAlignment(JLabel.CENTER);            
            p3.add(Drink);
            
            c2 = new JComboBox();
            c2.setFont(new Font("Arial", Font.PLAIN, 20));
            c2.setBackground(Color.WHITE); 
            c2.setPreferredSize(new Dimension(220,50));
            p3.add(c2);
            
            
            JLabel SFood = new JLabel("Secondary Food");
            SFood.setFont(new Font("Arial", Font.PLAIN, 20));  
            SFood.setHorizontalAlignment(JLabel.CENTER);   
            SFood.setPreferredSize(new Dimension(220,50));
            p3.add(SFood);
            c1 = new JComboBox();
            
            c1.setBackground(Color.WHITE); 
            c1.setFont(new Font("Arial", Font.PLAIN, 20));
            c1.setPreferredSize(new Dimension(220,50));
            p3.add(c1);
            
            JLabel Price = new JLabel("Total Price");
            Price.setFont(new Font("Arial", Font.PLAIN, 20));  
            Price.setHorizontalAlignment(JLabel.CENTER);
            Price.setPreferredSize(new Dimension(220,50));
            p3.add(Price);	
            JLabel label4 = new JLabel(); 
            label4.setPreferredSize(new Dimension(220,50));
            label4.setFont(font1);
            p3.add(label4);
            
            
            JLabel Calories = new JLabel("Total Calories");
            Calories.setFont(new Font("Arial", Font.PLAIN, 20));  
            Calories.setHorizontalAlignment(JLabel.CENTER);
            Calories.setPreferredSize(new Dimension(220,50));
            p3.add(Calories);	
            JLabel label7 = new JLabel(); 
            label7.setPreferredSize(new Dimension(220,50));
            label7.setFont(font1);
            p3.add(label7);
            	
            JLabel Phone = new JLabel("PHONE");
            Phone.setFont(new Font("Arial", Font.PLAIN, 20));  
            Phone.setHorizontalAlignment(JLabel.CENTER);
            Phone.setPreferredSize(new Dimension(220,50));
            p3.add(Phone);	
            textField_4 = new JTextField(); 
            textField_4.setPreferredSize(new Dimension(220,50));
            textField_4.setFont(font1);
            p3.add(textField_4);
            
            JLabel date = new JLabel("Date");
            date.setFont(new Font("Arial", Font.PLAIN, 20));  
            date.setHorizontalAlignment(JLabel.CENTER);
            date.setPreferredSize(new Dimension(220,50));
            p3.add(date);
            Date date1 = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String sdate = formatter.format(date1);
            JLabel label5 = new JLabel(); 
            label5.setPreferredSize(new Dimension(220,50));
            label5.setFont(font1);
            label5.setText(sdate);
            p3.add(label5);
            
            JLabel timeO = new JLabel("Time");
            timeO.setFont(new Font("Arial", Font.PLAIN, 20));  
            timeO.setHorizontalAlignment(JLabel.CENTER);
            timeO.setPreferredSize(new Dimension(220,50));
            p3.add(timeO);	
            String stime = "HH:mm:ss";
            SimpleDateFormat stime1 = new SimpleDateFormat(stime);
            JLabel label6 = new JLabel(); 
            label6.setPreferredSize(new Dimension(220,50));
            label6.setFont(font1);
            label6.setText(stime1.format(date1));
            p3.add(label6);
            
            fillComboBox();
            JButton btnSearchData = new JButton("Calculate Price");
	    btnSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                                    conn c11 = new conn();
                                    //conn c22 = new conn();
                                    //conn c33 = new conn();
                                    int i = 0, j=0, k=0;
                                    String a1 = "0", a2 = "0", a3 = "0", re1 = "0", re2 = "0", re3 = "0";
                                    int a11 = 0, a12 = 0, a13 = 0, re11 = 0, re22 = 0, re33 =0;
                                    String temp1 = (String)c3.getSelectedItem();
                                    String temp2 = (String)c2.getSelectedItem();
                                    String temp3 = (String)c1.getSelectedItem();
                                    String str1 = "Select price from food where fname = '"+temp1+"'";
                                    String str2 = "Select price from food where fname = '"+temp2+"'";
                                    String str3 = "Select price from food where fname = '"+temp3+"'";
                                    String str11 = "Select cal from food where fname = '"+temp1+"'";
                                    String str22 = "Select cal from food where fname = '"+temp2+"'";
                                    String str33 = "Select cal from food where fname = '"+temp3+"'";
                                    System.out.println("select1: "+str1);
                                    System.out.println("select2: "+str2);
                                    System.out.println("select3: "+str3);
                                    ResultSet rs1 = c11.s.executeQuery(str1);
                                    if(rs1.next()){
                                          a1 = rs1.getString("price");
                                          a11 = Integer.parseInt(a1);
                                          System.out.println("pfood: "+a11);
                                    }
                                    ResultSet rs11 = c11.s.executeQuery(str11);
                                    if(rs11.next()){
                                          re1 = rs11.getString("cal");
                                          re11 = Integer.parseInt(re1);
                                          
                                    }
                                    
                                    
                                    ResultSet rs2 = c11.s.executeQuery(str2);
                                    if(rs2.next()){
                                          a2 = rs2.getString("price");
                                          a12 = Integer.parseInt(a2);
                                          System.out.println("drink: "+a12);
                                    }
                                    ResultSet rs22 = c11.s.executeQuery(str22);
                                    if(rs22.next()){
                                          re2 = rs22.getString("cal");
                                          re22 = Integer.parseInt(re2);
                                          
                                    }
                                    
                                    
                                    ResultSet rs3 = c11.s.executeQuery(str3);
                                    if(rs3.next()){
                                          a3 = rs3.getString("price");
                                          a13 = Integer.parseInt(a3);
                                          System.out.println("sfood: "+a13);
                                    }
                                    ResultSet rs33 = c11.s.executeQuery(str33);
                                    if(rs33.next()){
                                          re3 = rs33.getString("cal");
                                          re33 = Integer.parseInt(re3);
                                          
                                    }
                                    
                                    totalprice = a11+a12+a13;
                                    System.out.println("total price: "+totalprice);
                                    label4.setText(""+totalprice);
                                    
                                    totalcaloriess = re11+re22+re33;
                                    System.out.println("total calories: "+totalprice);
                                    label7.setText(""+totalcaloriess);
                                     
                                    //c.close();
                                }catch(Exception e1){
                                    e1.printStackTrace();
                                }
			}
			
		});
		btnSearchData.setBounds(350, 500, 120, 30);
                btnSearchData.setBackground(Color.BLACK);
                btnSearchData.setForeground(Color.WHITE);                
		p3.add(btnSearchData);
            
            JButton Cancel = new JButton("Cancel");            
            Cancel.setBackground(Color.BLACK);
            Cancel.setForeground(Color.WHITE);
            Cancel.setPreferredSize(new Dimension(100,50));
            JButton Save = new JButton("Save"); 
            JFrame frame = new JFrame("New Order - Kurger Bing");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(720,650);
            frame.setLocation(690, 220);
            frame.setVisible(true);
            Save.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String cname = textField.getText();
                    String pfood = (String)c3.getSelectedItem();
                    String drink = (String)c2.getSelectedItem();
                    String sfood = (String)c1.getSelectedItem();
                    String tprice = (""+totalprice);
                    String cal = (""+totalcaloriess);
                    String cphone = textField_4.getText();
                    String odate = sdate;
                    String otime = stime1.format(date1);
                    String status = "1";
                    String oid = oid1;
                    try {
                        conn c = new conn();
                        String str = "insert into orders values('"+oid+"', '"+cname+"', '"+pfood+"','"+drink+"', '"+sfood+"', '"+tprice+"', '"+cal+"', '"+cphone+"', str_to_date('"+odate+"', '%d-%m-%Y') ,'"+otime+"','"+status+"')";
                        System.out.println(str);
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Order Added");
                        setVisible(false);
                        frame.dispose();
                    
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Order Could Not Be Added");
                        e.printStackTrace();
        	    }
		}
            });
            Save.setBackground(Color.BLACK);
            Save.setForeground(Color.WHITE);
            Save.setPreferredSize(new Dimension(100,50));
            p3.add(Save);
            
            
            p3.add(Cancel);
            Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new SearchEmp().setVisible(true);
                                frame.dispose();
			}
		});
            
            
            
            	
            

            	

            p1.add(l1);
            
            frame.add(p1);
            
            frame.add(p3);

            
            
			
	}
        public void fillComboBox(){
                try{
                    conn c = new conn();
                    int i = 0, j=0, k=0;
                    String str1 = "Select fname from food where ftype = 1";
                    String str2 = "Select fname from food where ftype = 2";
                    String str3 = "Select fname from food where ftype = 3";
                    ResultSet rs1 = c.s.executeQuery(str1);
                    while(rs1.next()){
                        c3.addItem(rs1.getString("fname"));
                        /*String fname = rs1.getString("fname");
                        course3[i++] = (String)fname;*/
                    }
                    ResultSet rs2 = c.s.executeQuery(str2);
                    while(rs2.next()){
                        c2.addItem(rs2.getString("fname"));
                        /*String fname = rs2.getString("fname");
                        course2[j++] = fname;*/
                    }
                    ResultSet rs3 = c.s.executeQuery(str3);
                    while(rs3.next()){
                        c1.addItem(rs3.getString("fname"));
                        /*String fname = rs3.getString("fname");
                        course1[k++] = fname;*/
                    }

                    //c.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        
        
    public static void main(String[] args){
        new NewOrd();
    }   
}