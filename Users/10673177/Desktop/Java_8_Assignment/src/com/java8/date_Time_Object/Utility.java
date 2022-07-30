package com.java8.date_Time_Object;


	
	import java.time.DateTimeException;
	import java.time.Duration;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import java.util.List;

	public class Utility {
		
		private List<String> getBusSchedule(String start, Duration frequency) {
			List<String> busSchedule = new ArrayList<String>();
			try {
				LocalDateTime startDate= LocalDateTime.parse(start);
				LocalDateTime ldt = LocalDateTime.parse(start);
				while(ldt.getHour()<24 && (ldt.getDayOfMonth()==startDate.getDayOfMonth())) {
					ldt = ldt.plusSeconds(frequency.getSeconds());
					if(ldt.getDayOfMonth()==startDate.getDayOfMonth()) {
						busSchedule.add(ldt.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
					}
				}
			}
			catch(DateTimeException e) {
				System.out.println("Invalid Format : " + e.getMessage());
			}
			
			return busSchedule;
		}
		
		public static void main(String[] args) {
			
			Utility ul = new Utility();
			
			List<String> busTimings = ul.getBusSchedule("2022-02-27T09:45:00", Duration.ofHours(1));
			busTimings.forEach(System.out::println);
			
		}

}
