package com.revature.LibraryCatalog;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("deprecation")
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Creating Library User");
    	
    	Patron patron1 = new Patron(1, "Carlos", "Portillo", "3737 N. Calle Cancion", 5202485337L,
    			"noisecore22live.com");
    	
    	System.out.println(patron1.getEmailAddress());

        @SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(patron1);
		session.getTransaction().commit();

		session.close();
    }
        
}
