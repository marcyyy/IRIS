package iris;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.sql.Connection;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class IRIS_InvHistory extends javax.swing.JFrame{
    
    DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy"); 
    DateFormat dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String rdate = dateformat.format(date);
    String comdate = dateformat2.format(date);
    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
    String rtime = timeformat.format(date);
    String passid;
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    private void table_update(){
        //update table
        int c;
        try{
        con = IRIS_Connection.getConnection();
        pst = con.prepareStatement("select * from inventory_dump");
        rs = pst.executeQuery();
        ResultSetMetaData rss = rs.getMetaData();
        c = rss.getColumnCount();
        
        DefaultTableModel df = (DefaultTableModel)Rs_Table.getModel();
        df.setRowCount(0);
        
        while(rs.next())
        {
                Vector v2 = new Vector();
                for(int a=1; a<=c; a++)
                {
                        v2.add(rs.getString("item_id"));
                        v2.add(rs.getString("item_name"));
                        v2.add(rs.getString("item_description"));
                        v2.add(rs.getString("item_status"));
                        v2.add(rs.getString("item_source"));
                        v2.add(rs.getString("item_availability"));
                        v2.add(rs.getString("item_officer"));
                        v2.add(rs.getString("item_date"));
                        v2.add(rs.getString("dump_type"));
                }df.addRow(v2);
        }
        
        ColorTable();
        Rs_Table.setAutoCreateRowSorter(true);
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_InvHistory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ColorTable(){
	Rs_Table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
        @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
	JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
	Color c = Color.WHITE;
        Color r = new Color(175,175,175);
        Color o = new Color(255,80,80);
	Object stat = table.getValueAt(row, 8);
        String status = stat.toString(); 
        
        if( null != status)
            switch (status) {
                case "Deleted":
                    label.setBackground(r);
                    break;
                case "Updated":
                    label.setBackground(c);
                    break;
                default:
                    break;
            }
        
	
	Rs_Table.setSelectionForeground(Color.BLACK);

        return label;
        }});
                }
    
    public IRIS_InvHistory() {
        initComponents();
        table_update();
        Rs_Table.setAutoCreateRowSorter(true);
        this.setLocationRelativeTo(null);
    }
    String logn;
    IRIS_InvHistory(String logname)
    {   initComponents();
        table_update();
        logn = logname;
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
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rs_label = new javax.swing.JLabel();
        Rs_Sep = new javax.swing.JSeparator();
        Rs_Scroll = new javax.swing.JScrollPane();
        Rs_Table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Rs_SearchBar = new javax.swing.JTextField();
        Inv_LTot6 = new javax.swing.JLabel();
        Inv_LTot7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(802, 802, 802))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(46, 56, 56));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rs_label.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        rs_label.setForeground(new java.awt.Color(252, 226, 5));
        rs_label.setText("Item Inventory History");
        rs_label.setToolTipText("");

        Rs_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item ID", "Item Name", "Description", "Status", "Source", "Availability", "Officer", "Date", "Action"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Rs_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rs_TableMouseClicked(evt);
            }
        });
        Rs_Scroll.setViewportView(Rs_Table);
        if (Rs_Table.getColumnModel().getColumnCount() > 0) {
            Rs_Table.getColumnModel().getColumn(0).setPreferredWidth(35);
            Rs_Table.getColumnModel().getColumn(1).setPreferredWidth(100);
            Rs_Table.getColumnModel().getColumn(2).setPreferredWidth(150);
            Rs_Table.getColumnModel().getColumn(3).setPreferredWidth(80);
            Rs_Table.getColumnModel().getColumn(4).setPreferredWidth(50);
            Rs_Table.getColumnModel().getColumn(5).setPreferredWidth(80);
            Rs_Table.getColumnModel().getColumn(7).setPreferredWidth(85);
        }

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Updated");

        jButton5.setBackground(new java.awt.Color(92, 92, 92));
        jButton5.setText("Deleted");

        Rs_SearchBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rs_SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_SearchBarActionPerformed(evt);
            }
        });
        Rs_SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Rs_SearchBarKeyReleased(evt);
            }
        });

        Inv_LTot6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inv_LTot6.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LTot6.setText("Search:");

        Inv_LTot7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inv_LTot7.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LTot7.setText("Legends:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rs_Sep)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rs_label, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Inv_LTot6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rs_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Inv_LTot7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Rs_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rs_label)
                    .addComponent(Rs_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inv_LTot6))
                .addGap(15, 15, 15)
                .addComponent(Rs_Sep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(Inv_LTot7))
                .addGap(10, 10, 10)
                .addComponent(Rs_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String logname = logn;
        IRIS_Inventory rf = new IRIS_Inventory(logname);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Rs_SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_SearchBarActionPerformed

    private void Rs_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rs_TableMouseClicked
        DefaultTableModel df = (DefaultTableModel)Rs_Table.getModel();
        int selectedIndex = Rs_Table.getSelectedRow();

        passid = (df.getValueAt(selectedIndex, 0).toString());

    }//GEN-LAST:event_Rs_TableMouseClicked

    private void Rs_SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Rs_SearchBarKeyReleased
        DefaultTableModel df = (DefaultTableModel)Rs_Table.getModel();
        String search = Rs_SearchBar.getText().trim();
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(df);
        Rs_Table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_Rs_SearchBarKeyReleased

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
            java.util.logging.Logger.getLogger(IRIS_InvHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IRIS_InvHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IRIS_InvHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IRIS_InvHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRIS_InvHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Inv_LTot6;
    private javax.swing.JLabel Inv_LTot7;
    private javax.swing.JScrollPane Rs_Scroll;
    private javax.swing.JTextField Rs_SearchBar;
    private javax.swing.JSeparator Rs_Sep;
    private javax.swing.JTable Rs_Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel rs_label;
    // End of variables declaration//GEN-END:variables

}
