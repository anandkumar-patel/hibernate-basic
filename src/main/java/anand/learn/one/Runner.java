package anand.learn.one;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class Runner {

	public void create(Session session) {
		System.out.println("Creating car records...");
		Car mustang = new Car();
		mustang.setModel("mustang");
		mustang.setPrice("40,000.00");

		Car mondeo = new Car();
		mondeo.setModel("mondeo");
		mondeo.setPrice("20,000.00");

		Car swift = new Car();
		swift.setModel("suzuki swift");
		swift.setPrice("10,000.00");

		Car beleno = new Car();
		beleno.setModel("suzuki beleno");
		beleno.setPrice("20,000.00");

		session.beginTransaction();
		// Transaction trans = session.beginTransaction();
		session.save(mustang);
		session.save(mondeo);
		session.save(swift);
		session.save(beleno);
		session.getTransaction().commit();
		// trans.commit();
	}

	public void update(Session session) {
		System.out.println("Updating mustang price...");
		Car mustang = (Car) session.get(Car.class, "mustang");
		mustang.setPrice("35,250.00");

		session.beginTransaction();
		session.saveOrUpdate(mustang);
		session.getTransaction().commit();
	}

	public void delete(Session session) {
		System.out.println("Deleting mondeo record...");
		Car mondeo = (Car) session.get(Car.class, "mondeo");

		session.beginTransaction();
		session.delete(mondeo);
		session.getTransaction().commit();
	}

	public void read(Session session) {
		Query query = session.createQuery("select _car from Car _car where model =	:code");
		query.setParameter("code", "mustang");
		List<Car> cars = query.list();

		System.out.println("Reading car records...of Model : mustang");
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
	
	public void readAllNames(Session session) {
        Query query = session.createQuery("select _car.model from Car _car");
        List<String> carNames = query.list();
        System.out.println("Reading all car name...");
        System.out.printf("%s%n", "Model");
        for (String name : carNames) {
            System.out.printf("%s%n", name);
        }
    }
}