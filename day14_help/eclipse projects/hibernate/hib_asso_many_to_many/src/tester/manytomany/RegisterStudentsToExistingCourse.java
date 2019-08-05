package tester.manytomany;

import static utils.HibernateUtils.*;

import java.util.Arrays;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.MappingDao3;
import pojos3.*;

public class RegisterStudentsToExistingCourse {

	public static void main(String[] args) {
		SessionFactory sf = null;

		try (Scanner sc = new Scanner(System.in)) {
			sf = getSf();
			System.out.println("Enter student id & course id");
			MappingDao3 dao = new MappingDao3();
			dao.registerStudentToCourse(sc.nextInt(),sc.nextInt());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sf.close();
		}
	}

}
