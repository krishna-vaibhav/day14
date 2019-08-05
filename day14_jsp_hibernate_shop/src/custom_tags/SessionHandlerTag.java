package custom_tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SessionHandlerTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("in logout ");
		((PageContext)getJspContext()).getSession().invalidate();
	}

}
