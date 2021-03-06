/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.MinitryDAO;
import pojo.MinitryEntity;

import javax.swing.*;
import java.sql.Date;

/**
 * @author Xuyen
 */
public class AccountGVjPn extends javax.swing.JPanel {

    public static MinitryEntity m = MinitryDAO.getMinitrybyUsername(GVHomePage.nameLogin);

    /**
     * Creates new form dm
     */
    public AccountGVjPn() {
        initComponents();
        setInforStudent();

    }

    public void setInforStudent() {
        m = MinitryDAO.getMinitrybyUsername(GVHomePage.nameLogin);
        jTFName.setText(m.getFullname());
        jTFName.setEnabled(false);
        jTAAddress.setText(m.getAddress());
        jTAAddress.setEnabled(false);
        jCBGender.setSelectedIndex(m.getGender());
        jCBGender.setEnabled(false);
        jDCBirthday.setDate(m.getBirthday());
        jDCBirthday.setEnabled(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jPFnewpass.setVisible(false);
        jPFoldpass.setVisible(false);
        jTFrepass.setVisible(false);
        btnSave.setVisible(false);
        btnSave.setEnabled(false);
        btnUpdate.setVisible(true);
        btnUpdate.setEnabled(true);
        btnSavePass.setVisible(false);
        btnSavePass.setEnabled(false);
        btnChangPass.setVisible(true);
        btnChangPass.setEnabled(true);

    }

    public void setBtnUpdate() {
        jTFName.setEnabled(true);
        jTAAddress.setEnabled(true);
        jCBGender.setEnabled(true);
        jDCBirthday.setEnabled(true);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jPFnewpass.setVisible(false);
        jPFoldpass.setVisible(false);
        jTFrepass.setVisible(false);
        btnSave.setVisible(true);
        btnSave.setEnabled(true);
        btnUpdate.setVisible(false);
        btnUpdate.setEnabled(false);
        btnSavePass.setVisible(false);
        btnSavePass.setEnabled(false);
        btnChangPass.setVisible(true);
        btnChangPass.setEnabled(true);
        jTFName.requestFocus();
    }

    public void setBtnChangPass() {
        jPFnewpass.setText("");
        jPFoldpass.setText("");
        jTFrepass.setText("");
        jTFName.setText(m.getFullname());
        jTFName.setEnabled(false);
        jTAAddress.setText(m.getAddress());
        jTAAddress.setEnabled(false);
        jCBGender.setSelectedIndex(m.getGender());
        jCBGender.setEnabled(false);
        jDCBirthday.setDate(m.getBirthday());
        jDCBirthday.setEnabled(false);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        jLabel15.setVisible(true);
        jPFnewpass.setVisible(true);
        jPFoldpass.setVisible(true);
        jTFrepass.setVisible(true);
        btnSave.setVisible(false);
        btnSave.setEnabled(false);
        btnUpdate.setVisible(false);
        btnUpdate.setEnabled(false);
        btnSavePass.setVisible(true);
        btnSavePass.setEnabled(true);
        btnChangPass.setVisible(false);
        btnChangPass.setEnabled(false);
        jPFoldpass.requestFocus();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTFName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jDCBirthday = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPFoldpass = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAAddress = new javax.swing.JTextArea();
        jCBGender = new javax.swing.JComboBox<>();
        jPFnewpass = new javax.swing.JPasswordField();
        jTFrepass = new javax.swing.JPasswordField();
        btnSee = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSavePass = new javax.swing.JButton();
        btnChangPass = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Th??ng tin t??i kho???n");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("H??? t??n:");

        jTFName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNameActionPerformed(evt);
            }
        });
        jPFoldpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jOldpassKeyReleased(evt);
            }
        });
        jPFnewpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jNewpassKeyReleased(evt);
            }
        });
        jTFrepass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRepassKeyReleased(evt);
            }
        });
        jTFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNameKeyReleased(evt);
            }
        });
        jCBGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jGenderKeyReleased(evt);
            }
        });
        jDCBirthday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDCBirthdayReleased(evt);
            }
        });
        jTAAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jAddressKeyReleased(evt);
            }
        });
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ng??y sinh:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Gi???i t??nh:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("?????a ch???:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("M???t kh???u c??:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("M???t kh???u m???i:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Nh???p l???i m???t kh???u:");


        jTAAddress.setColumns(20);
        jTAAddress.setRows(5);
        jScrollPane2.setViewportView(jTAAddress);

        jCBGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"N???", "Nam"}));

        jPFnewpass.setToolTipText("");

        jTFrepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFrepassActionPerformed(evt);
            }
        });

        btnSee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSee.setText("Xem");
        btnSee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeActionPerformed(evt);
            }
        });
        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate.setText("C???p nh???t");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("L??u");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSavePass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSavePass.setText("L??u");
        btnSavePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePassActionPerformed(evt);
            }
        });

        btnChangPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChangPass.setText("?????i m???t kh???u");
        btnChangPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangPassActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(62, 62, 62)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel9)
                                                                        .addGap(30, 30, 30)
                                                                        .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jLabel8)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(jLabel11)
                                                                                .addComponent(jLabel12))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jDCBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jCBGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane2))))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel14)
                                                                                        .addComponent(jLabel13))
                                                                                .addGap(50, 50, 50))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabel15)
                                                                                .addGap(23, 23, 23)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jPFnewpass)
                                                                        .addComponent(jPFoldpass)
                                                                        .addComponent(jTFrepass, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(btnSee)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnUpdate)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSave)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSavePass)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnChangPass)))
                                .addContainerGap(598, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel10))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jDCBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jCBGender, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 12, Short.MAX_VALUE)
                                                .addComponent(jLabel12)
                                                .addGap(65, 65, 65)
                                                .addComponent(jLabel13)
                                                .addGap(10, 10, 10))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPFoldpass, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPFnewpass, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTFrepass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnUpdate)
                                        .addComponent(btnSee)
                                        .addComponent(btnSave)
                                        .addComponent(btnSavePass)
                                        .addComponent(btnChangPass))
                                .addGap(246, 246, 246))
        );
    }// </editor-fold>

    private void jTFNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void jTFrepassActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setBtnUpdate();
    }

    private void btnSeeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setInforStudent();
    }

    private void btnChangPassActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        setBtnChangPass();
    }

    private void jPFoldpassActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        updateInformation();
    }

    private void btnSavePassActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        updatePassword();
    }

    private void jTFNameKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jDCBirthday.requestFocus();
        }
    }

    private void jDCBirthdayReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jCBGender.requestFocus();
        }
    }

    private void jGenderKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTAAddress.requestFocus();
        }
    }

    private void jAddressKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            updateInformation();
        }
    }

    private void updateInformation() {
        if (updateInfor()) {
            JOptionPane.showMessageDialog(null, "C???p nh???t th??ng tin th??nh c??ng");
            setInforStudent();
        } else {
            JOptionPane.showMessageDialog(null, "C???p nh???t th???t b???i!");
        }
    }

    private boolean updateInfor() {
        MinitryEntity newU = m;
        String name = jTFName.getText();
        java.util.Date date = jDCBirthday.getDate();
        Date date1 = new Date(date.getYear(), date.getMonth(), date.getDate());
        int gender = jCBGender.getSelectedIndex();
        String address = jTAAddress.getText();
        if (name.length() == 0 || address.length() == 0) {
            JOptionPane.showMessageDialog(null, "T??n v?? ?????a ch??? kh??ng ????? tr???ng!");
            return false;
        }
        newU.setAddress(address);
        newU.setFullname(name);
        newU.setGender(gender);
        newU.setBirthday(date1);

        return MinitryDAO.updateMinitry(newU);
    }

    private void updatePassword() {
        if (updatePass() == true) {
            JOptionPane.showMessageDialog(null, "C???p nh???t password th??nh c??ng!");
            jPFnewpass.setText("");
            jPFoldpass.setText("");
            jTFrepass.setText("");
        } else {
            jPFnewpass.setText("");
            jPFoldpass.setText("");
            jTFrepass.setText("");
        }
    }

    private boolean updatePass() {
        MinitryEntity newPass = MinitryDAO.getMinitrybyUsername(GVHomePage.nameLogin);
        String oldpass = jPFoldpass.getText();
        String newpass = jPFnewpass.getText();
        String repass = jTFrepass.getText();
        System.out.println(oldpass);
        System.out.println(m.getPassword());
        if (oldpass.length() == 0 || newpass.length() == 0 || repass.length() == 0) {
            JOptionPane.showMessageDialog(null, "M???t kh???u m???i, M???t kh???u c?? v?? Nh???p l???i m???t kh???u kh??ng ???????c tr???ng !");
            return false;
        }
        if (newPass.getPassword().equals(oldpass) == false) {
            JOptionPane.showMessageDialog(null, "M???t kh???u c?? kh??ng tr??ng kh???p !");
            return false;
        }
        if (newpass.equals(repass) == false) {
            JOptionPane.showMessageDialog(null, "Nh???p l???i m???t kh???u kh??ng tr??ng kh???p m???t kh???u m???i !");
            return false;
        }
        if (newpass.equals(oldpass)) {
            JOptionPane.showMessageDialog(null, "M???t kh???u m???i v?? c?? tr??ng nhau!");
            return false;
        }
        if (newpass.length() < 4) {
            JOptionPane.showMessageDialog(null, "M???t kh???u n??n l???n h??n 3 k?? t??? !");
            return false;
        }
        newPass.setPassword(newpass);
        return MinitryDAO.updateMinitry(newPass);
    }

    private void jOldpassKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jPFnewpass.requestFocus();
        }
    }

    private void jNewpassKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jTFrepass.requestFocus();
        }
    }

    private void jRepassKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == evt.VK_ENTER) {
            updatePassword();
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnChangPass;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSavePass;
    private javax.swing.JButton btnSee;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jCBGender;
    private com.toedter.calendar.JDateChooser jDCBirthday;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFnewpass;
    private javax.swing.JPasswordField jPFoldpass;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAAddress;
    private javax.swing.JTextField jTFName;
    private javax.swing.JPasswordField jTFrepass;
    // End of variables declaration
}
