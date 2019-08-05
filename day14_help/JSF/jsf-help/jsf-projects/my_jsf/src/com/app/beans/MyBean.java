package com.app.beans;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@ViewScoped
public class MyBean implements Serializable {

    private String selected;
    private String result;
    private List<Double> data=Arrays.asList(2.3,4.5,1.23,3.56);

    public void submit() {
        System.out.println("submit");
    }

    public void listener(AjaxBehaviorEvent event) {
        System.out.println("listener");
        result = "called by " + event.getComponent().
        		getClass().getName();
    }
    public void listener2(AjaxBehaviorEvent event) {
        System.out.println("listener2");
       /* for(int i=0;i<data.size();i++)
        	data.set(i, data.get(i)+1);*/
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getResult() {
        return result;
    }

	public List<Double> getData() {
		return data;
	}
    

}