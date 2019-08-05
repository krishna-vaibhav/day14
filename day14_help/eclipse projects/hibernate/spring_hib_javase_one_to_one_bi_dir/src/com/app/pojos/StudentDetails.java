package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "stud_details")
public class StudentDetails {
	private Integer id;
	private int javaMarks, cppMarks, seMarks;
	private Student student1;

	public StudentDetails() {
		System.out.println("stud details constr");
	}

	public StudentDetails(int javaMarks, int cppMarks, int seMarks) {
		super();
		this.javaMarks = javaMarks;
		this.cppMarks = cppMarks;
		this.seMarks = seMarks;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="java_mks",columnDefinition="int(3)")
	public int getJavaMarks() {
		return javaMarks;
	}

	public void setJavaMarks(int javaMarks) {
		this.javaMarks = javaMarks;
	}
	@Column(name="cpp_mks",columnDefinition="int(3)")
	public int getCppMarks() {
		return cppMarks;
	}

	public void setCppMarks(int cppMarks) {
		this.cppMarks = cppMarks;
	}
	@Column(name="se_mks",columnDefinition="int(3)")
	public int getSeMarks() {
		return seMarks;
	}

	public void setSeMarks(int seMarks) {
		this.seMarks = seMarks;
	}
	@OneToOne
	@JoinColumn(name="stud_pnr")
	public Student getStudent1() {
		return student1;
	}

	public void setStudent1(Student student1) {
		this.student1 = student1;
	}

	@Override
	public String toString() {
		return "Student Details id=" + id + ", javaMarks=" + javaMarks
				+ ", cppMarks=" + cppMarks + ", seMarks=" + seMarks + " of "
				+ student1.getName();
	}

}
