package ecommercedemo.business.abstracts;

import java.util.List;

import ecommercedemo.entities.concretes.User;

public interface UserService {
	
	void register(User user);
	void registerWithAuthService(String email, String password);
	void login(String email, String password);
	void logout(User user);
	void update(User user);
	void delete(User user);
	User get(int id);
	List<User> getAll();

}
