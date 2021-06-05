package com.company;

import dao.MinitryDAO;
import gui.HomePageStudent;
import gui.Login;
import pojo.MinitryEntity;

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
            Set<RegistrationEntity> r=st.getRegistered();
            System.out.println(r.size());
            for(RegistrationEntity re:r){
                System.out.println("dhsyfghj:" +re.getCourse().getSubject().getSubjectname());
            }

        }*/
        new Login().setVisible(true);

    }
}
