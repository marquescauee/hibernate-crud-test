package com.clm.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.clm.hibernate.demo.entity.Student;

public class ReadStudentDemo {
    public static void main(String[] args) {

        //* Create session factory */
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        //* Create Session */
        Session session = factory.getCurrentSession();

        try {

            //* Create Student */
            Student est = new Student("Teste", "Testando", "teste@gmail.com");

            //* Start Transaction */
            session.beginTransaction();

            //* Save student */
            session.save(est);

            //* Commit Transaction */
            session.getTransaction().commit();

            
            //* Start new Transaction */
            session = factory.getCurrentSession();
            session.beginTransaction();

            //*Retrieve student */
            Student retrievedStudent = session.get(Student.class, est.getId());

            System.out.println(retrievedStudent);
            
            //* Commit Transaction */
            session.getTransaction().commit();


            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
