package kmi.foundation.extensions;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class KMISmtpAuthenticator extends Authenticator {

	String userName = null;
	String password = null;
	
	public KMISmtpAuthenticator(String smtp_user, String smtp_password)
	{
		this.userName = smtp_user;
		this.password = smtp_password;
	}
	
	public PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(userName, password);
	}	
	
}

