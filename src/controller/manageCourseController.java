package controller;

import com.toedter.calendar.JDateChooser;
import dao.CourseDAO;
import dao.SemesterDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import gui.jPnQLCourse;
import pojo.CourseEntity;
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
import java.util.ArrayList;
import java.util.Set;

public class manageCourseController {
    private JPanel jPnView;
    private JTextField jtfSearchh;
    private JButton btnDelete;
    private JButton btnSeeList;
    private JComboBox jCBSubject;
    private JComboBox jCBteacher;
    private JComboBox jCBroom;
    private JComboBox jCBday;
    private JComboBox jCBperiod;
    private JTextField jTFmaximum;
    private JTextField jTFclass;
    private JLabel id;

    private ClassTableModel classTableModel = null;
    private TableRowSorter<TableModel> rowSorter = null;

    private final String[] COLUMNS= {"STT", "Mã môn học", "Tên Môn học", "Số tín chỉ", "Lớp","GVLT", "Lịch học", "Slot tối đa"};
    private final String[] COLUMNSRegistered= {"STT", "MSSV", "Họ tên", "Mã MH", "Tên Môn học","GVLT", "Thời gian học", "Thời gian ĐK"};

    //    private TableRowSorter<TableModel> rowSorter = null;
    public manageCourseController(JPanel jPnView, JTextField jtfSearchh) {
        this.jPnView = jPnView;
        this.jtfSearchh = jtfSearchh;
        this.classTableModel = new ClassTableModel();
    }

    public void setField(JButton btndelete, JButton btnSeelist, JComboBox subject, JComboBox teacher, JComboBox room, JComboBox day, JComboBox period, JTextField max, JTextField cl, JLabel id) {
        this.btnDelete = btndelete;
        this.btnSeeList = btnSeelist;
        this.jCBSubject = subject;
        this.jCBroom = room;
        this.jCBteacher = teacher;
        this.jCBday = day;
        this.jCBperiod = period;
        this.jTFmaximum = max;
        this.jTFclass=cl;
        this.id = id;
    }
    public void setDataToTableRegisteredCourse(int id) {
        CourseEntity course=CourseDAO.getCoursebyId(id);

        ArrayList<RegistrationEntity> list = new ArrayList<>();
        for (RegistrationEntity r : course.getRegistered()) {
            list.add(r);
        }


        DefaultTableModel model = classTableModel.setTableRegisteredCoursebyGV(list, COLUMNSRegistered);
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
        //table.getTableHeader().setPreferredSize(new Dimension(80, 25));
        table.getColumnModel().getColumn(0).setMinWidth(10);
        table.getColumnModel().getColumn(1).setMinWidth(30);
        table.getColumnModel().getColumn(2).setMinWidth(110);
        table.getColumnModel().getColumn(3).setMinWidth(50);
        table.getColumnModel().getColumn(4).setMinWidth(150);
        table.getColumnModel().getColumn(5).setMinWidth(100);
        table.getColumnModel().getColumn(6).setMinWidth(100);
        table.getColumnModel().getColumn(7).setMinWidth(150);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(700, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
    public void setDataToTableCourseofCurrentSemester() {
        Set<CourseEntity> setCourses= SemesterDAO.getSemester(jPnQLCourse.current.getSemesterId()).getCourses();
        ArrayList<CourseEntity> list=new ArrayList<>();
        for(CourseEntity c:setCourses){
            list.add(c);
        }

        DefaultTableModel model = ClassTableModel.setTableCourseOfCurrent(list, COLUMNS);
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
                    String Subject = model.getValueAt(selectedRowIndex, 2).toString();
                    //String cl = model.getValueAt(selectedRowIndex, 1).toString();
                    for (int i = 0; i < jPnQLCourse.CBsubject.length; i++) {
                        if (jPnQLCourse.CBsubject[i].equals(Subject)) {
                            jCBSubject.setSelectedIndex(i);
                            break;
                        }
                    }
                    String teacher = model.getValueAt(selectedRowIndex, 5).toString();
                    for (int i = 0; i < jPnQLCourse.CBteacher.length; i++) {
                        if (jPnQLCourse.CBteacher[i].equals(teacher)) {
                            jCBteacher.setSelectedIndex(i);
                            break;
                        }
                    }
                    String lh=model.getValueAt(selectedRowIndex,6).toString();
                    String[] component=lh.split(",");
                    //System.out.println(component[0]);
                    String day=component[0];
                    int indexday=-1;
                    switch (day){
                        case "T2":
                            indexday=0;
                            break;
                        case "T3":
                            indexday=1;
                            break;
                        case "T4":
                            indexday=2;
                            break;
                        case "T5":
                            indexday=3;
                            break;
                        case "T6":
                            indexday=4;
                            break;
                        case "T7":
                            indexday=5;
                            break;
                        case "CN":
                            indexday=6;
                            break;
                    }
                    int indexPeriod=-1;
                    jCBday.setSelectedIndex(indexday);
                    String period=component[1];
                    switch (period){
                        case "7:30-9:30":
                            indexPeriod=0;
                            break;
                        case "9:30-11:30":
                            indexPeriod=1;
                            break;
                        case "13:30-15:30":
                            indexPeriod=2;
                            break;
                        case "15:30-17:30":
                            indexPeriod=3;
                            break;
                    }
                    jCBperiod.setSelectedIndex(indexPeriod);
                    String room=component[2];
                    for (int i = 0; i < jPnQLCourse.CBroom.length; i++) {
                        if (jPnQLCourse.CBroom[i].equals(room)) {
                            jCBroom.setSelectedIndex(i);
                            break;
                        }
                    }
                    jTFclass.setText(model.getValueAt(selectedRowIndex,4).toString());
                    jTFmaximum.setText(model.getValueAt(selectedRowIndex,7).toString());
                    btnSeeList.setEnabled(true);
                    btnDelete.setEnabled(true);
                    String classname=Subject+" - "+model.getValueAt(selectedRowIndex,4).toString();
                    id.setText(String.valueOf(CourseDAO.getCoursebyClass(classname).getCourseId()));

                }
            }

        });


        // design
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(40, 25));
        table.getColumnModel().getColumn(0).setMinWidth(20);
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(2).setMinWidth(190);
        table.getColumnModel().getColumn(3).setMinWidth(45);
        table.getColumnModel().getColumn(4).setMinWidth(40);
        table.getColumnModel().getColumn(5).setMinWidth(120);
        table.getColumnModel().getColumn(6).setMinWidth(140);
        table.getColumnModel().getColumn(7).setMinWidth(60);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.validate();
        table.repaint();

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(695, 400));
        jPnView.removeAll();
        //jPnView.setLayout(new CardLayout());
        jPnView.setLayout(new BorderLayout());
        jPnView.add(scroll);
        jPnView.validate();
        jPnView.repaint();
    }
}
