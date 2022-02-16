package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkClark extends JFrame implements ActionListener
{
	private JLabel clarkIdLabel, clarkNameLabel,clarkSalaryLabel,joinDateLabel;
	private JTextField clarkIdTF, clarkNameTF,clarkSalaryTF,joinDateTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable clarkTable;
	private JScrollPane clarkTableSP;

	private User u;
	private ClerkRepo cr;
	
	
	public ClarkClark(User u)
	{
		super("Car Rental System - Manage Clerk");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u = u;
		cr = new ClerkRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "" }};
		
		String head[] = {"Id", "Name", "Salary","Join Date"};
		
		clarkTable = new JTable(data,head);
		clarkTableSP = new JScrollPane(clarkTable);
		clarkTableSP.setBounds(350, 100, 400, 150);
		clarkTable.setEnabled(false);
		panel.add(clarkTableSP);
		
		clarkIdLabel = new JLabel("ID :");
	    clarkIdLabel.setBounds(100,100,100,30);
		panel.add(clarkIdLabel);
		
		clarkIdTF = new JTextField();
		clarkIdTF.setBounds(220,100,100,30);
		panel.add(clarkIdTF);
		
		clarkNameLabel = new JLabel("NAME :");
	    clarkNameLabel.setBounds(100,150,100,30);
		panel.add(clarkNameLabel);
		
		clarkNameTF = new JTextField();
		clarkNameTF.setBounds(220,150,100,30);
		panel.add(clarkNameTF);
		
		clarkSalaryLabel = new JLabel("SALARY : ");
		clarkSalaryLabel.setBounds(100,200,100,30);
		panel.add(clarkSalaryLabel);
		
	    clarkSalaryTF = new JTextField();
		clarkSalaryTF.setBounds(220,200,100,30);
		panel.add(clarkSalaryTF);
		
		
		joinDateLabel = new JLabel("JOIN DATE : ");
		joinDateLabel.setBounds(100,250,100,30);
		panel.add(joinDateLabel);
		
		joinDateTF = new JTextField();
		joinDateTF.setBounds(220,250,100,30);
		panel.add(joinDateTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,350,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,350,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,350,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,350,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,350,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(loadBtn.getText()))
		{
           if (!clarkIdTF.getText().equals("")||!clarkIdTF.getText().equals(null))
           {
           	   Clerk c = cr.searchClerk(clarkIdTF.getText());
           	   if(c!=null)
           	   {
           	   	clarkNameTF.setText(c.getClerkName());
                clarkSalaryTF.setText(c.getClerkSalary()+"");
                joinDateTF.setText(c.getClerkJoinDate());

                clarkIdTF.setEnabled(false);
                clarkNameTF.setEnabled(true);
                clarkSalaryTF.setEnabled(true);
                joinDateTF.setEnabled(true);

                insertBtn.setEnabled(false);
                loadBtn.setEnabled(false);
                updateBtn.setEnabled(true);
                deleteBtn.setEnabled(true);
                refreshBtn.setEnabled(true);

           	   }
           	   else
           	   {
           	   	JOptionPane.showMessageDialog(this,"Invalid Id !");
           	   }
           }
		}
		else if(command.equals(insertBtn.getText()))
		{
			Clerk c = new Clerk();

			c.setClerkId(clarkIdTF.getText());
			c.setClerkName(clarkNameTF.getText());
			c.setClerkSalary(Double.parseDouble(clarkSalaryTF.getText()));
			c.setClerkJoinDate(joinDateTF.getText());


			cr.addClerk(c);

			JOptionPane.showMessageDialog(this,"Inserted !");

			clarkIdTF.setText("");
			clarkNameTF.setText("");
			clarkSalaryTF.setText("");
			joinDateTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Clerk c = new Clerk();

			c.setClerkId(clarkIdTF.getText());
			c.setClerkName(clarkNameTF.getText());
			c.setClerkSalary(Double.parseDouble(clarkSalaryTF.getText()));
			c.setClerkJoinDate(joinDateTF.getText());

			cr.updateClerkInfo(c);

			JOptionPane.showMessageDialog(this,"Updated !");

			clarkIdTF.setText("");
			clarkNameTF.setText("");
			clarkSalaryTF.setText("");
			joinDateTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			clarkIdTF.setEnabled(true);
			clarkNameTF.setEnabled(true);
			clarkSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			cr.deleteClerk(clarkIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			clarkIdTF.setText("");
			clarkNameTF.setText("");
			clarkSalaryTF.setText("");
			joinDateTF.setText("");

			clarkIdTF.setEnabled(true);
			clarkNameTF.setEnabled(true);
			clarkSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			clarkIdTF.setText("");
			clarkNameTF.setText("");
			clarkSalaryTF.setText("");
			joinDateTF.setText("");

			clarkIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getClerkUpdate();
			String head[] = {"Id", "Name", "Salary","Join Date"};

			panel.remove(clarkTableSP);

			clarkTable = new JTable(data,head);
			clarkTable.setEnabled(false);
			clarkTableSP = new JScrollPane(clarkTable);
			clarkTableSP.setBounds(350,100,400,150);
			panel.add(clarkTableSP);

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