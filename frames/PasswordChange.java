package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class PasswordChange extends JFrame implements ActionListener,MouseListener
{
	JLabel  userIdLabel, newpassLabel;
	JTextField userIdTF;
	JPasswordField newpassPF;
	JButton showPassBtn,passwordChangeBtn,backBtn;
	JPanel panel;

	private UserRepo ur;
	private User u;
	private ManagerHome mh;
	private ClarkHome ch;
	private ReceptionistHome rh;
	
	public PasswordChange(User u)
	{
		super("Car Rental System - Change Password");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		ur = new UserRepo();

		this.u=u;
		
		panel = new JPanel();
		panel.setLayout(null);

		
		userIdLabel = new JLabel("User ID : ");
		userIdLabel.setBounds(300, 80, 60, 30);
		panel.add(userIdLabel);
		
		userIdTF = new JTextField();
		userIdTF.setBounds(370, 80, 100, 30);
		panel.add(userIdTF);
		
		newpassLabel = new JLabel("NEW Password : ");
		newpassLabel.setBounds(300, 110, 70, 30);
		panel.add(newpassLabel);
		
		newpassPF = new JPasswordField();
		newpassPF.setBounds(370, 110, 100, 30);
		newpassPF.setEchoChar('*');
		panel.add(newpassPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(490,110,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		
		passwordChangeBtn = new JButton("Change Password");
		passwordChangeBtn.setBounds(190, 220, 170, 30);
		passwordChangeBtn.addActionListener(this);
		panel.add(passwordChangeBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(380,220,170,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(passwordChangeBtn.getText()))
		{
			String pass = newpassPF.getText(); 
		    if((userIdTF.getText()).equals(u.getUserId()))
		    {
              u.setUserPassword(pass);
		    }
		    ur.updateUserInfo(u);
           
           JOptionPane.showMessageDialog(this,"Changed !"+"\n"+"New Password : "+(newpassPF.getText()));
		}

		else if(command.equals(backBtn.getText()))
		{
			if(u.getUserStatus()==1)
			{
				mh = new ManagerHome(u);
                this.setVisible(false);
                mh.setVisible(true);
            }

            else if (u.getUserStatus()==2)
            {
               ch = new ClarkHome(u);
               this.setVisible(false);
               ch.setVisible(true);
            }
            else if (u.getUserStatus()==3)
            {
            	rh = new ReceptionistHome(u);
            	this.setVisible(false);
            	rh.setVisible(true);
            }
            else{}
    		
    	}
    	else {}
	}
    
    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me)
    {
    	newpassPF.setEchoChar((char)0);
    }
    public void mouseReleased(MouseEvent me)
    {  
    	newpassPF.setEchoChar('*');
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
	
}