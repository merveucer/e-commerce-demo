package ecommercedemo.core.abstracts;

public interface VerificationService {
	
	void sendEmail(String email);
	boolean verifyEmail();

}
