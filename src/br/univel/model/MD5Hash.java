package br.univel.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.univel.interfacee.Command;

public class MD5Hash implements Command {
	private String text;

	public MD5Hash(String text) {
		this.text = text;
	}

	@Override
	public String execute(String text) {

		MessageDigest instance;
		try {
			instance = MessageDigest.getInstance("MD5");
			instance.update(this.text.getBytes());
			String hash = new String(instance.digest());
			
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
