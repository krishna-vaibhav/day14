package com.app.validators;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
@FacesValidator("my_date_validator")
public class MyDateValidator implements Validator {
	private static SimpleDateFormat sdf;
	private static Date beginDate, endDate;
	static {
		try {
			sdf = new SimpleDateFormat("dd-MMM-yyyy");
			beginDate = sdf.parse("1-jan-2013");
			endDate = sdf.parse("1-mar-2014");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void validate(FacesContext arg0, 
			UIComponent arg1, Object arg2)
			throws ValidatorException {
		Date suppliedDate=(Date) arg2;
		if (suppliedDate.before(beginDate)||suppliedDate.after(endDate))
		{
			FacesMessage mesg=new FacesMessage
					("Supplied Date outside the range");
			mesg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mesg);
		}

	}

}
