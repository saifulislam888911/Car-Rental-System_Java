package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import entity.*;
import repository.*;

public class Login extends JFrame implements ActionListener,MouseListener
{
	JLabel title, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, addUserBtn, showPassBtn;
	JPanel panel;
	
	public Login()
	{
		super("Car Rental System - Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Car Rental System");
		title.setBounds(300, 50, 350, 30);
		panel.add(title);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		passPF.setEchoChar('*');
		panel.add(passPF);
		
		showPassBtn = new JButton("Show");
		showPassBtn.setBounds(470,150,80,30);
		showPassBtn.addMouseListener(this);
		panel.add(showPassBtn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		addUserBtn = new JButton("Add/Remove User!");
		addUserBtn.setBounds(300, 250, 170, 30);
		addUserBtn.addActionListener(this);
		panel.add(addUserBtn);
		
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(loginBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User u =ur.getUserInfo(userTF.getText(),passPF.getText());

			if(u != null)
			{
				if(u.getUserStatus()==1)
				{
					ManagerHome mh = new ManagerHome(u);
					mh.setVisible(true);
					this.setVisible(false);
				}

				else if(u.getUserStatus() == 2)
				{
					ClarkHome ch = new ClarkHome(u);
					ch.setVisible(true);
					this.setVisible(false);
				}

				else if(u.getUserStatus() == 3)
				{
					ReceptionistHome rh = new ReceptionistHome(u);
					rh.setVisible(true);
					this.setVisible(false);
				}
				else{JOptionPane.showMessageDialog(this,"Invalid User");}
			}
			else{JOptionPane.showMessageDialog(this,"Incorrent ID or Password");}
		}
		else if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}

		else if(command.equals(addUserBtn.getText()))
		{
			AddUser au = new AddUser(this);
			au.setVisible(true);
            this.setVisible(false);
		}
		else{}
	}
    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me)
    {
    	passPF.setEchoChar((char)0);
    }
    public void mouseReleased(MouseEvent me)
    {
    	passPF.setEchoChar('@');
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}

		
}