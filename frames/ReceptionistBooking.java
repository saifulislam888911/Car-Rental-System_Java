package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ReceptionistBooking extends JFrame implements ActionListener
{
	private JLabel carIdLabel,reservationLabel;
	private JTextField carIdTF,reservationTF;
	private JButton refreshBtn,bookBtn, backBtn,loadBtn,getAllBtn;
	private JPanel panel;
	private JTable carTable;
	private JScrollPane carTableSP;

	private User u;
	private ReceptionistRepo rr;
	
	
	public ReceptionistBooking(User u)
	{
		super("Car Rental System - Booking Car");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u = u;
		rr = new ReceptionistRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "","" }};
		
		String head[] = {"Id", "Brand", "Reservation Status","No Of Seat"};
		
		carTable = new JTable(data,head);
		carTableSP = new JScrollPane(carTable);
		carTableSP.setBounds(350, 100, 400, 150);
		carTable.setEnabled(false);
		panel.add(carTableSP);
		
		
		carIdLabel = new JLabel("ID :");
		carIdLabel.setBounds(100,150,100,30);
		panel.add(carIdLabel);
		
		carIdTF = new JTextField();
		carIdTF.setBounds(220,150,100,30);
		panel.add(carIdTF);
		
		reservationLabel = new JLabel("RESERVATION STATUS : ");
		reservationLabel.setBounds(100,200,100,30);
		panel.add(reservationLabel);
		
		reservationTF = new JTextField();
		reservationTF.setBounds(220,200,100,30);
		panel.add(reservationTF);
		
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,350,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		bookBtn = new JButton("Book");
		bookBtn.setBounds(300,350,80,30);
		bookBtn.addActionListener(this);
		panel.add(bookBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,350,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);

		getAllBtn = new JButton("All Car");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
    {
    	String command = ae.getActionCommand();

		if(command.equals(loadBtn.getText()))
		{
           if (!carIdTF.getText().equals("")||!carIdTF.getText().equals(null))
           {
           	   Car c = rr.searchCar(carIdTF.getText());
           	   if(c!=null)
           	   {
           	   	//carBrandTF.setText(c.getBrand());
                //carLicenceTF.setText(c.getCarLicence());
                reservationTF.setText(c.getReservationStatus());
                //carTypeTF.setText(c.getCarType());
                //carSeatTF.setText(c.getNumberOfSeat()+"");

                //carIdTF.setEnabled(false);
                //carBrandTF.setEnabled(true);
                //carLicenceTF.setEnabled(true);
                reservationTF.setEnabled(true);
                //carTypeTF.setEnabled(true);
                //carSeatTF.setEnabled(true);

                loadBtn.setEnabled(false);
                bookBtn.setEnabled(true);
                refreshBtn.setEnabled(true);

           	   }
           	   else
           	   {
           	   	JOptionPane.showMessageDialog(this,"Invalid Id !");
           	   }
           }
		}

		else if (command.equals(bookBtn.getText()))
		{
			Car c = new Car();

			c.setCarId(carIdTF.getText());
			//c.setBrand(carBrandTF.getText());
			//c.setCarLicence(carLicenceTF.getText());
			c.setReservationStatus(reservationTF.getText());
			//c.setCarType(carTypeTF.getText());
			//c.setNumberOfSeat(Integer.parseInt(carSeatTF.getText()));

			rr.updateCarInfo(c);

			JOptionPane.showMessageDialog(this,"Booked !");

			carIdTF.setText("");
			reservationTF.setText("");

			loadBtn.setEnabled(true);
			bookBtn.setEnabled(false);
			refreshBtn.setEnabled(false);

			carIdTF.setEnabled(true);
			reservationTF.setEnabled(true);
		}

		else if (command.equals(refreshBtn.getText()))
		{
			carIdTF.setText("");
			reservationTF.setText("");

			carIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			bookBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}

		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = rr.getCarDetails();
			String head[] = {"Id", "Brand","Reservation Status", "Seat"};

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
			ReceptionistHome rh = new ReceptionistHome(u);
			rh.setVisible(true);
			this.setVisible(false);
		}
		else{}
    }	
}