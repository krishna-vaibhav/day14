package tester.manytomany;

import static utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSf();) {
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getSf().close();
		}
	}

}
