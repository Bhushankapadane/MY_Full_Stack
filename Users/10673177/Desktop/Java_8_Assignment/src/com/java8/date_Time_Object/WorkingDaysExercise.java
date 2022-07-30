package com.java8.date_Time_Object;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class WorkingDaysExercise {
	private List<String> getNextMonthsWorkingDays() {
		LocalDate today = LocalDate.now();

		LocalDate nextMonthDate = today.withMonth(today.getMonthValue() + 1);
		LocalDate startDate = nextMonthDate.with(TemporalAdjusters.firstDayOfMonth()); //first date ofmonth
		LocalDate endDate = nextMonthDate.with(TemporalAdjusters.lastDayOfMonth());   //last day of month
		List<String> workingDays = new ArrayList<String>();
		while (startDate.compareTo(endDate) <= 0) {
			if ((startDate.getDayOfWeek() != DayOfWeek.SATURDAY) && (startDate.getDayOfWeek() != DayOfWeek.SUNDAY)) {
				workingDays.add(startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			}
			startDate = startDate.plusDays(1);  //plus one day
		}

		return workingDays;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkingDaysExercise wd = new WorkingDaysExercise();
		List<String> workingDays = wd.getNextMonthsWorkingDays();
		workingDays.forEach(System.out::println);
	}

}
