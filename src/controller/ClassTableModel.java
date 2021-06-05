package controller;



import pojo.*;

import java.util.ArrayList;
import java.util.Set;
import javax.swing.table.DefaultTableModel;


public class ClassTableModel {
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
        int i=1;
        for(RegistrationEntity s:listItem){
            obj=new Object[columns];
            CourseEntity course=s.getCourse();
            SubjectEntity subject=course.getSubject();
            obj[0] = i;
            obj[1] =subject.getSubjectId();
            obj[2] = subject.getSubjectname();
            obj[3] = subject.getCredit();
            String lh="";
            switch (course.getDay()){
                case 1:
                    lh+="T2,";
                    break;
                case 2:
                    lh+="T3,";
                    break;
                case 3:
                    lh+="T4,";
                    break;
                case 4:
                    lh+="T5,";
                    break;
                case 5:
                    lh+="T6,";
                    break;
                case 6:
                    lh+="T7,";
                    break;
                case 7:
                    lh+="CN,";
                    break;
            }
            switch (course.getPeriod()){
                case 1:
                    lh+="7:30-9:30,";
                    break;
                case 2:
                    lh+="9:30-11:30,";
                    break;
                case 3:
                    lh+="13:30-15:30,";
                    break;
                case 4:
                    lh+="15:30-17:30,";
                    break;
            }
            lh+= course.getRoom();
            obj[4]=lh;
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
        int i=1;
        for(MinitryEntity s:listItem){
            obj=new Object[columns];
            obj[0] = i;
            obj[1] =s.getUsername();
            obj[3] = s.getFullname();
            obj[2] = s.getPassword();
            if (s.getGender()==0){
                obj[4]="Nữ";
            }
            else{
                obj[4]="Nam";
            }

            obj[5]=s.getBirthday();
            obj[6]=s.getAddress();
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
        int i=1;
        for(StudentEntity s:listItem){
            obj=new Object[columns];
            obj[0] = i;
            obj[1] =s.getMssv();
            obj[2]=s.getUsername();
            obj[4] = s.getFullname();
            obj[3] = s.getPassword();
            if (s.getGender()==0){
                obj[5]="Nữ";
            }
            else{
                obj[5]="Nam";
            }
            String subject="";
            obj[6]=s.getBirthday();
            obj[7]=s.getAddress();
            Set<RegistrationEntity> hp=s.getRegistered();
            for( RegistrationEntity registered: hp){
                subject+=registered.getCourse().getSubject().getSubjectname();
                subject+=",";
            }
            obj[8]=subject;
            i++;
            dtm.addRow(obj);
        }


        return dtm;
    }

}

