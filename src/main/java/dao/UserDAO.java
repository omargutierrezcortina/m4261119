package dao;

import java.util.List;

import model.User;

public interface UserDAO {

	/**
	 * Busca un usuario por email y password
	 * 
	 * @param email
	 * @params password
	 * @return
	 */
	// MÉTODO LOGIN CON EMAIL Y PASSWORD

	List<User> login(String email, String password);

	/**
	 * It returns a list of all users
	 * 
	 * @return
	 */
	List<User> get();

	/**
	 * 
	 * @param id
	 * @return
	 */

	/**
	 * It saves an user
	 * 
	 * @param usuario
	 * @return true if user is correctly saved or false if there is an error
	 */

	User get(int id);

	boolean save(User user);

	boolean delete(int id);

	boolean update(User user);

}
