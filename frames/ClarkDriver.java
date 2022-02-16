package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ClarkDriver extends JFrame implements ActionListener
{
	private JLabel driverIdLabel, driverNameLabel,driverSalaryLabel, phoneLabel,joinDateLabel,driverLicenceLabel;
	private JTextField driverIdTF, driverNameTF,driverSalaryTF, phoneTF,joinDateTF,driverLicenceTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable driverTable;
	private JScrollPane driverTableSP;

	private User u;
	private ClerkRepo cr;
	
	
	public ClarkDriver(User u)
	{
		super("Car Rental System - Manage Driver");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u=u;
		cr = new ClerkRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "","","" }};
		
		String head[] = {"Id", "Name", "Salary", "Phone","Join Date", "Licence No"};
		
		driverTable = new JTable(data,head);
		driverTableSP = new JScrollPane(driverTable);
		driverTableSP.setBounds(350, 100, 400, 150);
		driverTable.setEnabled(false);
		panel.add(driverTableSP);
		
		driverIdLabel = new JLabel("ID :");
		driverIdLabel.setBounds(100,100,100,30);
		panel.add(driverIdLabel);
		
		driverIdTF = new JTextField();
		driverIdTF.setBounds(220,100,100,30);
		panel.add(driverIdTF);
		
		driverNameLabel = new JLabel("NAME :");
		driverNameLabel.setBounds(100,150,100,30);
		panel.add(driverNameLabel);
		
		driverNameTF = new JTextField();
		driverNameTF.setBounds(220,150,100,30);
		panel.add(driverNameTF);
		
		driverSalaryLabel = new JLabel("SALARY : ");
		driverSalaryLabel.setBounds(100,200,100,30);
		panel.add(driverSalaryLabel);
		
	    driverSalaryTF = new JTextField();
		driverSalaryTF.setBounds(220,200,100,30);
		panel.add(driverSalaryTF);
		
		phoneLabel = new JLabel("PHONE NO: ");
		phoneLabel.setBounds(100,250,100,30);
		panel.add(phoneLabel);
		
		phoneTF = new JTextField();
		phoneTF.setBounds(220,250,100,30);
		panel.add(phoneTF);
		
		joinDateLabel = new JLabel("JOIN DATE: ");
		joinDateLabel.setBounds(100,300,100,30);
		panel.add(joinDateLabel);
		
		joinDateTF = new JTextField();
		joinDateTF.setBounds(220,300,100,30);
		panel.add(joinDateTF);
		
		driverLicenceLabel = new JLabel("LICENCE No: ");
		driverLicenceLabel.setBounds(100,350,100,30);
		panel.add(driverLicenceLabel);
		
		driverLicenceTF = new JTextField();
		driverLicenceTF.setBounds(220,350,100,30);
		panel.add(driverLicenceTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,400,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,400,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,400,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,400,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,400,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 400, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

		if(command.equals(loadBtn.getText()))
		{
           if (!driverIdTF.getText().equals("")||!driverIdTF.getText().equals(null))
           {
           	   Driver d = cr.searchDriver(driverIdTF.getText());
           	   if(d!=null)
           	   {
           	   	driverNameTF.setText(d.getDriverName());
                driverSalaryTF.setText(d.getDriverSalary()+"");
                phoneTF.setText(d.getDriverPhone()+"");
                joinDateTF.setText(d.getDriverJoinDate());
                driverLicenceTF.setText(d.getDrivingLicence());

                driverIdTF.setEnabled(false);
                driverNameTF.setEnabled(true);
                driverSalaryTF.setEnabled(true);
                phoneTF.setEnabled(true);
                joinDateTF.setEnabled(true);
                driverLicenceTF.setEnabled(true);

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
			Driver d = new Driver();

			d.setDriverId(driverIdTF.getText());
			d.setDriverName(driverNameTF.getText());
			d.setDriverSalary(Double.parseDouble(driverSalaryTF.getText()));
			d.setDriverPhone(Integer.parseInt(phoneTF.getText()));
			d.setDriverJoinDate(joinDateTF.getText());
			d.setDrivingLicence(driverLicenceTF.getText());


			cr.addDriver(d);

			JOptionPane.showMessageDialog(this,"Inserted !");

			driverIdTF.setText("");
			driverNameTF.setText("");
			driverSalaryTF.setText("");
			phoneTF.setText("");
			joinDateTF.setText("");
			driverLicenceTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Driver d = new Driver();

			d.setDriverId(driverIdTF.getText());
			d.setDriverName(driverNameTF.getText());
			d.setDriverSalary(Double.parseDouble(driverSalaryTF.getText()));
			d.setDriverPhone(Integer.parseInt(phoneTF.getText()));
			d.setDriverJoinDate(joinDateTF.getText());
			d.setDrivingLicence(driverLicenceTF.getText());

			cr.updateDriverInfo(d);

			JOptionPane.showMessageDialog(this,"Updated !");

			driverIdTF.setText("");
			driverNameTF.setText("");
			driverSalaryTF.setText("");
			phoneTF.setText("");
			joinDateTF.setText("");
			driverLicenceTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			driverIdTF.setEnabled(true);
			driverNameTF.setEnabled(true);
			driverSalaryTF.setEnabled(true);
			phoneTF.setEnabled(true);
			joinDateTF.setEnabled(true);
			driverLicenceTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			cr.deleteDriver(driverIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			driverIdTF.setText("");
			driverNameTF.setText("");
			driverSalaryTF.setText("");
			phoneTF.setText("");
			joinDateTF.setText("");
			driverLicenceTF.setText("");

			driverIdTF.setEnabled(true);
			driverNameTF.setEnabled(true);
			driverSalaryTF.setEnabled(true);
			phoneTF.setEnabled(true);
			joinDateTF.setEnabled(true);
			driverLicenceTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			driverIdTF.setText("");
			driverNameTF.setText("");
			driverSalaryTF.setText("");
			phoneTF.setText("");
			joinDateTF.setText("");
			driverLicenceTF.setText("");

			driverIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getDriverUpdate();
			String head[] = {"Id", "Name", "Salary", "Phone","Join Date", "Licence No"};

			panel.remove(driverTableSP);

			driverTable = new JTable(data,head);
			driverTable.setEnabled(false);
			driverTableSP = new JScrollPane(driverTable);
			driverTableSP.setBounds(350,100,400,150);
			panel.add(driverTableSP);

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