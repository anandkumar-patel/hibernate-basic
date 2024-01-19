package anand.learn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class HqlRunner {
    public void update(Session session) {    
    	System.out.println("Updating swift price...");
        Query query = session.createQuery("update Car set price = :price where model = :model");
        query.setParameter("price", "13,000.00");
        query.setParameter("model", "swift");
        int result = query.executeUpdate();
        System.out.println("row updated : "+result);
    }
     
    public void delete(Session session) {
    	System.out.println("Deleting nano record...");
    	Query query = session.createQuery("delete Car where model = :model");
    	query.setParameter("model", "nano");
    	int result = query.executeUpdate();
    	System.out.println("row deleted : "+result);
    }
    
    public void read(Session session) {
        Query query = session.createQuery("from Car where model =	:code");
        query.setParameter("code", "santro");   
		List<Car> cars = query.list();
        System.out.println("Reading car records...of Model : santro");
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
}