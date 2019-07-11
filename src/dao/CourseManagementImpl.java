package dao;

import pojos.Address;
import pojos.Course;
import pojos.Student;

import org.hibernate.*;
import static utils.HibernateUtils.*;

public class CourseManagementImpl implements CourseManagementDao {

	@Override
	public String launchCourse(Course c) {
		// hs
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			hs.save(c);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Course launched...";
	}

	@Override
	public Course getCourseDetails(String nm1) {
		Course c = null;
		String jpql = "select c from Course c where c.name = :nm";
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.createQuery(jpql, Course.class).setParameter("nm", nm1).getSingleResult();
			// c ---PERSISTENT
			System.out.println("size=" + c.getStudents().size());
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c; // c --- DETACHED

	}

	@Override
	public Course getCourseDetailsViaJoin(String nm1) {
		Course c = null;
		String jpql = "select c from Course c left outer join fetch c.students where c.name = :nm";
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			c = hs.createQuery(jpql, Course.class).setParameter("nm", nm1).getSingleResult();
			// c ---PERSISTENT
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return c; // c --- DETACHED

	}

	@Override
	public String assignStudentAddress(int id, Address a) {
		String mesg = "Student address stored...";
		Session hs = getSf().getCurrentSession();
		// tx
		Transaction tx = hs.beginTransaction();
		try {
			Student s = hs.get(Student.class, id);
			if (s != null) {
				s.setAdr(a);
			} else
				mesg = "Invalid student id.....";
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
