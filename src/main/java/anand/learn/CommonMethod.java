package anand.learn;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class CommonMethod {
	
	public void readAllModelNames(Session session) {
        Query query = session.createQuery("select model from Car");
		List<String> carNames = query.list();
        System.out.println("Reading all car model name...");
        System.out.printf("%s%n", "Model");
        for (String name : carNames) {
            System.out.printf("%s%n", name);
        }
    }
	
	public void create(Session session) {
        Car nano = new Car();
        nano.setModel("nano");
        nano.setManufacturer("Tata");
        nano.setPrice("40,000.00");
        nano.setMakeYear(LocalDate.of(1998, 2, 12));
         
        Car santro = new Car();
        santro.setModel("santro");
        santro.setManufacturer("Hundai");
        santro.setPrice("20,000.00");
        santro.setMakeYear(LocalDate.of(1992, 11, 20));
        
        Car swift = new Car();
        swift.setModel("swift");
        swift.setManufacturer("suzuki");
        swift.setPrice("10,000.00");
        swift.setMakeYear(LocalDate.of(2002, 8, 15));
        
        Car baleno = new Car();
        baleno.setModel("baleno");
        baleno.setManufacturer("suzuki");
        baleno.setPrice("20,000.00");
        baleno.setMakeYear(LocalDate.of(2018, 5, 25));
         
        session.beginTransaction();
        session.save(nano);
        session.save(santro);
        session.save(swift);
        session.save(baleno);
        session.getTransaction().commit();
    }

}
