package umu.tds.myvideoapp.vista;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import tds.video.VideoWeb;
import umu.tds.myvideoapp.controlador.ControladorMyVideoApp;
import umu.tds.myvideoapp.dominio.Etiqueta;

public abstract class JPanelListaVideos extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel panelTituloLista;
	private JScrollPane scrollPanel;
	private JPanel contentPanel;
	private JPanel panelBotones;
	
	private String tituloLista;
	private AppFrame padre;
	
	public JPanelListaVideos(String tituloLista, AppFrame padre) {
		this.setTituloLista(tituloLista);
		this.padre = padre;
		
		setBackground(new Color(50, 50, 50));
		setLayout(new BorderLayout(0, 0));
		
		/****************************
		 *  Panel del titulo de la lista
		 ****************************/
		setPanelTituloLista(new JPanel());
		getPanelTituloLista().setBackground(new Color(50, 50, 50));
		
		JLabel etiqTitulo = new JLabel(tituloLista);
		etiqTitulo.setForeground(new Color(255, 255, 255));
		etiqTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		getPanelTituloLista().add(etiqTitulo, BorderLayout.CENTER);
		
		add(getPanelTituloLista(), BorderLayout.NORTH);
		
		/****************************
		 *  Panel de los videos de la lista
		 ****************************/
		setScrollPanel(new JScrollPane());
		setScrollPanel(new JScrollPane());
		getScrollPanel().setBackground(new java.awt.Color(50, 50, 50));
		getScrollPanel().setBorder(null);
		getScrollPanel().setForeground(new java.awt.Color(0, 153, 204));
		getScrollPanel().setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBackground(new java.awt.Color(50, 50, 50));
		contentPanel.setForeground(new java.awt.Color(0, 153, 204));
		getScrollPanel().setViewportView(contentPanel);
		
		generateTableVideos();
		
		add(getScrollPanel(), BorderLayout.CENTER);
		
		/****************************
		 *  Panel de los botones
		 ****************************/
		createButtonPanel(tituloLista, padre);
		
	}

	protected abstract void createButtonPanel(String tituloLista, AppFrame padre); 

	protected void generateTableVideos() {
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
						add(getPanelTituloLista(), BorderLayout.NORTH);
						add(vistaVideo, BorderLayout.CENTER);
						ControladorMyVideoApp.getUnicaInstancia().verVideo(label.getName());
						revalidate();
						repaint();
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
		Object tab[][] = getVideosData();
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

	protected abstract JLabel[][] getVideosData();
	
	
	protected JPanel createVistaVideo(JLabel label) {
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
		btnAnadirA.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnAnadirA.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				VentanaListas vl = new VentanaListas(label.getName());
				vl.setVisible();
			}
		});
		panel.add(btnAnadirA);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				volverVideo();
				
				removeAll();
				ControladorMyVideoApp.getUnicaInstancia().stopVideo();
				generateTableVideos();
				add(getPanelTituloLista(), BorderLayout.NORTH);
				add(getScrollPanel(), BorderLayout.CENTER);
				add(getPanelBotones(), BorderLayout.SOUTH);
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
		btnAnadirEtiq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				padre.addEtiq(label.getName());
				
				removeAll();
				createVistaVideo(label);

				add(getPanelTituloLista(), BorderLayout.NORTH);
				add(createVistaVideo(label), BorderLayout.CENTER);

				revalidate();
				repaint();
			}
		});
		panel_3.add(btnAnadirEtiq);
		
		return vistaVideo;
	}

	protected abstract void volverVideo();

	public JPanel getPanelBotones() {
		return panelBotones;
	}

	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}

	public String getTituloLista() {
		return tituloLista;
	}

	public void setTituloLista(String tituloLista) {
		this.tituloLista = tituloLista;
	}

	public JPanel getPanelTituloLista() {
		return panelTituloLista;
	}

	public void setPanelTituloLista(JPanel panelTituloLista) {
		this.panelTituloLista = panelTituloLista;
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}

}
