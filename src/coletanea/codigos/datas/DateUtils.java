package coletanea.codigos.datas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtils {

	  public enum IntervalType {  Month, Week  }
	  
	  private DateUtils() {  }

	  public static Calendar[] getDateIntervals(IntervalType type, Calendar reference) {
	    if (reference == null) {
	      reference = Calendar.getInstance();
	    }
	    Calendar startDate = (Calendar)reference.clone();
	    Calendar endDate = (Calendar)reference.clone();

	    if (type == IntervalType.Month) {
	      // first date of the month
	      startDate.set(Calendar.DATE, 1);
	      // previous month
	      startDate.add(Calendar.MONTH, -1);

	      // first date of the month
	      endDate.set(Calendar.DATE, 1);
	      // previous month, last date
	      endDate.add(Calendar.DATE, -1);
	    }
	    else {
	      // previous week by convention (monday ... sunday)
	      // you will have to adjust this a bit if you want
	      // sunday to be considered as the first day of the week.
	      //   start date : decrement until first sunday then 
	      //   down to monday  
	      int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
	      while (dayOfWeek  != Calendar.SUNDAY) {
	        startDate.add(Calendar.DATE, -1);
	        dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
	      }
	      while (dayOfWeek != Calendar.MONDAY) {
	        startDate.add(Calendar.DATE, -1);
	        dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
	      }

	      // end date , decrement until the first sunday
	      dayOfWeek = endDate.get(Calendar.DAY_OF_WEEK);
	      while (dayOfWeek  != Calendar.SUNDAY) {
	        endDate.add(Calendar.DATE, -1);
	        dayOfWeek = endDate.get(Calendar.DAY_OF_WEEK);
	      }
	    }
	    return new Calendar[] { startDate, endDate }; 
	  }

	  public static void main(String[] args) {
	    try {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	      System.out.println("** previous month (relative today)");
	      Calendar [] results = DateUtils.getDateIntervals(IntervalType.Month, null);
	      System.out.println(sdf.format(results[0].getTime()));
	      System.out.println(sdf.format(results[1].getTime()));
	      
	      System.out.println("** previous week (relative today)");
	      results = DateUtils.getDateIntervals(IntervalType.Week, null);
	      System.out.println(sdf.format(results[0].getTime()));
	      System.out.println(sdf.format(results[1].getTime()));

	      System.out.println("** previous month (relative jan 1, 2007)");
	      results = DateUtils.getDateIntervals(IntervalType.Month, 
	        new GregorianCalendar(2007, 00, 1));
	      System.out.println(sdf.format(results[0].getTime()));
	      System.out.println(sdf.format(results[1].getTime()));
	      
	      System.out.println("** previous week (relative jan 1, 2007)");
	      results = DateUtils.getDateIntervals(IntervalType.Week, 
	        new GregorianCalendar(2007, 00, 1));
	      System.out.println(sdf.format(results[0].getTime()));
	      System.out.println(sdf.format(results[1].getTime()));

	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	  }
	  /*
	    output :
	    ** previous month (relative today)
	    2008-06-01
	    2008-06-30
	    ** previous week (relative today)
	    2008-06-30
	    2008-07-06
	    ** previous month (relative jan 1, 2007)
	    2006-12-01
	    2006-12-31
	    ** previous week (relative jan 1, 2007)
	    2006-12-25
	    2006-12-31
	  */  
	}