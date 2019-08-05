package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ApplicationDataDao;
import com.app.pojos.ApplicationData;

@Service
@Transactional
public class ApplicatioDataServiceImpl implements ApplicationDataService {
	@Autowired
	private ApplicationDataDao dao;
	@Override
	public void saveData(ApplicationData data) {
		dao.saveData(data);

	}
	@Transactional(readOnly=true)
	@Override
	public ApplicationData getData(Integer id) {
		ApplicationData data=dao.getData(id);
		data.getBrowsers().size();
		data.getCities().size();
		data.getPlatforms().size();
		data.getTechnologies().size();
		return data;
	}

}
