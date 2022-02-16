package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

import entity.*;
import repository.*;

public class AddUser extends JFrame implements ActionListener
{
	private JLabel title, userLabel, jobtypeLabel;
	private JTextField userTF,statusTF,jobtypeTF;
	private JButton  addUserBtn, deleteUserBtn,backBtn;
	private JPanel panel;

	private User u;
	private UserRepo ur;
	private Login l;
	
	public AddUser(Login l)
	{
		super("Car Rental System - Add User Window");
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

        this.l=l;
		this.u=u;

		ur=new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(220, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(290, 100, 100, 30);
		panel.add(userTF);
		
		
		jobtypeLabel = new JLabel("Job Type : ");
		jobtypeLabel.setBounds(220, 170, 70, 30);
		panel.add(jobtypeLabel);
		
		jobtypeTF = new JTextField();
		jobtypeTF.setBounds(290, 170, 100, 30);
		panel.add(jobtypeTF);
		
		addUserBtn = new JButton("Add User!");
		addUserBtn.setBounds(120, 250, 170, 30);
		addUserBtn.addActionListener(this);
		panel.add(addUserBtn);
		
		deleteUserBtn = new JButton("Remove");
		deleteUserBtn.setBounds(300, 250, 170, 30);
		deleteUserBtn.addActionListener(this);
		panel.add(deleteUserBtn);

		backBtn = new JButton("Back");
		backBtn.setBounds(480,250,170,30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
    public void actionPerformed(ActionEvent ae)
    {
    	String command = ae.getActionCommand();

    	if(command.equals(addUserBtn.getText()))
    	{
    		User u = new User();
    		Random rd = new Random();
    		int x = rd.nextInt(99999)+100000;


    		u.setUserId(userTF.getText());
    		u.setUserPassword(x+"");

    		if(((jobtypeTF.getText()).equals("Manager")) || ((jobtypeTF.getText()).equals("manger")))
    		{
               u.setUserStatus(1);
    		}
    		else if (((jobtypeTF.getText()).equals("Clerk")) || ((jobtypeTF.getText()).equals("clerk")))
    		{
    			u.setUserStatus(2);
    		}
    		else if (((jobtypeTF.getText()).equals("Receptionist")) || ((jobtypeTF.getText()).equals("receptionist")))
    		{
    			u.setUserStatus(3);
    		}
    		else
    		{
    			u.setUserStatus(0);
    		}

            ur.insertUser(u);

            JOptionPane.showMessageDialog(this,"Inserted!"+"\n"+"ID : "+userTF.getText()+"\n"+"Password : " + x);
    	}
    	else if (command.equals(deleteUserBtn.getText()))
    	{
    		ur.deleteUser(userTF.getText());

    		JOptionPane.showMessageDialog(this,"Deleted !");

    		userTF.setText("");
    		jobtypeTF.setText("");

    		userTF.setEnabled(true);
    		jobtypeTF.setEnabled(true);
    	}

    	else if (command.equals(backBtn.getText()))
    	{
    		this.setVisible(false);
    		l.setVisible(true);
    	}
    	else{}
    }


}