/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

/**
 *
 * @author HP
 */
public class CoachPage extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    public CoachPage() {
        initComponents();
        setLocation(350, 50);
    }

 
    private void initComponents() {

        playerSkillBtn = new javax.swing.JButton();
        jPlayerSkillBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playerSkillBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        playerSkillBtn.setText("Player Skill");
        playerSkillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerSkillBtnActionPerformed(evt);
            }
        });

        jPlayerSkillBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jPlayerSkillBtn.setText("Junior Player Skill");
        jPlayerSkillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlayerSkillBtnActionPerformed(evt);
            }
        });

        logoutBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jPlayerSkillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(playerSkillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(logoutBtn)
                .addGap(48, 48, 48)
                .addComponent(playerSkillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPlayerSkillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playerSkillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerSkillBtnActionPerformed
        PlayerSkilFrame teamFrame = new PlayerSkilFrame();
        teamFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_playerSkillBtnActionPerformed

    private void jPlayerSkillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlayerSkillBtnActionPerformed
        JuniorPLayerSkillFrame cf = new JuniorPLayerSkillFrame();
        this.dispose();
        cf.setVisible(true);
    }//GEN-LAST:event_jPlayerSkillBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        LoginFrame lf = new LoginFrame();
        this.dispose();
        lf.setVisible(true); 
    }//GEN-LAST:event_logoutBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jPlayerSkillBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton playerSkillBtn;
    // End of variables declaration//GEN-END:variables
}
