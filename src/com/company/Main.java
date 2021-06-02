package com.company;

import dao.MinitryDAO;
import dao.StudentDAO;
import gui.HomePageStudent;
import gui.Login;
import gui.LoginView;
import pojo.ClazzEntity;
import pojo.MinitryEntity;
import pojo.StudentEntity;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void setLoginView(){
        JFrame frame = new JFrame("LoginView");
        frame.setContentPane(new LoginView().dm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    };
    public static void main(String[] args) {
	// write your code here
        /*List<MinitryEntity> ds = MinitryDAO.getMinitryList();
        for (int i = 0; i < ds.size(); i++) {
            MinitryEntity sv = ds.get(i);
            System.out.println("MSSV: " + sv.getUsername());

        }
        StudentEntity st = StudentDAO.getStudentbyUsername("1712001");
        if(st!=null){
            ClazzEntity cl=st.getClasss();
            System.out.println("dhsyfghj:" +st.getStudentId());
        }*/
        new HomePageStudent().setVisible(true);


    }
}
