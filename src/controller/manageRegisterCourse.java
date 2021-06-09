package controller;

import com.toedter.calendar.JDateChooser;
import dao.CourseDAO;
import dao.RegistrationDAO;
import dao.StudentDAO;
import gui.RegisterjPn;
import pojo.CourseEntity;
import pojo.RegistrationEntity;
import pojo.SemesterEntity;
import pojo.StudentEntity;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class manageRegisterCourse {
    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JLabel id;
    private JButton btnDelete;
    private JButton btnRegister;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNSCourse = {"STT", "Mã MH", "Tên MH", "Lớp","Số tín chỉ","GVLT", "Lịch học","Slot tối đa","Thời gian ĐK"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public manageRegisterCourse(JPanel jPnView, JTextField jtfSearchh,JLabel id) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
        this.id=id;
    }
    public void setbtn(JButton delete, JButton btnRegister){
        this.btnDelete=delete;
        this.btnRegister=btnRegister;
    }

    public void setDataToTableCourseRegister(String username) {
        SemesterEntity semester= RegisterjPn.semester;
        StudentEntity st=StudentDAO.getStudentbyUsername(username);
        ArrayList<CourseEntity> list = new ArrayList<CourseEntity>();
        boolean flag=false;
        for (CourseEntity co : semester.getCourses()) {
            flag=false;
            for(RegistrationEntity re:st.getRegistered())
            {
                if(co.getSubject().getSubId()==re.getCourse().getSubject().getSubId()){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                list.add(co);
            }
        }


        DefaultTableModel model = classTableModel.setTableCourseRe(list, COLUMNSCourse);
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
                    String classname=model.getValueAt(selectedRowIndex,2).toString()+" - "+model.getValueAt(selectedRowIndex,3);
                    CourseEntity co= CourseDAO.getCoursebyClass(classname);
                    id.setText(String.valueOf(co.getCourseId()));
                    btnRegister.setEnabled(true);
                }
            }

        });

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        //table.getTableHeader().setPreferredSize(new Dimension(80, 40));
        table.getColumnModel().getColumn(0).setMinWidth(20);
        table.getColumnModel().getColumn(1).setMinWidth(60);
        table.getColumnModel().getColumn(2).setMinWidth(220);
        table.getColumnModel().getColumn(3).setMinWidth(40);
        table.getColumnModel().getColumn(4).setMinWidth(60);
        table.getColumnModel().getColumn(5).setMinWidth(110);
        table.getColumnModel().getColumn(6).setMinWidth(140);
        table.getColumnModel().getColumn(7).setMinWidth(70);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1100, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
    public void setDataToTableCourseRegistered(String username) {
        StudentEntity st = StudentDAO.getStudentbyUsername(username);

        ArrayList<RegistrationEntity> list = new ArrayList<>();
        List<RegistrationEntity> ds= RegistrationDAO.listRegistration(username,RegisterjPn.semester.getSemesterId());
        for (RegistrationEntity r : ds) {
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
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 & table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    String classname=model.getValueAt(selectedRowIndex,2).toString()+" - "+model.getValueAt(selectedRowIndex,3);
                    CourseEntity co= CourseDAO.getCoursebyClass(classname);
                    id.setText(String.valueOf(co.getCourseId()));
                    btnDelete.setEnabled(true);
                }
            }

        });

        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        //table.getTableHeader().setPreferredSize(new Dimension(80, 40));
        table.getColumnModel().getColumn(0).setMinWidth(20);
        table.getColumnModel().getColumn(1).setMinWidth(60);
        table.getColumnModel().getColumn(2).setMinWidth(220);
        table.getColumnModel().getColumn(3).setMinWidth(40);
        table.getColumnModel().getColumn(4).setMinWidth(60);
        table.getColumnModel().getColumn(5).setMinWidth(110);
        table.getColumnModel().getColumn(6).setMinWidth(140);
        table.getColumnModel().getColumn(7).setMinWidth(70);
        table.getColumnModel().getColumn(8).setMinWidth(150);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1200, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
}
