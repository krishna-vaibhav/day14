package com.app.listeners;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import com.app.beans.BankController;

public class MyActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent arg0) 
			throws AbortProcessingException {
		BankController b = (BankController) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("bankController");
		if (b != null)
			b.setMesg("Mesg From Action Listener123");

	}

}
