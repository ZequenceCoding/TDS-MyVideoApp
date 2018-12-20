package umu.tds.myvideoapp.vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;
import pulsador.IEncendidoListener;
import pulsador.Luz;
import tds.video.VideoWeb;
import umu.tds.componente.BuscadorVideos;
import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.Etiqueta;
import umu.tds.myvideoapp.dominio.FiltroAdultos;
import umu.tds.myvideoapp.dominio.FiltroImpopulares;
import umu.tds.myvideoapp.dominio.FiltroMisListas;
import umu.tds.myvideoapp.dominio.ITest;
import umu.tds.myvideoapp.dominio.NoFiltro;
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
import java.util.EventObject;
import java.util.List;
import java.awt.Cursor;

public class JPanelExplorar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPanel;
	private JPanel searchPanel;
	private JPanel contentPanel;

	private AppFrame padre;

	public JPanelExplorar(AppFrame padre) {

		this.padre = padre;

		setBackground(new Color(50, 50, 50));
		setLayout(new BorderLayout(0, 0));

		/*************************
		 * Panel de busqueda
		 ************************/
		searchPanel = new JPanel();
		searchPanel.setBackground(new Color(50, 50, 50));

		GridBagLayout gbl_searchPanel = new GridBagLayout(); // Creas el GridBagLayout para el panel de busqueda
		gbl_searchPanel.columnWidths = new int[] { 30, 232, 116, 116, 0, 0 };
		gbl_searchPanel.rowHeights = new int[] { 30, 24, 10, 27, 0 };
		gbl_searchPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_searchPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		searchPanel.setLayout(gbl_searchPanel);

		JTextField searchTextField = new JTextField(); // Campo de texto para buscar
		searchTextField.setBackground(new java.awt.Color(50, 50, 50));
		searchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		searchTextField.setForeground(new java.awt.Color(0, 153, 204));
		searchTextField.setHorizontalAlignment(JTextField.LEFT);
		searchTextField.setText(ControladorMyVideoApp.getUnicaInstancia().getTextoBusqueda());
		if (searchTextField.getText().compareTo("") == 0) {
			searchTextField.setText("Search...");
		}
		searchTextField.setBorder(null);
		GridBagConstraints gbc_searchTextField = new GridBagConstraints();
		gbc_searchTextField.gridwidth = 2;
		gbc_searchTextField.fill = GridBagConstraints.BOTH;
		gbc_searchTextField.insets = new Insets(0, 0, 5, 5);
		gbc_searchTextField.gridx = 1;
		gbc_searchTextField.gridy = 1;
		searchPanel.add(searchTextField, gbc_searchTextField);

		// Creas el buscador de videos y el boton luz para cargar los videos
		BuscadorVideos bv = new BuscadorVideos();
		Luz luz = new Luz();

		GridBagConstraints gbc_luz = new GridBagConstraints();
		gbc_luz.gridheight = 3;
		gbc_luz.gridx = 4;
		gbc_luz.gridy = 1;

		bv.addVideosListener(ControladorMyVideoApp.getUnicaInstancia());

		luz.addEncendidoListener(bv);
		luz.addEncendidoListener(new IEncendidoListener() {

			@Override
			public void enteradoCambioEncendido(EventObject arg0) {
				removeAll();
				generateTableVideos();
				add(searchPanel, BorderLayout.NORTH);
				add(scrollPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
			}
		});
		
		searchPanel.add(luz, gbc_luz);

		
		JButton searchButton = new JButton("");
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				ControladorMyVideoApp.getUnicaInstancia().stopVideo();
				
				padre.buscaVideos(searchTextField.getText());
				generateTableVideos();
				add(searchPanel, BorderLayout.NORTH);
				add(scrollPanel, BorderLayout.CENTER);
				
				revalidate();
				repaint();
			}
		});
		searchButton.setBorderPainted(false);
		searchButton.setBackground(null);
		searchButton.setBorderPainted(false);
		searchButton.setIcon(new ImageIcon(JPanelExplorar.class.getResource("/sources/search.png")));
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.anchor = GridBagConstraints.EAST;
		gbc_searchButton.insets = new Insets(0, 0, 5, 5);
		gbc_searchButton.gridx = 3;
		gbc_searchButton.gridy = 1;
		searchPanel.add(searchButton, gbc_searchButton);
		

		// Creas un separador para el campo de busqueda
		JSeparator jSeparator5 = new JSeparator();

		GridBagConstraints gbc_jSeparator5 = new GridBagConstraints();
		gbc_jSeparator5.gridwidth = 3;
		gbc_jSeparator5.fill = GridBagConstraints.BOTH;
		gbc_jSeparator5.insets = new Insets(0, 0, 5, 5);
		gbc_jSeparator5.gridx = 1;
		gbc_jSeparator5.gridy = 2;

		searchPanel.add(jSeparator5, gbc_jSeparator5);

		// Creas un ComboBox para seleccionar el filtro
		JComboBox<String> tagComboBox = new JComboBox<String>();

		tagComboBox.setBackground(new java.awt.Color(50, 50, 50));
		tagComboBox.setForeground(new java.awt.Color(0, 153, 204));
		tagComboBox.setMaximumRowCount(64);
		tagComboBox.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "No filtro", "Mis listas", "Impopulares", "Adultos" }));
		tagComboBox.setBorder(null);
		tagComboBox.setSelectedItem(padre.getFiltroAcual());
		
		tagComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String filtroCad = String.valueOf(tagComboBox.getSelectedItem());
				switch (filtroCad) {
				case "No filtro":
					padre.cambiaFiltro(new NoFiltro());
					break;
				case "Mis listas":
					padre.cambiaFiltro(new FiltroMisListas());
					break;
				case "Impopulares":
					padre.cambiaFiltro(new FiltroImpopulares());
					break;
				case "Adultos":
					padre.cambiaFiltro(new FiltroAdultos());
					break;
				default:
					break;
				}
				
				removeAll();
				
				generateTableVideos();
				add(searchPanel, BorderLayout.NORTH);
				add(scrollPanel, BorderLayout.CENTER);
				
				revalidate();
				repaint();
				
			}
		});

		GridBagConstraints gbc_tagComboBox = new GridBagConstraints();
		gbc_tagComboBox.anchor = GridBagConstraints.NORTHWEST;
		gbc_tagComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_tagComboBox.gridx = 1;
		gbc_tagComboBox.gridy = 3;

		searchPanel.add(tagComboBox, gbc_tagComboBox);

		// Panel de botones, dentro del panel de busqueda
		JPanel panelBtn = new JPanel(new FlowLayout());
		panelBtn.setBackground(new Color(50, 50, 50));

		JButton btnEtiquetas = new JButton("Etiquetas"); // Boton de las etiquetas
		btnEtiquetas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEtiquetas.setForeground(new Color(0, 0, 0));
		btnEtiquetas.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) { // Abre la pestaña para seleccionar etiquetas
				VentanaEtiquetas ventanaEtiquetas = new VentanaEtiquetas();
			}
		});
		panelBtn.add(btnEtiquetas);

		JButton btnRefrescar = new JButton("Refrescar"); // Boton para refrescar la pantalla
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // Refresca la pantalla
				System.out.println(getClass());
				removeAll();
				
				generateTableVideos();
				add(searchPanel, BorderLayout.NORTH);
				add(scrollPanel, BorderLayout.CENTER);

				revalidate();
				repaint();

			}
		});
		panelBtn.add(btnRefrescar);

		GridBagConstraints gbc_panelBtn = new GridBagConstraints();
		gbc_panelBtn.gridwidth = 2;
		gbc_panelBtn.insets = new Insets(0, 0, 0, 5);
		gbc_panelBtn.gridx = 2;
		gbc_panelBtn.gridy = 3;
		searchPanel.add(panelBtn, gbc_panelBtn);

		add(searchPanel, BorderLayout.NORTH);

		/****************************
		 * Panel de videos
		 ****************************/
		scrollPanel = new JScrollPane();
		scrollPanel.setBackground(new java.awt.Color(50, 50, 50));
		scrollPanel.setBorder(null);
		scrollPanel.setForeground(new java.awt.Color(0, 153, 204));
		scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBackground(new java.awt.Color(50, 50, 50));
		contentPanel.setForeground(new java.awt.Color(0, 153, 204));
		scrollPanel.setViewportView(contentPanel);

		generateTableVideos();

		add(scrollPanel, BorderLayout.CENTER);
	}

	private void generateTableVideos() {
		JTable table = new JTable();
		table.setRowSelectionAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = table.getColumnModel().getColumnIndexAtX(e.getX());
				int row = e.getY() / table.getRowHeight();

				if (row < table.getRowCount() && row >= 0 && column < table.getColumnCount() && column >= 0) {
					Object value = table.getValueAt(row, column);
					if (value instanceof JLabel) {

						JLabel label = (JLabel) value;
						JPanel vistaVideo = createVistaVideo(label);
						removeAll();
						add(searchPanel, BorderLayout.NORTH);
						add(vistaVideo, BorderLayout.CENTER);
						revalidate();
						repaint();
						ControladorMyVideoApp.getUnicaInstancia().verVideo(label.getName());
					}
				}
			}
		});
		table.setShowGrid(false);
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {

				if (value instanceof JLabel) {
					JLabel label = (JLabel) value;
					return label;
				}

				return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			}
		});
		Object tab[][] = ControladorMyVideoApp.getUnicaInstancia().videosToArray();
		DefaultTableModel model = new DefaultTableModel(tab, new Object[] { "", "", "" }) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBackground(null);
		table.setModel(model);
		table.setRowHeight(120);
		table.setRowMargin(5);

		contentPanel.removeAll();
		contentPanel.add(table, BorderLayout.CENTER);

	}

	private JPanel createVistaVideo(JLabel label) {
		JPanel vistaVideo = new JPanel();
		vistaVideo.setMinimumSize(new Dimension(100, 0));
		vistaVideo.setBackground(new Color(51, 51, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 105, 0, 105, 0 };
		gridBagLayout.rowHeights = new int[] { 40, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		vistaVideo.setLayout(gridBagLayout);

		VideoWeb videoWeb = ControladorMyVideoApp.getUnicaInstancia().getVideoWeb();
		GridBagConstraints gbc_videoWeb = new GridBagConstraints();
		gbc_videoWeb.insets = new Insets(0, 0, 5, 5);
		gbc_videoWeb.fill = GridBagConstraints.BOTH;
		gbc_videoWeb.gridx = 1;
		gbc_videoWeb.gridy = 1;
		vistaVideo.add(videoWeb, gbc_videoWeb);

		JPanel panel = new JPanel(new FlowLayout());
		panel.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		vistaVideo.add(panel, gbc_panel);


		JButton btnAnadirA = new JButton("Añadir a");
		btnAnadirA.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadirA.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				VentanaListas vl = new VentanaListas(label.getName());
			}
		});
		panel.add(btnAnadirA);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				removeAll();
				ControladorMyVideoApp.getUnicaInstancia().stopVideo();
				add(searchPanel, BorderLayout.NORTH);
				add(scrollPanel, BorderLayout.CENTER);
				revalidate();
				repaint();
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
		vistaVideo.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 30, 420, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNombre = new JLabel(label.getText());
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
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
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblVisitas = new JLabel(String.valueOf(
				ControladorMyVideoApp.getUnicaInstancia().getNumReproducciones(label.getName()) + " reproducciones"));
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

		List<Etiqueta> etiquetas = ControladorMyVideoApp.getUnicaInstancia().getEtiquetasVideo(label.getName());
		for (Etiqueta etiqueta : etiquetas) {
			JLabel lbl = new JLabel(etiqueta.getNombre());
			lbl.setForeground(new Color(0, 153, 204));
			panel_3.add(lbl);
		}

		JButton btnAnadirEtiq = new JButton("");
		btnAnadirEtiq.setBorderPainted(false);
		btnAnadirEtiq.setBackground(null);
		btnAnadirEtiq.setBorderPainted(false);
		btnAnadirEtiq.setIcon(new ImageIcon(AppFrame.class.getResource("/sources/addEtiq.png")));
		btnAnadirEtiq.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadirEtiq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				padre.addEtiq(label.getName());
				
				removeAll();
				createVistaVideo(label);

				add(searchPanel, BorderLayout.NORTH);
				add(createVistaVideo(label), BorderLayout.CENTER);

				revalidate();
				repaint();
			}
		});
		panel_3.add(btnAnadirEtiq);

		return vistaVideo;
	}

}
