package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private HibernateUtil(){}

	public static SessionFactory getSessionFactory(){
		return SingletonHolder.sessionFactory;
	}

	private static class SingletonHolder{
		private static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		private static final SessionFactory sessionFactory = new MetadataSources(registry)
				.buildMetadata()
				.buildSessionFactory();
	}
}
