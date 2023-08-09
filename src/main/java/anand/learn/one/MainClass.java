package anand.learn.one;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class MainClass {
     
    public static void main(String []args) {
    	
    	Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        
        
         // Runner obj = new Runner();
        HqlRunner obj = new HqlRunner(); 
        obj.create(session);
        obj.readAll(session);
    
        obj.update(session);
        obj.read(session);
         
        obj.delete(session);
        obj.readAll(session);

        obj.readAllNames(session);
        
        // setter related 
        SetterRelated setterObj = new SetterRelated();
        setterObj.setId(11);
        setterObj.setName("set name");
        setterObj.setValue("set value");
        setterObj.setJoinDate(new Date());
        setterObj.setJoinTime(new Date());
        setterObj.setDescription("bla bla vla vla");
        
        session.beginTransaction();
        session.save(setterObj);
        session.getTransaction().commit();
     
        
        session.close();
        sessionFactory.close();
    }
}