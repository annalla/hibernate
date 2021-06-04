

package controller;

import java.awt.*;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;

import dao.RegistrationDAO;
import dao.StudentDAO;
import org.w3c.dom.events.DocumentEvent;
import pojo.RegistrationEntity;
import pojo.StudentEntity;


public class StudentController {

    private JPanel jPnView;
    private JTextField jtfSearchh;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNSCourse = {"STT", "Mã MH", "Tên MH", "Số tín chỉ","Lịch học"};

//    private TableRowSorter<TableModel> rowSorter = null;
    public StudentController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();

    }

    public void setDataToTableCourse(String username) {
        StudentEntity st= StudentDAO.getStudentbyUsername(username);

        ArrayList<RegistrationEntity> list = new ArrayList<>();
        for(RegistrationEntity r:st.getRegistered()){
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
        table.setFont(new Font("Arial",Font.PLAIN, 14));
        table.setRowHeight(40);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jPnView.removeAll();
        jPnView.setLayout(new CardLayout());
        //jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }

}


