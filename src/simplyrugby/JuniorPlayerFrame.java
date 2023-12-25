
package simplyrugby;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class JuniorPlayerFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    Object columns[] = {"Id", "Name", "SRU", "Phone", "Address", "Postal-Code", "Team", "Doctor",
        "Kin", "Guardin1", "Guardian1-Relation", "Guardin1", "Guardian1-Relation","Health"};

    DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

    private static Integer juniorPlayerId = 0;

    MemberDAO memberDAO = new MemberDAOImpl();
    TeamDAO teamDAO = new TeamDAOImpl();
    PlayerDAO playerDAO = new PlayerDAOImpl();
    JuniorPlayerDAO juniorPlayerDAO = new JuniorPlayerDAOImpl();

    public JuniorPlayerFrame() {
        initComponents();
        fillTeamsCombo();
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        fillTable();
        setSize(1340, 870);
        setLocation(350, 50);

    }

    public boolean isAnyFieldsEmpty() {
        if (nameField.getText().equals("") || sruField.getText().equals("") || phoneField.getText().equals("")
                || postalCodeField.getText().equals("") || addressField.getText().equals("") || addressField.getText().equals("")
                || doctorField.getText().equals("") || guardin1Field.getText().equals("") || g1RelationField.getText().equals("")
                || guardian2Field.getText().equals("") || g2RelationField.getText().equals("")) {
            return true;

        }
        return false;
    }

    public void setFields(JuniorPlayer juniorPlayer) {
        nameField.setText(juniorPlayer.getName());
        sruField.setText(juniorPlayer.getSruNum());
        phoneField.setText(juniorPlayer.getPhone());
        postalCodeField.setText(juniorPlayer.getPostCode().toString());
        addressField.setText(juniorPlayer.getAddress());
        doctorField.setText(juniorPlayer.getDoctor());
        kinField.setText(juniorPlayer.getNextOfKin());
        guardin1Field.setText(juniorPlayer.getGuardian1());
        g1RelationField.setText(juniorPlayer.getGuardian1Relation());
        guardian2Field.setText(juniorPlayer.getGuardian2());
        g2RelationField.setText(juniorPlayer.getGuardian2Relation());
        String teamName = teamDAO.getTeamById(juniorPlayer.getTeam().getTeamId()).getName();
        temsCombo.setSelectedItem(teamName);

    }

    public JuniorPlayer getJuniorPlayer() {
        String name = nameField.getText();
        String sru = sruField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();
        Integer postalCode = Integer.parseInt(postalCodeField.getText());
        String doctor = doctorField.getText();
        String kin = kinField.getText();
        String guardian1 = guardin1Field.getText();
        String guardian2 = guardian2Field.getText();
        String g1Relation = g1RelationField.getText();
        String g2relation = g2RelationField.getText();
        String knownHealth = healthField.getText();

        String selectedTeam = temsCombo.getSelectedItem().toString();
        Team team = teamDAO.getTeamByName(selectedTeam);
        JuniorPlayer juniorPlayer = new JuniorPlayer(0, name, sru, address, phone, postalCode, doctor, kin, guardian1,
                g1Relation, guardian2, g2relation, knownHealth);
        juniorPlayer.setTeam(team);
        return juniorPlayer;
    }

    public void clearFields() {
        nameField.setText("");
        sruField.setText("");
        postalCodeField.setText("");
        phoneField.setText("");
        doctorField.setText("");
        kinField.setText("");
        addressField.setText("");
        guardin1Field.setText("");
        g1RelationField.setText("");
        guardian2Field.setText("");
        g2RelationField.setText("");
    }

    public void fillTeamsCombo() {
        List<Team> teams = teamDAO.getAllTeams();
        for (Team team : teams) {
            temsCombo.addItem(team.getName());
        }
    }

    public void fillTable() {
        defaultTableModel = new DefaultTableModel(columns, 0);
        List<JuniorPlayer> juniorPlayers = juniorPlayerDAO.getAllJuniorPlayers();

        for (JuniorPlayer p : juniorPlayers) {
            Object row[] = {p.getJuniorPlayerId(), p.getName(), p.getSruNum(), p.getPhone(), p.getAddress(), p.getPostCode(),
                p.getTeam().getName(), p.getDoctor(), p.getNextOfKin(),
                p.getGuardian1(), p.getGuardian1Relation(), p.getGuardian2(), p.getGuardian2Relation(),p.getKnownHealth()};
            defaultTableModel.addRow(row);
            juniorPlayerTable.setModel(defaultTableModel);
        }
        juniorPlayerTable.getColumnModel().getColumn(0).setWidth(0);
        juniorPlayerTable.getColumnModel().getColumn(0).setMinWidth(0);
        juniorPlayerTable.getColumnModel().getColumn(0).setMaxWidth(0);

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
        juniorPlayerTable = new javax.swing.JTable();
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
        sruLbl1 = new javax.swing.JLabel();
        sruField1 = new javax.swing.JTextField();
        postalCodeField1 = new javax.swing.JTextField();
        passwordLbl1 = new javax.swing.JLabel();
        addressLbl1 = new javax.swing.JLabel();
        addressField1 = new javax.swing.JTextField();
        kinLbl1 = new javax.swing.JLabel();
        kinField1 = new javax.swing.JTextField();
        g1RelationField = new javax.swing.JTextField();
        guardian2Lbl = new javax.swing.JLabel();
        guardin1Field = new javax.swing.JTextField();
        g2RelationLbl = new javax.swing.JLabel();
        guardian2Field = new javax.swing.JTextField();
        g1RelationLbl = new javax.swing.JLabel();
        guardian1Lbl = new javax.swing.JLabel();
        g2RelationField = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        healthField = new javax.swing.JTextField();
        healthLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("Junior Player Details");

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

        juniorPlayerTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        juniorPlayerTable.setModel(new javax.swing.table.DefaultTableModel(
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
        juniorPlayerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                juniorPlayerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(juniorPlayerTable);

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

        sruLbl1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sruLbl1.setText("SRU Num");

        sruField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        postalCodeField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        passwordLbl1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        passwordLbl1.setText("Postal Code");

        addressLbl1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addressLbl1.setText("Address");

        addressField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        kinLbl1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        kinLbl1.setText("Next of Kin");

        kinField1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        g1RelationField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        guardian2Lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        guardian2Lbl.setText("Guardian2");

        guardin1Field.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        g2RelationLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        g2RelationLbl.setText("G2-Relation");

        guardian2Field.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        g1RelationLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        g1RelationLbl.setText("G1-Relation");

        guardian1Lbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        guardian1Lbl.setText("Guardian1");

        g2RelationField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        backBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        healthField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        healthLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        healthLbl.setText("Known Health");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(backBtn)
                .addGap(389, 389, 389)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sruLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sruField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruField1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(guardian1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(guardin1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(phoneLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(postalCodeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(g1RelationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(g1RelationField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(temsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressField1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(guardian2Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(guardian2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(doctorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kinLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kinField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinField1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(g2RelationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(g2RelationField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(healthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(healthField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(sruLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sruField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardian1Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardin1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1RelationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g1RelationField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardian2Lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardian2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kinField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2RelationLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2RelationField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void juniorPlayerTableMouseClicked(java.awt.event.MouseEvent evt) {                                               
        juniorPlayerId = (Integer) juniorPlayerTable.getValueAt(juniorPlayerTable.getSelectedRow(), 0);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        JuniorPlayer existingJuniorPlayer = juniorPlayerDAO.getJuniorPlayerById(juniorPlayerId);
        setFields(existingJuniorPlayer);

    }                                              

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (isAnyFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
        } else {
            JuniorPlayer juniorPlayer = getJuniorPlayer();
            boolean b = juniorPlayerDAO.addJuniorPlayer(juniorPlayer);
            if (b) {
                JOptionPane.showMessageDialog(this, "Junior Player Added Successfully");
                fillTable();
                clearFields();
            }
        }
    }                                      

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (isAnyFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
        } else {
            JuniorPlayer juniorPlayer = getJuniorPlayer();
            juniorPlayer.setJuniorPlayerId(juniorPlayerId);
            boolean b = juniorPlayerDAO.updateJuniorPlayer(juniorPlayer);
            if (b) {
                JOptionPane.showMessageDialog(this, "Junior Player Updated Successfully");
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
        juniorPlayerId = (Integer) juniorPlayerTable.getValueAt(juniorPlayerTable.getSelectedRow(), 0);
        boolean b = juniorPlayerDAO.deleteJuniorPlayer(juniorPlayerId);
        if (b) {
            JOptionPane.showMessageDialog(this, "Junior Player Deleted Successfully");
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
    private javax.swing.JTextField addressField1;
    private javax.swing.JLabel addressLbl;
    private javax.swing.JLabel addressLbl1;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField doctorField;
    private javax.swing.JLabel doctorLbl;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField g1RelationField;
    private javax.swing.JLabel g1RelationLbl;
    private javax.swing.JTextField g2RelationField;
    private javax.swing.JLabel g2RelationLbl;
    private javax.swing.JLabel guardian1Lbl;
    private javax.swing.JTextField guardian2Field;
    private javax.swing.JLabel guardian2Lbl;
    private javax.swing.JTextField guardin1Field;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JTextField healthField;
    private javax.swing.JLabel healthLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable juniorPlayerTable;
    private javax.swing.JTextField kinField;
    private javax.swing.JTextField kinField1;
    private javax.swing.JLabel kinLbl;
    private javax.swing.JLabel kinLbl1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel passwordLbl1;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTextField postalCodeField;
    private javax.swing.JTextField postalCodeField1;
    private javax.swing.JTextField sruField;
    private javax.swing.JTextField sruField1;
    private javax.swing.JLabel sruLbl;
    private javax.swing.JLabel sruLbl1;
    private javax.swing.JComboBox<String> temsCombo;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration                   
}
