package controller;

import com.toedter.calendar.JDateChooser;
import dao.SemesterDAO;
import dao.SubjectDAO;
import pojo.SemesterEntity;
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

public class ManagementSemesterController {
    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JButton btnDelete;
    private JButton btnSetcurrent;
    private JTextField jTFyear;
    private JTextField jTFterm;
    private JDateChooser jDCstart;
    private JDateChooser jDCend;
    private JLabel id;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNS = {"STT", "Tên học kỳ ", "Năm học", "Bắt đầu", "Kết thúc", "Học kỳ hiện tại"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public ManagementSemesterController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
    }

    public void setField(JButton btndelete, JButton btncurrentPeriod, JTextField term, JTextField year, JDateChooser start, JDateChooser end, JLabel id) {
        this.btnDelete = btndelete;
        this.btnSetcurrent = btncurrentPeriod;
        this.jTFterm = term;
        this.jTFyear = year;
        this.jDCstart = start;
        this.jDCend = end;
        this.id = id;
    }

    public void setDataToTableSemester() {
        ArrayList<SemesterEntity> list = (ArrayList<SemesterEntity>) SemesterDAO.getSemesterList();

        DefaultTableModel model = ClassTableModel.setTableSemester(list, COLUMNS);
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
                    String name = model.getValueAt(selectedRowIndex, 1).toString();
                    String year = model.getValueAt(selectedRowIndex, 2).toString();
                    jTFterm.setText(name);
                    jTFyear.setText(year);
                    jDCend.setDate((Date) model.getValueAt(selectedRowIndex, 3));
                    jDCstart.setDate((Date) model.getValueAt(selectedRowIndex, 4));
                    btnSetcurrent.setEnabled(true);
                    btnDelete.setEnabled(true);
                    id.setText(String.valueOf(SemesterDAO.getSemesterbyYearandName(name, year).getSemesterId()));

                }
            }

        });


        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
       // table.getTableHeader().setPreferredSize(new Dimension(40, 25));
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(1).setMinWidth(100);
        table.getColumnModel().getColumn(2).setMinWidth(120);
        table.getColumnModel().getColumn(3).setMinWidth(120);
        table.getColumnModel().getColumn(4).setMinWidth(120);
        table.getColumnModel().getColumn(5).setMinWidth(140);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(650, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
}
