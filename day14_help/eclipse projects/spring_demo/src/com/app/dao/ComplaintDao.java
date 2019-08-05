package com.app.dao;

import com.app.pojos.Complaint;

public interface ComplaintDao {
	Integer addComplaint(Complaint c);
	Complaint getComplaintStatus(Integer id);

}
