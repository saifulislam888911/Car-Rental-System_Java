package frames;



import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkReceptionist extends JFrame implements ActionListener
{
	private JLabel receptionistIdLabel, receptionistNameLabel,receptionistSalaryLabel,joinDateLabel;
	private JTextField receptionistIdTF, receptionistNameTF,receptionistSalaryTF,joinDateTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable receptionistTable;
	private JScrollPane receptionistTableSP;

	private User u;
	private ClerkRepo cr;
	
	
	public ClarkReceptionist(User u)
	{
		super("Car Rental System - Manage Receptionist");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cr = new ClerkRepo();
		this.u=u;

		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "" }};
		
		String head[] = {"Id", "Name", "Salary","Join Date"};
		
		receptionistTable = new JTable(data,head);
		receptionistTableSP = new JScrollPane(receptionistTable);
		receptionistTableSP.setBounds(350, 100, 400, 150);
		receptionistTable.setEnabled(false);
		panel.add(receptionistTableSP);
		
		receptionistIdLabel = new JLabel("ID :");
		receptionistIdLabel.setBounds(100,100,100,30);
		panel.add(receptionistIdLabel);
		
		receptionistIdTF = new JTextField();
		receptionistIdTF.setBounds(220,100,100,30);
		panel.add(receptionistIdTF);
		
		receptionistNameLabel = new JLabel("NAME :");
		receptionistNameLabel.setBounds(100,150,100,30);
		panel.add(receptionistNameLabel);
		
		receptionistNameTF = new JTextField();
		receptionistNameTF.setBounds(220,150,100,30);
		panel.add(receptionistNameTF);
		
		receptionistSalaryLabel = new JLabel("SALARY : ");
		receptionistSalaryLabel.setBounds(100,200,100,30);
		panel.add(receptionistSalaryLabel);
		
	    receptionistSalaryTF = new JTextField();
		receptionistSalaryTF.setBounds(220,200,100,30);
		panel.add(receptionistSalaryTF);
		
		
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
           if (!receptionistIdTF.getText().equals("")||!receptionistIdTF.getText().equals(null))
           {
           	   Receptionist r = cr.searchReceptionist(receptionistIdTF.getText());
           	   if(r!=null)
           	   {
           	   	receptionistNameTF.setText(r.getReceptionistName());
                receptionistSalaryTF.setText(r.getReceptionistSalary()+"");
                joinDateTF.setText(r.getReceptionistJoinDate());

                receptionistIdTF.setEnabled(false);
                receptionistNameTF.setEnabled(true);
                receptionistSalaryTF.setEnabled(true);
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
			Receptionist r = new Receptionist();

			r.setReceptionistId(receptionistIdTF.getText());
			r.setReceptionistName(receptionistNameTF.getText());
			r.setReceptionistSalary(Double.parseDouble(receptionistSalaryTF.getText()));
			r.setReceptionistJoinDate(joinDateTF.getText());


			cr.addReceptionist(r);

			JOptionPane.showMessageDialog(this,"Inserted !");

			receptionistIdTF.setText("");
			receptionistNameTF.setText("");
			receptionistSalaryTF.setText("");
			joinDateTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Receptionist r = new Receptionist();

			r.setReceptionistId(receptionistIdTF.getText());
			r.setReceptionistName(receptionistNameTF.getText());
			r.setReceptionistSalary(Double.parseDouble(receptionistSalaryTF.getText()));
			r.setReceptionistJoinDate(joinDateTF.getText());

			cr.updateReceptionistInfo(r);

			JOptionPane.showMessageDialog(this,"Updated !");

			receptionistIdTF.setText("");
			receptionistNameTF.setText("");
			receptionistSalaryTF.setText("");
			joinDateTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			receptionistIdTF.setEnabled(true);
			receptionistNameTF.setEnabled(true);
			receptionistSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			cr.deleteReceptionist(receptionistIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			receptionistIdTF.setText("");
			receptionistNameTF.setText("");
			receptionistSalaryTF.setText("");
			joinDateTF.setText("");

			receptionistIdTF.setEnabled(true);
			receptionistNameTF.setEnabled(true);
			receptionistSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			receptionistIdTF.setText("");
			receptionistNameTF.setText("");
			receptionistSalaryTF.setText("");
			joinDateTF.setText("");

			receptionistIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getReceptionistUpdate();
			String head[] = {"Id", "Name", "Salary","Join Date"};

			panel.remove(receptionistTableSP);

			receptionistTable = new JTable(data,head);
			receptionistTable.setEnabled(false);
			receptionistTableSP = new JScrollPane(receptionistTable);
			receptionistTableSP.setBounds(350,100,400,150);
			panel.add(receptionistTableSP);

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
	