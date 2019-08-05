package com.app.converters;

import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import com.app.model.UrlData;
//"com.app.converters.UrlConverter"
@FacesConverter("my_converter")
public class UrlConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, 
			UIComponent component,
			String value) {
		if (!value.startsWith("http") || !value.endsWith(".com")) {
			FacesMessage msg = new FacesMessage
					("Error converting URL",
					"Invalid URL format");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
		UrlData urlData = new UrlData(value);
		return urlData;
	}

	@Override
	public String getAsString(FacesContext facesContext, 
			UIComponent component,
			Object value) {
		return value.toString();
	}
}