package frames;


import java.lang.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import entity.*;
import repository.*;

public class ManagerCar extends JFrame implements ActionListener
{
	private JLabel carIdLabel, carBrandLabel,carTypeLabel,reservationLabel, carSeatLabel,carLicenceLabel;
	private JTextField carIdTF, carBrandTF,carTypeTF, carSeatTF,carLicenceTF,reservationTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable carTable;
	private JScrollPane carTableSP;

	private ManagerRepo mr;
	private User u;
	
	
	public ManagerCar(User u)
	{
		super("Car Rental System - Manage Car");
		this.setSize(900,550);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        mr = new ManagerRepo();
        this.u=u;

		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "","","" }};
		
		String head[] = {"Id", "Brand","Licence No","Reservation Status","Type", "Seat"};
		
		carTable = new JTable(data,head);
		carTableSP = new JScrollPane(carTable);
		carTableSP.setBounds(350, 100, 500, 200);
		carTable.setEnabled(false);
		panel.add(carTableSP);
		
		carIdLabel = new JLabel("ID :");
		carIdLabel.setBounds(100,100,100,30);
		panel.add(carIdLabel);
		
		carIdTF = new JTextField();
		carIdTF.setBounds(220,100,100,30);
		panel.add(carIdTF);
		
		carBrandLabel = new JLabel("BRAND :");
		carBrandLabel.setBounds(100,150,100,30);
		panel.add(carBrandLabel);
		
		carBrandTF = new JTextField();
		carBrandTF.setBounds(220,150,100,30);
		panel.add(carBrandTF);
		
		carLicenceLabel = new JLabel("LICENCE NO : ");
		carLicenceLabel.setBounds(100,200,100,30);
		panel.add(carLicenceLabel);
		
		carLicenceTF = new JTextField();
		carLicenceTF.setBounds(220,200,100,30);
		panel.add(carLicenceTF);
		
		reservationLabel = new JLabel("RESERVATION: ");
		reservationLabel.setBounds(100,250,100,30);
		panel.add(reservationLabel);
		
		reservationTF = new JTextField();
		reservationTF.setBounds(220,250,100,30);
		panel.add(reservationTF);
		
		carTypeLabel = new JLabel("CAR TYPE: ");
		carTypeLabel.setBounds(100,300,100,30);
		panel.add(carTypeLabel);
		
		carTypeTF = new JTextField();
		carTypeTF.setBounds(220,300,100,30);
		panel.add(carTypeTF);
		
		carSeatLabel = new JLabel("CAR SEAT: ");
		carSeatLabel.setBounds(100,350,100,30);
		panel.add(carSeatLabel);
		
		carSeatTF = new JTextField();
		carSeatTF.setBounds(220,350,100,30);
		panel.add(carSeatTF);
		
		
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
		getAllBtn.setBounds(540,320,80,30);
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
           if (!carIdTF.getText().equals("")||!carIdTF.getText().equals(null))
           {
           	   Car c = mr.searchCar(carIdTF.getText());
           	   if(c!=null)
           	   {
           	   	carBrandTF.setText(c.getBrand());
                carLicenceTF.setText(c.getCarLicence());
                reservationTF.setText(c.getReservationStatus());
                carTypeTF.setText(c.getCarType());
                carSeatTF.setText(c.getNumberOfSeat()+"");

                carIdTF.setEnabled(false);
                carBrandTF.setEnabled(true);
                carLicenceTF.setEnabled(true);
                reservationTF.setEnabled(true);
                carTypeTF.setEnabled(true);
                carSeatTF.setEnabled(true);

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
			Car c = new Car();

			c.setCarId(carIdTF.getText());
			c.setBrand(carBrandTF.getText());
			c.setCarLicence(carLicenceTF.getText());
			c.setReservationStatus(reservationTF.getText());
			c.setCarType(carTypeTF.getText());
			c.setNumberOfSeat(Integer.parseInt(carSeatTF.getText()));


			mr.addCar(c);

			JOptionPane.showMessageDialog(this,"Inserted !");

			carIdTF.setText("");
			carBrandTF.setText("");
			carLicenceTF.setText("");
			reservationTF.setText("");
			carTypeTF.setText("");
			carSeatTF.setText("");


			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(updateBtn.getText()))
		{
			Car c = new Car();

			c.setCarId(carIdTF.getText());
			c.setBrand(carBrandTF.getText());
			c.setCarLicence(carLicenceTF.getText());
			c.setReservationStatus(reservationTF.getText());
			c.setCarType(carTypeTF.getText());
			c.setNumberOfSeat(Integer.parseInt(carSeatTF.getText()));

			mr.updateCarInfo(c);

			JOptionPane.showMessageDialog(this,"Updated !");

			carIdTF.setText("");
			carBrandTF.setText("");
			carLicenceTF.setText("");
			reservationTF.setText("");
			carTypeTF.setText("");
			carSeatTF.setText("");

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			carIdTF.setEnabled(true);
			carBrandTF.setEnabled(true);
			carLicenceTF.setEnabled(true);
			reservationTF.setEnabled(true);
			carTypeTF.setEnabled(true);
			carSeatTF.setEnabled(true);
		}
		else if (command.equals(deleteBtn.getText()))
		{
			mr.deleteCar(carIdTF.getText());

			JOptionPane.showMessageDialog(this,"Deleted !");

			carIdTF.setText("");
			carBrandTF.setText("");
			carLicenceTF.setText("");
			reservationTF.setText("");
			carTypeTF.setText("");
			carSeatTF.setText("");

			carIdTF.setEnabled(true);
			carBrandTF.setEnabled(true);
			carLicenceTF.setEnabled(true);
			reservationTF.setEnabled(true);
			carTypeTF.setEnabled(true);
			carSeatTF.setEnabled(true);

			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			carIdTF.setText("");
			carBrandTF.setText("");
			carLicenceTF.setText("");
			reservationTF.setText("");
			carTypeTF.setText("");
			carSeatTF.setText("");

			carIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getCarDetails();
			String head[] = {"Id", "Brand","Licence No","Reservation Status","Type", "Seat"};

			panel.remove(carTableSP);

			carTable = new JTable(data,head);
			carTable.setEnabled(false);
			carTableSP = new JScrollPane(carTable);
			carTableSP.setBounds(350,100,400,150);
			panel.add(carTableSP);

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