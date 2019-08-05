package com.app.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="color_chooser")
public class ColorSelector {

	private String color = "grey";

	public void blue() {
		color = "blue";
	}

	public void green() {
		color = "green";
	}

	public void red() {
		color = "red";
	}

	public String getColor() {
		return color;
	}

	public String getCurrentTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
}
