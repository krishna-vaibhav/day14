package com.app.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.ApplicationData;
import com.app.pojos.Complaint;
import com.app.service.ApplicationDataService;
import com.app.service.ComplaintService;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	private ApplicationDataService service;

	@Autowired
	private ComplaintService compService;
	// even though Controller bean is singleton --so should be stateless,
	// applnData is
	// NOT representing any clnt specific state. so NOT a anti-pattern
	private ApplicationData applnData;

	@PostConstruct
	public void init() {
		// fetching all application data @ web app deployment & storing it in
		// d.m of controller bean
		applnData = service.getData(1);
	}

	@RequestMapping("/add")
	public String showRegComplaintForm(Complaint complaint, Model map) {

		map.addAttribute("applicationData", applnData);
		System.out.println("in show form" + map);
		return "reg_complaint";
	}
	//register complaint
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String processRegComplaintForm(Complaint complaint,RedirectAttributes attrs)
	{
		
		int id=compService.addComplaint(complaint);
		return "redirect:view/"+id;
	}
	
	//view complaint status via path variable
	@RequestMapping("/view/{complaintId}")
	public String viewStatus(@PathVariable int complaintId,Model map) {
		System.out.println("in view status "+complaintId);
		map.addAttribute("complaint",compService.getComplaintStatus(complaintId));
		return "view_complaint";
	}
	
	//view complaint status
		@RequestMapping("/view")
		public String viewStatus2(@RequestParam int compId,Model map) {
			System.out.println("in view status 2 "+compId);
			map.addAttribute("complaint",compService.getComplaintStatus(compId));
			return "view_complaint";
		}
	
	

}
