/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris;

import java.awt.HeadlessException;
import java.sql.Connection;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class IRIS_Request extends javax.swing.JFrame {

    DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy");  
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
    Date date = new Date();
    String rdate = dateformat.format(date);
    //String rtime = timeformat.format(date);
            
    public IRIS_Request() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public IRIS_Request(String logname)
    {   
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MinButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Reg_TitleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Reg_NameLabel = new javax.swing.JLabel();
        Reg_PassLabel = new javax.swing.JLabel();
        Log_Name = new javax.swing.JTextField();
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
        Search = new javax.swing.JButton();
        Reg_Status = new javax.swing.JTextField();
        Reg_NameLabel1 = new javax.swing.JLabel();
        Reg_NameLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MinButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(MinButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(46, 56, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Reg_TitleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Reg_TitleLabel.setForeground(new java.awt.Color(227, 227, 227));
        Reg_TitleLabel.setText("Request Register Account");

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

        Reg_ConfirmButton.setText("Request");
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
                            .addComponent(Reg_TitleLabel, javax.swing.GroupLayout.Alignment.LEADING)))
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
                                    .addComponent(Log_Pass, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))))))
                .addContainerGap(48, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reg_ConfirmButton)
                    .addComponent(Reg_ClearButton))
                .addGap(21, 21, 21))
        );

        jPanel5.setBackground(new java.awt.Color(252, 226, 5));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Reg_Logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JAVA\\pictures\\100x100.png")); // NOI18N

        Search.setText("Confirm");
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Reg_Status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reg_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reg_StatusActionPerformed(evt);
            }
        });

        Reg_NameLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Reg_NameLabel1.setForeground(new java.awt.Color(51, 51, 51));
        Reg_NameLabel1.setText("Check Status");

        Reg_NameLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Reg_NameLabel2.setForeground(java.awt.SystemColor.textHighlight);
        Reg_NameLabel2.setText("Enter Name");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Reg_Logo)
                            .addComponent(Reg_NameLabel1))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Reg_Status)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(Reg_NameLabel2)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Reg_Logo)
                .addGap(18, 18, 18)
                .addComponent(Reg_NameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reg_NameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Reg_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Log_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Log_NameActionPerformed

    private void Reg_YSFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_YSFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_YSFieldActionPerformed

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String reqname = Reg_Status.getText();
        try{
           con = IRIS_Connection.getConnection();
           pst = con.prepareStatement("select 1 from login_admin where acc_name = ? ");
           pst.setString(1,reqname);
           rs = pst.executeQuery();
           rs.next();
           int exist = rs.getInt(1);
           
           if(exist>0)
               JOptionPane.showMessageDialog(null,"Account already exist");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Account doesn't exist");
        }
    }//GEN-LAST:event_SearchMouseClicked

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        
    }//GEN-LAST:event_SearchActionPerformed

    private void Reg_ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_ConfirmButtonActionPerformed
            String regname = Log_Name.getText();
            String yearsection = Reg_YSField.getText();
            String schoolyear = Reg_SYField.getText();
            String regpass = String.valueOf(Log_Pass.getPassword());
            String repass = String.valueOf(Log_Repass.getPassword());
            int verify = 1;
            if(regname.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add A Username");
            }
            
            Connection con;
            PreparedStatement pst;
            ResultSet rs;
            
            try{
               con = IRIS_Connection.getConnection();
               pst = con.prepareStatement("select 1 from login_admin where acc_name = ? ");
               pst.setString(1,regname);
               rs = pst.executeQuery();
               rs.next();
               int exist = rs.getInt(1);

               if(exist>0){
                   JOptionPane.showMessageDialog(null,"Account already exist");
                   verify = 0;}
            } catch (SQLException ex) {
                verify = 1;
            }
            
            if(yearsection.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add Year & Section");
                verify = 0;
            }
            
            else if(schoolyear.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add Current School Year");
                verify = 0;
            }
            
            else if(regpass.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Add A Password");
                verify = 0;
            }
            
            else if(!regpass.equals(repass))
            {
                JOptionPane.showMessageDialog(null,"Password didn't match");
                verify = 0;
            }
            
            PreparedStatement ps;
            String query = "INSERT INTO `request`(`acc_name`, `yearsection`, `schoolyear`, `password`) VALUES (?,?,?,?)";
            if (verify > 0){
            try {
                ps = IRIS_Connection.getConnection().prepareStatement(query);
                
                ps.setString(1,regname);
                ps.setString(2,yearsection);
                ps.setString(3,schoolyear);
                ps.setString(4,regpass);
                
                
                if(ps.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Account Successfully Requested.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_Request.class.getName()).log(Level.SEVERE, null, ex);
            }}
        
    }//GEN-LAST:event_Reg_ConfirmButtonActionPerformed

    private void Reg_SYFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_SYFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_SYFieldActionPerformed

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

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        IRIS_LogIn out = new IRIS_LogIn();
        out.setVisible(true);
        out.pack();
        out.setLocationRelativeTo(null);
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ExitButtonMouseClicked

    private void Reg_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reg_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Reg_StatusActionPerformed

    private void MinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinButtonActionPerformed

    private void MinButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinButtonMouseClicked

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
            java.util.logging.Logger.getLogger(IRIS_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IRIS_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IRIS_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IRIS_Request.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRIS_Request().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextField Log_Name;
    private javax.swing.JPasswordField Log_Pass;
    private javax.swing.JPasswordField Log_Repass;
    private javax.swing.JButton MinButton;
    private javax.swing.JButton Reg_ClearButton;
    private javax.swing.JButton Reg_ConfirmButton;
    private javax.swing.JLabel Reg_Logo;
    private javax.swing.JLabel Reg_NameLabel;
    private javax.swing.JLabel Reg_NameLabel1;
    private javax.swing.JLabel Reg_NameLabel2;
    private javax.swing.JLabel Reg_PassLabel;
    private javax.swing.JLabel Reg_PassLabel1;
    private javax.swing.JTextField Reg_SYField;
    private javax.swing.JLabel Reg_SYLabel;
    private javax.swing.JTextField Reg_Status;
    private javax.swing.JLabel Reg_TitleLabel;
    private javax.swing.JTextField Reg_YSField;
    private javax.swing.JLabel Reg_YSLabel;
    private javax.swing.JButton Search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
