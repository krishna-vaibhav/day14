package com.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ComplaintDao;
import com.app.pojos.Complaint;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {
	@Autowired
	private ComplaintDao dao;

	@Override
	public Integer addComplaint(Complaint c) {
		c.setCompDate(new Date());
		c.setStatus("new");
		return dao.addComplaint(c);
	}

	@Override
	public Complaint getComplaintStatus(Integer id) {
		
		return dao.getComplaintStatus(id);
	}

}
