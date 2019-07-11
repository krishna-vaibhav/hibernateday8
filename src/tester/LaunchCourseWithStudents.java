package tester;
import static utils.HibernateUtils.*;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.CourseManagementImpl;
import pojos.Course;
import pojos.Student;

public class LaunchCourseWithStudents {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try(SessionFactory sf=getSf();
				Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter course details nm begin-dt end-dt fees");
			Course c1=new Course(sc.next(), sdf.parse(sc.next()), sdf.parse(sc.next()), sc.nextDouble());
			System.out.println("Enter 1st student details -- em");
			Student s1=new Student(sc.next());
			System.out.println("Enter 2nd student details -- em");
			Student s2=new Student(sc.next());
			System.out.println("Enter 3rd student details -- em");
			Student s3=new Student(sc.next());
			c1.addStudent(s1);c1.addStudent(s2);c1.addStudent(s3);
			System.out.println(new CourseManagementImpl().launchCourse(c1));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
