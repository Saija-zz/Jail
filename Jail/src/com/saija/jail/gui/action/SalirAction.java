package com.saija.jail.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class SalirAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("SalirAction... " + new Date());
		System.exit(0);
	}

}
