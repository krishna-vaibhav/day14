package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.app.pojos.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Student registerStudent(Student s) {
		System.out.println("in dao " + s);
		sf.getCurrentSession().save(s);
		return s;
	}

}
