package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


import entity.*;
import repository.*;

public class ManagerHome extends JFrame implements ActionListener
{
	private JButton logoutBtn, manageCarBtn, manageDriverBtn, manageEmployeeBtn, changePasswordBtn;
	private JPanel panel;

	private User u;
	private Login l;
	
	public ManagerHome(User u)
	{
		super("Car Rental System - Welcome Manager");
		this.setSize(700,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(180, 200, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(390, 200, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmployeeBtn = new JButton("Manage Employee");
		manageEmployeeBtn.setBounds(90, 100, 150, 30);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		manageCarBtn = new JButton("Manage Car");
		manageCarBtn.setBounds(265, 100, 150, 30);
		manageCarBtn.addActionListener(this);
		panel.add(manageCarBtn);
		
		
		manageDriverBtn = new JButton("Manage Driver");
		manageDriverBtn.setBounds(440, 100, 150, 30);
		manageDriverBtn.addActionListener(this);
		panel.add(manageDriverBtn);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(logoutBtn.getText()))
		{
			Login l =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(changePasswordBtn.getText()))
		{
			PasswordChange pc = new PasswordChange(u);
			pc.setVisible(true);
			this.setVisible(false);
		}

		else if(command.equals(manageEmployeeBtn.getText()))
		{
			if(u.getUserStatus()==1)
			{
				ManagerEmp me = new ManagerEmp(u);
			    me.setVisible(true);
			    this.setVisible(false);
			}

			else
			{
				JOptionPane.showMessageDialog(this,"Invalid Status");
			}
		}

		else if ( command.equals(manageCarBtn.getText()))
		{
			ManagerCar mc = new ManagerCar(u);
			mc.setVisible(true);
			this.setVisible(false);
		}

		else if (command.equals(manageDriverBtn.getText()))
		{
			ManagerDriver md = new ManagerDriver(u);
			md.setVisible(true);
			this.setVisible(false);
		}

		else {}
	}
}