package ecommercedemo.core.concretes;

import ecommercedemo.core.abstracts.AuthService;
import googleAuth.GoogleAuthManager;
import googleAuth.GoogleUser;
import googleAuth.GoogleUserManager;

public class GoogleAuthManagerAdapter implements AuthService {

	@Override
	public GoogleUser Auth(String email, String password) {
		
		GoogleAuthManager googleAuthManager = new GoogleAuthManager(new GoogleUserManager());
		
		return googleAuthManager.Auth(email, password);
	}

}
