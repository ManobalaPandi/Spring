package com.switchcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.switchcode.hibernate.entity.Instructor;
import com.switchcode.hibernate.entity.InstructorDetail;

public class CreateDemo {
	
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {

			System.out.println("creating session obj");
			Instructor tempInstructor = new Instructor("jj","jai","jai@mail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("jai","LOVE");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			session.save(tempInstructor);
			session.getTransaction().commit();
			System.out.println("done");
			
		} finally {
			factory.close();
		}

	}
	
}
