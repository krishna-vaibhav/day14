package tester;

import java.util.Date;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.pojos.Location;
import com.app.pojos.Student;
import com.app.pojos.StudentDetails;
import com.app.service.StudentService;

public class RegisterStudent {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
						"main-config.xml")) {
			System.out.println("sc strted");
			StudentService service = ctx.getBean(StudentService.class);
			System.out.println("Enter Student name & center location ");
			Student s1 = new Student(sc.next(), Location.valueOf(sc.next()
					.toUpperCase()));
			System.out.println("Enter java cpp se marks");
			StudentDetails sd = new StudentDetails(sc.nextInt(), sc.nextInt(),
					sc.nextInt());
			s1.addDetails(sd);
			System.out.println("Registered student : "
					+ service.registerStudent(s1));

		}

	}

}
