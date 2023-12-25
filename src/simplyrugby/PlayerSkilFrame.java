/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PlayerSkilFrame extends javax.swing.JFrame {

  
	private static final long serialVersionUID = 1L;

	
    Object columns[] = {"Id", "Player", "Category", "Skill", "Level"};

    DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

    private static Integer playerSkillId = 0;

    MemberDAO memberDAO = new MemberDAOImpl();
    TeamDAO teamDAO = new TeamDAOImpl();
    PlayerDAO playerDAO = new PlayerDAOImpl();
    PlayerSkillDAO playerSkillDAO = new PlayerSkillDAOImpl();

    public PlayerSkilFrame() {
        initComponents();
        fillAllCombos();
        fillTable();
        setLocation(350, 50);
    }

    public void setFields(PlayerSkill playerSkill) {
        categoryCombo.setSelectedItem(playerSkill.getCategory());
        skillCombo.setSelectedItem(playerSkill.getSkill());
        playerCombo.setSelectedItem(playerSkill.getPlayer().getName());
        levelCombo.setSelectedItem(playerSkill.getLevel());
    }

    public PlayerSkill getPlayerSkill() {
        String category = categoryCombo.getSelectedItem().toString();
        String skill = skillCombo.getSelectedItem().toString();
        String playerName = playerCombo.getSelectedItem().toString();
        Player player = playerDAO.getPlayerByName(playerName);
        String level = levelCombo.getSelectedItem().toString();
        return new PlayerSkill(0, player, category, skill, level);
    }

    public void fillAllCombos() {
        if (LoginFrame.memeberId > 0) {
            Member member = memberDAO.getMemberById(2);
            Team team = teamDAO.getTeamById(member.getTeam().getTeamId());
            teamsCombo.addItem(team.getName());
            List<Player> players = playerDAO.getAllPlayersByTeamId(team.getTeamId());
            for (Player player : players) {
                playerCombo.addItem(player.getName());
            }
            categoryCombo.addItem("Passing");
            categoryCombo.addItem("Tracking");
            categoryCombo.addItem("Kicking");
            skillCombo.addItem("Standard");
            skillCombo.addItem("Spin");
            skillCombo.addItem("Pop");
            levelCombo.addItem("1");
            levelCombo.addItem("2");
            levelCombo.addItem("3");
            levelCombo.addItem("4");
            levelCombo.addItem("5");
        }

    }

    public void fillTable() {
        defaultTableModel = new DefaultTableModel(columns, 0);
        List<PlayerSkill> playerSkills = playerSkillDAO.getAllPlayerSkills();

        for (PlayerSkill p : playerSkills) {
            Object row[] = {p.getPlayerSkillId(), p.getPlayer().getName(), p.getCategory(),
                p.getSkill(), p.getLevel()};
            defaultTableModel.addRow(row);
            playerSkillTable.setModel(defaultTableModel);
        }
        playerSkillTable.getColumnModel().getColumn(0).setWidth(0);
        playerSkillTable.getColumnModel().getColumn(0).setMinWidth(0);
        playerSkillTable.getColumnModel().getColumn(0).setMaxWidth(0);

    }

    private void initComponents() {

        headerLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        teamsCombo = new javax.swing.JComboBox<>();
        teamLbl = new javax.swing.JLabel();
        playerLbl = new javax.swing.JLabel();
        playerCombo = new javax.swing.JComboBox<>();
        caterogoryLbl = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox<>();
        skillCombo = new javax.swing.JComboBox<>();
        skilLbl = new javax.swing.JLabel();
        levelCombo = new javax.swing.JComboBox<>();
        levelLbl = new javax.swing.JLabel();
        addSkillBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerSkillTable = new javax.swing.JTable();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("Player Skills ");

        backBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        teamsCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        teamLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        teamLbl.setText("Team");

        playerLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        playerLbl.setText("Player");

        playerCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        caterogoryLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        caterogoryLbl.setText("Category");

        categoryCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        categoryCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryComboItemStateChanged(evt);
            }
        });

        skillCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        skilLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        skilLbl.setText("Skill");

        levelCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        levelLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        levelLbl.setText("Level");

        addSkillBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addSkillBtn.setText("Add Skil");
        addSkillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSkillBtnActionPerformed(evt);
            }
        });

        playerSkillTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        playerSkillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        playerSkillTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerSkillTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(playerSkillTable);

        editBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(backBtn)
                                    .addComponent(teamLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(teamsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(playerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(playerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(caterogoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(skilLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(skillCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(levelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(397, 397, 397)))))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addSkillBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn)
                    .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teamsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teamLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(caterogoryLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skillCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skilLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(levelLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addSkillBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CoachPage homePage = new CoachPage();
        homePage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void addSkillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSkillBtnActionPerformed
        PlayerSkill playerSkill = getPlayerSkill();
        boolean b = playerSkillDAO.addPlayerSkill(playerSkill);
        if (b) {
            JOptionPane.showMessageDialog(this, "Player Skill Added Successfully");
            fillTable();
        }
    }//GEN-LAST:event_addSkillBtnActionPerformed

    private void categoryComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryComboItemStateChanged
        if (categoryCombo.getSelectedItem().toString().equals("Tracking")) {
            skillCombo.removeAllItems();
            skillCombo.addItem("Front");
            skillCombo.addItem("Rear");
            skillCombo.addItem("Side");
            skillCombo.addItem("Scrabble");
        }
        if (categoryCombo.getSelectedItem().toString().equals("Kicking")) {
            skillCombo.removeAllItems();
            skillCombo.addItem("Drop");
            skillCombo.addItem("Punt");
            skillCombo.addItem("Grubber");
            skillCombo.addItem("Goal");
        }
    }//GEN-LAST:event_categoryComboItemStateChanged

    private void playerSkillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playerSkillTableMouseClicked
        playerSkillId = (Integer) playerSkillTable.getValueAt(playerSkillTable.getSelectedRow(), 0);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        PlayerSkill existingPlayerSkill = playerSkillDAO.getPlayerSkillById(playerSkillId);
        setFields(existingPlayerSkill);
    }//GEN-LAST:event_playerSkillTableMouseClicked

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        PlayerSkill playerSkill = getPlayerSkill();
        playerSkill.setPlayerSkillId(playerSkillId);
        boolean b = playerSkillDAO.updatePlayerSkill(playerSkill);
        if (b) {
            JOptionPane.showMessageDialog(this, "Player Skill Updated Successfully");
            fillTable();
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error Occurred");
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        playerSkillId = (Integer) playerSkillTable.getValueAt(playerSkillTable.getSelectedRow(), 0);
        boolean b = playerSkillDAO.deletePlayerSkill(playerSkillId);
        if (b) {
            JOptionPane.showMessageDialog(this, "Player Skill Deleted Successfully");
            fillTable();
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addSkillBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> categoryCombo;
    private javax.swing.JLabel caterogoryLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> levelCombo;
    private javax.swing.JLabel levelLbl;
    private javax.swing.JComboBox<String> playerCombo;
    private javax.swing.JLabel playerLbl;
    private javax.swing.JTable playerSkillTable;
    private javax.swing.JLabel skilLbl;
    private javax.swing.JComboBox<String> skillCombo;
    private javax.swing.JLabel teamLbl;
    private javax.swing.JComboBox<String> teamsCombo;
    // End of variables declaration//GEN-END:variables
}
