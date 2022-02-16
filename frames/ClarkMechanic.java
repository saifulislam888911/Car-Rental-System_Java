package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkMechanic extends JFrame implements ActionListener
{
	private JLabel mechanicIdLabel, mechanicNameLabel,mechanicSalaryLabel,joinDateLabel;
	private JTextField mechanicIdTF, mechanicNameTF,mechanicSalaryTF,joinDateTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable mechanicTable;
	private JScrollPane mechanicTableSP;
	
	private User u;
	private ClerkRepo cr;



	public ClarkMechanic(User u)
	{
		super("Car Rental System - Manage Mechanic");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u = u;
		cr = new ClerkRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "" }};
		
		String head[] = {"Id", "Name", "Salary","Join Date"};
		
		mechanicTable = new JTable(data,head);
		mechanicTableSP = new JScrollPane(mechanicTable);
		mechanicTableSP.setBounds(350, 100, 400, 150);
		mechanicTable.setEnabled(false);
		panel.add(mechanicTableSP);
		
		mechanicIdLabel = new JLabel("ID :");
	    mechanicIdLabel.setBounds(100,100,100,30);
		panel.add(mechanicIdLabel);
		
		mechanicIdTF = new JTextField();
		mechanicIdTF.setBounds(220,100,100,30);
		panel.add(mechanicIdTF);
		
		mechanicNameLabel = new JLabel("NAME :");
		mechanicNameLabel.setBounds(100,150,100,30);
		panel.add(mechanicNameLabel);
		
		mechanicNameTF = new JTextField();
		mechanicNameTF.setBounds(220,150,100,30);
		panel.add(mechanicNameTF);
		
		mechanicSalaryLabel = new JLabel("SALARY : ");
		mechanicSalaryLabel.setBounds(100,200,100,30);
		panel.add(mechanicSalaryLabel);
		
	    mechanicSalaryTF = new JTextField();
		mechanicSalaryTF.setBounds(220,200,100,30);
		panel.add(mechanicSalaryTF);
		
		
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
           if (!mechanicIdTF.getText().equals("")||!mechanicIdTF.getText().equals(null))
           {
           	   Mechanic m = cr.searchMechanic(mechanicIdTF.getText());
           	   if(m!=null)
           	   {
           	   	mechanicNameTF.setText(m.getMechanicName());
                mechanicSalaryTF.setText(m.getMechanicSalary()+"");
                joinDateTF.setText(m.getMechanicJoinDate());

                mechanicIdTF.setEnabled(false);
                mechanicNameTF.setEnabled(true);
                mechanicSalaryTF.setEnabled(true);
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
			Mechanic m = new Mechanic();

			m.setMechanicId(mechanicIdTF.getText());
			m.setMechanicName(mechanicNameTF.getText());
			m.setMechanicSalary(Double.parseDouble(mechanicSalaryTF.getText()));
			m.setMechanicJoinDate(joinDateTF.getText());


			cr.addMechanic(m);

			JOptionPane.showMessageDialog(this,"Inserted !");

			mechanicIdTF.setText("");
			mechanicNameTF.setText("");
			mechanicSalaryTF.setText("");
			joinDateTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Mechanic m = new Mechanic();

			m.setMechanicId(mechanicIdTF.getText());
			m.setMechanicName(mechanicNameTF.getText());
			m.setMechanicSalary(Double.parseDouble(mechanicSalaryTF.getText()));
			m.setMechanicJoinDate(joinDateTF.getText());

			cr.updateMechanicInfo(m);

			JOptionPane.showMessageDialog(this,"Updated !");

			mechanicIdTF.setText("");
			mechanicNameTF.setText("");
			mechanicSalaryTF.setText("");
			joinDateTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			mechanicIdTF.setEnabled(true);
			mechanicNameTF.setEnabled(true);
			mechanicSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			cr.deleteMechanic(mechanicIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			mechanicIdTF.setText("");
			mechanicNameTF.setText("");
			mechanicSalaryTF.setText("");
			joinDateTF.setText("");

			mechanicIdTF.setEnabled(true);
			mechanicNameTF.setEnabled(true);
			mechanicSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			mechanicIdTF.setText("");
			mechanicNameTF.setText("");
			mechanicSalaryTF.setText("");
			joinDateTF.setText("");

			mechanicIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getMechanicUpdate();
			String head[] = {"Id", "Name", "Salary","Join Date"};

			panel.remove(mechanicTableSP);

			mechanicTable = new JTable(data,head);
			mechanicTable.setEnabled(false);
			mechanicTableSP = new JScrollPane(mechanicTable);
			mechanicTableSP.setBounds(350,100,400,150);
			panel.add(mechanicTableSP);

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