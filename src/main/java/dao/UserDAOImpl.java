package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.User;
import utils.JPAUtil;

/**
 * 
 * 
 * 
 * 1. view --> JSP / JSTL -- interfaz de usuario 2. controller --> Servlet
 * Redirecciona, obtiene datos, carga las vistas, etc. 3. Service --> llama al
 * DAO y y hace operaciones (logica de negocio) 4. DAO o Repository -->
 * operaciones contra base datos: CRUD
 * 
 * 
 * 
 * @author omar.g
 *
 */
public class UserDAOImpl implements UserDAO {
	// si no pongo clase abstract me da error en la propia clase

	EntityManager manager;

	@Override
	public List<User> get() {

		try {
			manager = JPAUtil.getEntityManager();
			TypedQuery<User> namedQuery = manager.createNamedQuery("User.findAll", User.class);
			List<User> results = namedQuery.getResultList();
			manager.close();
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}

	@Override
	public User get(int id) {
		User user = null;
		try {
			manager = JPAUtil.getEntityManager();
			user = manager.find(User.class, id);
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean save(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean delete(int id) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			User user = manager.find(User.class, id);
			if (user != null) {
				manager.remove(user);
				manager.getTransaction().commit();
				flag = true;
			}
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean update(User user) {
		boolean flag = false;
		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(user);
			manager.getTransaction().commit();
			manager.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;

	}

	@Override
	public List<User> login(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
