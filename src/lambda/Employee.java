package lambda;

public class Employee {
	String name;
	int salary;
	int yearOfBirth;
	public Employee(String n, int s, int y) {
		this.name = n;
		this.salary = s;
		this.yearOfBirth = y;
	}
	
	public Employee(String n) {
		this.name = n;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(name);
		sb.append(" salary: ");
		sb.append("" + salary);
		sb.append(" year of birth: ");
		sb.append("" + yearOfBirth+">");
		return sb.toString();
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}

	@Override
	public boolean equals(Object o)
	{
		boolean ret = false;
		if(o == null || o.getClass() != this.getClass())
			
			return ret;
		if(o.getClass() == this.getClass())
		{
			Employee e = (Employee)o;
			ret = this.name.equals(e.getName());
		}
		return ret;
	}
}

