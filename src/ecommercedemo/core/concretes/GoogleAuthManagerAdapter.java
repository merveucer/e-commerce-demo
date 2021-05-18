package ecommercedemo.core.concretes;

import java.util.List;

import ecommercedemo.core.abstracts.AuthService;
import googleAuth.GoogleAuthManager;
import googleAuth.GoogleUserManager;

public class GoogleAuthManagerAdapter implements AuthService {

	@Override
	public List<String> auth(String email, String password) {
		
		GoogleAuthManager googleAuthManager = new GoogleAuthManager(new GoogleUserManager());
		
		return googleAuthManager.auth(email, password);
	}

}
