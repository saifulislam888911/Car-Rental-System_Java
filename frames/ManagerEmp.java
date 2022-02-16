package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ManagerEmp extends JFrame implements ActionListener
{
	private JLabel EmpIdLabel, EmpNameLabel,EmpSalaryLabel, JobTypeLabel,JoinDateLabel;
	private JTextField EmpIdTF, EmpNameTF,EmpSalaryTF, JobTypeTF,JoinDateTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable EmpTable;
	private JScrollPane EmpTableSP;

	private User u;
	private ManagerRepo mr;
	
	
	public ManagerEmp(User u)
	{
		super("Car Rental System - Manage Employee");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        mr = new ManagerRepo();

        this.u=u;

		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "","" }};
		
		String head[] = {"Id", "Name", "Salary", "Jobe Type","Join Date"};
		
		EmpTable = new JTable(data,head);
		EmpTableSP = new JScrollPane(EmpTable);
		EmpTableSP.setBounds(350, 100, 400, 150);
		EmpTable.setEnabled(false);
		panel.add(EmpTableSP);
		
		EmpIdLabel = new JLabel("ID :");
		EmpIdLabel.setBounds(100,100,100,30);
		panel.add(EmpIdLabel);
		
		EmpIdTF = new JTextField();
		EmpIdTF.setBounds(220,100,100,30);
		panel.add(EmpIdTF);
		
		EmpNameLabel = new JLabel("NAME :");
		EmpNameLabel.setBounds(100,150,100,30);
		panel.add(EmpNameLabel);
		
		EmpNameTF = new JTextField();
		EmpNameTF.setBounds(220,150,100,30);
		panel.add(EmpNameTF);
		
		EmpSalaryLabel = new JLabel("SALARY : ");
		EmpSalaryLabel.setBounds(100,200,100,30);
		panel.add(EmpSalaryLabel);
		
	    EmpSalaryTF = new JTextField();
		EmpSalaryTF.setBounds(220,200,100,30);
		panel.add(EmpSalaryTF);
		
		JobTypeLabel = new JLabel("JOB TYPE: ");
		JobTypeLabel.setBounds(100,250,100,30);
		panel.add(JobTypeLabel);
		
		JobTypeTF = new JTextField();
		JobTypeTF.setBounds(220,250,100,30);
		panel.add(JobTypeTF);
		
		JoinDateLabel = new JLabel("JOIN DATE : ");
		JoinDateLabel.setBounds(100,300,100,30);
		panel.add(JoinDateLabel);
		
		JoinDateTF = new JTextField();
		JoinDateTF.setBounds(220,300,100,30);
		panel.add(JoinDateTF);
		
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
           if (!EmpIdTF.getText().equals("")||!EmpIdTF.getText().equals(null))
           {
           	   Employee e = mr.searchEmployee(EmpIdTF.getText());
           	   if(e!=null)
           	   {
           	   	EmpNameTF.setText(e.getEmployeeName());
                EmpSalaryTF.setText(e.getEmployeeSalary()+"");
                JobTypeTF.setText(e.getJobType());
                JoinDateTF.setText(e.getEmployeeJoinDate());

                EmpIdTF.setEnabled(false);
                EmpNameTF.setEnabled(true);
                EmpSalaryTF.setEnabled(true);
                JobTypeTF.setEnabled(true);
                JoinDateTF.setEnabled(true);

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
			Employee e = new Employee();

			e.setEmployeeId(EmpIdTF.getText());
			e.setEmployeeName(EmpNameTF.getText());
			e.setEmployeeSalary(Double.parseDouble(EmpSalaryTF.getText()));
			e.setJobType(JobTypeTF.getText());
			e.setEmployeeJoinDate(JoinDateTF.getText());


			mr.addEmployee(e);

			JOptionPane.showMessageDialog(this,"Inserted !");

			EmpIdTF.setText("");
			EmpNameTF.setText("");
			EmpSalaryTF.setText("");
			JobTypeTF.setText("");
			JoinDateTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Employee e = new Employee();

			e.setEmployeeId(EmpIdTF.getText());
			e.setEmployeeName(EmpNameTF.getText());
			e.setEmployeeSalary(Double.parseDouble(EmpSalaryTF.getText()));
			e.setJobType(JobTypeTF.getText());
			e.setEmployeeJoinDate(JoinDateTF.getText());

			mr.updateEmployee(e);

			JOptionPane.showMessageDialog(this,"Updated !");

			EmpIdTF.setText("");
			EmpNameTF.setText("");
			EmpSalaryTF.setText("");
			JobTypeTF.setText("");
			JoinDateTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			EmpIdTF.setEnabled(true);
			EmpNameTF.setEnabled(true);
			EmpSalaryTF.setEnabled(true);
			JobTypeTF.setEnabled(true);
			JoinDateTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			mr.deleteEmployee(EmpIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			EmpIdTF.setText("");
			EmpNameTF.setText("");
			EmpSalaryTF.setText("");
			JobTypeTF.setText("");
			JoinDateTF.setText("");

			EmpIdTF.setEnabled(true);
			EmpNameTF.setEnabled(true);
			EmpSalaryTF.setEnabled(true);
			JobTypeTF.setEnabled(true);
			JoinDateTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			EmpIdTF.setText("");
			EmpNameTF.setText("");
			EmpSalaryTF.setText("");
			JobTypeTF.setText("");
			JoinDateTF.setText("");

			EmpIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getAllEmployee();
			String head[] = {"Id", "Name", "Salary", "Job Type","Join Date"};

			panel.remove(EmpTableSP);

			EmpTable = new JTable(data,head);
			EmpTable.setEnabled(false);
			EmpTableSP = new JScrollPane(EmpTable);
			EmpTableSP.setBounds(350,100,400,150);
			panel.add(EmpTableSP);

			panel.revalidate();
			panel.repaint();
		}

		else if(command.equals(backBtn.getText()))
		{
			ManagerHome mh = new ManagerHome(u);
			mh.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
}