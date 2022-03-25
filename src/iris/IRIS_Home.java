/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iris;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class IRIS_Home extends javax.swing.JFrame {
    DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy"); 
    Date date = new Date();
    String rdate = dateformat.format(date);
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm");
    String rtime = timeformat.format(date);
    int itemid = 0;
    String officer;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private void ItemList(){
        Connection con1;
        PreparedStatement pst1;
        ResultSet rs1;
        try{
        con1 = IRIS_Connection.getConnection();
        pst1 = con1.prepareStatement("select * from inventory_item");
        rs1 = pst1.executeQuery();
        
        while(rs1.next()){
            String items = rs1.getString("item_name");
            C_Name.addItem(items);
        }
        }catch(SQLException e)
            {}
    }
    
    public class Available{
       Connection con = null;
       ResultSet rs = null;
       PreparedStatement ps = null;
       
       public ResultSet find(String s){
           try{
           con = DriverManager.getConnection("jdbc:mysql://localhost/irisdbms","root","");
           ps = con.prepareStatement("select item_description,item_id from inventory where item_name = ? and item_availability in ('In Stock')");
           ps.setString(1,s);
           rs = ps.executeQuery();
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
   }
    
    private void InvUpdate(){
        try{
           SimpleDateFormat hour = new SimpleDateFormat("HH");
            String hourtime = hour.format(date);
            int htime = Integer.parseInt(hourtime);
            SimpleDateFormat minute = new SimpleDateFormat("mm");
            String minutetime = minute.format(date);
            int mtime = Integer.parseInt(minutetime);
            
           String totime = htime + ":" + mtime;
            
           java.util.Date dateStr = dateformat.parse(rdate);
           java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
           con = IRIS_Connection.getConnection();
           pst = con.prepareStatement("UPDATE inventory i INNER JOIN rental r ON i.item_id = r.rn_itemid SET i.item_availability = 'Under Rent' WHERE i.item_id = r.rn_itemid and r.rn_tmin>=? and r.rn_dtr = ?");
           pst.setString(1,totime);
           pst.setDate(2,dateDB);
           pst.executeUpdate();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Failed");
            Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(IRIS_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void Dashboard(){
        PreparedStatement invc, rnc, rnc1, rnc2, rnc3, ac, ac1, ac2;
        ResultSet rsinv, rsrn, rsrn1, rsrn2, rsrn3, rsa, rsa1, rsa2;
        con = IRIS_Connection.getConnection();
        try {
            //rental
            rnc = con.prepareStatement("select count(*) from rental");
            rsrn = rnc.executeQuery();
            rsrn.next();
            int rncount = rsrn.getInt(1);
            String rcount = String.valueOf(rncount);
            C_Rtotal.setText(rcount);
            //rental done
            rnc1 = con.prepareStatement("select count(*) from rental where rn_itemid = '1'");
            rsrn1 = rnc1.executeQuery();
            rsrn1.next();
            int rncount1 = rsrn1.getInt(1);
            String rcount1 = String.valueOf(rncount1);
            C_Done.setText(rcount1);
            //rental cancelled
            rnc2 = con.prepareStatement("select count(*) from rental where rn_itemid = '0'");
            rsrn2 = rnc2.executeQuery();
            rsrn2.next();
            int rncount2 = rsrn2.getInt(1);
            String rcount2 = String.valueOf(rncount2);
            C_Cancel.setText(rcount2);
            //reservations
            java.util.Date dateStr = dateformat.parse(rdate);
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
            rnc3 = con.prepareStatement("select count(*) from rental where rn_dtr > ? and rn_itemid not in ('1', '0')");
            rnc3.setDate(1, dateDB);
            rsrn3 = rnc3.executeQuery();
            rsrn3.next();
            int rncount3 = rsrn3.getInt(1);
            String rcount3 = String.valueOf(rncount3);
            C_Res.setText(rcount3);
            
            
            //inventory
            invc = con.prepareStatement("select count(*) from inventory");
            rsinv = invc.executeQuery();
            rsinv.next();
            int invcount = rsinv.getInt(1);
            String icount = String.valueOf(invcount);
            C_Itotal.setText(icount);
            
            //accounts
            ac = con.prepareStatement("select count(*) from login_admin");
            rsa = ac.executeQuery();
            rsa.next();
            int account = rsa.getInt(1);
            String acount = String.valueOf(account);
            C_Atotal.setText(acount);
            //admin
            ac1 = con.prepareStatement("select count(*) from login_admin where authority = 'Admin'");
            rsa1 = ac1.executeQuery();
            rsa1.next();
            int account1 = rsa1.getInt(1);
            String acount1 = String.valueOf(account1);
            C_Admin.setText(acount1);
            //officers
            ac2 = con.prepareStatement("select count(*) from login_admin where authority = 'Officer'");
            rsa2 = ac2.executeQuery();
            rsa2.next();
            int account2 = rsa2.getInt(1);
            String acount2 = String.valueOf(account2);
            C_Officer.setText(acount2);
            
            
        
        } catch (SQLException ex) {
            Logger.getLogger(IRIS_Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(IRIS_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public IRIS_Home() {
        initComponents();
        Dashboard();
        InvUpdate();
        ItemList();
        this.setLocationRelativeTo(null);
    }

    public IRIS_Home(String logname)
    { 
        initComponents();
        InvUpdate();
        Dashboard();
        ItemList();
        Logged_Name.setText(logname);
        officer = logname;
      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RentLabel = new javax.swing.JLabel();
        Rent_LItemName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        Rent_LDetails = new javax.swing.JLabel();
        Rent_LItemName1 = new javax.swing.JLabel();
        Rent_LItemName2 = new javax.swing.JLabel();
        Rent_LItemName3 = new javax.swing.JLabel();
        Rent_LItemName4 = new javax.swing.JLabel();
        Rent_LItemName5 = new javax.swing.JLabel();
        Rent_LItemName6 = new javax.swing.JLabel();
        Rent_LItemName7 = new javax.swing.JLabel();
        Rent_LItemName8 = new javax.swing.JLabel();
        C_Name = new javax.swing.JComboBox<>();
        Rent_LItemName9 = new javax.swing.JLabel();
        Rent_LItemName10 = new javax.swing.JLabel();
        Rent_LItemName11 = new javax.swing.JLabel();
        C_Res = new javax.swing.JTextField();
        C_Done = new javax.swing.JTextField();
        C_Cancel = new javax.swing.JTextField();
        C_Rtotal = new javax.swing.JTextField();
        C_Ntotal = new javax.swing.JTextField();
        C_Itotal = new javax.swing.JTextField();
        C_Admin = new javax.swing.JTextField();
        C_Officer = new javax.swing.JTextField();
        Rent_LItemName12 = new javax.swing.JLabel();
        C_Atotal = new javax.swing.JTextField();
        Rent_LDetails1 = new javax.swing.JLabel();
        about = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        inv_direct = new javax.swing.JButton();
        rs_direct = new javax.swing.JButton();
        rf_direct = new javax.swing.JButton();
        Logged_Name = new javax.swing.JLabel();
        out_direct = new javax.swing.JButton();
        logged_as = new javax.swing.JLabel();
        tr_direct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1136, 814));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("IRIS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabel3.setText("IBITS Rental & Inventory System");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JAVA\\pictures\\50x50.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addGap(325, 325, 325)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton1)))
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(46, 56, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        RentLabel.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        RentLabel.setForeground(new java.awt.Color(252, 226, 5));
        RentLabel.setText("Home");

        Rent_LItemName.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Rent_LItemName.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName.setText("Inventory Report");

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Raven\\Documents\\NetBeansProjects\\JAVA\\pictures\\100x100.png")); // NOI18N

        Rent_LDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LDetails.setForeground(new java.awt.Color(252, 226, 5));
        Rent_LDetails.setText("IRIS Dashboard");

        Rent_LItemName1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Rent_LItemName1.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName1.setText("Rentals Report");

        Rent_LItemName2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName2.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName2.setText("Reservations:");
        Rent_LItemName2.setToolTipText("");

        Rent_LItemName3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Rent_LItemName3.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName3.setText("Accounts Report");

        Rent_LItemName4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName4.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName4.setText("Rental Done:");

        Rent_LItemName5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName5.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName5.setText("Rent Cancelled:");

        Rent_LItemName6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName6.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName6.setText("Admin:");

        Rent_LItemName7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName7.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName7.setText("Officer:");

        Rent_LItemName8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName8.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName8.setText("Total:");

        C_Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        C_Name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TV" }));
        C_Name.setSelectedIndex(-1);
        C_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_NameActionPerformed(evt);
            }
        });

        Rent_LItemName9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName9.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName9.setText("Item Name:");
        Rent_LItemName9.setToolTipText("");

        Rent_LItemName10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName10.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName10.setText("Item Total:");
        Rent_LItemName10.setToolTipText("");

        Rent_LItemName11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName11.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName11.setText("Total:");

        C_Res.setEditable(false);
        C_Res.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Done.setEditable(false);
        C_Done.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Cancel.setEditable(false);
        C_Cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Rtotal.setEditable(false);
        C_Rtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Ntotal.setEditable(false);
        C_Ntotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Itotal.setEditable(false);
        C_Itotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Admin.setEditable(false);
        C_Admin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        C_Officer.setEditable(false);
        C_Officer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Rent_LItemName12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Rent_LItemName12.setForeground(new java.awt.Color(204, 204, 204));
        Rent_LItemName12.setText("Total:");

        C_Atotal.setEditable(false);
        C_Atotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Rent_LDetails1.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        Rent_LDetails1.setForeground(new java.awt.Color(252, 226, 5));
        Rent_LDetails1.setText("including due today");

        about.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rent_LItemName3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Rent_LItemName10)
                                .addGap(17, 17, 17)
                                .addComponent(C_Ntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Rent_LItemName9)
                                .addGap(17, 17, 17)
                                .addComponent(C_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Rent_LItemName11)
                                .addGap(17, 17, 17)
                                .addComponent(C_Itotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(Rent_LItemName6))
                                    .addComponent(Rent_LItemName7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(C_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(C_Officer, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Rent_LItemName12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(C_Atotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Rent_LItemName1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rent_LDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(Rent_LItemName)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rent_LDetails1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Rent_LItemName5)
                                .addComponent(Rent_LItemName4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Rent_LItemName2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Rent_LItemName8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(C_Rtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(C_Done, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(about)
                                    .addComponent(C_Res, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(RentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rent_LDetails)
                            .addComponent(about)))
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rent_LItemName1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Rent_LItemName4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(C_Res, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C_Done, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rent_LItemName2))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rent_LItemName5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(C_Rtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rent_LItemName8))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Rent_LItemName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rent_LDetails1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rent_LItemName9))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Ntotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rent_LItemName10))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rent_LItemName11)
                    .addComponent(C_Itotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rent_LItemName3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rent_LItemName6))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Officer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rent_LItemName7))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C_Atotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rent_LItemName12))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(252, 226, 5));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        inv_direct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris/pictures/6564 - Archive.png"))); // NOI18N
        inv_direct.setText("Inventory");
        inv_direct.setPreferredSize(new java.awt.Dimension(155, 23));
        inv_direct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inv_directMouseClicked(evt);
            }
        });
        inv_direct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inv_directActionPerformed(evt);
            }
        });

        rs_direct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris/pictures/6568 - Calendar.png"))); // NOI18N
        rs_direct.setText("Transaction Records");
        rs_direct.setPreferredSize(new java.awt.Dimension(155, 23));
        rs_direct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rs_directActionPerformed(evt);
            }
        });

        rf_direct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris/pictures/6569 - Compose.png"))); // NOI18N
        rf_direct.setText("Rental Form");
        rf_direct.setPreferredSize(new java.awt.Dimension(155, 23));
        rf_direct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rf_directMouseClicked(evt);
            }
        });
        rf_direct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rf_directActionPerformed(evt);
            }
        });

        Logged_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        out_direct.setText("Log Out");
        out_direct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                out_directMouseClicked(evt);
            }
        });
        out_direct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                out_directActionPerformed(evt);
            }
        });

        logged_as.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logged_as.setText("Signed in as:");

        tr_direct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iris/pictures/6592 - Settings II.png"))); // NOI18N
        tr_direct.setText("Home");
        tr_direct.setPreferredSize(new java.awt.Dimension(155, 23));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inv_direct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rs_direct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rf_direct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tr_direct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(out_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logged_as, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Logged_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tr_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rf_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rs_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inv_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logged_as, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Logged_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(out_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void inv_directMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inv_directMouseClicked
        String logname = Logged_Name.getText();
        IRIS_Inventory inv = new IRIS_Inventory(logname);
        inv.setVisible(true);
        inv.pack();
        inv.setLocationRelativeTo(null);
        inv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_inv_directMouseClicked

    private void inv_directActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inv_directActionPerformed

    }//GEN-LAST:event_inv_directActionPerformed

    private void rs_directActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rs_directActionPerformed
        String logname = Logged_Name.getText();
        IRIS_RentalSchedule rs = new IRIS_RentalSchedule(logname);
        rs.setVisible(true);
        rs.pack();
        rs.setLocationRelativeTo(null);
        rs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_rs_directActionPerformed

    private void rf_directMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rf_directMouseClicked
        String logname = Logged_Name.getText();
        IRIS_RentalForm rf = new IRIS_RentalForm(logname);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_rf_directMouseClicked

    private void rf_directActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rf_directActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rf_directActionPerformed

    private void out_directMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_out_directMouseClicked

        IRIS_LogIn out = new IRIS_LogIn();
        out.setVisible(true);
        out.pack();
        out.setLocationRelativeTo(null);
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_out_directMouseClicked

    private void out_directActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_out_directActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_out_directActionPerformed

    private void C_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_NameActionPerformed
        PreparedStatement rnc;
        ResultSet rsrn;
        con = IRIS_Connection.getConnection();
        
        String cname = C_Name.getSelectedItem().toString();
        try {
            rnc = con.prepareStatement("select count(*) from inventory where item_name = ?");
            rnc.setString(1, cname);
            rsrn = rnc.executeQuery();
            rsrn.next();
            int rncount = rsrn.getInt(1);
            String rcount = String.valueOf(rncount);
            C_Ntotal.setText(rcount);
            
        } catch (SQLException ex) {
            Logger.getLogger(IRIS_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_C_NameActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        
        IRIS_About out = new IRIS_About();
        out.setVisible(true);
        out.pack();
        out.setLocationRelativeTo(null);
        out.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//GEN-LAST:event_aboutActionPerformed

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
            java.util.logging.Logger.getLogger(IRIS_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IRIS_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IRIS_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IRIS_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRIS_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField C_Admin;
    private javax.swing.JTextField C_Atotal;
    private javax.swing.JTextField C_Cancel;
    private javax.swing.JTextField C_Done;
    private javax.swing.JTextField C_Itotal;
    private javax.swing.JComboBox<String> C_Name;
    private javax.swing.JTextField C_Ntotal;
    private javax.swing.JTextField C_Officer;
    private javax.swing.JTextField C_Res;
    private javax.swing.JTextField C_Rtotal;
    private javax.swing.JLabel Logged_Name;
    private javax.swing.JLabel RentLabel;
    private javax.swing.JLabel Rent_LDetails;
    private javax.swing.JLabel Rent_LDetails1;
    private javax.swing.JLabel Rent_LItemName;
    private javax.swing.JLabel Rent_LItemName1;
    private javax.swing.JLabel Rent_LItemName10;
    private javax.swing.JLabel Rent_LItemName11;
    private javax.swing.JLabel Rent_LItemName12;
    private javax.swing.JLabel Rent_LItemName2;
    private javax.swing.JLabel Rent_LItemName3;
    private javax.swing.JLabel Rent_LItemName4;
    private javax.swing.JLabel Rent_LItemName5;
    private javax.swing.JLabel Rent_LItemName6;
    private javax.swing.JLabel Rent_LItemName7;
    private javax.swing.JLabel Rent_LItemName8;
    private javax.swing.JLabel Rent_LItemName9;
    private javax.swing.JButton about;
    private javax.swing.JButton inv_direct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logged_as;
    private javax.swing.JButton out_direct;
    private javax.swing.JButton rf_direct;
    private javax.swing.JButton rs_direct;
    private javax.swing.JButton tr_direct;
    // End of variables declaration//GEN-END:variables
}
