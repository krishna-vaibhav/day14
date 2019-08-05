package tester.manytomany;

import static utils.HibernateUtils.*;

import java.util.Arrays;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.MappingDao3;
import pojos3.*;

public class RegisterNewStudent {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getSf();) {

			System.out.println("Enter student  name");
			Student s1 = new Student(sc.next());
			MappingDao3 dao = new MappingDao3();
			dao.registerStudent(s1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
