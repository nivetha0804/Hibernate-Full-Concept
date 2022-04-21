package EmployeeHqlOperation;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MainAppEmployee 
{
	public static void main(String[] args) 
	{
		Configuration con=new Configuration().configure().addAnnotatedClass(EmployeeHql.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf = con.buildSessionFactory(reg); //not deprecated
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		/*EmployeeHql e1=new EmployeeHql(1, "Leela",23456, "Bangalore", 100);
              session.save(e1);
              EmployeeHql e2=new EmployeeHql(2, "Ramesh",33456, "Mangalore", 100);
              session.save(e2);

              EmployeeHql e3=new EmployeeHql(3, "Krishna",53456, "Mumbai", 101);
              session.save(e3);
              EmployeeHql e4=new EmployeeHql(4, "Manoj",73456, "Mangalore", 101);
              session.save(e4);
              EmployeeHql e5=new EmployeeHql(5, "Lakshmi",63456, "Delho", 102);
              session.save(e5);*/

		//get record based on id
		/* EmployeeHql r=(EmployeeHql) session.get(EmployeeHql.class,1);

		   System.out.println(r); //it calls toString method

		   System.out.println();
		System.out.println("emp id="+r.getEid()+" name="+r.getEname()+" Salary="+r.getEsalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());
		 */

		//Retrieve all records
		/*Query q=session.createQuery("from EmployeeHql");  //select * from tablename

		//from nameoftheclass

           List l=q.list();  
           System.out.println(l);
           Iterator<EmployeeHql> it=l.iterator();
           while(it.hasNext()) {
        	 EmployeeHql r=it.next();
       System.out.println("emp id="+r.getEid()+" name="+r.getEname()+" Salary="+r.getEsalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());

           }*/

		//update record change name
		/*Query q=session.createQuery("update EmployeeHql set ename=:n where eid=:i");
		q.setParameter("n", "Poonam");
		q.setParameter("i", 1);

		int i=q.executeUpdate();
		if(i>0) {
			System.out.println("Record is updated");
		}
		else {
			 System.out.println("Not updated");
		}*/

		Query d=session.createQuery("delete from EmployeeHql where eid=:i");
		d.setParameter("i", 5);
		int i=d.executeUpdate();
		if(i>0) 
		{
			System.out.println("Record is deleted");
		}
		else 
		{
			System.out.println("Not deleted");
		}
		tx.commit();
		session.close();
	}
}
