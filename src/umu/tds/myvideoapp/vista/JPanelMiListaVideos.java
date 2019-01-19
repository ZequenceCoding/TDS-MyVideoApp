package umu.tds.myvideoapp.vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.Video;

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
				if (JOptionPane.showConfirmDialog(padre, "¿Seguro que quiere borrar esta lista?") == 0) {
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
				String tiempo = (JOptionPane.showInputDialog(padre, "¿Cuantos sugundos por video?", "Play all",
						JOptionPane.QUESTION_MESSAGE));

				int intTiempo = 0;
				try {
					intTiempo = Integer.parseInt(tiempo);
				} catch (Exception e2) {
					return;
				}

				reproduceTodos(tituloLista, null, intTiempo);

			}

			private void reproduceTodos(String tituloLista, Video v, int tiempo) {

				Video video = ControladorMyVideoApp.getUnicaInstancia().getSigVideo(tituloLista, v);
				if (video != null) {
					removeAll();

					JLabel etiq = new JLabel(video.getTitulo());
					etiq.setName(video.getUrl());
					add(getPanelTituloLista(), BorderLayout.NORTH);
					add(createVistaVideo(etiq), BorderLayout.CENTER);
					ControladorMyVideoApp.getUnicaInstancia().verVideo(video.getUrl());

					revalidate();
					repaint();

					ActionListener actionListener = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							reproduceTodos(tituloLista, video, tiempo);
						}
					};

					padre.setTimer(tiempo, actionListener);
				} else {
					removeAll();
					ControladorMyVideoApp.getUnicaInstancia().stopVideo();

					add(getPanelTituloLista(), BorderLayout.NORTH);
					generateTableVideos();
					add(getScrollPanel(), BorderLayout.CENTER);
					add(getPanelBotones(), BorderLayout.SOUTH);

					revalidate();
					repaint();

				}
			}

		});
		getPanelBotones().add(btnPlay);

		add(getPanelBotones(), BorderLayout.SOUTH);
	}

	@Override
	protected JLabel[][] getVideosData() {
		return ControladorMyVideoApp.getUnicaInstancia().videosToArray(getTituloLista());
	}

	@Override
	protected void volverVideo() {
		getPadre().stopTimer();
	}

}
