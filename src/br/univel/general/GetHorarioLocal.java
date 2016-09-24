package br.univel.general;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GetHorarioLocal {

	public String getHorarioLocal(String formatoData) {

		DateFormat dateFormat = new SimpleDateFormat(formatoData);
		Calendar cal = Calendar.getInstance();

		return dateFormat.format(cal.getTime());

	}

}
