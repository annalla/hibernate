package com.company;

import gui.HomePageStudent;
import gui.Login;

import javax.swing.*;

public class Main {
    public static void setLoginView(){

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
        new Login().setVisible(true);


    }
}
