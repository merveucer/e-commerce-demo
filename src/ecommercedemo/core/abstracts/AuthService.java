package ecommercedemo.core.abstracts;

import googleAuth.GoogleUser;

public interface AuthService {
	
	GoogleUser Auth(String email, String password);
	
}
