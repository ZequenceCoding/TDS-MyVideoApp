package umu.tds.myvideoapp.vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.Etiqueta;

import java.awt.Dimension;
import javax.swing.JButton;

public class VentanaEtiquetas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEtiquetas window = new VentanaEtiquetas();
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
	public VentanaEtiquetas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setMinimumSize(new Dimension(300, 0));
		frame.getContentPane().setMaximumSize(new Dimension(300, 2147483647));
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(300, 0));
		scrollPane.setPreferredSize(new Dimension(300, 4));
		scrollPane.setMinimumSize(new Dimension(300, 23));
		scrollPane.setMaximumSize(new Dimension(300, 32767));
		frame.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setMinimumSize(new Dimension(300, 10));
		panel.setSize(new Dimension(300, 0));
		panel.setPreferredSize(new Dimension(300, 10));
		panel.setMaximumSize(new Dimension(300, 32767));
		for (Etiqueta etiqueta : ControladorMyVideoApp.getUnicaInstancia().getEtiquetas()) {
			JCheckBox checkBoxEtiqueta = new JCheckBox(etiqueta.getNombre());
			checkBoxEtiqueta.setSelected(ControladorMyVideoApp.getUnicaInstancia().isEtiquetasSeleccionada(etiqueta.getNombre()));
			checkBoxEtiqueta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ControladorMyVideoApp.getUnicaInstancia().etiquetaSeleccionada(etiqueta);
					
				}
			});
			//checkBoxEtiqueta.addAction
			panel.add(checkBoxEtiqueta);
		}
		scrollPane.setViewportView(panel);
		frame.setBounds(100, 100, 300, 364);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

}
