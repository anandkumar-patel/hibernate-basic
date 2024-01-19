package anand.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainClass {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		Session session = sessionFactory.openSession();

		Runner obj = new Runner();
		//HqlRunner obj = new HqlRunner();
		
		CommonMethod common = new CommonMethod();
		common.create(session);
		obj.readAll(session);

		obj.update(session);
		obj.read(session);

		obj.delete(session);
		obj.readAll(session);

		common.readAllModelNames(session);

		session.close();
		sessionFactory.close();
	}
}