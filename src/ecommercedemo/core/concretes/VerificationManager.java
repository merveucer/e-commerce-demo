package ecommercedemo.core.concretes;

import ecommercedemo.core.abstracts.VerificationService;

public class VerificationManager implements VerificationService {

	@Override
	public void sendEmail(String email) {
		System.out.println(email + " adresine doğrulama e-postası gönderilmiştir.");
	}

	@Override
	public boolean verifyEmail() {
		return true;
	}

}
