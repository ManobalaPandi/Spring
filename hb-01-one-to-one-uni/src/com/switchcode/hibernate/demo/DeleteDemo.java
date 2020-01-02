package com.switchcode.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.switchcode.hibernate.entity.Instructor;
import com.switchcode.hibernate.entity.InstructorDetail;

public class DeleteDemo {
	
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			System.out.println("creating session obj");
			Instructor tempInstructor = session.get(Instructor.class, 1);
			
			if (tempInstructor!=null)
			{
				session.delete(tempInstructor);
			}
			
			
			
			session.getTransaction().commit();
			System.out.println("done");
			
		} finally {
			factory.close();
		}

	}
	
}
