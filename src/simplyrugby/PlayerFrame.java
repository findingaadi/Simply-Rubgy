
package simplyrugby;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class PlayerFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    Object columns[] = {"Id", "Name", "SRU", "Phone", "Address", "Postal-Code", "Team", "Doctor", "Kin","Health"};

    DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

    private static Integer playerId = 0;

    MemberDAO memberDAO = new MemberDAOImpl();
    TeamDAO teamDAO = new TeamDAOImpl();
    PlayerDAO playerDAO = new PlayerDAOImpl();

    public PlayerFrame() {
        initComponents();
        fillTeamsCombo();
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        fillTable();
        setSize(930, 820);
        setLocation(350, 50);

    }

    public boolean isAnyFieldsEmpty() {
        if (nameField.getText().equals("") || sruField.getText().equals("") || phoneField.getText().equals("")
                || postalCodeField.getText().equals("") || addressField.getText().equals("") || addressField.getText().equals("")
                || doctorField.getText().equals("")) {
            return true;

        }
        return false;
    }

    public void setFields(Player player) {
        nameField.setText(player.getName());
        sruField.setText(player.getSruNum());
        phoneField.setText(player.getPhone());
        postalCodeField.setText(player.getPostCode().toString());
        addressField.setText(player.getAddress());
        doctorField.setText(player.getDoctor());
        kinField.setText(player.getNextOfKin());
        String teamName = teamDAO.getTeamById(player.getTeam().getTeamId()).getName();
        temsCombo.setSelectedItem(teamName);

    }

    public Player getPlayer() {
        String name = nameField.getText();
        String sru = sruField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        Integer postalCode = Integer.parseInt(postalCodeField.getText());
        String doctor = doctorField.getText();
        String kin = kinField.getText();
        String selectedTeam = temsCombo.getSelectedItem().toString();
        String knownHealth = healthField.getText();
        Team team = teamDAO.getTeamByName(selectedTeam);
        Player player = new Player(0, name, sru, address, phone, postalCode, doctor, kin, knownHealth);
        player.setTeam(team);
        return player;
    }

    public void clearFields() {
        nameField.setText("");
        sruField.setText("");
        postalCodeField.setText("");
        phoneField.setText("");
        doctorField.setText("");
        kinField.setText("");
        addressField.setText("");
    }

    public void fillTeamsCombo() {
        List<Team> teams = teamDAO.getAllTeams();
        for (Team team : teams) {
            temsCombo.addItem(team.getName());
        }
    }

    public void fillTable() {
        defaultTableModel = new DefaultTableModel(columns, 0);
        List<Player> players = playerDAO.getAllPlayers();

        for (Player p : players) {
            Object row[] = {p.getPlayerId(), p.getName(), p.getSruNum(), p.getPhone(), p.getAddress(), p.getPostCode(),
                p.getTeam().getName(), p.getDoctor(), p.getNextOfKin(),p.getKnownHealth()};
            defaultTableModel.addRow(row);
            playerTable.setModel(defaultTableModel);
        }
        playerTable.getColumnModel().getColumn(0).setWidth(0);
        playerTable.getColumnModel().getColumn(0).setMinWidth(0);
        playerTable.getColumnModel().getColumn(0).setMaxWidth(0);

    }
                   
    private void initComponents() {

        headerLbl = new javax.swing.JLabel();
        nameLbl = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        phoneLbl = new javax.swing.JLabel();
        sruLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        addressLbl = new javax.swing.JLabel();
        postalCodeField = new javax.swing.JTextField();
        sruField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        typeLbl = new javax.swing.JLabel();
        temsCombo = new javax.swing.JComboBox<>();
        addressField = new javax.swing.JTextField();
        kinField = new javax.swing.JTextField();
        doctorField = new javax.swing.JTextField();
        doctorLbl = new javax.swing.JLabel();
        kinLbl = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        healthLbl = new javax.swing.JLabel();
        healthField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("Senior Player Details");

        nameLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        nameLbl.setText("Name");

        nameField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        phoneLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        phoneLbl.setText("Phone");

        sruLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sruLbl.setText("SRU Num");

        passwordLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        passwordLbl.setText("Postal Code");

        phoneField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        addressLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addressLbl.setText("Address");

        postalCodeField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        sruField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        playerTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        playerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        playerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(playerTable);

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
        typeLbl.setText("Team");

        temsCombo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        addressField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        kinField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        doctorField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        doctorLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        doctorLbl.setText("Doctor");

        kinLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        kinLbl.setText("Next of Kin");

        backBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        healthLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        healthLbl.setText("Known Health");

        healthField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backBtn)
                .addGap(159, 159, 159)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(sruLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(sruField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(phoneLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(temsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(doctorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(kinLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(kinField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(healthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(healthField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backBtn)
                    .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void playerTableMouseClicked(java.awt.event.MouseEvent evt) {                                         
        playerId = (Integer) playerTable.getValueAt(playerTable.getSelectedRow(), 0);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        Player existingPlayer = playerDAO.getPlayerById(playerId);
        setFields(existingPlayer);

    }                                        

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (isAnyFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
        } else {
            Player player = getPlayer();
            boolean b = playerDAO.addPlayer(player);
            if (b) {
                JOptionPane.showMessageDialog(this, "Player Added Successfully");
                fillTable();
                clearFields();
            }
        }

    }                                      

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (isAnyFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
        } else {
            Player player = getPlayer();
            player.setPlayerId(playerId);
            boolean b = playerDAO.updatePlayer(player);
            if (b) {
                JOptionPane.showMessageDialog(this, "Player Updated Successfully");
                fillTable();
                clearFields();
                editBtn.setEnabled(false);
                deleteBtn.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Error Occurred");
            }
        }
    }                                       

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
        playerId = (Integer) playerTable.getValueAt(playerTable.getSelectedRow(), 0);
        boolean b = playerDAO.deletePlayer(playerId);
        if (b) {
            JOptionPane.showMessageDialog(this, "Player Deleted Successfully");
            fillTable();
            clearFields();
            editBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        }
    }                                         

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        this.dispose();
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField doctorField;
    private javax.swing.JLabel doctorLbl;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JTextField healthField;
    private javax.swing.JLabel healthLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kinField;
    private javax.swing.JLabel kinLbl;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTable playerTable;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JTextField sruField;
    private javax.swing.JLabel sruLbl;
    private javax.swing.JComboBox<String> temsCombo;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration                   
}
