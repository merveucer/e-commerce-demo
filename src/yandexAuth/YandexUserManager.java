package yandexAuth;

import java.util.ArrayList;
import java.util.List;

public class YandexUserManager implements YandexUserService {
	
	List<YandexUser> yandexUsers;
	
	public YandexUserManager() {		
		yandexUsers = new ArrayList<YandexUser>();
		yandexUsers.add(new YandexUser(1, "Ddd", "Ddd", "ddd@yandex.com", "dddddd"));
		yandexUsers.add(new YandexUser(2, "Eee", "Eee", "eee@yandex.com", "eeeeee"));
		yandexUsers.add(new YandexUser(3, "Fff", "Fff", "fff@yandex.com", "ffffff"));
	}

	@Override
	public List<YandexUser> getAll() {
		return yandexUsers;
	}

}
