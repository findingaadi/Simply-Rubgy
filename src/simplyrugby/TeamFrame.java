/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class TeamFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    Object columns[] = {"Id", "Name", "Type"};

    DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

    TeamDAO teamDAO = new TeamDAOImpl();

    private static Integer teamId = 0;

    public TeamFrame() {
        initComponents();
        fillTypeCombo();
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        setSize(920, 660);
        setLocation(350, 50);
        try {
            fillTable();
        } catch (SQLException ex) {
            Logger.getLogger(TeamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fillTable() throws SQLException {
        defaultTableModel = new DefaultTableModel(columns, 0);
        List<Team> teams = teamDAO.getAllTeams();

        for (Team t : teams) {
            Object row[] = {t.getTeamId(), t.getName(), t.getType()};
            defaultTableModel.addRow(row);
            teamTable.setModel(defaultTableModel);
        }
        teamTable.getColumnModel().getColumn(0).setWidth(0);
        teamTable.getColumnModel().getColumn(0).setMinWidth(0);
        teamTable.getColumnModel().getColumn(0).setMaxWidth(0);

    }

    private void clearFields() {
        nameField.setText("");
    }

    private void setFields(Team team) {
        nameField.setText(team.getName());
        typeCombo.setSelectedItem(team.getType());

    }

    private Team getTeam() {
        String name = nameField.getText();
        String type = typeCombo.getSelectedItem().toString();
        return new Team(0, name, type);
    }

    public void fillTypeCombo() {
        typeCombo.addItem("Junior Team");
        typeCombo.addItem("Senior Team");
    }
                     
    private void initComponents() {

        headerLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        teamTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        typeLbl = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("Team Details");

        nameLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nameLbl.setText("Name");

        nameField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        teamTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        teamTable.setModel(new javax.swing.table.DefaultTableModel(
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
        teamTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(teamTable);

        addBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

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

        typeLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        typeLbl.setText("Type");

        typeCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        backBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backBtn)
                .addGap(149, 149, 149)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Team team = getTeam();
        try {
            boolean b = teamDAO.addTeam(team);
            if (b) {
                JOptionPane.showMessageDialog(this, "Team Added Successfully");
                fillTable();
                clearFields();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                      

    private void teamTableMouseClicked(java.awt.event.MouseEvent evt) {                                       
        teamId = (Integer) teamTable.getValueAt(teamTable.getSelectedRow(), 0);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        Team existingTeam = teamDAO.getTeamById(teamId);
        setFields(existingTeam);
    }                                      

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Team team = getTeam();
        team.setTeamId(teamId);
        try {
            boolean b = teamDAO.updateTeam(team);
            if (b) {
                JOptionPane.showMessageDialog(this, "Team Updated Successfully");
                fillTable();
                clearFields();
                editBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Error Occurred");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }                                       

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        teamId = (Integer) teamTable.getValueAt(teamTable.getSelectedRow(), 0);
        try {
            boolean b = teamDAO.deleteTeam(teamId);
            if (b) {
                JOptionPane.showMessageDialog(this, "Team Deleted Successfully");
                fillTable();
                clearFields();
                editBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                         

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        this.dispose();
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTable teamTable;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration                   
}
