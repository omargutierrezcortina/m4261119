package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Utility Class for manage JPA connections
 * @author omar.g
 */
public class JPAUtil {

	private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("user");
	

	public static EntityManager getEntityManager() {
		return emFactory.createEntityManager();
	}

}
