package tester;

import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseManagementImpl;
import pojos.Course;
import pojos.Student;

public class FetchCourseDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter course name to get details");
			Course c1 = new CourseManagementImpl().getCourseDetails(sc.next());
			//c1 --- DETACHED
			System.out.println("Course details : " + c1);
			System.out.println("Student details : ");
			c1.getStudents().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
