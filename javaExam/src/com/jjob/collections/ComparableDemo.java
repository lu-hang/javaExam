package com.jjob.collections;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableDemo {
	public static void main(String[ ] args) {

		ArrayList<Employee> list = new ArrayList<>();

		list.add(new Employee(22l, "Lokesh", LocalDate.now()));
		list.add(new Employee(18l, "Alex", LocalDate.now()));
		list.add(new Employee(30l, "Bob", LocalDate.now()));
		list.add(new Employee(600l, "Charles", LocalDate.now()));
		list.add(new Employee(5l, "David", LocalDate.now()));

		//Natural order
		Collections.sort(list);

		System.out.println(list);

		//Sort in reverse natural order
		Collections.sort(list, Collections.reverseOrder());

		System.out.println(list.get(0).toString());
		
		Collections.sort(list, new NameSorter());
		
		System.out.println(list);

	}
}



class Employee implements Comparable<Employee>,   Serializable {

	private Long id;
	private String name;
	private LocalDate dob;
	
	private static final long serialVersionUID = 1L;
	
	public Employee(Long id, String name, LocalDate date)
	{
		this.id=id;
		this.name=name;
		this.dob=date;
	}
	
	@Override
	
	public String toString()
	{
		return "id="+this.id+", \tname="+this.name+"\tdate="+this.dob;
	}

	@Override
	public int compareTo(Employee o)
	{
		return this.getId().compareTo( o.getId() );
	}

	private Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	protected String getName()
	{
		return this.name;
	}
}

class NameSorter implements Comparator<Employee>
{
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareToIgnoreCase( e2.getName() );
    }
}

