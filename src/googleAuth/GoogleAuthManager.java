package googleAuth;

import java.util.ArrayList;
import java.util.List;

public class GoogleAuthManager {

	GoogleUserService googleUserService;

	public GoogleAuthManager(GoogleUserService googleUserService) {
		this.googleUserService = googleUserService;
	}

	public List<String> auth(String email, String password) {

		for (GoogleUser googleUser : googleUserService.getAll()) {
			if (googleUser.getEmail() == email && googleUser.getPassword() == password) {

				List<String> userInformations = new ArrayList<String>();
				userInformations.add(0, googleUser.getFirstName());
				userInformations.add(1, googleUser.getLastName());
				userInformations.add(2, googleUser.getEmail());
				userInformations.add(3, googleUser.getPassword());
				
				return userInformations;
			}
		}

		return null;
	}

}
