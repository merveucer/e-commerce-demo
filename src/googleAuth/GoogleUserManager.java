package googleAuth;

import java.util.ArrayList;
import java.util.List;

public class GoogleUserManager implements GoogleUserService {

	List<GoogleUser> googleUsers;

	public GoogleUserManager() {		
		googleUsers = new ArrayList<GoogleUser>();
		googleUsers.add(new GoogleUser(1, "Aaa", "Aaa", "aaa@gmail.com", "aaaaaa"));
		googleUsers.add(new GoogleUser(2, "Bbb", "Bbb", "bbb@gmail.com", "bbbbbb"));
		googleUsers.add(new GoogleUser(3, "Ccc", "Ccc", "ccc@gmail.com", "cccccc"));
	}

	public List<GoogleUser> getAll() {		
		return googleUsers;
	}

}
