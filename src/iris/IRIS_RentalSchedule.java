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

public class IRIS_RentalSchedule extends javax.swing.JFrame{
    
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
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
    
        int c, dtcount = 0, dncount = 0, rscount = 0, totcount = 0;
        try{
        con = IRIS_Connection.getConnection();
        pst = con.prepareStatement("select * from rental");
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
                        v2.add(rs.getString("rn_id"));
                        v2.add(rs.getString("rn_stuname"));
                        v2.add(rs.getDate("rn_dtr"));
                        v2.add(rs.getString("rn_room"));
                        v2.add(rs.getString("rn_tmin"));
                        v2.add(rs.getString("rn_tmout"));
                        v2.add(rs.getString("rn_itemid"));
                        v2.add(rs.getString("rn_itemname"));
                        v2.add(rs.getString("rn_itemdesc"));
                        v2.add(rs.getString("rn_fee"));
                        v2.add(rs.getString("rn_oic"));
                        v2.add(rs.getString("rn_cdate"));
                        v2.add(rs.getString("rn_dtr"));
                }
                cal2.setTime((Date)v2.get(2));
                if((true==(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                        cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)))
                        && "0".equals(v2.get(6)) || "1".equals(v2.get(6))){
                    dncount++;
                }
                else if(true==(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                        cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))){
                    dtcount++;
                }
                else if(false==(date.after((Date)v2.get(2)))){
                    rscount++;
                }
                else {
                    dncount++;
                }
                df.addRow(v2);
        }
        
        
        totcount = dtcount + rscount + dncount;
        
        String str1 = Integer.toString(dtcount);
        Rs_DueToday.setText(str1);
        String str2 = Integer.toString(rscount);
        Rs_TotRes.setText(str2);
        String str3 = Integer.toString(dncount);
        Rs_TotDone.setText(str3);
        String str4 = Integer.toString(totcount);
        Rs_Tot.setText(str4);
        
        ColorTable();
        Rs_Table.setAutoCreateRowSorter(true);
        
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Failed");
                Logger.getLogger(IRIS_RentalSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ColorTable(){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        Calendar cal2 = Calendar.getInstance();
        
	Rs_Table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
        @Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
	JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
	Color c = Color.WHITE;
        Color r = new Color(175,175,175);
        Color o = new Color(255,80,80);
        Color g = new Color(102,255,102);
	Object dtext = table.getValueAt(row, 2);
        Object idtext = table.getValueAt(row, 6);
        
        String itemid = idtext.toString(); 
        cal2.setTime((Date)dtext);
        
        
        if(dtext != null && true == (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))
                    && "1".equals(itemid)
                )
            label.setBackground(r);
        else if(dtext != null && "1".equals(itemid))
            label.setBackground(r);
        else if(dtext != null&& "0".equals(itemid))
            label.setBackground(o);
        else if(dtext != null &&(true==(cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                        cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR))))
		label.setBackground(g);
        else if (dtext != null && (false==(date.after((Date)dtext))))
            label.setBackground(c);
        else
            label.setBackground(r);
        
	
	Rs_Table.setSelectionForeground(Color.BLACK);

        return label;
        }});
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
    
    public IRIS_RentalSchedule() {
        initComponents();
        table_update();
        InvUpdate();
        Rs_Table.setAutoCreateRowSorter(true);
        this.setLocationRelativeTo(null);
    }

    IRIS_RentalSchedule(String logname)
    {
        initComponents();
        table_update();
        InvUpdate();
        Logged_Name.setText(logname);
        
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
        rs_label = new javax.swing.JLabel();
        Rs_Sep = new javax.swing.JSeparator();
        Rs_Scroll = new javax.swing.JScrollPane();
        Rs_Table = new javax.swing.JTable();
        Rs_Delete = new javax.swing.JButton();
        Rs_Done = new javax.swing.JButton();
        Rs_Cancel = new javax.swing.JButton();
        Rs_Edit = new javax.swing.JButton();
        Rs_DueToday = new javax.swing.JTextField();
        Inv_LTot3 = new javax.swing.JLabel();
        Inv_LBorrow1 = new javax.swing.JLabel();
        Rs_TotRes = new javax.swing.JTextField();
        Separator2 = new javax.swing.JSeparator();
        Inv_LTot4 = new javax.swing.JLabel();
        Rs_TotDone = new javax.swing.JTextField();
        Inv_LBorrow2 = new javax.swing.JLabel();
        Rs_Tot = new javax.swing.JTextField();
        Inv_LBorrow3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Rs_SearchBar = new javax.swing.JTextField();
        Inv_LTot6 = new javax.swing.JLabel();
        Inv_LTot7 = new javax.swing.JLabel();
        Rs_History = new javax.swing.JButton();
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
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(751, 751, 751))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
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
        rs_label.setText("Rent Schedules");
        rs_label.setToolTipText("");

        Rs_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rent ID", "Student Name", "Rent Date", "Room", "Time In", "Time Out", "Item ID", "Item", "Description", "Fee", "Officer", "Transaction Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
            Rs_Table.getColumnModel().getColumn(3).setPreferredWidth(35);
            Rs_Table.getColumnModel().getColumn(4).setPreferredWidth(35);
            Rs_Table.getColumnModel().getColumn(5).setPreferredWidth(35);
            Rs_Table.getColumnModel().getColumn(6).setPreferredWidth(35);
            Rs_Table.getColumnModel().getColumn(8).setPreferredWidth(100);
            Rs_Table.getColumnModel().getColumn(9).setPreferredWidth(25);
            Rs_Table.getColumnModel().getColumn(11).setPreferredWidth(85);
        }

        Rs_Delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rs_Delete.setText("Delete Record");
        Rs_Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rs_DeleteMouseClicked(evt);
            }
        });
        Rs_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_DeleteActionPerformed(evt);
            }
        });

        Rs_Done.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rs_Done.setText("Rent Done");
        Rs_Done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rs_DoneMouseClicked(evt);
            }
        });
        Rs_Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_DoneActionPerformed(evt);
            }
        });

        Rs_Cancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rs_Cancel.setText("Rent Cancel");
        Rs_Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rs_CancelMouseClicked(evt);
            }
        });
        Rs_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_CancelActionPerformed(evt);
            }
        });

        Rs_Edit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rs_Edit.setText("Edit Record");
        Rs_Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rs_EditMouseClicked(evt);
            }
        });
        Rs_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_EditActionPerformed(evt);
            }
        });

        Rs_DueToday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rs_DueToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_DueTodayActionPerformed(evt);
            }
        });

        Inv_LTot3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inv_LTot3.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LTot3.setText("Due Today:");

        Inv_LBorrow1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inv_LBorrow1.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LBorrow1.setText("Reservations:");

        Rs_TotRes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Inv_LTot4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Inv_LTot4.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LTot4.setText("Rent Summary");

        Rs_TotDone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Inv_LBorrow2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inv_LBorrow2.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LBorrow2.setText("Done:");

        Rs_Tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Inv_LBorrow3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Inv_LBorrow3.setForeground(new java.awt.Color(204, 204, 204));
        Inv_LBorrow3.setText("Total:");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reserved");

        jButton4.setBackground(new java.awt.Color(60, 233, 60));
        jButton4.setText("Today");

        jButton5.setBackground(new java.awt.Color(92, 92, 92));
        jButton5.setText("Done");

        jButton6.setBackground(new java.awt.Color(239, 49, 49));
        jButton6.setText("Cancelled");

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

        Rs_History.setText("History");
        Rs_History.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rs_HistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rs_Sep)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Inv_LTot4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Inv_LBorrow2)
                                        .addGap(18, 18, 18)
                                        .addComponent(Rs_TotDone, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Inv_LBorrow3)
                                        .addGap(18, 18, 18)
                                        .addComponent(Rs_Tot, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Inv_LBorrow1)
                                    .addComponent(Inv_LTot3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Rs_TotRes, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Rs_DueToday, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Rs_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rs_Edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rs_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Rs_Done, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rs_label, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Rs_History, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Inv_LTot7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Inv_LTot6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Rs_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Rs_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 24, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rs_label)
                    .addComponent(Rs_History))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rs_Sep, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Rs_SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inv_LTot6)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(Inv_LTot7))
                .addGap(8, 8, 8)
                .addComponent(Rs_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Inv_LTot4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inv_LTot3)
                            .addComponent(Rs_DueToday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inv_LBorrow1)
                            .addComponent(Rs_TotRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inv_LBorrow2)
                            .addComponent(Rs_TotDone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Inv_LBorrow3)
                            .addComponent(Rs_Tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Rs_Done)
                        .addGap(11, 11, 11)
                        .addComponent(Rs_Cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rs_Edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Rs_Delete)
                        .addGap(7, 7, 7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        tr_direct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tr_directMouseClicked(evt);
            }
        });
        tr_direct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tr_directActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inv_direct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
            .addComponent(rs_direct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rf_direct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(out_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logged_as, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logged_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tr_direct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tr_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(rf_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rs_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inv_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logged_as, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Logged_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(out_direct, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        // TODO add your handling code here:
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

    private void Rs_SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_SearchBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_SearchBarActionPerformed

    private void Rs_DueTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_DueTodayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_DueTodayActionPerformed

    private void Rs_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_EditActionPerformed
        String logname = Logged_Name.getText();
        IRIS_RentalEdit re = new IRIS_RentalEdit(logname,passid);
        re.setVisible(true);
        re.pack();
        re.setLocationRelativeTo(null);
        re.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();

    }//GEN-LAST:event_Rs_EditActionPerformed

    private void Rs_EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rs_EditMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_EditMouseClicked

    private void Rs_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_CancelActionPerformed
        DefaultTableModel df = (DefaultTableModel)Rs_Table.getModel();
        int selectedIndex = Rs_Table.getSelectedRow();

        try{
            int rid = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            
            PreparedStatement pst3,pst4;
                
                pst3 = con.prepareStatement("INSERT INTO `rental_dump`(`rn_id`, `rn_stuno`, `rn_stuname`, `rn_section`, `rn_dtr`, `rn_room`, `rn_tmin`, `rn_tmout`, `rn_itemid`, `rn_itemname`, `rn_itemdesc`, `rn_fee`, `rn_oic`, `rn_cdate`) SELECT `rn_id`, `rn_stuno`, `rn_stuname`, `rn_section`, `rn_dtr`, `rn_room`, `rn_tmin`, `rn_tmout`, `rn_itemid`, `rn_itemname`, `rn_itemdesc`, `rn_fee`, `rn_oic`, `rn_cdate` FROM `rental` WHERE rn_id = ?", Statement.RETURN_GENERATED_KEYS);
                pst4 = con.prepareStatement("UPDATE rental_dump i INNER JOIN rental r ON i.rn_id = r.rn_id SET i.rn_type = 'Cancelled' WHERE i.rn_id = r.rn_id and i.rn_id = ? and i.rdump_id = ?");

                pst3.setInt(1, rid);
                pst3.executeUpdate();
                
                ResultSet ts = pst3.getGeneratedKeys();
                int rec_id=0;
                if (ts.next()){
                    rec_id= ts.getInt(1);
                }
                
                pst4.setInt(1, rid);
                pst4.setInt(2, rec_id);
                pst4.executeUpdate();
                
            
            int dialogRes = JOptionPane.showConfirmDialog(null,"Do you confirm the Cancellation of Rent?","Confirm",JOptionPane.YES_NO_OPTION);
            if(dialogRes == JOptionPane.YES_OPTION)
            {   con = IRIS_Connection.getConnection();
                PreparedStatement pst2;
                pst = con.prepareStatement("UPDATE inventory i INNER JOIN rental r ON i.item_id = r.rn_itemid SET r.rn_itemid = '0' , i.item_availability = 'In Stock' WHERE i.item_id = r.rn_itemid and r.rn_id = ?");
                pst.setInt(1, rid);

                if(pst.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Item Successfully Updated");
                    table_update();
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Failed");
            Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rs_CancelActionPerformed

    private void Rs_CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rs_CancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_CancelMouseClicked

    private void Rs_DoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_DoneActionPerformed
        DefaultTableModel df = (DefaultTableModel)Rs_Table.getModel();
        int selectedIndex = Rs_Table.getSelectedRow();

        try{
            int rid = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            
            int dialogRes = JOptionPane.showConfirmDialog(null,"Is the item received in Good Condition?","Confirm",JOptionPane.YES_NO_OPTION);
            if(dialogRes == JOptionPane.YES_OPTION)
            {   con = IRIS_Connection.getConnection();
                PreparedStatement pst2;
                pst = con.prepareStatement("UPDATE inventory i INNER JOIN rental r ON i.item_id = r.rn_itemid SET r.rn_itemid = '1' , i.item_availability = 'In Stock' WHERE i.item_id = r.rn_itemid and r.rn_id = ?");
                pst.setInt(1, rid);

                if(pst.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Item Successfully Updated");
                    table_update();
                }

            }
            else
            {   con = IRIS_Connection.getConnection();
                PreparedStatement pst2;
                pst = con.prepareStatement("UPDATE inventory i INNER JOIN rental r ON i.item_id = r.rn_itemid SET r.rn_itemid = '1' , i.item_status = 'Damaged', i.item_availability = 'Unavailable' WHERE i.item_id = r.rn_itemid and r.rn_id = ?");
                pst.setInt(1, rid);

                if(pst.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Item Successfully Updated");
                    table_update();
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Failed");
            Logger.getLogger(IRIS_RentalSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Rs_DoneActionPerformed

    private void Rs_DoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rs_DoneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_DoneMouseClicked

    private void Rs_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_DeleteActionPerformed
        DefaultTableModel df = (DefaultTableModel)Rs_Table.getModel();
        int selectedIndex = Rs_Table.getSelectedRow();

        try{
            int rid = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
            int dialogRes = JOptionPane.showConfirmDialog(null,"Do you want to Delete the Rent Record #"+rid+"?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogRes == JOptionPane.YES_OPTION)
            {   con = IRIS_Connection.getConnection();
                PreparedStatement pst2,pst3,pst4;
                pst3 = con.prepareStatement("INSERT INTO `rental_dump`(`rn_id`, `rn_stuno`, `rn_stuname`, `rn_section`, `rn_dtr`, `rn_room`, `rn_tmin`, `rn_tmout`, `rn_itemid`, `rn_itemname`, `rn_itemdesc`, `rn_fee`, `rn_oic`, `rn_cdate`) SELECT `rn_id`, `rn_stuno`, `rn_stuname`, `rn_section`, `rn_dtr`, `rn_room`, `rn_tmin`, `rn_tmout`, `rn_itemid`, `rn_itemname`, `rn_itemdesc`, `rn_fee`, `rn_oic`, `rn_cdate` FROM `rental` WHERE rn_id = ?", Statement.RETURN_GENERATED_KEYS);
                pst4 = con.prepareStatement("UPDATE rental_dump i INNER JOIN rental r ON i.rn_id = r.rn_id SET i.rn_type = 'Deleted' WHERE i.rn_id = r.rn_id and i.rn_id = ? and i.rdump_id = ?");
                pst2 = con.prepareStatement("UPDATE inventory i INNER JOIN rental r ON i.item_id = r.rn_itemid SET r.rn_itemid = '1' , i.item_availability = 'In Stock' WHERE i.item_id = r.rn_itemid and r.rn_id = ?");
                pst = con.prepareStatement("delete from rental where rn_id = ?");
                
                pst3.setInt(1, rid);
                pst3.executeUpdate();
                
                ResultSet ts = pst3.getGeneratedKeys();
                int rec_id=0;
                if (ts.next()){
                    rec_id= ts.getInt(1);
                }
                
                pst4.setInt(1, rid);
                pst4.setInt(2, rec_id);
                pst2.setInt(1, rid);
                pst.setInt(1, rid);
                
                pst4.executeUpdate();
                pst2.executeUpdate();
                if(pst.executeUpdate() > 0)
                {
                    JOptionPane.showMessageDialog(null,"Item Successfully Deleted");
                    table_update();
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Failed");
            Logger.getLogger(IRIS_AdminAccounts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rs_DeleteActionPerformed

    private void Rs_DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rs_DeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Rs_DeleteMouseClicked

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

    private void tr_directMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tr_directMouseClicked
        String logname = Logged_Name.getText();
        IRIS_Home rf = new IRIS_Home(logname);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_tr_directMouseClicked

    private void tr_directActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tr_directActionPerformed
        String logname = Logged_Name.getText();
        IRIS_Home rf = new IRIS_Home(logname);
        rf.setVisible(true);
        rf.pack();
        rf.setLocationRelativeTo(null);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_tr_directActionPerformed

    private void Rs_HistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rs_HistoryActionPerformed
            String logname = Logged_Name.getText();
            IRIS_RentalHistory rf = new IRIS_RentalHistory(logname);
            rf.setVisible(true);
            rf.pack();
            rf.setLocationRelativeTo(null);
            rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_Rs_HistoryActionPerformed

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
            java.util.logging.Logger.getLogger(IRIS_RentalSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IRIS_RentalSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IRIS_RentalSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IRIS_RentalSchedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IRIS_RentalSchedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Inv_LBorrow1;
    private javax.swing.JLabel Inv_LBorrow2;
    private javax.swing.JLabel Inv_LBorrow3;
    private javax.swing.JLabel Inv_LTot3;
    private javax.swing.JLabel Inv_LTot4;
    private javax.swing.JLabel Inv_LTot6;
    private javax.swing.JLabel Inv_LTot7;
    private javax.swing.JLabel Logged_Name;
    private javax.swing.JButton Rs_Cancel;
    private javax.swing.JButton Rs_Delete;
    private javax.swing.JButton Rs_Done;
    private javax.swing.JTextField Rs_DueToday;
    private javax.swing.JButton Rs_Edit;
    private javax.swing.JButton Rs_History;
    private javax.swing.JScrollPane Rs_Scroll;
    private javax.swing.JTextField Rs_SearchBar;
    private javax.swing.JSeparator Rs_Sep;
    private javax.swing.JTable Rs_Table;
    private javax.swing.JTextField Rs_Tot;
    private javax.swing.JTextField Rs_TotDone;
    private javax.swing.JTextField Rs_TotRes;
    private javax.swing.JSeparator Separator2;
    private javax.swing.JButton inv_direct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logged_as;
    private javax.swing.JButton out_direct;
    private javax.swing.JButton rf_direct;
    private javax.swing.JButton rs_direct;
    private javax.swing.JLabel rs_label;
    private javax.swing.JButton tr_direct;
    // End of variables declaration//GEN-END:variables

}
