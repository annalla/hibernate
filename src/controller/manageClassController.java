package controller;

import dao.ClassDAO;
import dao.SubjectDAO;
import pojo.ClazzEntity;
import pojo.SubjectEntity;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class manageClassController {
    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JButton btnDelete;
    private JTextField jTFclassName;
    private JTextField jTFTotal;
    private JTextField jTFboy;
    private JLabel id;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNS = {"STT", "Tên lớp học", "Sĩ số", "Tổng số nam", "Tổng số nữ"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public manageClassController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
    }

    public void setField(JButton btndelete, JTextField className, JTextField total, JTextField boys, JLabel id) {
        this.btnDelete = btndelete;
        this.jTFclassName = className;
        this.jTFTotal = total;
        jTFboy = boys;
        this.id = id;
    }

    public void setDataToTableClass() {
        ArrayList<ClazzEntity> list = (ArrayList<ClazzEntity>) ClassDAO.getClassList();

        DefaultTableModel model = ClassTableModel.setTableClass(list, COLUMNS);
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
                    String classname = model.getValueAt(selectedRowIndex, 1).toString();
                    jTFclassName.setText(classname);
                    jTFTotal.setText(model.getValueAt(selectedRowIndex, 2).toString());
                    jTFboy.setText(model.getValueAt(selectedRowIndex, 3).toString());
                    btnDelete.setEnabled(true);
                    id.setText(String.valueOf(ClassDAO.getClassbyClassname(classname).getClassId()));

                }
            }

        });


        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(40, 25));
        table.getColumnModel().getColumn(0).setMinWidth(40);
        table.getColumnModel().getColumn(1).setMinWidth(120);
        table.getColumnModel().getColumn(2).setMinWidth(120);
        table.getColumnModel().getColumn(3).setMinWidth(120);
        table.getColumnModel().getColumn(4).setMinWidth(120);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(520, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
}
