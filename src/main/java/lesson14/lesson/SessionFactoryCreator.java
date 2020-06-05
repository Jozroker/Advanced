package lesson14.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryCreator {

    private static SessionFactory sf;

    private SessionFactoryCreator(){
    }

    public static SessionFactory getInstance() {
        if (sf == null) {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sf = cfg.buildSessionFactory();
        }
        return sf;
    }
}
