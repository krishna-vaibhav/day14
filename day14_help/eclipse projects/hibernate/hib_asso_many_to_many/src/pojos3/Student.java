package pojos3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "dac_students")
public class Student {
	private Integer studId;
	private String name;
	private List<Course> courses=new ArrayList<>();

	public Student() {
		System.out.println("stud def cnstr");
	}
	
	public Student(Integer studId) {
		super();
		this.studId = studId;
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stud_id")
	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	@Column(length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@ManyToMany(mappedBy="students")
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + "]";
	}

	

}
