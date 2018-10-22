/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umu.tds.myvideoapp.appframe;

import javax.swing.UIManager;

/**
 *
 * @author Agustin
 */
@SuppressWarnings("serial")
public class AppFrame extends javax.swing.JFrame {

    /**
     * Creates new form AppFrame
     */
    public AppFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    private void initComponents() {

        framePanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        userIconLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        deployableUserPanel = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();
        mostSeenLabel = new javax.swing.JLabel();
        recentLabel = new javax.swing.JLabel();
        newListLabel = new javax.swing.JLabel();
        myListsLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        myListsPanel = new javax.swing.JPanel();
        myListsScrollPanel = new javax.swing.JScrollPane();
        listButtonSplit = new javax.swing.JSplitPane();
        listNamePanel = new javax.swing.JPanel();
        testLabel = new javax.swing.JLabel();
        buttonsSplitPanel = new javax.swing.JSplitPane();
        playButtonPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        deleteButtonPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        searchButton = new javax.swing.JButton();
        tagComboBox = new javax.swing.JComboBox<>();
        contentPanel = new javax.swing.JPanel();
        layeredPanel = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyVideoApp");
        setMaximumSize(new java.awt.Dimension(4320, 2160));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName("appFrame"); // NOI18N

        framePanel.setBackground(new java.awt.Color(36, 36, 36));
        framePanel.setMinimumSize(new java.awt.Dimension(900, 600));
        framePanel.setPreferredSize(new java.awt.Dimension(900, 600));

        topPanel.setBackground(new java.awt.Color(42, 42, 42));
        topPanel.setMinimumSize(new java.awt.Dimension(512, 120));
        topPanel.setPreferredSize(new java.awt.Dimension(900, 120));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppFrame/logo64.png"))); // NOI18N

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AppFrame/userIcon64.png"))); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 153, 204));
        usernameLabel.setText("Hola @Username!");

        deployableUserPanel.setBorder(null);
        deployableUserPanel.setMaximumSize(new java.awt.Dimension(16, 16));
        deployableUserPanel.setMinimumSize(new java.awt.Dimension(16, 16));
        deployableUserPanel.setPreferredSize(new java.awt.Dimension(16, 16));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 518, Short.MAX_VALUE)
                .addComponent(userIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deployableUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoLabel)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deployableUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel))))
                .addGap(16, 16, 16))
        );

        leftPanel.setBackground(new java.awt.Color(45, 45, 45));

        mostSeenLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        mostSeenLabel.setForeground(new java.awt.Color(0, 153, 204));
        mostSeenLabel.setText("Más vistos");

        recentLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        recentLabel.setForeground(new java.awt.Color(0, 153, 204));
        recentLabel.setText("Recientes");

        newListLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        newListLabel.setForeground(new java.awt.Color(0, 153, 204));
        newListLabel.setText("Nueva Lista");

        myListsLabel.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        myListsLabel.setForeground(new java.awt.Color(0, 153, 204));
        myListsLabel.setText("Mis listas");

        myListsPanel.setBackground(new java.awt.Color(45, 45, 45));
        myListsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204), 2));

        myListsScrollPanel.setBackground(new java.awt.Color(45, 45, 45));
        myListsScrollPanel.setBorder(null);
        myListsScrollPanel.setMinimumSize(new java.awt.Dimension(100, 100));

        listButtonSplit.setBackground(new java.awt.Color(45, 45, 45));
        listButtonSplit.setBorder(null);
        listButtonSplit.setDividerSize(0);
        listButtonSplit.setMinimumSize(new java.awt.Dimension(200, 100));

        listNamePanel.setBackground(new java.awt.Color(45, 45, 45));
        listNamePanel.setForeground(new java.awt.Color(0, 153, 204));
        listNamePanel.setMaximumSize(new java.awt.Dimension(168, 32767));
        listNamePanel.setMinimumSize(new java.awt.Dimension(168, 100));
        listNamePanel.setPreferredSize(new java.awt.Dimension(160, 242));

        testLabel.setForeground(new java.awt.Color(0, 153, 204));
        testLabel.setText("League of legends");
        listNamePanel.add(testLabel);
        testLabel.getAccessibleContext().setAccessibleName("");

        listButtonSplit.setLeftComponent(listNamePanel);

        buttonsSplitPanel.setBorder(null);
        buttonsSplitPanel.setDividerSize(0);
        buttonsSplitPanel.setMinimumSize(new java.awt.Dimension(40, 100));
        buttonsSplitPanel.setPreferredSize(new java.awt.Dimension(40, 242));

        playButtonPanel.setBackground(new java.awt.Color(45, 45, 45));
        playButtonPanel.setMaximumSize(new java.awt.Dimension(20, 32767));
        playButtonPanel.setMinimumSize(new java.awt.Dimension(20, 100));
        playButtonPanel.setPreferredSize(new java.awt.Dimension(20, 203));

        jButton1.setBorder(null);
        jButton1.setMaximumSize(new java.awt.Dimension(16, 16));
        jButton1.setMinimumSize(new java.awt.Dimension(16, 16));
        jButton1.setPreferredSize(new java.awt.Dimension(16, 16));
        playButtonPanel.add(jButton1);

        buttonsSplitPanel.setLeftComponent(playButtonPanel);

        deleteButtonPanel.setBackground(new java.awt.Color(45, 45, 45));
        deleteButtonPanel.setMaximumSize(new java.awt.Dimension(20, 32767));
        deleteButtonPanel.setMinimumSize(new java.awt.Dimension(20, 100));
        deleteButtonPanel.setPreferredSize(new java.awt.Dimension(20, 240));

        jButton2.setBorder(null);
        jButton2.setMaximumSize(new java.awt.Dimension(16, 16));
        jButton2.setMinimumSize(new java.awt.Dimension(16, 16));
        jButton2.setPreferredSize(new java.awt.Dimension(16, 16));
        deleteButtonPanel.add(jButton2);

        buttonsSplitPanel.setRightComponent(deleteButtonPanel);

        listButtonSplit.setRightComponent(buttonsSplitPanel);

        myListsScrollPanel.setViewportView(listButtonSplit);

        javax.swing.GroupLayout myListsPanelLayout = new javax.swing.GroupLayout(myListsPanel);
        myListsPanel.setLayout(myListsPanelLayout);
        myListsPanelLayout.setHorizontalGroup(
            myListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myListsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        myListsPanelLayout.setVerticalGroup(
            myListsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myListsScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(myListsLabel)
                            .addComponent(newListLabel)
                            .addComponent(recentLabel)
                            .addComponent(mostSeenLabel)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4)))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(myListsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(mostSeenLabel)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(recentLabel)
                .addGap(4, 4, 4)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(newListLabel)
                .addGap(4, 4, 4)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(myListsLabel)
                .addGap(4, 4, 4)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myListsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        rightPanel.setBackground(new java.awt.Color(50, 50, 50));

        searchPanel.setBackground(new java.awt.Color(50, 50, 50));

        searchTextField.setBackground(new java.awt.Color(50, 50, 50));
        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(0, 153, 204));
        searchTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTextField.setText("Search...");
        searchTextField.setBorder(null);
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(50, 50, 50));
        searchButton.setForeground(new java.awt.Color(0, 153, 204));
        searchButton.setBorder(null);
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);

        tagComboBox.setBackground(new java.awt.Color(50, 50, 50));
        tagComboBox.setForeground(new java.awt.Color(0, 153, 204));
        tagComboBox.setMaximumRowCount(64);
        tagComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        tagComboBox.setBorder(null);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5)
                            .addComponent(searchTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tagComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(50, 50, 50));
        contentPanel.setForeground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout layeredPanelLayout = new javax.swing.GroupLayout(layeredPanel);
        layeredPanel.setLayout(layeredPanelLayout);
        layeredPanelLayout.setHorizontalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layeredPanelLayout.setVerticalGroup(
            layeredPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredPanel)
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout framePanelLayout = new javax.swing.GroupLayout(framePanel);
        framePanel.setLayout(framePanelLayout);
        framePanelLayout.setHorizontalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(framePanelLayout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        framePanelLayout.setVerticalGroup(
            framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, framePanelLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(framePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(framePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
            		UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
                new AppFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane buttonsSplitPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel deleteButtonPanel;
    private javax.swing.JButton deployableUserPanel;
    private javax.swing.JPanel framePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLayeredPane layeredPanel;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JSplitPane listButtonSplit;
    private javax.swing.JPanel listNamePanel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel mostSeenLabel;
    private javax.swing.JLabel myListsLabel;
    private javax.swing.JPanel myListsPanel;
    private javax.swing.JScrollPane myListsScrollPanel;
    private javax.swing.JLabel newListLabel;
    private javax.swing.JPanel playButtonPanel;
    private javax.swing.JLabel recentLabel;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> tagComboBox;
    private javax.swing.JLabel testLabel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel userIconLabel;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
