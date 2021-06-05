

package controller;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;

import com.toedter.calendar.JDateChooser;
import dao.MinitryDAO;
import dao.RegistrationDAO;
import dao.StudentDAO;
import org.w3c.dom.events.DocumentEvent;
import pojo.MinitryEntity;
import pojo.RegistrationEntity;
import pojo.StudentEntity;


public class StudentController {

    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JButton btnDelete;
    private JButton btnReset;
    private JButton btnUpdate;
    private JTextField jTFUsername;
    private JTextField jTFName;
    private JComboBox jCBgender;
    private JTextArea jaddress;
    private JDateChooser jBirth;
    private  JLabel id;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNSCourse = {"STT", "Mã MH", "Tên MH", "Số tín chỉ", "Lịch học"};

    private final String[] COLUMNSMinitry = {"STT", "Username", "Password", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public StudentController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
    }

    public void setButton(JButton btndelete, JButton btnreset, JButton btnupdate, JTextField username, JTextField name, JComboBox gender, JTextArea address, JDateChooser birth,JLabel id) {
        this.btnDelete = btndelete;
        this.btnReset = btnreset;
        this.btnUpdate = btnupdate;
        this.jaddress = address;
        this.jTFUsername = username;
        this.jCBgender = gender;
        this.jTFName = name;
        this.jBirth = birth;
        this.id=id;
    }

    public void setDataToTableCourse(String username) {
        StudentEntity st = StudentDAO.getStudentbyUsername(username);

        ArrayList<RegistrationEntity> list = new ArrayList<>();
        for (RegistrationEntity r : st.getRegistered()) {
            list.add(r);
        }


        DefaultTableModel model = classTableModel.setTableCourse(list, COLUMNSCourse);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearchh.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String text = jtfSearchh.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                String text = jtfSearchh.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });


        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(80, 40));
        table.getColumnModel().getColumn(0).setWidth(40);
        table.getColumnModel().getColumn(1).setWidth(250);
        table.getColumnModel().getColumn(2).setWidth(500);
        table.getColumnModel().getColumn(3).setWidth(200);
        table.getColumnModel().getColumn(4).setWidth(400);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(40);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }

    public void setDataToTableMinitry() {
        ArrayList<MinitryEntity> list = (ArrayList<MinitryEntity>) MinitryDAO.getMinitryList();

        DefaultTableModel model = classTableModel.setTableMinitry(list, COLUMNSMinitry);
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        jtfSearchh.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String text = jtfSearchh.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                String text = jtfSearchh.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 & table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    String username=model.getValueAt(selectedRowIndex,1).toString();
                    jTFUsername.setText(username);
                    jTFName.setText(model.getValueAt(selectedRowIndex,3).toString());
                    int gender=0;
                    if(model.getValueAt(selectedRowIndex,4).toString().equals("Nam")){
                        gender=1;
                    }
                    else{
                        gender=0;
                    }
                    id.setText(String.valueOf(MinitryDAO.getMinitrybyUsername(username).getMinitryId()));
                    jCBgender.setSelectedIndex(gender);
                    jBirth.setDate((Date)model.getValueAt(selectedRowIndex,5));
                    jaddress.setText(model.getValueAt(selectedRowIndex,6).toString());
                    btnDelete.setEnabled(true);
                    btnReset.setEnabled(true);
                    btnUpdate.setEnabled(true);
                    jTFUsername.requestFocus();


                }
            }

        });

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        //table.getTableHeader().setPreferredSize(new Dimension(30, 30));

        table.getColumnModel().getColumn(0).setMinWidth(30);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(100);
        table.getColumnModel().getColumn(4).setMinWidth(80);
        table.getColumnModel().getColumn(5).setMinWidth(100);
        table.getColumnModel().getColumn(6).setMinWidth(150);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(698, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }

}


