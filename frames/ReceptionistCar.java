package frames;


import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import entity.*;
import repository.*;

public class ReceptionistCar extends JFrame implements ActionListener
{
	private JButton getAllBtn, backBtn;
	private JPanel panel;
	private JTable carTable;
	private JScrollPane carTableSP;

	private User u;
	private ReceptionistRepo rr;
	
	
	public ReceptionistCar(User u)
	{
		super("Car Rental System - Car Status");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.u=u;
		rr = new ReceptionistRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", "" }};
		
		String head[] = {"Id", "Brand","Reservation Status","No Of Seat"};
		
		carTable = new JTable(data,head);
		carTableSP = new JScrollPane(carTable);
		carTableSP.setBounds(350, 100, 400, 150);
		carTable.setEnabled(false);
		panel.add(carTableSP);
		
		
		getAllBtn = new JButton("GetCarStatus!");
		getAllBtn.setBounds(100,100,100,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(100, 150, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();

	 if(command.equals(getAllBtn.getText()))
		{
			String data[][] = rr.getReservationStatus();
			String head[] = {"Id", "Brand","Reservation Status","No Of Seat"};

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
