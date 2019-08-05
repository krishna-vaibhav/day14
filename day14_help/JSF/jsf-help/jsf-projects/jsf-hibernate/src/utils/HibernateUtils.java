package utils;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		// create empty config & populate it
		Configuration cfg = new Configuration().configure();
		// create service reg inst
		// create empty SRB ---populate it --- applySettings(Map<S,S> props)
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		factory = cfg.buildSessionFactory(reg);
		System.out.println("sf created ");
	}

	public static SessionFactory getFactory() {
		return factory;
	}

}
