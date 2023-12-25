
package simplyrugby;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 */
public class CoachFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    Object columns[] = {"Id", "First Name", "Last Name", "Email", "Address", "Team"};

    DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

    private static Integer coachId = 0;

    MemberDAO memberDAO = new MemberDAOImpl();
    TeamDAO teamDAO = new TeamDAOImpl();

    public CoachFrame() {
        initComponents();
        fillTeamsCombo();
        editBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        fillTable();
        setSize(930, 800);
        setLocation(350, 50);

    }

    @SuppressWarnings("deprecation")
	public boolean isAnyFieldsEmpty() {
        if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || emailField.getText().equals("")
                || passwordFiel.getText().equals("") || addressField.getText().equals("") || addressField.getText().equals("")) {
            return true;

        }
        return false;
    }

    public void setFields(Member member) {
        firstNameField.setText(member.getFirstName());
        lastNameField.setText(member.getLastName());
        emailField.setText(member.getEmail());
        passwordFiel.setText(member.getPassword());
        addressField.setText(member.getAddress());
        String teamName = teamDAO.getTeamById(member.getTeam().getTeamId()).getName();
        temsCombo.setSelectedItem(teamName);

    }

    @SuppressWarnings("deprecation")
    public Member getCoach() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String password = passwordFiel.getText();
        String address = addressField.getText();
        String selectedTeam = temsCombo.getSelectedItem().toString();
        Team team = teamDAO.getTeamByName(selectedTeam);
        return new Member(0, firstName, lastName, email, password, address, false, true, team);
    }

    public void clearFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        passwordFiel.setText("");
        addressField.setText("");
        emailField.setText("");
    }

    public void fillTeamsCombo() {
        List<Team> teams = teamDAO.getAllTeams();
        for (Team team : teams) {
            temsCombo.addItem(team.getName());
        }
    }

    public void fillTable() {
        defaultTableModel = new DefaultTableModel(columns, 0);
        List<Member> members = memberDAO.getAllMembers();

        for (Member m : members) {
            String teamName = teamDAO.getTeamById(m.getTeam().getTeamId()).getName();
            Object row[] = {m.getMemberId(), m.getFirstName(), m.getLastName(), m.getEmail(), m.getAddress(), teamName};
            defaultTableModel.addRow(row);
            coachTable.setModel(defaultTableModel);
        }
        coachTable.getColumnModel().getColumn(0).setWidth(0);
        coachTable.getColumnModel().getColumn(0).setMinWidth(0);
        coachTable.getColumnModel().getColumn(0).setMaxWidth(0);

    }
                       
    private void initComponents() {

    	headerLbl = new javax.swing.JLabel();
        firstNameLbl = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        emailLbl = new javax.swing.JLabel();
        lastNameLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        addressLbl = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        passwordFiel = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        coachTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        typeLbl = new javax.swing.JLabel();
        temsCombo = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerLbl.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("Coach Details");

        firstNameLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        firstNameLbl.setText("First Name");

        firstNameField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        emailLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        emailLbl.setText("Email");

        lastNameLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lastNameLbl.setText("Last Name");

        passwordLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        passwordLbl.setText("Password");

        emailField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        addressLbl.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addressLbl.setText("Address");

        addressField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        lastNameField.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        passwordFiel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        coachTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        coachTable.setModel(new javax.swing.table.DefaultTableModel(
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
        coachTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coachTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(coachTable);

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
                .addGap(159, 159, 159)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(firstNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(lastNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(emailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(passwordFiel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(190, 190, 190)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
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
                    .addComponent(firstNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordFiel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temsCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>                        

    private void coachTableMouseClicked(java.awt.event.MouseEvent evt) {                                        
        coachId = (Integer) coachTable.getValueAt(coachTable.getSelectedRow(), 0);
        editBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
        Member existingCoach = memberDAO.getMemberById(coachId);
        setFields(existingCoach);

    }                                       

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        if (isAnyFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
        } else {
            Member coach = getCoach();
            boolean b = memberDAO.addMember(coach);
            if (b) {
                JOptionPane.showMessageDialog(this, "Coach Added Successfully");
                fillTable();
                clearFields();
            }
        }
    }                                      

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (isAnyFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!!");
        } else {
            Member coach = getCoach();
            coach.setMemberId(coachId);
            boolean b = memberDAO.updateMember(coach);
            if (b) {
                JOptionPane.showMessageDialog(this, "Coach Updated Successfully");
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
        coachId = (Integer) coachTable.getValueAt(coachTable.getSelectedRow(), 0);
        boolean b = memberDAO.deleteMember(coachId);
        if (b) {
            JOptionPane.showMessageDialog(this, "Coach Deleted Successfully");
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
    private javax.swing.JTable coachTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JPasswordField passwordFiel;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JComboBox<String> temsCombo;
    private javax.swing.JLabel typeLbl;
    // End of variables declaration                   
}
