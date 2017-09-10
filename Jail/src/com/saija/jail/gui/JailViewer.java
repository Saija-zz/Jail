package com.saija.jail.gui;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

import org.pushingpixels.substance.api.skin.SubstanceGraphiteLookAndFeel;

import com.saija.jail.gui.action.CargarAction;
import com.saija.jail.gui.action.LookAndFeelAction;
import com.saija.jail.gui.action.SalirAction;

import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class JailViewer implements Observer {

	private JFrame frame;
	private JDesktopPane desktop;
	private String[] lookAndFeels;
	private HashMap<String, String> lookAndFeelsDisponibles;

	public JailViewer() {
		frame = new JFrame("Jail");
		desktop = new JDesktopPane();
		lookAndFeelsDisponibles = new HashMap<>();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel(new SubstanceGraphiteLookAndFeel());

			for (LookAndFeelInfo lyfInfo : UIManager.getInstalledLookAndFeels()) {
				System.out.println(lyfInfo.getClassName());
				lookAndFeelsDisponibles.put(lyfInfo.getName(), lyfInfo.getClassName());
			}

			lookAndFeels = new String[lookAndFeelsDisponibles.keySet().size()];
			lookAndFeelsDisponibles.keySet().toArray(lookAndFeels);

		}/*catch(Exception e) {
			e.printStackTrace();
		} */
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setJMenuBar(createMenus());
		frame.add(desktop, BorderLayout.CENTER);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

	private JMenuBar createMenus() {
		JMenuBar mBar = new JMenuBar();

		mBar.add(crearMenuLogs());
		mBar.add(crearMenuOpciones());

		return mBar;
	}

	private JMenu crearMenuLogs() {
		JMenu menuLogs = new JMenu("Logs");

		JMenuItem cargar = new JMenuItem("Cargar");
		cargar.addActionListener(new CargarAction(desktop));

		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new SalirAction());

		menuLogs.add(cargar);
		menuLogs.addSeparator();
		menuLogs.add(salir);

		return menuLogs;
	}

	private JMenu crearMenuOpciones() {
		JMenu menuLogs = new JMenu("Opciones");

		JMenuItem lyf = new JMenuItem("Look & Feel");
		lyf.addActionListener(new LookAndFeelAction(lookAndFeels, this));

		menuLogs.add(lyf);

		return menuLogs;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		String lookAndFeelSel = (String) arg1;
		
		System.out.println("update = " + arg0 + " -> " + lookAndFeelSel);
		
		try {
			UIManager.setLookAndFeel(lookAndFeelsDisponibles.get(lookAndFeelSel));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
