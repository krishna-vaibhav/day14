package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "my_students")
public class Student {
	private Integer pnr;
	private String name;
	private Location location;
	private StudentDetails details;
	

	public Student() {
		System.out.println("stud1 constr");
	}

	public Student(String name, Location location) {
		super();
		this.name = name;
		this.location=location;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPnr() {
		return pnr;
	}

	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	@Column(length=30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="student1")
	public StudentDetails getDetails() {
		return details;
	}

	public void setDetails(StudentDetails details) {
		this.details = details;
	}
	//convenience method to specify reverse relationship
	public void addDetails(StudentDetails details)
	{
		setDetails(details);
		details.setStudent1(this);
	}

	@Override
	public String toString() {
		return "Student  pnr=" + pnr + ", name=" + name + ", location="
				+ location+" details "+details;
	}

	
}
