package umu.tds.myvideoapp.vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.Cell;
import javafx.scene.layout.Border;
import tds.video.VideoWeb;
import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.CatalogoVideos;
import umu.tds.myvideoapp.dominio.Etiqueta;
import umu.tds.myvideoapp.dominio.Video;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
		btnVolver.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				padre.volverAExplorar();
			}
		});
		getPanelBotones().add(btnVolver);
		
		JButton btnBorrar = new JButton("Borrar lista");
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(padre, "¿Seguro que quiere borrar esta lista?") == 0) {
					padre.borrarLista(tituloLista);
				}
			}
		});
		getPanelBotones().add(btnBorrar);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
