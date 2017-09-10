package com.saija.jail.main;

import javax.swing.SwingUtilities;

import com.saija.jail.gui.JailViewer;

public class Jail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		    	  new JailViewer();
		      }
		    });
		
		
	}

}
