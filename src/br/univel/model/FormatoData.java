package br.univel.model;

public class FormatoData {

	private static final String dtFormattDdMmYyyyHhMm = "dd/MM/yyyy HH:mm";
	private static final String dtFormattDdMmYyyy = "dd/MM/yyyy";

	public static String getDtformattddmmyyyyhhmm() {
		return dtFormattDdMmYyyyHhMm;
	}

	public static String getDtformattddmmyyyy() {
		return dtFormattDdMmYyyy;
	}

}
