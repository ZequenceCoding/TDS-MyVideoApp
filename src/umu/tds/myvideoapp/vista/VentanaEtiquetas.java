package umu.tds.myvideoapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.Etiqueta;

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
		for (Etiqueta etiqueta : ControladorMyVideoApp.getUnicaInstancia().getEtiquetas()) {
			JCheckBox checkBoxEtiqueta = new JCheckBox(etiqueta.getNombre());
			checkBoxEtiqueta.setSelected(ControladorMyVideoApp.getUnicaInstancia().isEtiquetasSeleccionada(etiqueta.getNombre()));
			checkBoxEtiqueta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ControladorMyVideoApp.getUnicaInstancia().etiquetaSeleccionada(etiqueta);
					
				}
			});
			checkBoxEtiqueta.setForeground(Color.WHITE);
			panel.add(checkBoxEtiqueta);
		}

		scrollPane.setViewportView(panel);
		frame.setBounds(100, 100, 200, 308);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}

}
