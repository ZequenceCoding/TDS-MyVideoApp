package umu.tds.myvideoapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JCheckBox;

public class VentanaListas {

	private JFrame frame;
	private static String url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListas window = new VentanaListas(url);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaListas(String _url) {
		url = _url;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.getContentPane().setMinimumSize(new Dimension(200, 0));
		frame.getContentPane().setMaximumSize(new Dimension(200, 2147483647));
		frame.setSize(new Dimension(210, 308));
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 10));
		panel.setBackground(new Color(51, 51, 51));
		
		LinkedList<JCheckBox> list = ControladorMyVideoApp.getUnicaInstancia().getAnadirA(url);
		for (JCheckBox jCheckBox : list) {
			jCheckBox.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ControladorMyVideoApp.getUnicaInstancia().anadirVideoALista(url, jCheckBox.getName());
					
				}
			});
			panel.add(jCheckBox);
		}
		
		scrollPane.setViewportView(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void setVisible() {
		frame.setVisible(true);
		
	}

}
