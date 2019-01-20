package umu.tds.myvideoapp.vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import tds.video.VideoWeb;
import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Cursor;

public class BirthdayFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BirthdayFrame window = new BirthdayFrame();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BirthdayFrame() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setMinimumSize(new Dimension(60, 0));
		getFrame().getContentPane().setBackground(new Color(51, 51, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{60, 0, 60, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getFrame().getContentPane().setLayout(gridBagLayout);
		
		VideoWeb videoWeb = ControladorMyVideoApp.getUnicaInstancia().getVideoWeb();
		GridBagConstraints gbc_videoWeb = new GridBagConstraints();
		gbc_videoWeb.insets = new Insets(0, 0, 5, 5);
		gbc_videoWeb.fill = GridBagConstraints.BOTH;
		gbc_videoWeb.gridx = 1;
		gbc_videoWeb.gridy = 1;
		getFrame().getContentPane().add(videoWeb, gbc_videoWeb);
		
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		getFrame().getContentPane().add(panel, gbc_panel);
		
		JLabel lblElEquipoDe = new JLabel("El equipo de MyVideoApp te desea un feliz cumplea\u00F1os :)");
		lblElEquipoDe.setForeground(Color.WHITE);
		panel.add(lblElEquipoDe);
		
		JButton btnGracias = new JButton("Gracias");
		btnGracias.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGracias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ControladorMyVideoApp.getUnicaInstancia().stopVideo();
				frame.dispose();
			}
		});
		GridBagConstraints gbc_btnGracias = new GridBagConstraints();
		gbc_btnGracias.insets = new Insets(0, 0, 0, 5);
		gbc_btnGracias.gridx = 1;
		gbc_btnGracias.gridy = 4;
		frame.getContentPane().add(btnGracias, gbc_btnGracias);
		
		frame.setVisible(true);
		ControladorMyVideoApp.getUnicaInstancia().verVideoCumple();

		getFrame().setBounds(100, 100, 500, 397);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setUndecorated(true);
	}

}
