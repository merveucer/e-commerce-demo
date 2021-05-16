package ecommercedemo;

import ecommercedemo.business.abstracts.UserService;
import ecommercedemo.business.concretes.UserManager;
import ecommercedemo.core.concretes.GoogleAuthManagerAdapter;
import ecommercedemo.core.concretes.VerificationManager;
import ecommercedemo.dataAccess.concretes.InMemoryUserDao;
import ecommercedemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
				
		UserService userService = new UserManager(new InMemoryUserDao(), new VerificationManager(), new GoogleAuthManagerAdapter());
		
		User user1 = new User(userService.getAll().size() + 1, "Merve", "Üçer", "merveucer08@gmail.com", "123456");
		User user2 = new User(userService.getAll().size() + 1, "Merve", "Üçer", "merveucer08", "123456");
		User user3 = new User(userService.getAll().size() + 1, "Merve", "Üçer", "merveucer08@gmail.com", "123456");
		User user4 = new User(userService.getAll().size() + 1, "M", "Ü", "mu08@gmail.com", "123456");
		User user5 = new User(userService.getAll().size() + 1, "Merve", "Üçer", "mu08@gmail.com", "123");
		
		System.out.println("------ Register ------");
		userService.register(user1);
		
		System.out.println("------ Invalid E-mail Address ------");
		userService.register(user2);
		
		System.out.println("------ E-mail Address Already Exists ------");
		userService.register(user3);
		
		System.out.println("------ Invalid Name ------");
		userService.register(user4);
		
		System.out.println("------ Invalid Password ------");
		userService.register(user5);
		
		System.out.println("------ Register With Auth Service ------");
		userService.registerWithAuthService("aaa@gmail.com", "aaaaaa");
		userService.registerWithAuthService("bbb@gmail.com", "bbbbbb");
		userService.registerWithAuthService("ccc@gmail.com", "cccccc");
		
		System.out.println("------ Login ------");
		userService.login("merveucer08@gmail.com", "123456");
		
		System.out.println("------ E-mail Address Does Not Exist ------");
		userService.login("merveucer@gmail.com", "123456");
		
		System.out.println("------ Incorrect Password ------");
		userService.login("merveucer08@gmail.com", "123456789");
		
		System.out.println("------ Logout ------");
		userService.logout(user1);
		
		System.out.println("------ Get ------");
		System.out.println(userService.get(1).getId() + " " + userService.get(1).getFirstName() + " " + userService.get(1).getLastName());
		
		System.out.println("------ Get All ------");
		for (User u : userService.getAll()) {
			System.out.println(u.getId() + " " + u.getFirstName() + " " + u.getLastName());
		}
		
		System.out.println("------ Update ------");
		userService.update(new User(1, "Merve", "Üçer", "merveucer08@gmail.com", "abcdef"));
		
		System.out.println("------ Delete ------");
		userService.delete(user1);
		
	}

}
