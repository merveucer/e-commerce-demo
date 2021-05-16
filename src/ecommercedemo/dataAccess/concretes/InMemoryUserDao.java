package ecommercedemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ecommercedemo.dataAccess.abstracts.UserDao;
import ecommercedemo.entities.concretes.User;

public class InMemoryUserDao implements UserDao {

	List<User> users;

	public InMemoryUserDao() {
		users = new ArrayList<User>();
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

	@Override
	public void update(User user) {

		for (User u : users) {
			if (u.getId() == user.getId()) {
				u.setFirstName(user.getFirstName());
				u.setLastName(user.getLastName());
				u.setEmail(user.getEmail());
				u.setPassword(user.getPassword());
			}
		}
	}

	@Override
	public void delete(User user) {
		users.remove(user);
	}

	@Override
	public User get(int id) {

		for (User u : users) {
			if (u.getId() == id) {
				return u;
			}
		}
		
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
