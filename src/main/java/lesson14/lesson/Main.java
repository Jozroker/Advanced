package lesson14.lesson;

import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {
        createDB();
    }

    private static void createDB() {
        SessionFactory sf = ManagerFactoryClass.getInstance();
    }
}
