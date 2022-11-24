package com.clm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        
        String jdbc = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";

        String user = "hbstudent";
        String password = "hbstudent";

        try {

            @SuppressWarnings("unused")
            Connection myConn = DriverManager.getConnection(jdbc, user, password);

            System.out.println("Connection Successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
