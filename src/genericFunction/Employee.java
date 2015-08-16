package genericFunction;


public class Employee {
	private String name;
	private double salary;
	
	public Employee(String name, double salary)
	{
		this.name = name;
		this.salary = salary;
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String toString()
	{
		String str = "<";
		str += str + "name:" + this.name + " Salary:" + this.salary + ">";
		return str;
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o.getClass() != this.getClass())
			return -1;
		Employee e = (Employee)o;
		if(this.salary != e.getSalary())
			return -1;
		return this.name.compareTo(e.getName()) ;
	}
	
	public boolean equals(Object o)
	{
		if(o.getClass() != this.getClass())
			return false;
		
		Employee e = (Employee)o;
		return this.getName().equals(e.getName()) && this.getSalary() == e.getSalary();
	}
}
