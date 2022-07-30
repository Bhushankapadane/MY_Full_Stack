package com.java8.date_Time_Object;
//Pattern	Example
//MM-dd-yyyy	01-31-2012
//yyyy-MM-dd	2012-01-31
//yyyy-MM-dd HH:mm:ss	2012-01-31 23:59:59
//yyyy-MM-dd HH:mm:ss.SSS	2012-01-31 23:59:59.999
import java.time.DateTimeException;//mmm -apr abbreviation//   mm get like int//mmmm april
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class BankDepositExercise {

	private String getMaturityDate(String investmentDate, Period duration) {
		String maturityDate = new String();
		try {
			LocalDate startDate = LocalDate.parse(investmentDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			LocalDate finalDate = startDate.plusDays(duration.getDays()).plusMonths(duration.getMonths()).plusYears(duration.getYears());
			maturityDate = finalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		} catch (DateTimeException e) {
			System.out.println(" Date Format Not Correct: " + e.getMessage());
		}
		return maturityDate;
	}

	private String getInvestmentPeriod(String investmentDate, String maturityDate) {
		Period period = Period.of(0, 0, 0);
		try {
			LocalDate startDate = LocalDate.parse(investmentDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			LocalDate endDate = LocalDate.parse(maturityDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			period = startDate.until(endDate);                                                                                 //between //check period between 
		} catch (DateTimeException e) {
			System.out.println("Invalid Date Format: " + e.getMessage());
		}
		return "a=  " + period.getYears() + " years  b= " + period.getMonths() + " months - c= " + period.getDays()
				+ " days";
	}

	public static void main(String[] args) {

		BankDepositExercise bankDep = new BankDepositExercise();

		System.out.println(bankDep.getMaturityDate("11-04-1997", Period.of(20, 8, 12)));                             //y-m-d
		System.out.println(bankDep.getInvestmentPeriod("11-07-1997", "25-05-2022"));
	}

}
