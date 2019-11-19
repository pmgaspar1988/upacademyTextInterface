package desafio5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Desafio {

	public static int countDays(String string, String string2) {
		// TODO Auto-generated method stub

		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = string;
		String inputString2 = string2;
int days=0;
		try {
		    Date date1 = myFormat.parse(inputString1);
		    Date date2 = myFormat.parse(inputString2);
		    long diff = date2.getTime() - date1.getTime();
		    days += TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		
		return days;
		
		
	}
}
