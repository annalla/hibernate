package com.company;

import dao.MinitryDAO;
import pojo.MinitryEntity;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<MinitryEntity> ds = MinitryDAO.getMinitryList();
        for (int i = 0; i < ds.size(); i++) {
            MinitryEntity sv = ds.get(i);
            System.out.println("MSSV: " + sv.getFullname());

        }
    }
}
