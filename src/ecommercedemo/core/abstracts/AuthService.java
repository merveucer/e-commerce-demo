package ecommercedemo.core.abstracts;

import java.util.List;

public interface AuthService {
	
	List<String> auth(String email, String password);
	
}
