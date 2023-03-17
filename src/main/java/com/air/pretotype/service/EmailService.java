package com.air.pretotype.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.air.pretotype.model.UserEmail;
import com.air.pretotype.repository.EmailRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

	@Value("${EMAIL_SEND_INFO.adminEmail}")
	String user;
	@Value("${EMAIL_SEND_INFO.adminEmailPassword}")
	String password;
	private final EmailRepository repository;

	private String encrypt(String code){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		md.update(code.getBytes());

		return bytesToHex(md.digest());
	}

	private String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}

	public String createDiscountCode(){
		String code = "";

		// 시간데이터 생성
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		String timeData = formatter.format(LocalDateTime.now());

		// 난수 10자리 생성
		Random random =new Random();
		String randomData  = "";
		for(int i=0;i<10;i++){
			if(random.nextBoolean()){
				randomData+=((char)((int)(random.nextInt(26))+97));
			}else{
				randomData+=((random.nextInt(10)));
			}
		}

		code = timeData+randomData;

		return encrypt(code);
	}

	public boolean checkDisCountCodeDistinct(List<String> codeList){

		boolean result = true;

		for(int i = 0; i<codeList.size();i++){
			for(int j = 0; j<i; j++){
				if(codeList.get(i).equals(codeList.get(j))){
					return !result;
				}
			}
		}

		return result;
	}

	public void save(UserEmail email){
		repository.save(email);
	}

	public void send(UserEmail email){
		email.setDiscountCode(createDiscountCode());
		save(email);

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.naver.com");
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");

		Authenticator auth = new SMTPAuthenticator();

		Session session = Session.getDefaultInstance(props,auth);

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(email.getEmailAddress()));
			message.setSubject("할인 코드");
			message.setText(email.getDiscountCode());

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator{
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(user,password);
		}
	}

}
