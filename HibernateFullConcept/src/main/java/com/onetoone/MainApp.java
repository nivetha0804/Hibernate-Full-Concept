package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainApp 
{
	public static void main(String[] args) {
		Configuration con= new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory factory= con.buildSessionFactory(reg);
		Session session= factory.openSession();
		Transaction t= session.beginTransaction();
		Address sadd=new Address();
		sadd.setCountry("india");
		sadd.setPincode(54261);
		sadd.setStreet("MGR NAGAR");
		sadd.setState("tamilnadu");
		session.save(sadd);
		Student sob=new Student();
		sob.setSname("poorni");
		sob.setScourse("AWS");
		sob.setStadd(sadd);
		session.save(sob);
		t.commit();
		session.close();
	}
}

