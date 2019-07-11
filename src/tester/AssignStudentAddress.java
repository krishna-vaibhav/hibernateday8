package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseManagementImpl;
import pojos.Address;
import pojos.Course;
import pojos.Student;

public class AssignStudentAddress {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter student id n address --city state country");
			
			System.out.println(new CourseManagementImpl().
					assignStudentAddress(sc.nextInt(),
							new Address(sc.next(), sc.next(),
									sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
