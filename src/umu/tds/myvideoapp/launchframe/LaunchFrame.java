/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umu.tds.myvideoapp.launchframe;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;

import umu.tds.myvideoapp.appframe.AppFrame;
import umu.tds.myvideoapp.controlador.ControladorUsuarios;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Agustin
 */
@SuppressWarnings("serial")
public class LaunchFrame extends javax.swing.JFrame {

	JFrame ventana;
    /**
     * Creates new form LaunchFrame
     */
    public LaunchFrame() {
    	ventana = new JFrame();
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        registerPanel = new javax.swing.JPanel();
        separatorPanel = new javax.swing.JPanel();
        registerButton = new javax.swing.JButton();
        registerButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		if (checkRegisterFields()) {
        			boolean registrado = false;
        			//Date fechaNac = new Date();
        			System.out.println("Entro");
        			registrado = ControladorUsuarios.getUnicaInstancia().registrarUsuario(usernameField.getText(), new String(passwordField.getPassword()), nameField.getText(), surnameField.getText(), emailField.getText());
        			System.out.println("Salgo: " + registrado); 
        			if (registrado) {
        				JOptionPane.showMessageDialog(ventana, "Usuario registrado con �xito.", "Registro", JOptionPane.INFORMATION_MESSAGE);
        			} else {
        				JOptionPane.showMessageDialog(ventana, "No se ha podido registrar el usuario. \n", "Registro", JOptionPane.ERROR_MESSAGE);
        			}	
        		}
        	}
        });
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        birthdayLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        repeatPassLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator(); 
        surnameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        repeatPasswordField = new javax.swing.JPasswordField();
        termsAndCondsCheckBox = new javax.swing.JCheckBox();
        titleLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        termsAndCondsLabel = new javax.swing.JLabel();
        loginPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        passwordLoginField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        loginButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		boolean login;
        		login = ControladorUsuarios.getUnicaInstancia().loginUsuario(
        				userTextField.getText(), new String(passwordLoginField.getPassword()));
        			
        		if (login) {
        			AppFrame ventanaPrincipal = new AppFrame();
        			ventanaPrincipal.setVisible(true);
        			dispose();
        		} else {
        			JOptionPane.showMessageDialog(ventana, "No se ha podido efectuar el login. \n", "Login", JOptionPane.ERROR_MESSAGE);	
        		}
        	}
        });
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVideoApp");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setMaximumSize(new java.awt.Dimension(882, 580));
        setMinimumSize(new java.awt.Dimension(882, 580));
        setName("launchFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(882, 580));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(79, 79, 79));

        registerPanel.setBackground(new java.awt.Color(65, 65, 65));

        separatorPanel.setBackground(new java.awt.Color(36, 36, 36));

        javax.swing.GroupLayout separatorPanelLayout = new javax.swing.GroupLayout(separatorPanel);
        separatorPanel.setLayout(separatorPanelLayout);
        separatorPanelLayout.setHorizontalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        separatorPanelLayout.setVerticalGroup(
            separatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        registerButton.setText("Registrarme");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //registerButtonActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("* Nombre:");

        surnameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        surnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        surnameLabel.setText("Apellidos:");

        birthdayLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        birthdayLabel.setForeground(new java.awt.Color(255, 255, 255));
        birthdayLabel.setText("* Fecha de nacimiento:");

        emailLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("* E-Mail:");

        userLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("* Username:");

        passLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(255, 255, 255));
        passLabel.setText("* Password:");

        repeatPassLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        repeatPassLabel.setForeground(new java.awt.Color(255, 255, 255));
        repeatPassLabel.setText("* Repeat password:");

        nameField.setBackground(new java.awt.Color(65, 65, 65));
        nameField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(153, 153, 153));
        nameField.setBorder(null);
        nameField.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        nameField.setSelectionColor(new java.awt.Color(0, 153, 204));


        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        surnameField.setBackground(new java.awt.Color(65, 65, 65));
        surnameField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        surnameField.setForeground(new java.awt.Color(153, 153, 153));
        surnameField.setBorder(null);
        surnameField.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        surnameField.setSelectionColor(new java.awt.Color(0, 153, 204));


        emailField.setBackground(new java.awt.Color(65, 65, 65));
        emailField.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        emailField.setForeground(new java.awt.Color(153, 153, 153));
        emailField.setBorder(null);
        emailField.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        emailField.setSelectionColor(new java.awt.Color(0, 153, 204));


        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator9.setForeground(new java.awt.Color(255, 255, 255));

        usernameField.setBackground(new java.awt.Color(65, 65, 65));
        usernameField.setForeground(new java.awt.Color(153, 153, 153));
        usernameField.setBorder(null);
        usernameField.setSelectionColor(new java.awt.Color(0, 153, 204));


        passwordField.setBackground(new java.awt.Color(65, 65, 65));
        passwordField.setForeground(new java.awt.Color(153, 153, 153));
        passwordField.setBorder(null);
        passwordField.setSelectionColor(new java.awt.Color(0, 153, 204));


        repeatPasswordField.setBackground(new java.awt.Color(65, 65, 65));
        repeatPasswordField.setForeground(new java.awt.Color(153, 153, 153));
        repeatPasswordField.setBorder(null);
        repeatPasswordField.setSelectionColor(new java.awt.Color(0, 153, 204));

        termsAndCondsCheckBox.setBackground(new java.awt.Color(65, 65, 65));
        termsAndCondsCheckBox.setForeground(new java.awt.Color(0, 153, 204));


        titleLabel.setBackground(new java.awt.Color(65, 65, 65));
        titleLabel.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 153, 204));
        titleLabel.setText("Formulario de registro: ");

        infoLabel.setFont(new java.awt.Font("Candara", 2, 12)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setText("* Campos obligatorios");

        termsAndCondsLabel.setForeground(new java.awt.Color(0, 153, 204));
        termsAndCondsLabel.setText("<HTML><U>Terms and conditions</HTML></U>");

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanelLayout.setHorizontalGroup(
        	registerPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(registerPanelLayout.createSequentialGroup()
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(registerPanelLayout.createSequentialGroup()
        					.addGap(42)
        					.addComponent(titleLabel)
        					.addPreferredGap(ComponentPlacement.RELATED, 317, Short.MAX_VALUE))
        				.addGroup(registerPanelLayout.createSequentialGroup()
        					.addGroup(registerPanelLayout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(registerPanelLayout.createSequentialGroup()
        							.addGap(84)
        							.addGroup(registerPanelLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(infoLabel)
        								.addGroup(registerPanelLayout.createSequentialGroup()
        									.addGap(0, 248, Short.MAX_VALUE)
        									.addComponent(registerButton))))
        						.addGroup(registerPanelLayout.createSequentialGroup()
        							.addContainerGap(64, Short.MAX_VALUE)
        							.addGroup(registerPanelLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(registerPanelLayout.createSequentialGroup()
        									.addGroup(registerPanelLayout.createParallelGroup(Alignment.TRAILING)
        										.addComponent(birthdayLabel)
        										.addComponent(nameLabel)
        										.addComponent(surnameLabel)
        										.addComponent(emailLabel)
        										.addComponent(passLabel)
        										.addComponent(userLabel)
        										.addComponent(repeatPassLabel))
        									.addGap(18)
        									.addGroup(registerPanelLayout.createParallelGroup(Alignment.LEADING, false)
        										.addComponent(jSeparator9, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(jSeparator3, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(surnameField, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(jSeparator4, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(jSeparator5, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(jSeparator6, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(jSeparator7, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(jSeparator8, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        										.addComponent(usernameField)
        										.addComponent(passwordField)
        										.addComponent(repeatPasswordField)))
        								.addGroup(registerPanelLayout.createSequentialGroup()
        									.addGap(76)
        									.addComponent(termsAndCondsCheckBox)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(termsAndCondsLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))))
        					.addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)))
        			.addComponent(separatorPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        registerPanelLayout.setVerticalGroup(
        	registerPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(separatorPanel, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        		.addGroup(registerPanelLayout.createSequentialGroup()
        			.addGap(64)
        			.addComponent(titleLabel)
        			.addGap(18)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(nameLabel)
        				.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(14)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(surnameLabel)
        				.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(8)
        			.addComponent(birthdayLabel)
        			.addGap(5)
        			.addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(8)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(emailLabel)
        				.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(35)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(userLabel)
        				.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addComponent(jSeparator7, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(8)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(passLabel)
        				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(8)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(repeatPassLabel)
        				.addComponent(repeatPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addComponent(jSeparator9, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(infoLabel)
        			.addGap(18)
        			.addGroup(registerPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(registerPanelLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(registerButton)
        					.addComponent(termsAndCondsLabel))
        				.addComponent(termsAndCondsCheckBox))
        			.addContainerGap(101, Short.MAX_VALUE))
        );
        registerPanel.setLayout(registerPanelLayout);

        loginPanel.setBackground(new java.awt.Color(51, 51, 51));
        loginPanel.setForeground(new java.awt.Color(255, 255, 255));
        loginPanel.setMaximumSize(new java.awt.Dimension(420, 2160));
        loginPanel.setPreferredSize(new java.awt.Dimension(330, 501));

        //logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LaunchFrame/logo64.png"))); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 153, 204));
        usernameLabel.setText("Username: ");

        passwordLabel.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 153, 204));
        passwordLabel.setText("Password: ");
        passwordLabel.setMaximumSize(new java.awt.Dimension(68, 18));
        passwordLabel.setMinimumSize(new java.awt.Dimension(68, 18));
        passwordLabel.setPreferredSize(new java.awt.Dimension(68, 18));

        userTextField.setBackground(new java.awt.Color(51, 51, 51));
        userTextField.setForeground(new java.awt.Color(153, 153, 153));
        userTextField.setText("Username");
        userTextField.setBorder(null);
        userTextField.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        userTextField.setSelectionColor(new java.awt.Color(0, 153, 204));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        loginButton.setText("Login");

        passwordLoginField.setBackground(new java.awt.Color(50, 50, 50));
        passwordLoginField.setForeground(new java.awt.Color(153, 153, 153));
        passwordLoginField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        passwordLoginField.setText("yourpassword");
        passwordLoginField.setBorder(null);
        
        forgotLabel = new JLabel("<HTML><U>Forgot your password? </U></HTML>");
        forgotLabel.setForeground(new java.awt.Color(0, 153, 204));
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new java.awt.Color(50, 50, 50));

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanelLayout.setHorizontalGroup(
        	loginPanelLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(loginPanelLayout.createSequentialGroup()
        			.addGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(loginPanelLayout.createSequentialGroup()
        					.addGap(128)
        					.addComponent(logoLabel))
        				.addGroup(loginPanelLayout.createSequentialGroup()
        					.addGap(48)
        					.addComponent(forgotLabel)
        					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
        					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
        				.addGroup(loginPanelLayout.createSequentialGroup()
        					.addGap(27)
        					.addGroup(loginPanelLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(usernameLabel)))
        				.addGroup(loginPanelLayout.createSequentialGroup()
        					.addGap(58)
        					.addGroup(loginPanelLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        						.addComponent(passwordLoginField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        						.addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(67, Short.MAX_VALUE))
        		.addGroup(loginPanelLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
        			.addGap(31))
        );
        loginPanelLayout.setVerticalGroup(
        	loginPanelLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(loginPanelLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(59)
        			.addComponent(logoLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        			.addGap(75)
        			.addComponent(usernameLabel)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(userTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(passwordLoginField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
        			.addGap(11)
        			.addGroup(loginPanelLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(loginButton)
        				.addComponent(forgotLabel))
        			.addContainerGap(166, Short.MAX_VALUE))
        );
        GridBagLayout gbl_buttonPanel = new GridBagLayout();
        gbl_buttonPanel.columnWidths = new int[]{150, 8, 0};
        gbl_buttonPanel.rowHeights = new int[]{20, 0};
        gbl_buttonPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_buttonPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        buttonPanel.setLayout(gbl_buttonPanel);
        
        closeLabel = new JLabel("X");
        GridBagConstraints gbc_closeLabel = new GridBagConstraints();
        gbc_closeLabel.insets = new Insets(0, 0, 0, 5);
        gbc_closeLabel.anchor = GridBagConstraints.NORTHEAST;
        gbc_closeLabel.gridx = 0;
        gbc_closeLabel.gridy = 0;
        buttonPanel.add(closeLabel, gbc_closeLabel);
        closeLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseReleased(MouseEvent arg0) {
        		System.exit(0);
        	}
        });
        closeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        closeLabel.setForeground(new java.awt.Color(0, 153, 204));
        loginPanel.setLayout(loginPanelLayout);

        logoLabel.getAccessibleContext().setAccessibleName("logoIcon");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(registerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LaunchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaunchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaunchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaunchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaunchFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordLoginField;
    private javax.swing.JButton registerButton;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JLabel repeatPassLabel;
    private javax.swing.JPasswordField repeatPasswordField;
    private javax.swing.JPanel separatorPanel;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JCheckBox termsAndCondsCheckBox;
    private javax.swing.JLabel termsAndCondsLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private JLabel forgotLabel;
    private JLabel closeLabel;
    
    
	public void mostrarVentana() {
		setVisible(true);		
	}

	private boolean checkRegisterFields() {
		boolean ok=true;
		ocultarErrores();

		if (nameField.getText().trim().isEmpty()) {
			nameLabel.setForeground(new java.awt.Color(190, 0, 0));
			ok=false;
		}

		if (emailField.getText().trim().isEmpty()) {
			emailLabel.setForeground(new java.awt.Color(190, 0, 0));
			ok=false;
		}
		
		if (usernameField.getText().trim().isEmpty()) {
			userLabel.setForeground(new java.awt.Color(190, 0, 0));
			ok=false;
		}
		
		if (ControladorUsuarios.getUnicaInstancia().esUsuarioRegistrado(usernameField.getText())) {
			usernameLabel.setForeground(new java.awt.Color(190, 0, 0));
			ok=false;		
		}
		
		String password = new String(passwordField.getPassword());
		String password2 = new String(repeatPasswordField.getPassword());
		
		if (password.equals("")) {
			passLabel.setForeground(new java.awt.Color(190, 0, 0)); 
			ok = false;
		} 
		
		if (password2.equals("")) {
			repeatPassLabel.setForeground(new java.awt.Color(190, 0, 0)); 
			ok = false;
		} 
		
		if (!termsAndCondsCheckBox.isSelected()) {
			ok = false;
		}
		
		if (!password.equals(password2)) {
			passLabel.setForeground(new java.awt.Color(190, 0, 0));
			repeatPassLabel.setForeground(new java.awt.Color(190, 0, 0));
			ok = false;
		}
		System.out.println(ok);
		return ok;
	}
	
	private void ocultarErrores() {
		nameLabel.setForeground(new java.awt.Color(255, 255, 255));
		emailLabel.setForeground(new java.awt.Color(255, 255, 255));
		userLabel.setForeground(new java.awt.Color(255, 255, 255));
		passLabel.setForeground(new java.awt.Color(255, 255, 255));
		repeatPassLabel.setForeground(new java.awt.Color(255, 255, 255));
	} 
}
