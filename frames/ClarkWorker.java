package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkWorker extends JFrame implements ActionListener
{
	private JLabel workerIdLabel, workerNameLabel,workerSalaryLabel,joinDateLabel;
	private JTextField workerIdTF, workerNameTF,workerSalaryTF,joinDateTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable workerTable;
	private JScrollPane workerTableSP;

	private User u;
	private ClerkRepo cr;
	
	
	public ClarkWorker(User u)
	{
		super("Car Rental System - Manage Worker");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u=u;
		cr = new ClerkRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "" }};
		
		String head[] = {"Id", "Name", "Salary","Join Date"};
		
		workerTable = new JTable(data,head);
		workerTableSP = new JScrollPane(workerTable);
		workerTableSP.setBounds(350, 100, 400, 150);
		workerTable.setEnabled(false);
		panel.add(workerTableSP);
		
		workerIdLabel = new JLabel("ID :");
	    workerIdLabel.setBounds(100,100,100,30);
		panel.add(workerIdLabel);
		
		workerIdTF = new JTextField();
		workerIdTF.setBounds(220,100,100,30);
		panel.add(workerIdTF);
		
		workerNameLabel = new JLabel("NAME :");
		workerNameLabel.setBounds(100,150,100,30);
		panel.add(workerNameLabel);
		
		workerNameTF = new JTextField();
		workerNameTF.setBounds(220,150,100,30);
		panel.add(workerNameTF);
		
		workerSalaryLabel = new JLabel("SALARY : ");
		workerSalaryLabel.setBounds(100,200,100,30);
		panel.add(workerSalaryLabel);
		
	    workerSalaryTF = new JTextField();
		workerSalaryTF.setBounds(220,200,100,30);
		panel.add(workerSalaryTF);
		
		
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
           if (!workerIdTF.getText().equals("")||!workerIdTF.getText().equals(null))
           {
           	   Worker w = cr.searchWorker(workerIdTF.getText());
           	   if(w!=null)
           	   {
           	   	workerNameTF.setText(w.getWorkerName());
                workerSalaryTF.setText(w.getWorkerSalary()+"");
                joinDateTF.setText(w.getWorkerJoinDate());

                workerIdTF.setEnabled(false);
                workerNameTF.setEnabled(true);
                workerSalaryTF.setEnabled(true);
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
			Worker w = new Worker();

			w.setWorkerId(workerIdTF.getText());
			w.setWorkerName(workerNameTF.getText());
			w.setWorkerSalary(Double.parseDouble(workerSalaryTF.getText()));
			w.setWorkerJoinDate(joinDateTF.getText());


			cr.addWorker(w);

			JOptionPane.showMessageDialog(this,"Inserted !");

			workerIdTF.setText("");
			workerNameTF.setText("");
			workerSalaryTF.setText("");
			joinDateTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Worker w = new Worker();

			w.setWorkerId(workerIdTF.getText());
			w.setWorkerName(workerNameTF.getText());
			w.setWorkerSalary(Double.parseDouble(workerSalaryTF.getText()));
			w.setWorkerJoinDate(joinDateTF.getText());

			cr.updateWorkerInfo(w);

			JOptionPane.showMessageDialog(this,"Updated !");

			workerIdTF.setText("");
			workerNameTF.setText("");
			workerSalaryTF.setText("");
			joinDateTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			workerIdTF.setEnabled(true);
			workerNameTF.setEnabled(true);
			workerSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			cr.deleteWorker(workerIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			workerIdTF.setText("");
			workerNameTF.setText("");
			workerSalaryTF.setText("");
			joinDateTF.setText("");

			workerIdTF.setEnabled(true);
			workerNameTF.setEnabled(true);
			workerSalaryTF.setEnabled(true);
			joinDateTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			workerIdTF.setText("");
			workerNameTF.setText("");
			workerSalaryTF.setText("");
			joinDateTF.setText("");

			workerIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getWorkerUpdate();
			String head[] = {"Id", "Name", "Salary","Join Date"};

			panel.remove(workerTableSP);

			workerTable = new JTable(data,head);
			workerTable.setEnabled(false);
			workerTableSP = new JScrollPane(workerTable);
			workerTableSP.setBounds(350,100,400,150);
			panel.add(workerTableSP);

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