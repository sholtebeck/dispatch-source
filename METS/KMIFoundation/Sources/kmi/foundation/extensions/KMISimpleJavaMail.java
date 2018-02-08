package kmi.foundation.extensions;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.smtp.SMTPTransport;
import com.webobjects.appserver.WOApplication;
import com.webobjects.appserver.WOComponent;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSDictionary;

import er.extensions.foundation.ERXStringUtilities;

public class KMISimpleJavaMail {

	private boolean _requiresSSL;
	private boolean _requiresAuthentication;
	private int _portNumber;
	private String _smtpHost;
	private String _userName;
	private String _password;
	private Session _session;
	private MimeMessage _message;
	private boolean _debug;

	public KMISimpleJavaMail() {
		this(
				System.getProperty("SMTP_HOST"), 
				System.getProperty("SMTP_USER"), 
				System.getProperty("SMTP_PASS"), 
				Boolean.parseBoolean(System.getProperty("SMTP_AUTH")), 
				Boolean.parseBoolean(System.getProperty("SMTP_SSL")), 
				Integer.parseInt(System.getProperty("SMTP_PORT")),
				Boolean.parseBoolean(System.getProperty("MAIL_DEBUG")));
	}
	
	public KMISimpleJavaMail(
			String smtpHost, 
			String userName, 
			String password, 
			boolean requiresAuthentication, 
			boolean requiresSSL, 
			int portNumber,
			boolean debug) {
		
		this._smtpHost = smtpHost;
		this._userName = userName;
		this._password = password;
		this._requiresAuthentication = requiresAuthentication;
		this._requiresSSL = requiresSSL;
		this._portNumber = portNumber;
	
		Properties properties = new Properties();
		properties.put("mail.smtp.host", _smtpHost);
		properties.put("mail.smtp.auth", String.valueOf(_requiresAuthentication));
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.port", String.valueOf(_portNumber));

		KMISmtpAuthenticator auth = new KMISmtpAuthenticator(this._userName, this._password);
		this._session = Session.getInstance(properties, auth);
		this._session.setDebug(_debug);
		this._message = new MimeMessage(_session);
		
	}	
	
	public void addAttachment(String fileName, String framework) throws MessagingException, URISyntaxException, IOException {
		URL url = WOApplication.application().resourceManager().pathURLForResourceNamed(fileName, framework, null);
		File attachmentFile = new File(url.toURI());
		addAttachment(attachmentFile);
	}
	
	public void addAttachment(File attachmentFile) throws MessagingException, URISyntaxException, IOException {
		
		MimeMultipart mixed = new MimeMultipart("mixed");
		BodyPart attachment = new MimeBodyPart();
		DataSource source = new FileDataSource(attachmentFile);
		attachment.setDataHandler(new DataHandler(source));
		attachment.setFileName(attachmentFile.getName());

		if(_message.getContent() != null) {
			MimeBodyPart wrap = new MimeBodyPart();
			wrap.setContent(_message.getContent(),"text/html");
			mixed.addBodyPart(wrap);
		}

		mixed.addBodyPart(attachment);
		
		_message.setContent(mixed);
		
	}

	
	public void addRecipient(String email, String label) throws MessagingException, UnsupportedEncodingException {
		addRecipient(Message.RecipientType.TO, email, label);
	}

	public void addRecipient(Message.RecipientType recipientType, String email, String label) throws MessagingException, UnsupportedEncodingException {
		_message.addRecipient(recipientType, internetAddressForEMailAndLabel(email, label));
	}
	
	public void addRecipients(Message.RecipientType recipientType, NSArray<NSDictionary<String, String>> recipients) throws MessagingException, UnsupportedEncodingException {
		for(NSDictionary<String, String> recipient : recipients) {
			addRecipient(recipientType, (String)recipient.valueForKey("email"), (String)recipient.valueForKey("label"));
		}
	}

	public void addRecipients(NSArray<NSDictionary<String, String>> recipients) throws MessagingException, UnsupportedEncodingException {
		for(NSDictionary<String, String> recipient : recipients) {
			addRecipient(Message.RecipientType.TO, (String)recipient.valueForKey("email"), (String)recipient.valueForKey("label"));
		}
	}
	
	public static InternetAddress internetAddressForEMailAndLabel(String email, String label) throws UnsupportedEncodingException {
		return new InternetAddress(email, label);
	}
	
	public void sendMessage() throws MessagingException {

		SMTPTransport transport = (SMTPTransport)_session.getTransport(this._requiresSSL ? "smtps" : "smtp");
		transport.connect(_smtpHost, _userName, _password);
		_message.setSentDate(new Date());
		_message.saveChanges();
		transport.sendMessage(_message, _message.getAllRecipients());
		transport.close();
		
	}
	
	public void setContent(String text, String html) throws MessagingException {
		
		if(ERXStringUtilities.stringIsNullOrEmpty(html)) {

			setText(text);
		
		} else {

			Multipart multiPartMessage = new MimeMultipart("alternative");

			BodyPart textPart = new MimeBodyPart();
			textPart.setContent(text, "text/plain");
			multiPartMessage.addBodyPart(textPart);

			BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(html, "text/html");
			multiPartMessage.addBodyPart(htmlPart);
			
			_message.setContent(multiPartMessage);

			MailcapCommandMap mc = (MailcapCommandMap)CommandMap.getDefaultCommandMap();
			mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
			CommandMap.setDefaultCommandMap(mc);
		
		}
	}
	
	public void setContent(String text, WOComponent component) throws MessagingException {
		setContent(text, component.generateResponse().contentString());
	}
	
	public void setFrom(String email, String label) throws MessagingException, UnsupportedEncodingException {
		_message.setFrom(internetAddressForEMailAndLabel(email, label));
	}
	
	public void setReplyTo(String email, String label) throws MessagingException, UnsupportedEncodingException {
		setReplyTo( new InternetAddress[] { internetAddressForEMailAndLabel(email, label) });
	}

	public void setReplyTo(InternetAddress[] addresses) throws MessagingException {
		_message.setReplyTo(addresses);
	}
	
	public void setSubject(String subject) throws MessagingException {
		_message.setSubject(subject);
	}

	public void setText(String text) throws MessagingException {
		_message.setText(text);
	}
	
}
