package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkEmpInfo extends JFrame implements ActionListener
{
    private JButton	 updateBtn,backBtn;
	private JPanel panel;
	private JTable empTable;
	private JScrollPane empTableSP;

	private User u;
	private ClerkRepo cr;
	
	
	public ClarkEmpInfo(User u)
	{
		super("Car Rental System - Manage Employee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u=u;
		cr = new ClerkRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "","" }};
		
		String head[] = {"Id", "Name", "Salary", "Job Type","Join Date"};
		
		empTable = new JTable(data,head);
		empTableSP = new JScrollPane(empTable);
		empTableSP.setBounds(150, 100, 450, 150);
		empTable.setEnabled(false);
		panel.add(empTableSP);
		
		
		updateBtn = new JButton("GetUpdate!");
        updateBtn.setBounds(380,300,80,30);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);


		backBtn = new JButton("Back");
		backBtn.setBounds(280, 300, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(updateBtn.getText()))
		{
			String data[][] = cr.getEmployeeUpdate();
			String head[] = {"Id", "Name", "Salary", "Job Type","Join Date"};

			panel.remove(empTableSP);

			empTable = new JTable(data,head);
			empTable.setEnabled(false);
			empTableSP = new JScrollPane(empTable);
			empTableSP.setBounds(350,100,400,150);
			panel.add(empTableSP);

			panel.revalidate();
			panel.repaint();
		}

		else if(command.equals(backBtn.getText()))
		{
			ClarkHome ch = new ClarkHome(u);
			ch.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
	
}