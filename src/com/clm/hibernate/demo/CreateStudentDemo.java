package com.clm.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.clm.hibernate.demo.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {

        //* Create session factory */
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        //* Create Session */
        Session session = factory.getCurrentSession();

        try {
            Student est = new Student("Cauê", "Marques", "caue@gmail.com");

            session.beginTransaction();

            session.save(est);

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
