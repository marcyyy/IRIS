/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris;

import java.sql.Connection;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class IRIS_AdminAccounts extends javax.swing.JFrame {
    DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy"); 
    Date date = new Date();
    String rdate = dateformat.format(date);
    //SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
    //String rtime = timeformat.format(date);
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private void table_update(){
        //update table
        int c;
        try{
        con = IRIS_Connection.getConnection();
        pst = con.prepareStatement("select * from login_admin");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        c = rss.getColumnCount();

        DefaultTableModel df = (DefaultTableModel)Acc_Table.getModel();
        df.setRowCount(0);

        while(rs.next())
        {
                Vector v2 = new Vector();
                for(int a=1; a<=c; a++)
                {
                        v2.add(rs.getString("acc_id"));
                        v2.add(rs.getString("acc_name"));
                        v2.add(rs.getString("yearsection"));
                        v2.add(rs.getString("schoolyear"));
                        v2.add(rs.getString("password"));
                        v2.add(rs.getString("authority"));
                        v2.add(rs.getString("reg_admin"));
                        v2.add(rs.getString("reg_date"));
                }
                df.addRow(v2);
        }
        
        Acc_Table.setAutoCreateRowSorter(true);
    
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public IRIS_AdminAccounts() 
    {
        initComponents();
        table_update();
        this.setLocationRelativeTo(null);
    }
    
    public IRIS_AdminAccounts(String logname)
    {   initComponents();
        table_update();
        Accounts_Admin.setText(logname);
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rs_direct2 = new javax.swing.JButton();
        rs_direct3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Acc_Scroll = new javax.swing.JScrollPane();
        Acc_Table = new javax.swing.JTable();
        Accounts_LAdmin = new javax.swing.JLabel();
        Accounts_Admin = new javax.swing.JTextField();
        Accounts_LDate = new javax.swing.JLabel();
        Accounts_Date = new javax.swing.JTextField();
        Acc_Search = new javax.swing.JTextField();
        Sep1 = new javax.swing.JSeparator();
        Acc_Request = new javax.swing.JButton();
        Accounts_LDate1 = new javax.swing.JLabel();
        out_direct2 = new javax.swing.JButton();
        Acc_Delete = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        Acc_L = new javax.swing.JLabel();
        Sep2 = new javax.swing.JSeparator();
        Acc_LID = new javax.swing.JLabel();
        Acc_LOName = new javax.swing.JLabel();
        Acc_YS = new javax.swing.JLabel();
        Acc_SY = new javax.swing.JLabel();
        Acc_LPass = new javax.swing.JLabel();
        Acc_LAuth = new javax.swing.JLabel();
        Acc_ID = new javax.swing.JTextField();
        Acc_LogName = new javax.swing.JTextField();
        Acc_YSField = new javax.swing.JTextField();
        Acc_SYField = new javax.swing.JTextField();
        Acc_Auth = new javax.swing.JComboBox<>();
        Acc_Pass = new javax.swing.JPasswordField();
        Acc_Update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rs_direct2.setBackground(new java.awt.Color(255, 255, 255));
        rs_direct2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rs_direct2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JAVA\\pictures\\6586 - Paper Plane.png")); // NOI18N
        rs_direct2.setText("Registration");
        rs_direct2.setPreferredSize(new java.awt.Dimension(155, 23));
        rs_direct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rs_direct2MouseClicked(evt);
            }
        });

        rs_direct3.setBackground(new java.awt.Color(255, 255, 255));
        rs_direct3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rs_direct3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JAVA\\pictures\\6606 - Male User.png")); // NOI18N
        rs_direct3.setText("Accounts");
        rs_direct3.setPreferredSize(new java.awt.Dimension(155, 23));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton2.setText("_");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setText("X");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rs_direct2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rs_direct3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rs_direct2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rs_direct3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(46, 56, 56));

        Acc_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Year&Section", "School Year", "Password", "Authority", "Registered by", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Acc_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Acc_TableMouseClicked(evt);
            }
        });
        Acc_Scroll.setViewportView(Acc_Table);
        if (Acc_Table.getColumnModel().getColumnCount() > 0) {
            Acc_Table.getColumnModel().getColumn(0).setResizable(false);
            Acc_Table.getColumnModel().getColumn(0).setPreferredWidth(10);
            Acc_Table.getColumnModel().getColumn(1).setResizable(false);
            Acc_Table.getColumnModel().getColumn(2).setResizable(false);
            Acc_Table.getColumnModel().getColumn(3).setResizable(false);
            Acc_Table.getColumnModel().getColumn(4).setResizable(false);
            Acc_Table.getColumnModel().getColumn(5).setResizable(false);
            Acc_Table.getColumnModel().getColumn(5).setPreferredWidth(50);
            Acc_Table.getColumnModel().getColumn(6).setResizable(false);
            Acc_Table.getColumnModel().getColumn(7).setResizable(false);
        }

        Accounts_LAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Accounts_LAdmin.setForeground(new java.awt.Color(255, 255, 255));
        Accounts_LAdmin.setText("Current Admin:");

        Accounts_Admin.setEditable(false);
        Accounts_Admin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Accounts_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accounts_AdminActionPerformed(evt);
            }
        });

        Accounts_LDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Accounts_LDate.setForeground(new java.awt.Color(255, 255, 255));
        Accounts_LDate.setText("Current Date:");

        Accounts_Date.setEditable(false);
        Accounts_Date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Accounts_Date.setText(rdate);
        Accounts_Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accounts_DateActionPerformed(evt);
            }
        });

        Acc_Search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_SearchActionPerformed(evt);
            }
        });
        Acc_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Acc_SearchKeyReleased(evt);
            }
        });

        Acc_Request.setText("Account Requests");
        Acc_Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_RequestActionPerformed(evt);
            }
        });

        Accounts_LDate1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Accounts_LDate1.setForeground(new java.awt.Color(255, 255, 255));
        Accounts_LDate1.setText("Search:");

        out_direct2.setText("Log Out");
        out_direct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                out_direct2MouseClicked(evt);
            }
        });
        out_direct2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                out_direct2ActionPerformed(evt);
            }
        });

        Acc_Delete.setText("Delete");
        Acc_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Acc_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Acc_Request)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Accounts_LDate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Acc_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Accounts_LAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Accounts_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Accounts_LDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Accounts_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Acc_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(out_direct2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Accounts_LAdmin)
                    .addComponent(Accounts_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Accounts_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Accounts_LDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sep1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Acc_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Accounts_LDate1)
                    .addComponent(Acc_Request))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Acc_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(out_direct2)
                    .addComponent(Acc_Delete))
                .addGap(11, 11, 11))
        );

        jPanel5.setBackground(new java.awt.Color(252, 226, 5));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Acc_L.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        Acc_L.setForeground(new java.awt.Color(255, 255, 255));
        Acc_L.setText("Accounts");

        Acc_LID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Acc_LID.setForeground(new java.awt.Color(51, 51, 51));
        Acc_LID.setText("Account ID:");

        Acc_LOName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Acc_LOName.setForeground(new java.awt.Color(51, 51, 51));
        Acc_LOName.setText("Officer Name:");

        Acc_YS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Acc_YS.setForeground(new java.awt.Color(51, 51, 51));
        Acc_YS.setText("Year&Section:");

        Acc_SY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Acc_SY.setForeground(new java.awt.Color(51, 51, 51));
        Acc_SY.setText("School Year:");

        Acc_LPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Acc_LPass.setForeground(new java.awt.Color(51, 51, 51));
        Acc_LPass.setText("Password:");

        Acc_LAuth.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Acc_LAuth.setForeground(new java.awt.Color(51, 51, 51));
        Acc_LAuth.setText("Authority:");

        Acc_ID.setEditable(false);
        Acc_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_IDActionPerformed(evt);
            }
        });

        Acc_LogName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_LogName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_LogNameActionPerformed(evt);
            }
        });

        Acc_YSField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_YSField.setToolTipText("");
        Acc_YSField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_YSFieldActionPerformed(evt);
            }
        });

        Acc_SYField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_SYField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_SYFieldActionPerformed(evt);
            }
        });

        Acc_Auth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Acc_Auth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Officer", "Admin" }));

        Acc_Pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Acc_Update.setText("Update");
        Acc_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acc_UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Acc_LogName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Acc_LPass)
                                .addComponent(Acc_LOName)
                                .addComponent(Acc_YS)
                                .addComponent(Acc_SY)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(Acc_YSField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Acc_LAuth)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Acc_Auth, javax.swing.GroupLayout.Alignment.LEADING, 0, 110, Short.MAX_VALUE)
                                        .addComponent(Acc_Update, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(Acc_SYField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Acc_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Acc_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Acc_LID))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Sep2))
                        .addContainerGap())))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Acc_L, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Acc_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sep2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_LID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_LOName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_LogName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_YS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_YSField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_SY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_SYField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_LPass)
                .addGap(4, 4, 4)
                .addComponent(Acc_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Acc_LAuth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Acc_Auth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Acc_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Acc_LogNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_LogNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Acc_LogNameActionPerformed

    private void Acc_YSFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_YSFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Acc_YSFieldActionPerformed

    private void Acc_SYFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_SYFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Acc_SYFieldActionPerformed

    private void Acc_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Acc_IDActionPerformed

    private void Accounts_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accounts_AdminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Accounts_AdminActionPerformed

    private void Accounts_DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accounts_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Accounts_DateActionPerformed

    private void Acc_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Acc_SearchActionPerformed

    private void out_direct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_out_direct2MouseClicked
        IRIS_LogIn out = new IRIS_LogIn();
        out.setVisible(true);
        out.pack();
        out.setLocationRelativeTo(null);
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_out_direct2MouseClicked

    private void out_direct2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_out_direct2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_out_direct2ActionPerformed

    private void rs_direct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rs_direct2MouseClicked
        String logname = Accounts_Admin.getText();
        IRIS_AdminRegistration out = new IRIS_AdminRegistration(logname);
                                        out.setVisible(true);
                                        out.pack();
                                        out.setLocationRelativeTo(null);
                                        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        this.dispose();
    }//GEN-LAST:event_rs_direct2MouseClicked

    private void Acc_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Acc_TableMouseClicked
        //table select
        DefaultTableModel df = (DefaultTableModel)Acc_Table.getModel();
        int selectedIndex = Acc_Table.getSelectedRow();

        Acc_ID.setText(df.getValueAt(selectedIndex, 0).toString());
        Acc_LogName.setText(df.getValueAt(selectedIndex, 1).toString());
        Acc_YSField.setText(df.getValueAt(selectedIndex, 2).toString());
        Acc_SYField.setText(df.getValueAt(selectedIndex, 3).toString());
        Acc_Pass.setText(df.getValueAt(selectedIndex, 4).toString());
        Acc_Auth.setSelectedItem(df.getValueAt(selectedIndex, 5).toString());

    }//GEN-LAST:event_Acc_TableMouseClicked

    private void Acc_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_UpdateActionPerformed
        //
        DefaultTableModel df = (DefaultTableModel)Acc_Table.getModel();
        int selectedIndex = Acc_Table.getSelectedRow();

        try{
	int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            String logname = Acc_LogName.getText();
            String yearsection = Acc_YSField.getText();
            String schoolyear = Acc_SYField.getText();
            String logpass = String.valueOf(Acc_Pass.getPassword());
            String admin = Accounts_Admin.getText();
	    
            java.util.Date dateStr = dateformat.parse(rdate);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            
            String authtype = Acc_Auth.getSelectedItem().toString();
            
            if(logname.equals(""))
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
            
            else if(logpass.equals(""))
            {   
                JOptionPane.showMessageDialog(null,"Add A Password");
            }
            
            
            
            con = IRIS_Connection.getConnection();
            pst = con.prepareStatement("update login_admin set acc_name=?, yearsection=?, schoolyear=?, password=?, authority=?, reg_admin=?, reg_date=? where acc_id=?");
            
			pst.setString(1, logname);
                        pst.setString(2, yearsection);
			pst.setString(3, schoolyear);
                        pst.setString(4, logpass);
			pst.setString(5, authtype);
                        pst.setString(6, admin);
			pst.setDate(7, dateDB);
			pst.setInt(8, id);
		
            if(pst.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Account Successfully Updated");
                    table_update();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
            Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Acc_UpdateActionPerformed

    private void Acc_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_DeleteActionPerformed
        DefaultTableModel df = (DefaultTableModel)Acc_Table.getModel();
        int selectedIndex = Acc_Table.getSelectedRow();

        try{
            int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogRes = JOptionPane.showConfirmDialog(null,"Do you want to Delete the Record?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogRes == JOptionPane.YES_OPTION)
                {   con = IRIS_Connection.getConnection();
                    pst = con.prepareStatement("delete from login_admin where acc_id=?");
                    pst.setInt(1, id);
                    
                    if(pst.executeUpdate() > 0)
                        {
                            JOptionPane.showMessageDialog(null,"Account Successfully Deleted");
                            table_update();
                        }

                }

                    } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_Acc_DeleteActionPerformed

    private void Acc_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Acc_SearchKeyReleased
        DefaultTableModel df = (DefaultTableModel)Acc_Table.getModel();
        String search = Acc_Search.getText().trim();
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(df);
        Acc_Table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_Acc_SearchKeyReleased

    private void Acc_RequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acc_RequestActionPerformed
        String logname = Accounts_Admin.getText();
        IRIS_AdminRequest out = new IRIS_AdminRequest(logname);
                                        out.setVisible(true);
                                        out.pack();
                                        out.setLocationRelativeTo(null);
                                        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        this.dispose();
    }//GEN-LAST:event_Acc_RequestActionPerformed

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
            java.util.logging.Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRIS_AdminAccounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Acc_Auth;
    private javax.swing.JButton Acc_Delete;
    private javax.swing.JTextField Acc_ID;
    private javax.swing.JLabel Acc_L;
    private javax.swing.JLabel Acc_LAuth;
    private javax.swing.JLabel Acc_LID;
    private javax.swing.JLabel Acc_LOName;
    private javax.swing.JLabel Acc_LPass;
    private javax.swing.JTextField Acc_LogName;
    private javax.swing.JPasswordField Acc_Pass;
    private javax.swing.JButton Acc_Request;
    private javax.swing.JLabel Acc_SY;
    private javax.swing.JTextField Acc_SYField;
    private javax.swing.JScrollPane Acc_Scroll;
    private javax.swing.JTextField Acc_Search;
    private javax.swing.JTable Acc_Table;
    private javax.swing.JButton Acc_Update;
    private javax.swing.JLabel Acc_YS;
    private javax.swing.JTextField Acc_YSField;
    private javax.swing.JTextField Accounts_Admin;
    private javax.swing.JTextField Accounts_Date;
    private javax.swing.JLabel Accounts_LAdmin;
    private javax.swing.JLabel Accounts_LDate;
    private javax.swing.JLabel Accounts_LDate1;
    private javax.swing.JSeparator Sep1;
    private javax.swing.JSeparator Sep2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton out_direct2;
    private javax.swing.JButton rs_direct2;
    private javax.swing.JButton rs_direct3;
    // End of variables declaration//GEN-END:variables
}
