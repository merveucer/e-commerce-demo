package yandexAuth;

import java.util.ArrayList;
import java.util.List;

public class YandexAuthManager {
	
	YandexUserService yandexUserService;

	public YandexAuthManager(YandexUserService yandexUserService) {
		this.yandexUserService = yandexUserService;
	}

	public List<String> auth(String email, String password) {

		for (YandexUser yandexUser : yandexUserService.getAll()) {
			if (yandexUser.getEmail() == email && yandexUser.getPassword() == password) {
				
				List<String> userInformations = new ArrayList<String>();
				userInformations.add(0, yandexUser.getFirstName());
				userInformations.add(1, yandexUser.getLastName());
				userInformations.add(2, yandexUser.getEmail());
				userInformations.add(3, yandexUser.getPassword());
				
				return userInformations;
			}
		}
		
		return null;
	}

}
