/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.manageClassController;
import dao.ClassDAO;
import dao.SubjectDAO;
import pojo.ClazzEntity;
import pojo.SubjectEntity;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Locale;

/**
 * @author Xuyen
 */
public class jPnClass extends javax.swing.JPanel {

    /**
     * Creates new form jPnQLGV
     */
    public jPnClass() {
        initComponents();
        labelId.setVisible(false);
        setData();
    }

    void setData() {
        btnDelete.setEnabled(false);
        manageClassController controller = new manageClassController(jPnTable, jTFSearch);
        controller.setField(btnDelete, jTFclassName, jTFtotal, jTFboy, labelId);
        controller.setDataToTableClass();
    }

    void setClear() {
        jTFSearch.setText("");
        jTFtotal.setText("");
        jTFclassName.setText("");
        jTFboy.setText("");
    }
    public void deleteClass(){
        int id=Integer.parseInt(labelId.getText());
        if(ClassDAO.deleteClass(ClassDAO.getClassbyId(id))){
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            setData();
            setClear();
            return;
        }
        JOptionPane.showMessageDialog(null, "Xóa không thành công!");
        setClear();

    }



    public void addClass() {
        String classname=jTFclassName.getText().toUpperCase();
        String total=jTFtotal.getText();
        String boy=jTFboy.getText();

        if (classname.length() == 0 || total.length() == 0 || boy.length() == 0) {
            JOptionPane.showMessageDialog(null, "Không để trống!");
            return;
        }
        boolean isNumeric = (total != null && total.matches("[0-9]+"));
        boolean isNumeric2 = (boy != null && boy.matches("[0-9]+"));
        if(!isNumeric||!isNumeric2){
            JOptionPane.showMessageDialog(null, "Sĩ số và Số nam là số!");
            return;
        }
        int t=Integer.parseInt(total);
        int b=Integer.parseInt(boy);
        if(b>t){
            JOptionPane.showMessageDialog(null, "Sĩ số phải lớn hơn hoặc bằng  Số nam!");
            return;
        }
        ClazzEntity cl=new ClazzEntity();
        cl.setClassname(classname);
        cl.setTotal(t);
        cl.setBoy(b);
        cl.setGirl(t-b);
        if (ClassDAO.addClass(cl)) {
            JOptionPane.showMessageDialog(null, "Thêm lớp học thành công!");
            setData();
            setClear();
            return;
        }
        JOptionPane.showMessageDialog(null, "Trùng lớp học. Vui lòng kiểm tra lại!");
        return;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFclassName = new javax.swing.JTextField();
        jTFtotal = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        labelId = new javax.swing.JLabel();
        jTFboy = new javax.swing.JTextField();
        jPnTable = new javax.swing.JPanel();

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên lớp:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sĩ số:");

        jTFclassName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFclassName.setToolTipText("");
        jTFclassName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFclassNameKeyReleased(evt);
            }
        });

        jTFtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFtotalKeyReleased(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/account-search.png"))); // NOI18N

        jTFSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFSearch.setToolTipText("Tìm kiếm");
        jTFSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSearchActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số nam:");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jTFboy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFboy.setToolTipText("");
        jTFboy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFboyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(labelId))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel1))
                                                                        .addComponent(jLabel7))
                                                                .addGap(23, 23, 23)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(btnDelete)
                                                                                .addGap(14, 14, 14))
                                                                        .addComponent(jTFtotal, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jTFSearch)
                                                                        .addComponent(jTFclassName, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                                                        .addComponent(jTFboy))))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jTFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFclassName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTFtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTFboy, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(labelId)
                                .addContainerGap(292, Short.MAX_VALUE))
        );

        jPnTable.setFocusTraversalPolicyProvider(true);
        jPnTable.setPreferredSize(new java.awt.Dimension(700, 630));

        javax.swing.GroupLayout jPnTableLayout = new javax.swing.GroupLayout(jPnTable);
        jPnTable.setLayout(jPnTableLayout);
        jPnTableLayout.setHorizontalGroup(
                jPnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 856, Short.MAX_VALUE)
        );
        jPnTableLayout.setVerticalGroup(
                jPnTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPnTable, javax.swing.GroupLayout.DEFAULT_SIZE, 856, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPnTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>

    private void jTFSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        deleteClass();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        addClass();
    }

    private void jTFclassNameKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFtotal.requestFocus();
        }
    }

    private void jTFtotalKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jTFboy.requestFocus();
        }
    }

    private void jTFboyKeyReleased(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            addClass();;
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPnTable;
    private javax.swing.JTextField jTFSearch;
    private javax.swing.JTextField jTFboy;
    private javax.swing.JTextField jTFclassName;
    private javax.swing.JTextField jTFtotal;
    private javax.swing.JLabel labelId;
    // End of variables declaration
}
