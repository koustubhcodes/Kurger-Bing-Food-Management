package fms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddFood extends JFrame{ 

    
	JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
        JComboBox c1, c2;

        public AddFood()
        {
            super("Add Food");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(63,100,126));
            p1.setBounds(0, 0, 240, 650);
            p1.setLayout(null);
            JLabel l1 = new JLabel("   Add Food");
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
            p3.setLayout(new GridLayout(6,2,20,50));
            p3.setForeground(Color.BLUE);
            p3.setBackground(Color.WHITE);
           
            JLabel Name = new JLabel("Food Name");
            Name.setFont(new Font("Arial", Font.PLAIN, 20));
            Name.setPreferredSize(new Dimension(220,50));
            Name.setHorizontalAlignment(JLabel.CENTER); 
            p3.add(Name);
            textField = new JTextField(); 
            textField.setPreferredSize(new Dimension(220,50));
            textField.setFont(font1);
            p3.add(textField);
			
            
			
            JLabel Age = new JLabel("Food Type");
            Age.setFont(new Font("Arial", Font.PLAIN, 20));    
            Age.setHorizontalAlignment(JLabel.CENTER);        
            p3.add(Age);
            String course[] = {"Primary(Burgers)","Drink","Secondary(Add-Ons)"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE); 
            c1.setFont(new Font("Arial", Font.PLAIN, 20));
            c1.setPreferredSize(new Dimension(220,50));
            p3.add(c1);
            
            
            JLabel Gender = new JLabel("Price");
            Gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
            Gender.setHorizontalAlignment(JLabel.CENTER);            
            p3.add(Gender);		
            SpinnerModel value1 = new SpinnerNumberModel(0,0,1000,1);
            JSpinner spinner1 = new JSpinner(value1);
            JComponent editor1 = spinner1.getEditor();
            JSpinner.DefaultEditor spinnerEditor1 = (JSpinner.DefaultEditor)editor1;
            spinnerEditor1.getTextField().setHorizontalAlignment(JTextField.LEFT);
            spinnerEditor1.getTextField().setFont(new Font("Arial", Font.PLAIN, 20));
            p3.add(spinner1);
            
            
            JLabel Job = new JLabel("Calories");
            Job.setFont(new Font("Arial", Font.PLAIN, 20));  
            Job.setHorizontalAlignment(JLabel.CENTER);   
            Job.setPreferredSize(new Dimension(220,50));
            p3.add(Job);
            SpinnerModel value = new SpinnerNumberModel(0,0,1000,1);
            JSpinner spinner = new JSpinner(value);
            JComponent editor = spinner.getEditor();
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
            spinnerEditor.getTextField().setHorizontalAlignment(JTextField.LEFT);
            spinnerEditor.getTextField().setFont(new Font("Arial", Font.PLAIN, 20));
            p3.add(spinner);
            
            		
            	
                     
            
            JLabel e1,e11;
            Random ran = new Random();
            long first = (ran.nextLong() % 1000000);
            e11 = new JLabel();
            String e111 = new String("" + Math.abs(first));
            e11.setText(e111);
            e11.setFont(new Font("Arial", Font.PLAIN, 20));
            JLabel EID = new JLabel("Food ID");
            EID.setFont(new Font("Arial", Font.PLAIN, 20));
            EID.setPreferredSize(new Dimension(220,50));
            EID.setHorizontalAlignment(JLabel.CENTER); 
            p3.add(EID);
            p3.add(e11);
            
	
            JButton Save = new JButton("Save");            
            Save.setBackground(Color.BLACK);
            Save.setForeground(Color.WHITE);
            Save.setPreferredSize(new Dimension(100,50));
            p3.add(Save);
            
            JFrame frame = new JFrame("Add Food");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(720,650);
            frame.setLocation(690, 220);
            frame.setVisible(true);	
            
            JButton Cancel = new JButton("Cancel");            
            Cancel.setBackground(Color.BLACK);
            Cancel.setForeground(Color.WHITE);
            Cancel.setPreferredSize(new Dimension(100,50));
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

            
            Save.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String fname = textField.getText();
                    String ftype = (String)c1.getSelectedItem();
                    int price = (int)spinner1.getValue();
                    int cal = (int)spinner.getValue();
                    String j1 = new String("Primary(Burgers)");
                    String j2 = new String("Drink");
                    int job11;
                    if(ftype.equals(j1))
                    {
                         job11 = 1;
                         
                    }else if(ftype.equals(j2))
                    {
                         job11 = 2;
                         
                    }else{
                        
                        job11 = 3;
                    }
                    
                    String fid = e111;
                    try {
                        conn c = new conn();
                        String str = "insert into food values( '"+fid+"', '"+fname+"', '"+job11+"','"+price+"', '"+cal+"')";
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Food Item Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,"Food Item Could Not Be Added");
                        e.printStackTrace();
        	    }
		}
            });
			
            
			
	}
        
    public static void main(String[] args){
        new AddFood();
    }   
}