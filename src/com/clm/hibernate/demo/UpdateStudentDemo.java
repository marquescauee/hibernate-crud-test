package com.clm.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.clm.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {

        //* Create session factory */
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        //* Create Session */
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            
            session.beginTransaction();

            // Student tempStudent = session.get(Student.class, studentId);

            // tempStudent.setFirstName("Cauezin");

            session.createQuery("update Student set firstName = :firstName where id = :id")
            .setParameter("firstName", "Cauê")
            .setParameter("id", studentId)
            .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
