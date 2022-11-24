package com.clm.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.clm.hibernate.demo.entity.Student;

public class QueryStudentDemo {
    public static void main(String[] args) {

        // * Create session factory */
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // * Create Session */
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // *Query Students */
            List<Student> students = session.createQuery("from Student", Student.class).getResultList();

            // *Display Students */
            for (Student s : students) {
                System.out.println(s);
            }

            students = session.createQuery("from Student s where s.lastName like '%a%' or s.lastName like '%A%'", Student.class).getResultList();

            // *Display Students */
            for (Student s : students) {
                System.out.println(s);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
