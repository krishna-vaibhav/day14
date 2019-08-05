package com.app.beans;

import javax.faces.bean.ManagedBean;

import com.app.model.UrlData;

@ManagedBean(name="url")
public class URLBean {
	private UrlData data;

	public UrlData getData() {
		return data;
	}

	public void setData(UrlData data) {
		this.data = data;
	}
	public String test()
	{
		return "result";
	}
	

}
