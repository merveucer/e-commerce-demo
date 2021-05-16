package googleAuth;

public class GoogleAuthManager {

	GoogleUserService googleUserService;

	public GoogleAuthManager(GoogleUserService googleUserService) {
		this.googleUserService = googleUserService;
	}

	public GoogleUser Auth(String email, String password) {

		for (GoogleUser googleUser : googleUserService.getAll()) {
			if (googleUser.getEmail() == email && googleUser.getPassword() == password) {
				return googleUser;
			}
		}
		
		return null;
	}

}
