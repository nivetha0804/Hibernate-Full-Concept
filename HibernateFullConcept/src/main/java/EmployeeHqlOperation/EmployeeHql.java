package EmployeeHqlOperation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HibernateEmployee")
public class EmployeeHql 
{
	@Id
	private int eid;
	private String ename;
	private float esalary;
	private String address;
	private int deptno;
	public int getEid() 
	{
		return eid;
	}
	public void setEid(int eid) 
	{
		this.eid = eid;
	}
	public String getEname() 
	{
		return ename;
	}
	public void setEname(String ename) 
	{
		this.ename = ename;
	}
	public float getEsalary()
	{
		return esalary;
	}
	public void setEsalary(float esalary) 
	{
		this.esalary = esalary;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public int getDeptno() 
	{
		return deptno;
	}
	public void setDeptno(int deptno) 
	{
		this.deptno = deptno;
	}
	public EmployeeHql(int eid, String ename, float esalary, String address, int deptno)
	{
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.address = address;
		this.deptno = deptno;
	}
	public EmployeeHql() 
	{
		super();
	}
	@Override
	public String toString() 
	{
		return "EmployeeHql [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + ", address=" + address
				+ ", deptno=" + deptno + "]";
	}
}
