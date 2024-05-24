package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory factory;

    static {
        try {
            factory = Persistence.createEntityManagerFactory("shopping_project");
        } catch (Exception e) {
        	System.out.println(e);
            System.out.println("ERROR! EntityManagerFactory 연결 실패");
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }
}
