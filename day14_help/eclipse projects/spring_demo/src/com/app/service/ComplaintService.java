package com.app.service;

import com.app.pojos.Complaint;

public interface ComplaintService {
	Integer addComplaint(Complaint c);
	Complaint getComplaintStatus(Integer id);

}
