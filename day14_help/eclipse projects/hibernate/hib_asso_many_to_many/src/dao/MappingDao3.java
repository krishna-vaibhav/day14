package dao;

import static utils.HibernateUtils.getSf;
import org.hibernate.*;
import pojos3.*;


public class MappingDao3 {
	public Integer launchCourse(Course c) {
		Integer id = null;
		Session hs = getSf().getCurrentSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			id = (Integer) hs.save(c);
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}

		return id;
	}
	public Integer registerStudent(Student s) {
		Integer id = null;
		Session hs = getSf().getCurrentSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			id = (Integer) hs.save(s);
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}

		return id;
	}
	public String registerStudentToCourse(int studId,int courseId) {
		String status="";
		
		Session hs = getSf().getCurrentSession();
		// begin tx
		Transaction tx = hs.beginTransaction();
		try {
			//validate student
			Student s=hs.get(Student.class, studId);
			if(s != null)
			{
				//validate course
				Course c=hs.get(Course.class, courseId);
				if(c != null)
				{
					c.addStudent(s);
				}
			}
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}
		return status;
	}

}
