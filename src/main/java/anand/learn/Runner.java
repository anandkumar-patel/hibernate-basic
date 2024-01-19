package anand.learn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Runner {
	public void update(Session session) {
		System.out.println("Updating swift price...");
		Car mustang = (Car) session.get(Car.class, "swift");
		mustang.setPrice("35,250.00");

		session.beginTransaction();
		session.saveOrUpdate(mustang);
		session.getTransaction().commit();
	}

	public void delete(Session session) {
		System.out.println("Deleting nano record...");
		Car mondeo = (Car) session.get(Car.class, "nano");

		session.beginTransaction();
		session.delete(mondeo);
		session.getTransaction().commit();
	}

	public void read(Session session) {
		Query query = session.createQuery("select _car from Car  _car where model =	:code");
		query.setParameter("code", "santro");
		List<Car> cars = query.list();

		System.out.println("Reading car records...of Model : santro");
		System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
		for (Car c : cars) {
			System.out.printf("%-30.30s  %-30.30s%n", c.getModel(), c.getPrice());
		}
	}

	public void readAll(Session session) {
		Query query = session.createQuery("select _car from Car _car");

		List<Car> cars = query.list();

		System.out.println("Reading all car records...");
		System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
		for (Car c : cars) {
			System.out.printf("%-30.30s  %-30.30s%n", c.getModel(), c.getPrice());
		}
	}
}