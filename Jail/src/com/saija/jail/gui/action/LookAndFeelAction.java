package com.saija.jail.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class LookAndFeelAction extends Observable implements ActionListener {

	private String[] lookAndFeels;
	private String lookAndFeelSel;

	public LookAndFeelAction(String[] lookAndFeels, Observer observador) {
		this.lookAndFeels = lookAndFeels;
		System.out.println(countObservers());
		addObserver(observador);
		System.out.println(countObservers());
	}

	@Override
	public void actionPerformed(ActionEvent eventoAccion) {
		// TODO Auto-generated method stub
		System.out.println("LookAndFeelAction... " + new Date());

		
		lookAndFeelSel = (String) JOptionPane.showInputDialog(null, "Seleccione un Look & Feel", "Seleccione",
				JOptionPane.PLAIN_MESSAGE, null, lookAndFeels, lookAndFeels[0]);

		if (lookAndFeelSel != null && lookAndFeelSel.length() > 0) {
			System.out.println("CAMBIO_L&F");
			setChanged();
			notifyObservers(lookAndFeelSel);
		}

	}

}
