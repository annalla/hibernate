package controller;

import com.toedter.calendar.JDateChooser;
import dao.RegistrationSessionDAO;
import dao.SemesterDAO;
import pojo.RegistrationEntity;
import pojo.RegistrationsessionEntity;
import pojo.SemesterEntity;

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

public class manageRegistrationSessionController {
    private JPanel jPnView;
    private JTextField jtfSearchh;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNS = {"STT", "Tên học kỳ ", "Năm học", "Bắt đầu đăng ký", "Kết thúc đăng ký",};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public manageRegistrationSessionController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
    }


    public void setDataToTableRegistrationSession() {
        ArrayList<RegistrationsessionEntity> list= (ArrayList<RegistrationsessionEntity>) RegistrationSessionDAO.getRegistrationSessionList();
        DefaultTableModel model = ClassTableModel.setTableRegistraionSession(list, COLUMNS);
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

                }
            }

        });


        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(40, 25));
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(100);
        table.getColumnModel().getColumn(3).setMinWidth(200);
        table.getColumnModel().getColumn(4).setMinWidth(200);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(640, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
}
