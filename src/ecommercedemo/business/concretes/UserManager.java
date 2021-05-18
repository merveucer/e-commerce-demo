package ecommercedemo.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ecommercedemo.business.abstracts.UserService;
import ecommercedemo.core.abstracts.AuthService;
import ecommercedemo.core.abstracts.VerificationService;
import ecommercedemo.dataAccess.abstracts.UserDao;
import ecommercedemo.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;
	VerificationService verificationService;
	AuthService authService;

	public UserManager(UserDao userDao, VerificationService verificationService, AuthService authService) {
		this.userDao = userDao;
		this.verificationService = verificationService;
		this.authService = authService;
	}

	@Override
	public void register(User user) {

		if (checkIfEmailIsValid(user.getEmail())) {

			if (checkIfEmailExists(user.getEmail()) != true) {

				if (checkIfNameIsValid(user.getFirstName(), user.getLastName())) {

					if (checkIfPasswordIsValid(user.getPassword())) {

						verificationService.sendEmail(user.getEmail());

						if (verificationService.verifyEmail()) {

							userDao.add(user);
							System.out.println("Üyelik işlemleri tamamlanmıştır.");
						}
					} else {
						System.out.println("Parola en az 6 karakter uzunluğunda olmalıdır.");
					}
				} else {
					System.out.println("İsim ve soyisim en az 2 karakter uzunluğunda olmalıdır.");
				}
			} else {
				System.out.println("Bu e-posta adresi başka bir hesap tarafından kullanılmaktadır.");
			}
		} else {
			System.out.println("Lütfen geçerli bir e-posta adresi giriniz.");
		}
	}

	@Override
	public void registerWithAuthService(String email, String password) {

		var userInformations = authService.auth(email, password);

		if (userInformations != null) {
			
			userDao.add(new User(getAll().size() + 1, userInformations.get(0), userInformations.get(1), userInformations.get(2), userInformations.get(3)));
			System.out.println(userInformations.get(2) + " adresine ait hesap kullanılarak üyelik işlemleri tamamlanmıştır.");
		} else {
			System.out.println("Lütfen bilgilerinizi kontrol ederek yeniden deneyiniz.");
		}
	}

	@Override
	public void login(String email, String password) {

		if (checkIfEmailExists(email)) {

			if (checkIfEmailAndPasswordAreCorrect(email, password)) {
				System.out.println("Başarıyla giriş yapıldı.");
			} else {
				System.out.println("Parolanızı yanlış girdiniz. Lütfen yeniden deneyiniz.");
			}
		} else {
			System.out.println("Bu e-posta adresine ait bir hesap bulunmamaktadır.");
		}
	}

	@Override
	public void logout(User user) {
		System.out.println("Başarıyla çıkış yapıldı.");
	}

	@Override
	public void update(User user) {

		userDao.update(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " isimli kullanıcı güncellendi.");
	}

	@Override
	public void delete(User user) {

		userDao.delete(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " isimli kullanıcı silindi.");
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	public boolean checkIfEmailIsValid(String email) {

		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
	}

	public boolean checkIfEmailExists(String email) {

		boolean result = false;

		for (User user : getAll()) {
			if (user.getEmail() == email) {
				result = true;
			}
		}

		return result;
	}

	public boolean checkIfNameIsValid(String firstName, String lastName) {

		boolean result = false;

		if (firstName.length() >= 2 && lastName.length() >= 2) {
			result = true;
		}

		return result;
	}

	public boolean checkIfPasswordIsValid(String password) {

		boolean result = false;

		if (password.length() >= 6) {
			result = true;
		}

		return result;
	}

	public boolean checkIfEmailAndPasswordAreCorrect(String email, String password) {

		boolean result = false;

		for (User user : getAll()) {
			if (user.getEmail() == email && user.getPassword() == password) {
				result = true;
			}
		}

		return result;
	}

}
