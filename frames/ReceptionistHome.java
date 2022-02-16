package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ReceptionistHome extends JFrame implements ActionListener
{
	JButton logoutBtn,carStatusBtn,bookingBtn,changePasswordBtn;
	JPanel panel;

	private User u;
	private Login l;
	
	public ReceptionistHome(User u)
	{
		super("Car Rental System - Welcome To Receptionist");
		this.setSize(700,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.u=u;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(150, 200, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(330, 200, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		
		carStatusBtn = new JButton("Car Status");
		carStatusBtn.setBounds(150, 100, 150, 30);
        carStatusBtn.addActionListener(this);
		panel.add(carStatusBtn);
		
		bookingBtn = new JButton("Booking");
		bookingBtn.setBounds(330, 100, 150, 30);
		bookingBtn.addActionListener(this);
		panel.add(bookingBtn);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(logoutBtn.getText()))
		{
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(changePasswordBtn.getText()))
		{
			PasswordChange pc = new PasswordChange(u);
			pc.setVisible(true);
			this.setVisible(false);
		}

		else if(command.equals(carStatusBtn.getText()))
		{
			
				ReceptionistCar rc = new ReceptionistCar(u);
			    rc.setVisible(true);
			    this.setVisible(false);
		}

		else if ( command.equals(bookingBtn.getText()))
		{
			ReceptionistBooking rb = new ReceptionistBooking(u);
			rb.setVisible(true);
			this.setVisible(false);
		}

		else {}
	}
	
}