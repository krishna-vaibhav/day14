package custom_tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.jasper.el.JspELException;

public class HelloTagHandler extends SimpleTagSupport {
	public HelloTagHandler() {
		System.out.println("in constr of "+getClass().getName());
	}
	@Override
	public void doTag() throws JspException,IOException{
		System.out.println("in do-tag");
		//WC has alrdy invoked , after inst tag class -- setJspContext
		//to pass entire page env to custom tag class.
		getJspContext().getOut().write("Hello from custom tags....");
		
	}
}
