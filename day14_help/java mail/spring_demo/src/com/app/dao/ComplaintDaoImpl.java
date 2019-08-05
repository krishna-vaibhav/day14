package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.ApplicationData;
import com.app.pojos.Complaint;

@Repository
public class ComplaintDaoImpl implements ComplaintDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Integer addComplaint(Complaint c) {
		sf.getCurrentSession().persist(c);
		return c.getId();
	}

	@Override
	public Complaint getComplaintStatus(Integer id) {
		return (Complaint) sf.getCurrentSession().get(
				Complaint.class, id);
	}

}
