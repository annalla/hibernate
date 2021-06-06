package controller;

import com.toedter.calendar.JDateChooser;
import dao.MinitryDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import pojo.MinitryEntity;
import pojo.RegistrationEntity;
import pojo.StudentEntity;
import pojo.SubjectEntity;

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

public class ManagementSubjectController {
    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JButton btnDelete;
    private JButton btnUpdate;
    private JTextField jTFSujectId;
    private JTextField jTFSuject;
    private JTextField jTFcredit;
    private JLabel id;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNSSuject = {"STT", "Mã môn học", "Tên Môn học", "Số tín chỉ"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public ManagementSubjectController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
    }

    public void setField(JButton btndelete, JButton btnupdate, JTextField Subid, JTextField subject, JTextField credit, JLabel id) {
        this.btnDelete = btndelete;
        this.btnUpdate = btnupdate;
        this.jTFSujectId = Subid;
        this.jTFSuject = subject;
        this.jTFcredit = credit;
        this.id = id;
    }

    public void setDataToTableSubject() {
        ArrayList<SubjectEntity> list= (ArrayList<SubjectEntity>) SubjectDAO.getSubjectList();

        DefaultTableModel model = ClassTableModel.setTableSubject(list, COLUMNSSuject);
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
                    String idSubject=model.getValueAt(selectedRowIndex, 1).toString();
                    jTFSujectId.setText(idSubject);
                    jTFSuject.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    jTFcredit.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    btnUpdate.setEnabled(true);
                    btnDelete.setEnabled(true);
                    id.setText(String.valueOf(SubjectDAO.getSujectbyID(idSubject).getSubId()));

                }
            }

        });


        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(40, 25));
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(1).setMinWidth(150);
        table.getColumnModel().getColumn(2).setMinWidth(300);
        table.getColumnModel().getColumn(3).setMinWidth(110);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(600, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }

}
