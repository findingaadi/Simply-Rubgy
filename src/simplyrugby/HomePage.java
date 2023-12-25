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
public class HomePage extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form HomePage
     */
    public HomePage() {
        initComponents();
        setLocation(350, 50);
        if(LoginFrame.IS_COACH){ 
           teamBtn.setEnabled(false);
           coachBtn.setEnabled(false);
        }
    }

  
    private void initComponents() {

        teamBtn = new javax.swing.JButton();
        coachBtn = new javax.swing.JButton();
        playerBtn = new javax.swing.JButton();
        juniorPlayerBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        teamBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        teamBtn.setText("Team");
        teamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamBtnActionPerformed(evt);
            }
        });

        coachBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        coachBtn.setText("Coach");
        coachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachBtnActionPerformed(evt);
            }
        });

        playerBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        playerBtn.setText("Player");
        playerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBtnActionPerformed(evt);
            }
        });

        juniorPlayerBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        juniorPlayerBtn.setText("Junior Player");
        juniorPlayerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juniorPlayerBtnActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(teamBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(juniorPlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(logoutBtn)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(juniorPlayerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamBtnActionPerformed
        TeamFrame teamFrame = new TeamFrame();
        teamFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_teamBtnActionPerformed

    private void coachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachBtnActionPerformed
        CoachFrame cf = new CoachFrame();
        this.dispose();
        cf.setVisible(true);
    }//GEN-LAST:event_coachBtnActionPerformed

    private void playerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerBtnActionPerformed
        PlayerFrame pf = new PlayerFrame();
        this.dispose();
        pf.setVisible(true); 
    }//GEN-LAST:event_playerBtnActionPerformed

    private void juniorPlayerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juniorPlayerBtnActionPerformed
        JuniorPlayerFrame jpf = new JuniorPlayerFrame();
        this.dispose();
        jpf.setVisible(true);
    }//GEN-LAST:event_juniorPlayerBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        LoginFrame lf = new LoginFrame();
        this.dispose();
        lf.setVisible(true); 
    }//GEN-LAST:event_logoutBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coachBtn;
    private javax.swing.JButton juniorPlayerBtn;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton playerBtn;
    private javax.swing.JButton teamBtn;
    // End of variables declaration//GEN-END:variables
}
