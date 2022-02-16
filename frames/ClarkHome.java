package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkHome extends JFrame implements ActionListener
{
	JButton logoutBtn, receptionistBtn,workerBtn,clarkBtn, driverBtn, mechanicBtn, changePasswordBtn,empInfoBtn;
	JPanel panel;

	private User u;
	private Login l;
	
	public ClarkHome(User u)
	{
		super("Car Rental System - Welcome To Clark");
		this.setSize(700,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(180, 300, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(390, 300, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		receptionistBtn = new JButton("Receptionist");
		receptionistBtn.setBounds(90, 100, 150, 30);
		receptionistBtn.addActionListener(this);
		panel.add(receptionistBtn);
		
		workerBtn = new JButton("Worker");
		workerBtn.setBounds(265, 100, 150, 30);
		workerBtn.addActionListener(this);
		panel.add(workerBtn);
		
		
		driverBtn = new JButton(" Driver");
		driverBtn.setBounds(440, 100, 150, 30);
		driverBtn.addActionListener(this);
		panel.add(driverBtn);
		
		
		mechanicBtn = new JButton("Mechanic");
		mechanicBtn.setBounds(90, 200, 150, 30);
		mechanicBtn.addActionListener(this);
		panel.add(mechanicBtn);
		
		clarkBtn = new JButton("Clark");
		clarkBtn.setBounds(265, 200, 150, 30);
		clarkBtn.addActionListener(this);
		panel.add(clarkBtn);
		
		empInfoBtn = new JButton("Employee Info");
		empInfoBtn.setBounds(440, 200, 150, 30);
		empInfoBtn.addActionListener(this);
		panel.add(empInfoBtn);
		
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

		else if(command.equals(receptionistBtn.getText()))
		{
			if(u.getUserStatus()==2)
			{
				ClarkReceptionist cr = new ClarkReceptionist(u);
			    cr.setVisible(true);
			    this.setVisible(false);
			}

			else
			{
				JOptionPane.showMessageDialog(this,"Invalid Status");
			}
		}

		else if ( command.equals(workerBtn.getText()))
		{
			if (u.getUserStatus()==2) 
			{
				ClarkWorker cw = new ClarkWorker(u);
			    cw.setVisible(true);
			    this.setVisible(false);
			}
		}

		else if (command.equals(driverBtn.getText()))
		{
			ClarkDriver cd = new ClarkDriver(u);
			cd.setVisible(true);
			this.setVisible(false);
		}

		else if (command.equals(mechanicBtn.getText()))
		{
			ClarkMechanic cm = new ClarkMechanic(u);
			cm.setVisible(true);
			this.setVisible(false);
		}

		else if (command.equals(clarkBtn.getText()))
		{
			ClarkClark cc = new ClarkClark(u);
			cc.setVisible(true);
			this.setVisible(false);
		}

		else if (command.equals(empInfoBtn.getText()))
		{
			ClarkEmpInfo ce = new ClarkEmpInfo(u);
			ce.setVisible(true);
			this.setVisible(false);
		}

		else {}
	}
	
}