package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.ApplicationData;

@Repository
public class ApplicationDataDaoImpl implements ApplicationDataDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public void saveData(ApplicationData data) {
		sf.getCurrentSession().persist(data);
	}

	@Override
	public ApplicationData getData(Integer id) {
		return (ApplicationData) sf.getCurrentSession().get(
				ApplicationData.class, id);
	}

}
