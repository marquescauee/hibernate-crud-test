package com.clm.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.clm.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        // * Create session factory */
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // * Create Session */
        Session session = factory.getCurrentSession();

        try {
            Student est1 = new Student("A", "A", "A@gmail.com");
            Student est2 = new Student("B", "B", "B@gmail.com");
            Student est3 = new Student("C", "C", "C@gmail.com");

            session.beginTransaction();

            session.save(est1);
            session.save(est2);
            session.save(est3);

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
