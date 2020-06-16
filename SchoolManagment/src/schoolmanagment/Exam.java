
package schoolmanagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Exam extends javax.swing.JFrame {

    public Exam() {
        initComponents();
        connect();
        loadClass();
        loadsection();
        loadsubject();
        examLoad();
    }
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;
    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/schoolmanagment","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     
    }
    public void loadClass(){
        try {
            pst = conn.prepareStatement("select distinct classname from class");
            rs = pst.executeQuery();
            chk2.removeAllItems();
            while(rs.next()){
                    chk2.addItem(rs.getString("classname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public void loadsection(){
        try {
            pst = conn.prepareStatement("select distinct section from class ");
            rs = pst.executeQuery();
            chk3.removeAllItems();
            while(rs.next()){
               chk3.addItem(rs.getString("section"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    public void loadsubject(){
        try {
            pst = conn.prepareStatement("select distinct subjectname from subject");
            rs = pst.executeQuery();
            chk4.removeAllItems();
            while(rs.next()){
                 
                 chk4.addItem(rs.getString("subjectname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
    }
    public void examLoad(){
        try {
            pst = conn.prepareStatement("select * from exam");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
            
            d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            while(rs.next()){
              Vector v = new Vector();  
              for(int i = 0; i<=c ; i++){
                v.add(rs.getString("examid"));
                v.add(rs.getString("examname"));
                v.add(rs.getString("term"));
                v.add(rs.getString("date"));
                v.add(rs.getString("class"));
                v.add(rs.getString("section"));
                v.add(rs.getString("subject"));
                
              } 
                d.addRow(v);
            }
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtename = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        chk1 = new javax.swing.JComboBox<>();
        chk2 = new javax.swing.JComboBox<>();
        chk3 = new javax.swing.JComboBox<>();
        chk4 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Exam");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Exam Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Term");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Class");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Section");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Subject");

        txtename.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        chk1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chk1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st term", "2nd term", "3rd term", "4th term", "5th term" }));

        chk2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        chk3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        chk4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chk4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtename)
                    .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk1, 0, 211, Short.MAX_VALUE)
                    .addComponent(chk2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(chk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chk2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(chk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(chk4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Id", "Exam Name", "Term", "Date", "Class", "Section", "Subjectl"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chk4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk4ActionPerformed
       
    }//GEN-LAST:event_chk4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String examname = txtename.getText();
            String term = chk1.getSelectedItem().toString();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String date =  df.format(txtdate.getDate());
            String classs = chk2.getSelectedItem().toString();
            String section = chk3.getSelectedItem().toString();
            String subject = chk4.getSelectedItem().toString();
            
            pst = conn.prepareStatement("insert into exam(examname,term,date,class,section,subject) values(?,?,?,?,?,?)");
            pst.setString(1,examname);
            pst.setString(2,term);
            pst.setString(3,date);
            pst.setString(4,classs);
            pst.setString(5,section);
            pst.setString(6,subject);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Record Updated in exam");
            
            txtename.setText("");
            txtdate.setCalendar(null);
            chk1.setSelectedIndex(-1);
            chk2.setSelectedIndex(-1);
            chk3.setSelectedIndex(-1);
            chk4.setSelectedIndex(-1);
            
            txtename.requestFocus();
            examLoad();
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       d = (DefaultTableModel)jTable1.getModel();
        int selectindex =  jTable1.getSelectedRow();
        String id = jTable1.getValueAt(selectindex, 0).toString();
        txtename.setText(jTable1.getValueAt(selectindex, 1).toString());
        chk1.setSelectedItem(jTable1.getValueAt(selectindex, 2).toString());
        //txtdate.setCalendar(jTable1.getValueAt(selectindex,3));
        chk2.setSelectedItem(jTable1.getValueAt(selectindex, 4).toString());
        chk3.setSelectedItem(jTable1.getValueAt(selectindex, 5).toString());
        chk4.setSelectedItem(jTable1.getValueAt(selectindex, 6).toString());
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       this.setVisible(false);
       new Main().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtename.setText("");
        chk1.setSelectedIndex(-1);
        txtdate.setCalendar(null);
        chk2.setSelectedIndex(-1);
        chk3.setSelectedIndex(-1);
        chk4.setSelectedIndex(-1);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            d = (DefaultTableModel)jTable1.getModel();
            int selectindex = jTable1.getSelectedRow();
            //Date date = new SimpleDateFormat("yyyy-mm-dd").parse();
            String id = jTable1.getValueAt(selectindex,0).toString();
            String examname = txtename.getText();
            String term = chk1.getSelectedItem().toString();
           // String date = txtdate.getCalendar().toString();
            String classs = chk2.getSelectedItem().toString(); 
            String section = chk3.getSelectedItem().toString();
            String subject = chk4.getSelectedItem().toString();

            pst = conn.prepareStatement("update exam set examname = ?, term = ?, class = ? , section = ? , subject = ?  where examid = ?");
            pst.setString(1,examname);
            pst.setString(2,term);
           // pst.setString(3,date);
            pst.setString(3, classs);
            pst.setString(4, section);
            pst.setString(5, subject);
            pst.setString(6,id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Record Edited in exam");
           
            
            txtename.setText("");
            chk1.setSelectedIndex(-1);
            txtdate.setCalendar(null);
            chk2.setSelectedIndex(-1);
            chk3.setSelectedIndex(-1);
            chk4.setSelectedIndex(-1);
            txtename.requestFocus();
            
            examLoad();
             jButton1.setEnabled(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            d = (DefaultTableModel) jTable1.getModel();
            int selectindex = jTable1.getSelectedRow();
            
            String id = jTable1.getValueAt(selectindex,0).toString();
            
            pst = conn.prepareStatement("delete from exam where examid = ?");
            pst.setString(1,id);
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Record Deleted");
            jButton1.setEnabled(true);
            
            txtename.setText("");
            txtdate.setCalendar(null);
            chk1.setSelectedIndex(-1);
            chk2.setSelectedIndex(-1);
            chk3.setSelectedIndex(-1);
            chk4.setSelectedIndex(-1);
            
            txtename.requestFocus();
            examLoad();
            jButton1.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> chk1;
    private javax.swing.JComboBox<String> chk2;
    private javax.swing.JComboBox<String> chk3;
    private javax.swing.JComboBox<String> chk4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtename;
    // End of variables declaration//GEN-END:variables
}
