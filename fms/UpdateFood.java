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

public class UpdateFood extends JFrame{ 

    
    private JTable table;
    JTextField l11, l12, l13, l14, l15, l16;
    JLabel eno;
    JComboBox c1, c2;

        public UpdateFood(String tempq)
        {
            super("Update Food");
        
            JPanel p1 = new JPanel();
            p1.setBackground(new Color(245,205,220));
            p1.setBounds(0, 0, 720, 50);
            p1.setLayout(null);
            JLabel l1 = new JLabel(" Update Food Details");
            l1.setFont(new Font("Arial", Font.BOLD, 30));
            l1.setForeground(Color.BLACK);
            l1.setHorizontalTextPosition(JButton.CENTER);
            l1.setVerticalTextPosition(JButton.BOTTOM);
            ImageIcon z5 = new ImageIcon(ClassLoader.getSystemResource("fmsicons/updatedb.png"));
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
           
            JLabel SearchE = new JLabel("Updating Food");
            SearchE.setFont(new Font("Arial", Font.BOLD, 20));  
            SearchE.setHorizontalAlignment(JLabel.CENTER);
            SearchE.setPreferredSize(new Dimension(240,30));
            SearchE.setBounds(5,5,240,30);
            p3.add(SearchE);
            JLabel eno = new JLabel(); 
            eno.setText(tempq);
            eno.setPreferredSize(new Dimension(170,30));
            eno.setFont(new Font("Arial", Font.BOLD, 20)); 
            eno.setForeground(Color.BLUE);
            eno.setBounds(250,5,240,30);
            p3.add(eno);
            
            JPanel p4 = new JPanel();
            p4.setBackground(Color.LIGHT_GRAY);
            p4.setBounds(25, 100, 650, 470);
            p4.setLayout(new GridLayout(5,2,25,25));
            p4.setForeground(Color.BLUE);
            p4.setBackground(Color.WHITE);
            
            JLabel lab1 = new JLabel("Food Name");
            lab1.setFont(font1);
            lab1.setHorizontalAlignment(JLabel.CENTER);
            p4.add(lab1);
            l11 = new JTextField();
            p4.add(l11);
            
            JLabel lab2 = new JLabel("Food Type");
            lab2.setFont(font1);
            lab2.setHorizontalAlignment(JLabel.CENTER);
            p4.add(lab2);
            String course[] = {"Primary(Burgers)","Drink","Secondary(Add-Ons)"};
            c1 = new JComboBox(course);
            c1.setBackground(Color.WHITE); 
            c1.setFont(new Font("Arial", Font.PLAIN, 20));
            c1.setPreferredSize(new Dimension(220,50));
            p4.add(c1);
            
            JLabel lab3 = new JLabel("Price");
            lab3.setFont(font1);
            lab3.setHorizontalAlignment(JLabel.CENTER);
            p4.add(lab3);
            SpinnerModel value1 = new SpinnerNumberModel(0,0,1000,1);
            JSpinner spinner1 = new JSpinner(value1);
            JComponent editor1 = spinner1.getEditor();
            JSpinner.DefaultEditor spinnerEditor1 = (JSpinner.DefaultEditor)editor1;
            spinnerEditor1.getTextField().setHorizontalAlignment(JTextField.LEFT);
            spinnerEditor1.getTextField().setFont(new Font("Arial", Font.PLAIN, 20));
            p4.add(spinner1);
            
            JLabel lab4 = new JLabel("Calories");
            lab4.setFont(font1);
            lab4.setHorizontalAlignment(JLabel.CENTER);
            p4.add(lab4);
            SpinnerModel value = new SpinnerNumberModel(0,0,1000,1);
            JSpinner spinner = new JSpinner(value);
            JComponent editor = spinner.getEditor();
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
            spinnerEditor.getTextField().setHorizontalAlignment(JTextField.LEFT);
            spinnerEditor.getTextField().setFont(new Font("Arial", Font.PLAIN, 20));
            p4.add(spinner);
            
            
                
                JPanel p2 = new JPanel();
                p2.setBackground(new Color(245,205,220));
                p2.setBounds(0, 570, 720, 40);
                p2.setLayout(new FlowLayout());
                JButton UpdateData = new JButton("Update Data");
		UpdateData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae){
                            String fname = l11.getText();
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
                            String fid = tempq;
                            try {
                                conn c = new conn();
                                String str = "update food set fname = '"+fname+"', ftype = '"+job11+"', price = '"+price+"', cal = '"+cal+"' where fid = '"+fid+"'";
                                c.s.executeUpdate(str);
                                JOptionPane.showMessageDialog(null,"Food Item Updated");
                                setVisible(false);

                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,"Food Item Not Updated");
                                e.printStackTrace();
                            }
                    }
                });
		UpdateData.setBounds(350, 500, 120, 30);
                UpdateData.setBackground(Color.BLACK);
                UpdateData.setForeground(Color.WHITE);                
		p2.add(UpdateData);
		
                JFrame frame = new JFrame("Update Food");
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
            frame.add(p4);

            
          
	}
        
    public static void main(String[] args){
        new UpdateFood("");
    }   
}