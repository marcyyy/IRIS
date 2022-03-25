/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris;

import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IRIS_AdminRegistration extends javax.swing.JFrame {

    DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy");  
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    String rdate = dateformat.format(date);
    //String rtime = timeformat.format(date);
            
    public IRIS_AdminRegistration() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public IRIS_AdminRegistration(String logname)
    {   
        initComponents();
        Reg_Admin.setText(logname);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RegistationTab = new javax.swing.JButton();
        AccountsTab = new javax.swing.JButton();
        MinButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Reg_TitleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Reg_NameLabel = new javax.swing.JLabel();
        Reg_PassLabel = new javax.swing.JLabel();
        Log_Name = new javax.swing.JTextField();
        Reg_AuthorityLabel = new javax.swing.JLabel();
        Log_Authority = new javax.swing.JComboBox<>();
        Reg_YSLabel = new javax.swing.JLabel();
        Reg_YSField = new javax.swing.JTextField();
        Reg_SYLabel = new javax.swing.JLabel();
        Reg_SYField = new javax.swing.JTextField();
        Reg_ConfirmButton = new javax.swing.JButton();
        Reg_ClearButton = new javax.swing.JButton();
        Reg_PassLabel1 = new javax.swing.JLabel();
        Log_Pass = new javax.swing.JPasswordField();
        Log_Repass = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        Reg_Logo = new javax.swing.JLabel();
        Reg_AdminLabel = new javax.swing.JLabel();
        Reg_Admin = new javax.swing.JTextField();
        Reg_DateLabel = new javax.swing.JLabel();
        LogOutButton = new javax.swing.JButton();
        Reg_Date = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RegistationTab.setBackground(new java.awt.Color(255, 255, 255));
        RegistationTab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RegistationTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris/pictures/6586 - Paper Plane.png"))); // NOI18N
        RegistationTab.setText("Registration");
        RegistationTab.setPreferredSize(new java.awt.Dimension(155, 23));
        RegistationTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistationTabActionPerformed(evt);
            }
        });

        AccountsTab.setBackground(new java.awt.Color(255, 255, 255));
        AccountsTab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AccountsTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris/pictures/6606 - Male User.png"))); // NOI18N
        AccountsTab.setText("Accounts");
        AccountsTab.setPreferredSize(new java.awt.Dimension(155, 23));
        AccountsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AccountsTabMouseClicked(evt);
            }
        });

        MinButton.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        MinButton.setText("_");
        MinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinButtonMouseClicked(evt);
            }
        });
        MinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinButtonActionPerformed(evt);
            }
        });

        ExitButton.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        ExitButton.setText("X");
        ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitButtonMouseClicked(evt);
            }
        });
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RegistationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AccountsTab, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MinButton)
                    .addComponent(ExitButton))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AccountsTab, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(MinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(46, 56, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Reg_TitleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Reg_TitleLabel.setForeground(new java.awt.Color(227, 227, 227));
        Reg_TitleLabel.setText("Register Account");

        Reg_NameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_NameLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_NameLabel.setText("Officer Name:");

        Reg_PassLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_PassLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_PassLabel.setText("Password:");

        Log_Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Log_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log_NameActionPerformed(evt);
            }
        });

        Reg_AuthorityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_AuthorityLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_AuthorityLabel.setText("Authority:");

        Log_Authority.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Log_Authority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Officer", "Admin" }));

        Reg_YSLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_YSLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_YSLabel.setText("Year&Section:");

        Reg_YSField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reg_YSField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_YSFieldActionPerformed(evt);
            }
        });

        Reg_SYLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_SYLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_SYLabel.setText("School Year:");

        Reg_SYField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reg_SYField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_SYFieldActionPerformed(evt);
            }
        });

        Reg_ConfirmButton.setText("Register");
        Reg_ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_ConfirmButtonActionPerformed(evt);
            }
        });

        Reg_ClearButton.setText("Clear");
        Reg_ClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reg_ClearButtonMouseClicked(evt);
            }
        });
        Reg_ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_ClearButtonActionPerformed(evt);
            }
        });

        Reg_PassLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_PassLabel1.setForeground(new java.awt.Color(255, 255, 255));
        Reg_PassLabel1.setText("Confirm Password:");

        Log_Pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Log_Repass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Reg_PassLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Log_Repass, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Reg_ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Reg_ConfirmButton))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Reg_TitleLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Reg_NameLabel)
                                .addGap(18, 18, 18)
                                .addComponent(Log_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Reg_SYLabel)
                                    .addComponent(Reg_YSLabel)
                                    .addComponent(Reg_PassLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Reg_YSField)
                                    .addComponent(Reg_SYField)
                                    .addComponent(Log_Pass, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Reg_AuthorityLabel)
                                .addGap(18, 18, 18)
                                .addComponent(Log_Authority, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Reg_TitleLabel)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_NameLabel)
                    .addComponent(Log_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_YSField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reg_YSLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_SYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reg_SYLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_PassLabel)
                    .addComponent(Log_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_PassLabel1)
                    .addComponent(Log_Repass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_AuthorityLabel)
                    .addComponent(Log_Authority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_ConfirmButton)
                    .addComponent(Reg_ClearButton))
                .addGap(21, 21, 21))
        );

        jPanel5.setBackground(new java.awt.Color(252, 226, 5));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Reg_Logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JAVA\\pictures\\100x100.png")); // NOI18N

        Reg_AdminLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_AdminLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_AdminLabel.setText("Admin:");

        Reg_Admin.setEditable(false);
        Reg_Admin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reg_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_AdminActionPerformed(evt);
            }
        });

        Reg_DateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_DateLabel.setForeground(new java.awt.Color(255, 255, 255));
        Reg_DateLabel.setText("Current Date:");

        LogOutButton.setText("Log Out");
        LogOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutButtonMouseClicked(evt);
            }
        });
        LogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutButtonActionPerformed(evt);
            }
        });

        Reg_Date.setEditable(false);
        Reg_Date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reg_Date.setText(rdate);
        Reg_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_DateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Reg_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(Reg_AdminLabel)
                            .addComponent(Reg_DateLabel)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(Reg_Logo))
                            .addComponent(Reg_Date, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(LogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Reg_Logo)
                .addGap(18, 18, 18)
                .addComponent(Reg_AdminLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reg_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reg_DateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reg_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOutButton)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Log_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Log_NameActionPerformed

    private void MinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinButtonActionPerformed

    private void MinButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinButtonMouseClicked

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void Reg_YSFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_YSFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_YSFieldActionPerformed

    private void Reg_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_AdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_AdminActionPerformed

    private void LogOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutButtonMouseClicked
        IRIS_LogIn out = new IRIS_LogIn();
        out.setVisible(true);
        out.pack();
        out.setLocationRelativeTo(null);
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_LogOutButtonMouseClicked

    private void LogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutButtonActionPerformed
        
    }//GEN-LAST:event_LogOutButtonActionPerformed

    private void RegistationTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistationTabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistationTabActionPerformed

    private void Reg_ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_ConfirmButtonActionPerformed
        try {                                                  
            String regname = Log_Name.getText();
            String yearsection = Reg_YSField.getText();
            String schoolyear = Reg_SYField.getText();
            String regpass = String.valueOf(Log_Pass.getPassword());
            String repass = String.valueOf(Log_Repass.getPassword());
            
            String regadmin = Reg_Admin.getText();
            
            java.util.Date dateStr = dateformat.parse(rdate);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            
            String authtype = Log_Authority.getSelectedItem().toString();
            
            if(regname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add A Username");
            }
            
            else if(yearsection.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add Year & Section");
            }
            
            else if(schoolyear.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add Current School Year");
            }
            
            else if(regpass.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add A Password");
            }
            
            else if(!regpass.equals(repass))
            {
                JOptionPane.showMessageDialog(null,"Password didn't match");
            }
            
            PreparedStatement ps;
            String query = "INSERT INTO `login_admin`(`acc_name`, `yearsection`, `schoolyear`, `password`, `authority`, `reg_admin`, `reg_date`) VALUES (?,?,?,?,?,?,?)";
            
            try {
                ps = IRIS_Connection.getConnection().prepareStatement(query);
                
                ps.setString(1,regname);
                ps.setString(2,yearsection);
                ps.setString(3,schoolyear);
                ps.setString(4,regpass);
                ps.setString(5,authtype);
                ps.setString(6,regadmin);
                ps.setDate(7,dateDB);
                
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Account Registered.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_AdminRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ParseException ex) {
            Logger.getLogger(IRIS_AdminRegistration.class.getName()).log(Level.SEVERE,null, ex);
        }
        
    }//GEN-LAST:event_Reg_ConfirmButtonActionPerformed

    private void Reg_SYFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_SYFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_SYFieldActionPerformed

    private void AccountsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AccountsTabMouseClicked
        String logname = Reg_Admin.getText();
        IRIS_AdminAccounts out = new IRIS_AdminAccounts(logname);
                                        out.setVisible(true);
                                        out.pack();
                                        out.setLocationRelativeTo(null);
                                        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        this.dispose();
    }//GEN-LAST:event_AccountsTabMouseClicked

    private void Reg_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_DateActionPerformed

    private void Reg_ClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reg_ClearButtonMouseClicked
        Log_Name.setText("");
        Reg_YSField.setText("");
        Reg_SYField.setText("");
        Log_Pass.setText("");
        Log_Repass.setText("");
        
    }//GEN-LAST:event_Reg_ClearButtonMouseClicked

    private void Reg_ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_ClearButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_ClearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(IRIS_AdminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IRIS_AdminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IRIS_AdminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IRIS_AdminRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRIS_AdminRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AccountsTab;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JComboBox<String> Log_Authority;
    private javax.swing.JTextField Log_Name;
    private javax.swing.JPasswordField Log_Pass;
    private javax.swing.JPasswordField Log_Repass;
    private javax.swing.JButton MinButton;
    private javax.swing.JTextField Reg_Admin;
    private javax.swing.JLabel Reg_AdminLabel;
    private javax.swing.JLabel Reg_AuthorityLabel;
    private javax.swing.JButton Reg_ClearButton;
    private javax.swing.JButton Reg_ConfirmButton;
    private javax.swing.JTextField Reg_Date;
    private javax.swing.JLabel Reg_DateLabel;
    private javax.swing.JLabel Reg_Logo;
    private javax.swing.JLabel Reg_NameLabel;
    private javax.swing.JLabel Reg_PassLabel;
    private javax.swing.JLabel Reg_PassLabel1;
    private javax.swing.JTextField Reg_SYField;
    private javax.swing.JLabel Reg_SYLabel;
    private javax.swing.JLabel Reg_TitleLabel;
    private javax.swing.JTextField Reg_YSField;
    private javax.swing.JLabel Reg_YSLabel;
    private javax.swing.JButton RegistationTab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
