package com.saija.jail.gui.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;

import com.saija.jail.gui.JailLogViewer;


public class CargarAction implements ActionListener{
	private JDesktopPane desktop;
	
	public CargarAction(JDesktopPane desktop){
		this.desktop = desktop;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JFileChooser chooser = new JFileChooser();
		JailLogViewer fInterno = null; 
		
		System.out.println("CargarAction... " + new Date());
		
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			
			boolean resizable = true, closable = true, maximizable = true;
			String titulo = chooser.getSelectedFile().getName();
			fInterno = new JailLogViewer(titulo);
			
			desktop.add(fInterno);
		}
		
	}

}
