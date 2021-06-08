package controller;


import gui.jPnQLSemester;
import pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/*Tham khảo tạo bảng*/

public class ClassTableModel {
    public DefaultTableModel setTableRegisteredCoursebyGV(ArrayList<RegistrationEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (RegistrationEntity s : listItem) {
            obj = new Object[columns];
            StudentEntity student=s.getStudent();
            obj[1]=student.getMssv();
            obj[2]=student.getFullname();
            CourseEntity course = s.getCourse();
            SubjectEntity subject = course.getSubject();
            obj[0] = i;
            obj[3] = subject.getSubjectId();
            obj[4] = subject.getSubjectname();
            obj[5] = course.getTeacher();
            String lh = "";
            switch (course.getDay()) {
                case 1:
                    lh += "T2,";
                    break;
                case 2:
                    lh += "T3,";
                    break;
                case 3:
                    lh += "T4,";
                    break;
                case 4:
                    lh += "T5,";
                    break;
                case 5:
                    lh += "T6,";
                    break;
                case 6:
                    lh += "T7,";
                    break;
                case 7:
                    lh += "CN,";
                    break;
            }
            switch (course.getPeriod()) {
                case 1:
                    lh += "7:30-9:30,";
                    break;
                case 2:
                    lh += "9:30-11:30,";
                    break;
                case 3:
                    lh += "13:30-15:30,";
                    break;
                case 4:
                    lh += "15:30-17:30,";
                    break;
            }
            lh += course.getRoom();
            obj[6] = lh;
            obj[7]=s.getTime();
            i++;
            dtm.addRow(obj);
        }
        return dtm;
    }

    public static DefaultTableModel setTableCourseOfCurrent(ArrayList<CourseEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (CourseEntity c : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = c.getSubject().getSubjectId();
            obj[2] = c.getSubject().getSubjectname();
            obj[3] = c.getSubject().getCredit();
            String courseName=c.getCoursename();
            String[] dm=courseName.split(" - ");
            obj[4]=dm[1];
            obj[5] = c.getTeacher();
            String lh = "";
            switch (c.getDay()) {
                case 1:
                    lh += "T2,";
                    break;
                case 2:
                    lh += "T3,";
                    break;
                case 3:
                    lh += "T4,";
                    break;
                case 4:
                    lh += "T5,";
                    break;
                case 5:
                    lh += "T6,";
                    break;
                case 6:
                    lh += "T7,";
                    break;
                case 7:
                    lh += "CN,";
                    break;
            }
            switch (c.getPeriod()) {
                case 1:
                    lh += "7:30-9:30,";
                    break;
                case 2:
                    lh += "9:30-11:30,";
                    break;
                case 3:
                    lh += "13:30-15:30,";
                    break;
                case 4:
                    lh += "15:30-17:30,";
                    break;
            }
            lh += c.getRoom();
            obj[6] = lh;
            obj[7] = c.getMaximum();
            i++;
            dtm.addRow(obj);
        }
        return dtm;
    }

    public static DefaultTableModel setTableRegistraionSession(ArrayList<RegistrationsessionEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (RegistrationsessionEntity s : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = s.getSemester().getTerm();
            obj[2] = s.getSemester().getYear();
            obj[3] = s.getStartdate();
            obj[4] = s.getEnddate();
            i++;
            dtm.addRow(obj);

        }
        return dtm;
    }

    public static DefaultTableModel setTableClass(ArrayList<ClazzEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (ClazzEntity s : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = s.getClassname();
            obj[2] = s.getTotal();
            obj[3] = s.getBoy();
            obj[4] = s.getGirl();
            i++;
            dtm.addRow(obj);

        }
        return dtm;
    }

    public static DefaultTableModel setTableSemester(ArrayList<SemesterEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (SemesterEntity s : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = s.getTerm();
            obj[2] = s.getYear();
            obj[3] = s.getStartsemester();
            obj[4] = s.getEndsemester();
            obj[5]=s.getIspresent();
            i++;
            dtm.addRow(obj);

        }
        return dtm;
    }

    public static DefaultTableModel setTableSubject(ArrayList<SubjectEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (SubjectEntity s : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = s.getSubjectId();
            obj[2] = s.getSubjectname();
            obj[3] = s.getCredit();
            i++;
            dtm.addRow(obj);

        }
        return dtm;
    }

    public DefaultTableModel setTableCourse(ArrayList<RegistrationEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (RegistrationEntity s : listItem) {
            obj = new Object[columns];
            CourseEntity course = s.getCourse();
            SubjectEntity subject = course.getSubject();
            obj[0] = i;
            obj[1] = subject.getSubjectId();
            obj[2] = subject.getSubjectname();
            obj[3] = subject.getCredit();
            String lh = "";
            switch (course.getDay()) {
                case 1:
                    lh += "T2,";
                    break;
                case 2:
                    lh += "T3,";
                    break;
                case 3:
                    lh += "T4,";
                    break;
                case 4:
                    lh += "T5,";
                    break;
                case 5:
                    lh += "T6,";
                    break;
                case 6:
                    lh += "T7,";
                    break;
                case 7:
                    lh += "CN,";
                    break;
            }
            switch (course.getPeriod()) {
                case 1:
                    lh += "7:30-9:30,";
                    break;
                case 2:
                    lh += "9:30-11:30,";
                    break;
                case 3:
                    lh += "13:30-15:30,";
                    break;
                case 4:
                    lh += "15:30-17:30,";
                    break;
            }
            lh += course.getRoom();
            obj[4] = lh;
            i++;
            dtm.addRow(obj);

        }
        return dtm;
    }

    public DefaultTableModel setTableMinitry(ArrayList<MinitryEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (MinitryEntity s : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = s.getUsername();
            obj[3] = s.getFullname();
            obj[2] = s.getPassword();
            if (s.getGender() == 0) {
                obj[4] = "Nữ";
            } else {
                obj[4] = "Nam";
            }

            obj[5] = s.getBirthday();
            obj[6] = s.getAddress();
            i++;
            dtm.addRow(obj);
        }


        return dtm;
    }

    public DefaultTableModel setTableStudent(ArrayList<StudentEntity> listItem, String[] listColumn) {
        int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        int i = 1;
        for (StudentEntity s : listItem) {
            obj = new Object[columns];
            obj[0] = i;
            obj[1] = s.getMssv();
            obj[2] = s.getClasss().getClassname();
            obj[3] = s.getUsername();
            obj[5] = s.getFullname();
            obj[4] = s.getPassword();
            if (s.getGender() == 0) {
                obj[6] = "Nữ";
            } else {
                obj[6] = "Nam";
            }
            String subject = "";
            obj[7] = s.getBirthday();
            obj[8] = s.getAddress();
            Set<RegistrationEntity> hp = s.getRegistered();
            for (RegistrationEntity registered : hp) {
                subject += registered.getCourse().getSubject().getSubjectname();
                subject += ",";
            }
            obj[9] = subject;
            i++;
            dtm.addRow(obj);
        }


        return dtm;
    }

}

