package j8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;

/*
No more duplicate class
e.g. java.util.Date and java.sql.Date
access now are synchronized as opposed to earlier
Clean and clear separation of package
*/
public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);

		LocalTime time = LocalTime.now();
		System.out.println(time);

		LocalDate date = LocalDate.of(2021, Month.NOVEMBER, 13);
		System.out.println(date);
		
		System.out.println("MIN -> " + LocalDate.MIN);
		System.out.println("MAX -> " + LocalDate.MAX);
		
		//difference
		Long diff = currentDate.until(date, java.time.temporal.ChronoUnit.DAYS);
		System.out.println("Diff in days ->"+ diff);
		
		Period daysToGo = Period.between(currentDate,date);
		System.out.println(daysToGo);
		int years = daysToGo.getYears(); int months = daysToGo.getMonths(); int days = daysToGo.getDays();
        System.out.println("number of years: " + years);
        System.out.println("number of months: " + months);
        System.out.println("number of days: " + days);     
        
        
        long totalDays = java.time.temporal.ChronoUnit.DAYS.between(currentDate, date);
        System.out.println("TotalDays -> " + totalDays);
        
        
        
	}

}
