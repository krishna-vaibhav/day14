package com.app.service;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager=true)
@ApplicationScoped
public class UserServiceImpl implements UserService {
	private HashMap<String,String> users;

	@Override
	public boolean userExists(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
