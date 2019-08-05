package com.app.dao;

import com.app.pojos.ApplicationData;

public interface ApplicationDataDao {
	void saveData(ApplicationData data);
	ApplicationData getData(Integer id);
}
