package pojos3;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "dac_courses")
public class Course {
	private Integer id;
	private String name;
	private List<Student> students = new ArrayList<>();

	public Course() {
		System.out.println("course def cnstr");
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "course_studs", joinColumns = @JoinColumn(name = "c_id"), inverseJoinColumns = @JoinColumn(name = "s_id"))
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	// convenience methods
	// add student to course
	public void addStudent(Student s) {
		// set up bi-dir asso
		students.add(s);
		s.getCourses().add(this);
	}

	// remove student from course
	public void removeStudent(Student s) {
		// set up bi-dir asso
		students.remove(s);
		s.getCourses().remove(this);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}


}
