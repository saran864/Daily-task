package skart.controller;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import skart.model.SkartUser;
import skart.model.Vendor;

public class Verfication {
	
	public String getRandomNumberString() {
	    Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    return String.format("%06d", number);
	}
	
	public boolean emailVerification(SkartUser skartuser)
	{
		boolean test= false;
		String sendEmail="yoursskart@gmail.com";
		String sendPassword="oyvehjwuqpvismxs";
		String toEmail=skartuser.getUsername();
		try {
			
		
			    Properties ps = new Properties();
			    ps.put("mail.smtp.host", "smtp.gmail.com");		
		        ps.put("mail.smtp.auth", "true");
		        ps.put("mail.smtp.port", "587");
		        ps.put("mail.smtp.starttls.enable", "true");
				
			Session session=Session.getInstance(ps,new Authenticator()
					{
				
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(sendEmail,sendPassword);
				}
				
					}
					);
			session.setDebug(true);
			Message msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(sendEmail));
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail) );	
			msg.setSubject("Skart Email Verification");
			msg.setText("Please verify your skart account using this code: "+skartuser.getCode()+".");
			System.out.println("Sending");
			Transport.send(msg);
			System.out.println("Messege Send successfully");
			test=true;
		}catch( Exception e)
		{
			e.printStackTrace();
		}
		return test;
		
		
	}
	
		
	
	public boolean vendorsEmailVerification(Vendor vendor)
	{
		boolean test= false;
		String sendEmail="yoursskart@gmail.com";
		String sendPassword="oyvehjwuqpvismxs";
		String toEmail=vendor.getEmail();
		try {
			
		
			    Properties ps = new Properties();
			    ps.put("mail.smtp.host", "smtp.gmail.com");		
		        ps.put("mail.smtp.auth", "true");
		        ps.put("mail.smtp.port", "587");
		        ps.put("mail.smtp.starttls.enable", "true");
				
			Session session=Session.getInstance(ps,new Authenticator()
					{
				
				protected PasswordAuthentication getPasswordAuthentication()
				{
					return new PasswordAuthentication(sendEmail,sendPassword);
				}
				
					}
					);
			session.setDebug(true);
			Message msg=new MimeMessage(session);
			msg.setFrom(new InternetAddress(sendEmail));
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail) );	
			msg.setSubject("Skart Email Verification");
			msg.setText(" Congratlations! You are successfully Added for Skart vendor.\n Please  change password to continue your account\n username:"+vendor.getUserName()+"\npassword:"+vendor.getPassword()+".");
			System.out.println("Sending");
			Transport.send(msg);
			System.out.println("Messege Send successfully");
			test=true;
		}catch( Exception e)
		{
			e.printStackTrace();
		}
		return test;
		
		
	}

}
