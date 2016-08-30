package br.univel.general;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.univel.interfacee.Command;

public class MD5Hash implements Command {
	private String text;

	public MD5Hash(String text) {
		this.text = text;
	}

	@Override
	public String execute() {

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(this.text.getBytes(), 0, this.text.length());
			String hash = new BigInteger(1, m.digest()).toString(16);
			
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}
