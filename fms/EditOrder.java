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

public class EditOrder extends JFrame{ 

    
    private JTable table;
    JTextField l11, l12, l13, l14, l15, l16, textField, textField_4;
    JLabel eno;
    JComboBox c1, c2, c3, c4;
    int totalprice;

        public EditOrder(String tempq)
        {
            super("Edit Order");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(228,142,88));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Update Order");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.WHITE);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/food2.png"));
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
            
            JLabel Name = new JLabel("Customer Name");
            Name.setFont(new Font("Arial", Font.PLAIN, 20));
            Name.setPreferredSize(new Dimension(220,50));
            Name.setHorizontalAlignment(JLabel.CENTER); 
            p4.add(Name);
            textField = new JTextField(); 
            textField.setPreferredSize(new Dimension(220,50));
            textField.setFont(font1);
            p4.add(textField);
		
            
			
            JLabel PFood = new JLabel("Primary Food");
            PFood.setFont(new Font("Arial", Font.PLAIN, 20));    
            PFood.setHorizontalAlignment(JLabel.CENTER);        
            p4.add(PFood);			
            //String course3[] = {""};
            c3 = new JComboBox();
            c3.setFont(new Font("Arial", Font.PLAIN, 20));
            c3.setBackground(Color.WHITE); 
            c3.setPreferredSize(new Dimension(220,50));
            p4.add(c3);
            
            JLabel Drink = new JLabel("Drink");
            Drink.setFont(new Font("Arial", Font.PLAIN, 20)); 
            Drink.setHorizontalAlignment(JLabel.CENTER);            
            p4.add(Drink);
            
            c2 = new JComboBox();
            c2.setFont(new Font("Arial", Font.PLAIN, 20));
            c2.setBackground(Color.WHITE); 
            c2.setPreferredSize(new Dimension(220,50));
            p4.add(c2);
            
            
            JLabel SFood = new JLabel("Secondary Food");
            SFood.setFont(new Font("Arial", Font.PLAIN, 20));  
            SFood.setHorizontalAlignment(JLabel.CENTER);   
            SFood.setPreferredSize(new Dimension(220,50));
            p4.add(SFood);
            c1 = new JComboBox();
            
            c1.setBackground(Color.WHITE); 
            c1.setFont(new Font("Arial", Font.PLAIN, 20));
            c1.setPreferredSize(new Dimension(220,50));
            p4.add(c1);
            
            
            
            
            JLabel Price = new JLabel("Total Price");
            Price.setFont(new Font("Arial", Font.PLAIN, 20));  
            Price.setHorizontalAlignment(JLabel.CENTER);
            Price.setPreferredSize(new Dimension(220,50));
            p4.add(Price);	
            JLabel label4 = new JLabel(); 
            label4.setPreferredSize(new Dimension(220,50));
            label4.setFont(font1);
            label4.setText(""+totalprice);
            p4.add(label4);
            	
            JLabel Phone = new JLabel("Phone");
            Phone.setFont(new Font("Arial", Font.PLAIN, 20));  
            Phone.setHorizontalAlignment(JLabel.CENTER);
            Phone.setPreferredSize(new Dimension(220,50));
            p4.add(Phone);	
            textField_4 = new JTextField(); 
            textField_4.setPreferredSize(new Dimension(220,50));
            textField_4.setFont(font1);
            p4.add(textField_4);
                      
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
            
            fillComboBox();
            
            /*JLabel date = new JLabel("Date");
            date.setFont(new Font("Arial", Font.PLAIN, 20));  
            date.setHorizontalAlignment(JLabel.CENTER);
            date.setPreferredSize(new Dimension(220,50));
            p4.add(date);
            java.util.Date date1 = new java.util.Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String sdate = formatter.format(date1);
            JLabel label5 = new JLabel(); 
            label5.setPreferredSize(new Dimension(220,50));
            label5.setFont(font1);
            label5.setText(sdate);
            p4.add(label5);
            
            JLabel timeO = new JLabel("Time");
            timeO.setFont(new Font("Arial", Font.PLAIN, 20));  
            timeO.setHorizontalAlignment(JLabel.CENTER);
            timeO.setPreferredSize(new Dimension(220,50));
            p4.add(timeO);	
            String stime = "HH:mm:ss";
            SimpleDateFormat stime1 = new SimpleDateFormat(stime);
            JLabel label6 = new JLabel(); 
            label6.setPreferredSize(new Dimension(220,50));
            label6.setFont(font1);
            label6.setText(stime1.format(date1));
            p4.add(label6);*/
            
            /*JLabel lab4 = new JLabel("Calories");
            lab4.setFont(font1);
            lab4.setHorizontalAlignment(JLabel.CENTER);
            p4.add(lab4);
            SpinnerModel value = new SpinnerNumberModel(0,0,1000,1);
            JSpinner spinner = new JSpinner(value);
            JComponent editor = spinner.getEditor();
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
            spinnerEditor.getTextField().setHorizontalAlignment(JTextField.LEFT);
            spinnerEditor.getTextField().setFont(new Font("Arial", Font.PLAIN, 20));
            p4.add(spinner);*/
            
                JButton btnSearchData = new JButton("Calculate Price");
                btnSearchData.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                    try{
                                        conn c = new conn();
                                        int i = 0, j=0, k=0;
                                        String a1 = "0", a2 = "0", a3 = "0";
                                        int a11 = 0, a12 = 0, a13 = 0;
                                        String temp1 = (String)c3.getSelectedItem();
                                        String temp2 = (String)c2.getSelectedItem();
                                        String temp3 = (String)c1.getSelectedItem();
                                        String str1 = "Select price from food where fname = '"+temp1+"'";
                                        String str2 = "Select price from food where ftype = '"+temp2+"'";
                                        String str3 = "Select price from food where ftype = '"+temp3+"'";
                                        ResultSet rs1 = c.s.executeQuery(str1);
                                        if(rs1.next()){
                                             a1 = rs1.getString("price");
                                              a11 = Integer.parseInt(a1);
                                        }


                                        ResultSet rs2 = c.s.executeQuery(str2);
                                        if(rs2.next()){
                                             a2 = rs2.getString("price");
                                              a12 = Integer.parseInt(a2);
                                        }


                                        ResultSet rs3 = c.s.executeQuery(str3);
                                        if(rs3.next()){
                                             a3 = rs3.getString("price");
                                              a13 = Integer.parseInt(a3);
                                        }

                                        totalprice = a11+a12+a13;

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
                
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(228,142,88));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
                JButton UpdateData = new JButton("Update Data");
		UpdateData.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                        String cname = textField.getText();
                        String pfood = (String)c3.getSelectedItem();
                        String drink = (String)c2.getSelectedItem();
                        String sfood = (String)c1.getSelectedItem();
                        //String tprice = (""+totalprice);
                        String cphone = textField_4.getText();
                        //String odate = sdate;
                        //String otime = stime1.format(date1);
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
                            String str = "update orders set cname = '"+cname+"', pfood = '"+pfood+"', drink = '"+drink+"', sfood = '"+sfood+"', cphone = '"+cphone+"', status = '"+status+"' where oid = '"+oid+"'";
                            System.out.println(str);
                            c.s.executeUpdate(str);
                            JOptionPane.showMessageDialog(null,"Order Added");
                            setVisible(false);

                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"Order Could Not Be Added");
                            e.printStackTrace();
                        }
                    }
                });
		UpdateData.setBounds(350, 500, 120, 30);
                UpdateData.setBackground(Color.BLACK);
                UpdateData.setForeground(Color.WHITE);                
		p2.add(UpdateData);
		
		JButton btnExit = new JButton("Back");
                JFrame frame = new JFrame("Edit Order - Kurger Bing");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(null);
                frame.setSize(720,650);
                frame.setLocation(690, 220);
                frame.setVisible(true);	
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new SearchEmp().setVisible(true);
                                //setVisible(false);
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
        new EditOrder("");
    }   
}