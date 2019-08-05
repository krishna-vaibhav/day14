package tester.manytomany;

import static utils.HibernateUtils.*;

import java.util.Arrays;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.MappingDao3;
import pojos3.*;

public class LaunchCourseWithStudents {

	public static void main(String[] args) {
		SessionFactory sf = null;

		try (Scanner sc = new Scanner(System.in)) {
			sf = getSf();
			System.out.println("Enter course 1 name");
			Course c1 = new Course(sc.next());
			System.out.println("Enter course 2 name");
			Course c2 = new Course(sc.next());
			System.out.println("Enter student 1 details");
			Student s1 = new Student(sc.next());
			System.out.println("Enter student 2 details");
			Student s2 = new Student(sc.next());
			System.out.println("Enter student 3 details");
			Student s3 = new Student(sc.next());
			// 1st course adding s2 & s3
			c1.addStudent(s1);
			c1.addStudent(s3);
			// 2nd course adding s1 , s2 s3
			c2.addStudent(s1);
			c2.addStudent(s2);
			c2.addStudent(s3);
			MappingDao3 dao = new MappingDao3();
			dao.launchCourse(c1);
			System.out.println("continue");
			System.in.read();
			
			dao.launchCourse(c2);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sf.close();
		}
	}

}
