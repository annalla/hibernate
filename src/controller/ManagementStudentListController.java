package controller;

import com.toedter.calendar.JDateChooser;
import dao.MinitryDAO;
import dao.StudentDAO;
import pojo.MinitryEntity;
import pojo.RegistrationEntity;
import pojo.StudentEntity;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

public class ManagementStudentListController {

    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JButton btnFind;
    private JButton btnReset;
    private JButton btnUpdate;
    private JTextField jTFUsername;
    private JTextField jTFName;
    private JComboBox jCBgender;
    private JTextArea jaddress;
    private JDateChooser jBirth;
    private  JComboBox jClass;
    private JTextField jTFmssv;
    private  JTextArea jSubject;
    private JLabel id;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;


    private final String[] COLUMNSMinitry = {"STT", "MSSV","Username", "Password", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ","Môn học"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public ManagementStudentListController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();

    }

    public void setField(JButton btnfind, JButton btnreset, JButton btnupdate, JTextField username, JTextField name, JComboBox gender, JTextArea address, JDateChooser birth, JLabel id,JTextField mssv,JComboBox classs,JTextArea subject) {
        this.btnFind = btnfind;
        this.btnReset = btnreset;
        this.btnUpdate = btnupdate;
        this.jaddress = address;
        this.jTFUsername = username;
        this.jCBgender = gender;
        this.jTFName = name;
        this.jBirth = birth;
        this.id = id;
        this.jClass=classs;
        this.jTFmssv=mssv;
        this.jSubject=subject;
    }


    public void setDataToTableStudent() {
        ArrayList<StudentEntity> list = (ArrayList<StudentEntity>) StudentDAO.getStudentList();

        DefaultTableModel model = classTableModel.setTableStudent(list, COLUMNSMinitry);
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
                   /* DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    String username = model.getValueAt(selectedRowIndex, 1).toString();
                    jTFUsername.setText(username);
                    jTFName.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    int gender = 0;
                    if (model.getValueAt(selectedRowIndex, 4).toString().equals("Nam")) {
                        gender = 1;
                    } else {
                        gender = 0;
                    }
                    id.setText(String.valueOf(MinitryDAO.getMinitrybyUsername(username).getMinitryId()));
                    jCBgender.setSelectedIndex(gender);
                    jBirth.setDate((Date) model.getValueAt(selectedRowIndex, 5));
                    jaddress.setText(model.getValueAt(selectedRowIndex, 6).toString());
                    btnReset.setEnabled(true);
                    btnUpdate.setEnabled(true);
                    jTFUsername.requestFocus();

*/
                }
            }

        });

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        //table.getTableHeader().setPreferredSize(new Dimension(30, 30));

        table.getColumnModel().getColumn(0).setMinWidth(20);
        table.getColumnModel().getColumn(1).setMinWidth(65);
        table.getColumnModel().getColumn(2).setMinWidth(65);
        table.getColumnModel().getColumn(3).setMinWidth(65);
        table.getColumnModel().getColumn(4).setMinWidth(100);
        table.getColumnModel().getColumn(5).setMinWidth(50);
        table.getColumnModel().getColumn(6).setMinWidth(80);
        table.getColumnModel().getColumn(7).setMinWidth(100);
        table.getColumnModel().getColumn(8).setMinWidth(200);
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
