package umu.tds.myvideoapp.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

public class JPanelRecientes extends JPanelListaVideos{

	
	public JPanelRecientes(String tituloLista, AppFrame padre) {
		super(tituloLista, padre);
	}

	@Override
	protected void createButtonPanel(String tituloLista, AppFrame padre) {
		setPanelBotones(new JPanel());
		getPanelBotones().setBackground(new Color(51, 51, 51));
		
		JButton btnVolver = new JButton("Volver a explorar");
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				padre.volverAExplorar();
			}
		});
		getPanelBotones().add(btnVolver);
		
		add(getPanelBotones(), BorderLayout.SOUTH);
	}

	@Override
	protected JLabel[][] getVideosData() {
		return ControladorMyVideoApp.getUnicaInstancia().recientesToArray();
	}

}
