package coletanea.codigos.datas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UsandoDatas {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Calendar data = Calendar.getInstance();
		Date date = data.getTime();
				
		Locale brasil = new Locale("pt", "BR");
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(date));
		
		
		Calendar c = Calendar.getInstance();
		c.set(2013, Calendar.FEBRUARY, 28);
		Date data2 = c.getTime();
		System.out.println("Data atual sem formatação: "+data2);
		
		//Formata a data
		DateFormat formataData = DateFormat.getDateInstance();
		System.out.println("Data atual com formatação: "+ formataData.format(data2));
		
		//Formata Hora
		DateFormat hora = DateFormat.getTimeInstance();
		System.out.println("Hora formatada: "+hora.format(data2));

		//Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		System.out.println(dtHora.format(data2));
	}
}
