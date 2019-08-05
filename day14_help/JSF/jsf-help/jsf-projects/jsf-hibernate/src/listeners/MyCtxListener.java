package listeners;

import java.util.Arrays;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyCtxListener
 *
 */
@WebListener
public class MyCtxListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		arg0.getServletContext().setAttribute(
				"countries",
				Arrays.asList("India", "Russia", "USA", "UK", "Malaysia",
						"Singapore"));
		arg0.getServletContext().setAttribute(
				"languages",Arrays.asList("Java","C#","C++","Scala"));
		arg0.getServletContext().setAttribute(
				"technologies",Arrays.asList("J2SE","J2EE",".NET","XML","JS"));
	}

}
