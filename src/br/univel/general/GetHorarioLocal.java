package br.univel.general;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetHorarioLocal {

	public String getHorarioLocal() {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar cal = Calendar.getInstance();

		return dateFormat.format(cal.getTime());

	}

}
