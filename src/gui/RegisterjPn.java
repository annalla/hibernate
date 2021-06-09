/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.manageRegisterCourse;
import dao.CourseDAO;
import dao.RegistrationDAO;
import dao.StudentDAO;
import pojo.CourseEntity;
import pojo.RegistrationEntity;
import pojo.RegistrationsessionEntity;
import pojo.SemesterEntity;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 * @author Xuyen
 */
public class RegisterjPn extends javax.swing.JPanel {
    String namelogin="";
    /**
     * Creates new form DSHPjPn
     */
    public static SemesterEntity semester=null;
    public RegisterjPn() {
        jPNQLRegistrationSession.setCurrentPeriod();
        semester=jPNQLRegistrationSession.current; if(semester==null){
            JOptionPane.showMessageDialog(null, "Chưa có kì DKHP!");
            return;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Set<RegistrationsessionEntity> session=semester.getSession();
        boolean flag=false;
        for(RegistrationsessionEntity se:session){
            if(timestamp.getTime()>=se.getStartdate().getTime()&& timestamp.getTime()<=se.getEnddate().getTime()){
                flag=true;
            }
        }
        if(!flag){
            JOptionPane.showMessageDialog(null, "Chưa có kì DKHP!");
            return;
        }
        initComponents();
        namelogin=HomePageStudent.nameLogin;
        labelId.setVisible(false);
        labelId.setText("");
        jTFSearch.setVisible(false);
        setData();
    }

    void setData(){

        btnDelete.setEnabled(false);
        btnRegister.setEnabled(false);
        manageRegisterCourse controller=new manageRegisterCourse(jPnDs,jTFsearch,labelId);
        controller.setDataToTableCourseRegister(namelogin);
        controller.setbtn(btnDelete,btnRegister);
    }
    void setbtnRegistered(){
        btnDelete.setEnabled(false);
        btnRegister.setEnabled(false);
        manageRegisterCourse controller=new manageRegisterCourse(jPnDs,jTFsearch,labelId);
        controller.setbtn(btnDelete,btnRegister);
        controller.setDataToTableCourseRegistered(namelogin);
        //btnDelete.setEnabled(true);
    }
    void setBtnDelete(){
        int idcourse=Integer.parseInt(labelId.getText());
        if(RegistrationDAO.deleteRegistration(RegistrationDAO.getRegistByCourseAndUser(namelogin,idcourse))){
            JOptionPane.showMessageDialog(null, "Xóa thành công!");
            setbtnRegistered();
            return;
        }
    }
    void setBtnRegister(){
        int idcourse=Integer.parseInt(labelId.getText());
        RegistrationEntity re=new RegistrationEntity();
        re.setStudent(StudentDAO.getStudentbyUsername(namelogin));
        CourseEntity co=CourseDAO.getCoursebyId(idcourse);
        re.setCourse(co);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        re.setTime(timestamp);
        int day=co.getDay();
        int period=co.getPeriod();
        if(RegistrationDAO.checkisOk(namelogin,day,period)){
            if(RegistrationDAO.addRegistration(re)){
                JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
                setData();
                return;
            }
            JOptionPane.showMessageDialog(null, "Đã đăng ký học phần này rồi!");

            return;
        }
        JOptionPane.showMessageDialog(null, "Trùng lịch học!");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPnDs = new javax.swing.JPanel();
        jTFsearch = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRegistered = new javax.swing.JButton();
        jTFSearch = new javax.swing.JTextField();
        labelId = new javax.swing.JLabel();

        javax.swing.GroupLayout jPnDsLayout = new javax.swing.GroupLayout(jPnDs);
        jPnDs.setLayout(jPnDsLayout);
        jPnDsLayout.setHorizontalGroup(
                jPnDsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPnDsLayout.setVerticalGroup(
                jPnDsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        jTFsearch.setBorder(null);

        btnRegister.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRegistered.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegistered.setText("Đã Đăng ký");
        btnRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisteredActionPerformed(evt);
            }
        });

        labelId.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistered)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jTFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(labelId)
                                .addGap(0, 494, Short.MAX_VALUE))
                        .addComponent(jPnDs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTFsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnRegistered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(labelId)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPnDs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setBtnDelete();
    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setBtnRegister();
    }

    private void btnRegisteredActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setbtnRegistered();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegistered;
    private javax.swing.JPanel jPnDs;
    private javax.swing.JTextField jTFSearch;
    private javax.swing.JTextField jTFsearch;
    private javax.swing.JLabel labelId;
    // End of variables declaration
}
