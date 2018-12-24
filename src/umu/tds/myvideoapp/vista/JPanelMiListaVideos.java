package umu.tds.myvideoapp.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

public class JPanelMiListaVideos extends JPanelListaVideos {

	
	private static final long serialVersionUID = 1L;

	public JPanelMiListaVideos(String tituloLista, AppFrame padre) {
		super(tituloLista, padre);
	}

	@Override
	protected void createButtonPanel(String tituloLista, AppFrame padre) {
		setPanelBotones(new JPanel());
		getPanelBotones().setBackground(new Color(51, 51, 51));
		
		JButton btnVolver = new JButton("Volver a explorar");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				padre.volverAExplorar();
			}
		});
		getPanelBotones().add(btnVolver);
		
		JButton btnBorrar = new JButton("Borrar lista");
		btnBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(padre, "¿Seguro que quiere borrar esta lista?") == 0) {
					padre.borrarLista(tituloLista);
				}
			}
		});
		getPanelBotones().add(btnBorrar);
		
		JButton btnPlay = new JButton("Play all");
		btnPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*****
				String tiempo = (JOptionPane.showInputDialog(padre,
						"¿Cuantos sugundos por video?", "Play all", JOptionPane.QUESTION_MESSAGE));
			
				if(tiempo != null && !tiempo.equals("")) {
					int intTiempo = 0;
					try {
						intTiempo = Integer.parseInt(tiempo);
					} catch (Exception e2) {
						return;
					}
					for (Video video : ControladorMyVideoApp.getUnicaInstancia().getVideosLista(tituloLista)) {
						
						removeAll();

						add(getPanelTituloLista(), BorderLayout.NORTH);
						JLabel etiq = new JLabel(video.getTitulo());
						etiq.setName(video.getUrl());
						add(createVistaVideo(etiq), BorderLayout.CENTER);
						
						revalidate();
						repaint();
						
						
					}

					
				}
				*/
			}
		});
		getPanelBotones().add(btnPlay);

		add(getPanelBotones(), BorderLayout.SOUTH);
	}

	@Override
	protected JLabel[][] getVideosData() {
		return ControladorMyVideoApp.getUnicaInstancia().videosToArray(getTituloLista());
	}
	
}
