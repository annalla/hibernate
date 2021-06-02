/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import controller.ScreenController;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xuyen
 */
public class HomePageStudent extends javax.swing.JFrame {

    /**
     * Creates new form HomePageStudent
     */
    public HomePageStudent() {
        initComponents();
        List<DanhMuc> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMuc("Account", jPnAccount, jLbAccount));
        listDanhMuc.add(new DanhMuc("DSHP", jPnDS, jLbDs));
        listDanhMuc.add(new DanhMuc("Register", jPnRegister, jLbRegister));

        ScreenController controller = new ScreenController(jPnStudent);
        controller.setDashboard(jPnAccount, jLbAccount);
        controller.setEvent(listDanhMuc);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPnNav = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPnDS = new javax.swing.JPanel();
        jLbDs = new javax.swing.JLabel();
        jPnRegister = new javax.swing.JPanel();
        jLbRegister = new javax.swing.JLabel();
        jPnAccount = new javax.swing.JPanel();
        jLbAccount = new javax.swing.JLabel();
        jPnStudent = new javax.swing.JPanel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jPnDS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLbDs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLbDs.setText("Danh sách Học Phần");
        jLbDs.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                jLbDsComponentRemoved(evt);
            }
        });

        javax.swing.GroupLayout jPnDSLayout = new javax.swing.GroupLayout(jPnDS);
        jPnDS.setLayout(jPnDSLayout);
        jPnDSLayout.setHorizontalGroup(
                jPnDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnDSLayout.createSequentialGroup()
                                .addGap(0, 20, Short.MAX_VALUE)
                                .addComponent(jLbDs, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPnDSLayout.setVerticalGroup(
                jPnDSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLbDs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPnRegister.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLbRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLbRegister.setText("Đăng ký học phần");

        javax.swing.GroupLayout jPnRegisterLayout = new javax.swing.GroupLayout(jPnRegister);
        jPnRegister.setLayout(jPnRegisterLayout);
        jPnRegisterLayout.setHorizontalGroup(
                jPnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPnRegisterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLbRegister)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPnRegisterLayout.setVerticalGroup(
                jPnRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPnRegisterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLbRegister)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLbAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        javax.swing.GroupLayout jPnAccountLayout = new javax.swing.GroupLayout(jPnAccount);
        jPnAccount.setLayout(jPnAccountLayout);
        jPnAccountLayout.setHorizontalGroup(
                jPnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnAccountLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLbAccount)
                                .addContainerGap())
        );
        jPnAccountLayout.setVerticalGroup(
                jPnAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLbAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPnNavLayout = new javax.swing.GroupLayout(jPnNav);
        jPnNav.setLayout(jPnNavLayout);
        jPnNavLayout.setHorizontalGroup(
                jPnNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPnNavLayout.createSequentialGroup()
                                .addGap(0, 47, Short.MAX_VALUE)
                                .addComponent(jPnDS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(jPnAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogout)
                                .addContainerGap())
        );
        jPnNavLayout.setVerticalGroup(
                jPnNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPnNavLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPnNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPnDS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPnNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                                .addComponent(jPnAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPnStudentLayout = new javax.swing.GroupLayout(jPnStudent);
        jPnStudent.setLayout(jPnStudentLayout);
        jPnStudentLayout.setHorizontalGroup(
                jPnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPnStudentLayout.setVerticalGroup(
                jPnStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 352, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPnNav, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPnStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPnNav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPnStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>

    private void jLbDsComponentRemoved(java.awt.event.ContainerEvent evt) {
        // TODO add your handling code here:
    }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
            java.util.logging.Logger.getLogger(HomePageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnLogout;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLbAccount;
    private javax.swing.JLabel jLbDs;
    private javax.swing.JLabel jLbRegister;
    private javax.swing.JPanel jPnAccount;
    private javax.swing.JPanel jPnDS;
    private javax.swing.JPanel jPnNav;
    private javax.swing.JPanel jPnRegister;
    private javax.swing.JPanel jPnStudent;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    // End of variables declaration
}