package br.univel.general;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.univel.interfacee.Command;

public class Sha256Hash implements Command {
	private String text;

	public Sha256Hash(String text) {
		this.text = text;
	}

	@Override
	public String execute() {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");

			md.update(text.getBytes("UTF-8"));

			byte[] digest = md.digest();

			String hash = String.format("%064x", new java.math.BigInteger(1, digest));
			return hash;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
