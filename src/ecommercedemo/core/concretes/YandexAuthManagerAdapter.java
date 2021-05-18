package ecommercedemo.core.concretes;

import java.util.List;

import ecommercedemo.core.abstracts.AuthService;
import yandexAuth.YandexAuthManager;
import yandexAuth.YandexUserManager;

public class YandexAuthManagerAdapter implements AuthService {

	@Override
	public List<String> auth(String email, String password) {
		
		YandexAuthManager yandexAuthManager = new YandexAuthManager(new YandexUserManager());
		
		return yandexAuthManager.auth(email, password);
	}

}
