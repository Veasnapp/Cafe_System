package cafeManagementSystem;

import javax.swing.JOptionPane;
import view.*;

public class Home extends javax.swing.JFrame {

    public static String email;
    public static String name;

    public Home() {
        initComponents();
    }
    
    public Home(String userName) {
        initComponents();
        name = userName;
        if (!name.equals("Admin")) {
            btnmc.setVisible(false);
            btnnp.setVisible(false);
            btnvedp.setVisible(false);
            btnvu.setVisible(false);
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnmc = new javax.swing.JButton();
        btnnp = new javax.swing.JButton();
        btnvedp = new javax.swing.JButton();
        btnvu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/View Bills & Order Placed Details.png"))); // NOI18N
        jButton2.setText("Bill & Order Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/place order.png"))); // NOI18N
        jButton3.setText("Place Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, -1, -1));

        btnmc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnmc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/category.png"))); // NOI18N
        btnmc.setText("Manage Category");
        btnmc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmcActionPerformed(evt);
            }
        });
        getContentPane().add(btnmc, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 692, -1, -1));

        btnnp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnnp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new product.png"))); // NOI18N
        btnnp.setText("New Product");
        btnnp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnpActionPerformed(evt);
            }
        });
        getContentPane().add(btnnp, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 692, -1, -1));

        btnvedp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnvedp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view edit delete product.png"))); // NOI18N
        btnvedp.setText("View, Edit & Delete Product");
        btnvedp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvedpActionPerformed(evt);
            }
        });
        getContentPane().add(btnvedp, new org.netbeans.lib.awtextra.AbsoluteConstraints(629, 692, -1, -1));

        btnvu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/verify users.png"))); // NOI18N
        btnvu.setText("Verify Users");
        btnvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvuActionPerformed(evt);
            }
        });
        getContentPane().add(btnvu, new org.netbeans.lib.awtextra.AbsoluteConstraints(918, 692, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home page.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            setVisible(false);
            new Login().setVisible(true);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
        new Thankyou().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnmcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmcActionPerformed
        new ManageCategory().setVisible(true);
    }//GEN-LAST:event_btnmcActionPerformed

    private void btnnpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnpActionPerformed
        new AddNewProduct().setVisible(true);
    }//GEN-LAST:event_btnnpActionPerformed

    private void btnvedpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvedpActionPerformed
        new ViewEditDeleteProduct().setVisible(true);       
    }//GEN-LAST:event_btnvedpActionPerformed

    private void btnvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvuActionPerformed
        new VerifyUsers().setVisible(true);
    }//GEN-LAST:event_btnvuActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        new PlaceOrder(name).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ViewBillPlaceOrderDetails().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed


    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(name==null){
                    new Welcome().setVisible(true);
                }else{
                new Home().setVisible(true);}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnmc;
    private javax.swing.JButton btnnp;
    private javax.swing.JButton btnvedp;
    private javax.swing.JButton btnvu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
