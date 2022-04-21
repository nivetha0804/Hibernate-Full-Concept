package com.ComponentMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainAppcomponent 
{
	public static void main(String[] args) 
	{
		Configuration con= new Configuration().configure().addAnnotatedClass(Employee.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory factory= con.buildSessionFactory(reg);
		Session session= factory.openSession();
		Transaction t= session.beginTransaction();				
		Address ad=new Address("manglaore", "Karnataka");		 
		Employee em=new Employee(13, "Devi",ad);
		session.save(em);
		t.commit();
		session.close();
	}
}