package umu.tds.myvideoapp.vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import tds.video.VideoWeb;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class VistaVideo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVideo window = new VistaVideo();
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
	public VistaVideo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setMinimumSize(new Dimension(60, 0));
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 0, 60, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		VideoWeb videoWeb = new VideoWeb();
		GridBagConstraints gbc_videoWeb = new GridBagConstraints();
		gbc_videoWeb.insets = new Insets(0, 0, 5, 5);
		gbc_videoWeb.fill = GridBagConstraints.BOTH;
		gbc_videoWeb.gridx = 1;
		gbc_videoWeb.gridy = 1;
		frame.getContentPane().add(videoWeb, gbc_videoWeb);
		
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		frame.getContentPane().add(panel, gbc_panel);
		
		JButton btnReproducir = new JButton("Reproducir");
		panel.add(btnReproducir);
		
		JButton btnParar = new JButton("Parar");
		panel.add(btnParar);
		btnParar.setMinimumSize(new Dimension(122, 29));
		btnParar.setMaximumSize(new Dimension(122, 29));
		btnParar.setPreferredSize(new Dimension(122, 29));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {

			}
		});
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{30, 420, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 0;
		panel_1.add(lblNombre, gbc_lblNombre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblVisitas = new JLabel("20 visitas");
		lblVisitas.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblVisitas = new GridBagConstraints();
		gbc_lblVisitas.insets = new Insets(0, 0, 0, 5);
		gbc_lblVisitas.gridx = 0;
		gbc_lblVisitas.gridy = 0;
		panel_2.add(lblVisitas, gbc_lblVisitas);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		
		JLabel lblmusic = new JLabel("#Music");
		lblmusic.setForeground(new Color(0, 153, 204));
		panel_3.add(lblmusic);
		
		JLabel lblbejo = new JLabel("#Bejo");
		lblbejo.setForeground(new Color(0, 153, 204));
		panel_3.add(lblbejo);
		btnReproducir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				videoWeb.playVideo("https://www.youtube.com/watch?v=ATkyIB8JcTY");
			}
		});
		frame.setBounds(100, 100, 500, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
