package Model.VO;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Util {
	public static String formataData(Calendar data) {
		String d;
		int ano = data.get(Calendar.YEAR);
		int mes = data.get(Calendar.MONTH);
		int dia = data.get(Calendar.DATE);
		
		if (dia < 10 && mes < 10)
			d = 0 + "" + dia + "/" + 0 + "" + mes + "/" + ano;
		else if (dia < 10)
			d = 0 + "" + dia + "/" + mes + "/" + ano;
		else if (mes < 10)
			d = dia + "/" + 0 + "" + mes + "/" + ano;
		else 
			d = dia + "/" + mes + "/" + ano;
		
		return d;
	}
	
	public static Calendar formataData(String d) {
		Calendar dataNascimento = new GregorianCalendar();
		
		int dia = Integer.parseInt(d.substring(0, 2));
		int mes = Integer.parseInt(d.substring(3, 5));
		int ano = Integer.parseInt(d.substring(6, 10));
		
		if(dia > 0 && dia <= 31 && mes > 0 && mes <= 12)
			if (mes == 2 && dia > 28)
				dataNascimento = null;
			else 
				dataNascimento.set(ano, mes, dia);
		
		return dataNascimento;
	}
	
	public static String formataHora(Calendar hora) {
		int h = hora.get(Calendar.HOUR_OF_DAY);
		int m = hora.get(Calendar.MINUTE);
		
		String r;
		
		if (h < 10 && m < 10)
			r = "0" + h + ":" + "0" + m;
		else if(h < 10)
			r = "0" + h + ":" + m;	
		else if (m < 10)
			r = h + ":" + "0" + m;
		else
			r = h + ":" + m;
		
		return r;
	}
	
	public static Calendar formataHora(String h) {
		Calendar hora = new GregorianCalendar();
		
		int hr = Integer.parseInt(h.substring(0, 2));
		int m = Integer.parseInt(h.substring(3, 5));
		
		if(hr >= 0 && hr <= 24 && m >= 0 && m <= 59) 
			hora.set(1, 1, 1, hr, m, 0);
		else hora = null;
		
		return hora;
		
	}
	
}
