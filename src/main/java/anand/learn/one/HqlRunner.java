package anand.learn.one;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class HqlRunner {
 
    public void create(Session session) {
        Car mustang = new Car();
        mustang.setModel("nano");
        mustang.setPrice("40,000.00");
         
        Car mondeo = new Car();
        mondeo.setModel("santro");
        mondeo.setPrice("20,000.00");
        
        Car swift = new Car();
        swift.setModel("suzuki swift");
        swift.setPrice("10,000.00");
        
        Car beleno = new Car();
        beleno.setModel("suzuki beleno");
        beleno.setPrice("20,000.00");
         
        session.beginTransaction();
        session.save(mustang);
        session.save(mondeo);
        session.save(swift);
        session.save(beleno);
        session.getTransaction().commit();
    }
    
    public void update(Session session) {        
        Query query = session.createQuery("update Car set price = :price" +
				" where model = :model");
        query.setParameter("price", "13,000.00");
        query.setParameter("model", "mustang");
        int result = query.executeUpdate();
        System.out.println("row updated : "+result);
    }
     
    public void delete(Session session) {
    	Query query = session.createQuery("delete Car where model = :model");
    	query.setParameter("model", "nano");
    	int result = query.executeUpdate();
    	System.out.println("row deleted : "+result);
    }
    
    public void read(Session session) {
        Query query = session.createQuery("from Car where model =	:code");
        query.setParameter("code", "mustang");   
		List<Car> cars = query.list();
        System.out.println("Reading car records...of Model : mustang");
        System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
        for (Car c : cars) {
            System.out.printf("%-30.30s  %-30.30s%n", c.getModel(), c.getPrice());
        }
    }
    public void readAll(Session session) {
        Query query = session.createQuery("from Car");
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