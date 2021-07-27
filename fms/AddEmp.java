package fms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddEmp extends JFrame{ 

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1, c2;
        JSpinner spinner;

        public AddEmp()
        {
            super("Add Employee");
            
            
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(63,100,126));
            p1.setBounds(0, 0, 240, 650);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Add Employee");
            l1.setFont(new Font("Arial", Font.BOLD, 32));
            l1.setForeground(Color.WHITE);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/addemp.png"));
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
            p3.setLayout(new GridLayout(8,2,20,10));
            p3.setForeground(Color.BLUE);
            p3.setBackground(Color.WHITE);
           
            JLabel Name = new JLabel("NAME");
            Name.setFont(new Font("Arial", Font.PLAIN, 20));
            Name.setPreferredSize(new Dimension(220,50));
            Name.setHorizontalAlignment(JLabel.CENTER); 
            p3.add(Name);
            textField = new JTextField(); 
            textField.setPreferredSize(new Dimension(220,50));
            textField.setFont(font1);
            p3.add(textField);
			
            
			
            JLabel Age = new JLabel("AGE");
            Age.setFont(new Font("Arial", Font.PLAIN, 20));    
            Age.setHorizontalAlignment(JLabel.CENTER);        
            p3.add(Age);			
            SpinnerModel value = new SpinnerNumberModel(18,18,60,1);
            JSpinner spinner = new JSpinner(value);
            JComponent editor = spinner.getEditor();
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
            spinnerEditor.getTextField().setHorizontalAlignment(JTextField.LEFT);
            spinnerEditor.getTextField().setFont(new Font("Arial", Font.PLAIN, 20));
            p3.add(spinner);
            
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
            Gender.setHorizontalAlignment(JLabel.CENTER);            
            p3.add(Gender);		
            String course1[] = {"Male","Female","Other"};
            c2 = new JComboBox(course1);
            c2.setFont(new Font("Arial", Font.PLAIN, 20));
            c2.setBackground(Color.WHITE); 
            c2.setPreferredSize(new Dimension(220,50));
            p3.add(c2);
            
            
            JLabel Job = new JLabel("JOB");
            Job.setFont(new Font("Arial", Font.PLAIN, 20));  
            Job.setHorizontalAlignment(JLabel.CENTER);   
            Job.setPreferredSize(new Dimension(220,50));
            p3.add(Job);
			
            String course[] = {"Kitchen","Billing"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE); 
            c1.setFont(new Font("Arial", Font.PLAIN, 20));
            c1.setPreferredSize(new Dimension(220,50));
            p3.add(c1);
            		
            	
            JLabel Phone = new JLabel("PHONE");
            Phone.setFont(new Font("Arial", Font.PLAIN, 20));  
            Phone.setHorizontalAlignment(JLabel.CENTER);
            Phone.setPreferredSize(new Dimension(220,50));
            p3.add(Phone);	
            textField_4 = new JTextField(); 
            textField_4.setPreferredSize(new Dimension(220,50));
            textField_4.setFont(font1);
            p3.add(textField_4);
            
            
            JLabel e1,e11;
            Random ran = new Random();
            long first = (ran.nextLong() % 1000000);
            e11 = new JLabel();
            String e111 = new String("" + Math.abs(first));
            e11.setText(e111);
            e11.setFont(new Font("Arial", Font.PLAIN, 20));
            JLabel EID = new JLabel("Employee ID");
            EID.setFont(new Font("Arial", Font.PLAIN, 20));
            EID.setPreferredSize(new Dimension(220,50));
            EID.setHorizontalAlignment(JLabel.CENTER); 
            p3.add(EID);
            p3.add(e11);
            JLabel Password = new JLabel("Password");
            Password.setFont(new Font("Arial", Font.PLAIN, 20));  
            Password.setHorizontalAlignment(JLabel.CENTER);
            Password.setPreferredSize(new Dimension(220,50));
            p3.add(Password);	
            textField_5 = new JTextField(); 
            textField_5.setPreferredSize(new Dimension(220,50));
            textField_5.setFont(font1);
            p3.add(textField_5);
            
            
	
            JButton Save = new JButton("Save");            
            Save.setBackground(Color.BLACK);
            Save.setForeground(Color.WHITE);
            Save.setPreferredSize(new Dimension(100,50));
            p3.add(Save);
            
            JButton Cancel = new JButton("Cancel");            
            Cancel.setBackground(Color.BLACK);
            Cancel.setForeground(Color.WHITE);
            Cancel.setPreferredSize(new Dimension(100,50));
            p3.add(Cancel);
            
            JFrame frame = new JFrame("Add Employee - Kurger Bing");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(720,650);
            frame.setLocation(690, 220);
            frame.setVisible(true); 
            
            p1.add(l1);
            frame.add(p1);
            frame.add(p3);
            
            Cancel.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    frame.dispose();
		}
            });
            
	
            	
            

            	

            

            
            Save.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String ename = textField.getText();
                    int age = (int)spinner.getValue();
                    String gender = (String)c2.getSelectedItem();
                    String job = (String)c1.getSelectedItem();
                    String j1 = new String("Billing");
                    int job11;
                    if(job.equals(j1))
                    {
                         job11 = 1;
                    }else
                    {
                         job11 = 2;
                    }
                    String phone = textField_4.getText();
                    String password = textField_5.getText();
                    String eid = e111;
                    try {
                        conn c = new conn();
                        String str = "insert into emp values( '"+eid+"', '"+ename+"', '"+age+"','"+gender+"', '"+job11+"', '"+phone+"','"+password+"')";
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Employee Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });	
	}
    
        
    public static void main(String[] args){
        new AddEmp();
    }   
}