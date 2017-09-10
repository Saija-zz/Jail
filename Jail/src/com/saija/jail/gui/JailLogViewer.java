package com.saija.jail.gui;

import javax.swing.JInternalFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.nio.*;

public class JailLogViewer extends JInternalFrame {
	
	
	public JailLogViewer(String titulo) {
		super(titulo, true, true, true, true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension screenSizeHalf = new Dimension((int)screenSize.getWidth() / 2, (int)screenSize.getHeight() / 2);
		
		setSize(screenSizeHalf);
		setVisible(true);
	} 
	
	

}
