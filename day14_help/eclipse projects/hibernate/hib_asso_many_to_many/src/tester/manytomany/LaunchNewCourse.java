package tester.manytomany;

import static utils.HibernateUtils.*;

import java.util.Scanner;
import org.hibernate.SessionFactory;

import dao.MappingDao3;
import pojos3.*;

public class LaunchNewCourse {

	public static void main(String[] args) {
		SessionFactory sf = null;

		try (Scanner sc = new Scanner(System.in)) {
			sf = getSf();
			System.out.println("Enter course  name");
			Course c1 = new Course(sc.next());
			MappingDao3 dao = new MappingDao3();
			dao.launchCourse(c1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sf.close();
		}
	}

}
