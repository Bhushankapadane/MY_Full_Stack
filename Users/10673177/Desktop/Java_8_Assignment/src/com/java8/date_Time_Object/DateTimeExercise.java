package com.java8.date_Time_Object;



import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;



/*bhushan*/
public class DateTimeExercise {
	
	private List<Tablet> tablets = new ArrayList<Tablet>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add(new Tablet("Calebrex", "cipala", LocalDate.parse("2018-05-13"), LocalDate.parse("2022-06-30")));
			add(new Tablet("Cipro", "bharat boitech",LocalDate.parse("2020-02-25"), LocalDate.parse("2022-05-15")));
			add(new Tablet("colasi", "Medicare Remedies Private Limited", LocalDate.parse("2021-08-19"), LocalDate.parse("2022-08-26")));
			add(new Tablet("Thiocolchiciside IP", "sunfarma", LocalDate.parse("2019-05-05"), LocalDate.parse("2023-05-06")));
			add(new Tablet("Paracetamol", "lupin", LocalDate.parse("2019-05-05"), LocalDate.parse("2022-05-06")));
			add(new Tablet("Dolo 650", "Talent Health Care", LocalDate.parse("2022-01-05"), LocalDate.parse("2022-02-06")));
			add(new Tablet("Amalong", "Bluewaterresearch", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-02-20")));
		}
	};
	
	
	//operational methods
	
	private List<String> getExpiringTablets(int months) {
		LocalDate today = LocalDate.now();
		List<String> tabletNames = new ArrayList<String>();
		BiConsumer<LocalDate,List<Tablet>> exptablets = (a,b) -> b.forEach(c -> {
			if(a.until(c.getExpiryDate(),ChronoUnit.MONTHS)<=months) {
				tabletNames.add(c.getTabletName());
			}
		});
		
		exptablets.accept(today, tablets);
		return tabletNames;
	}
	
	
	
	
	
	
	private List<Tablet> getExpiringTabletsSorted () {
		Comparator<Tablet> sortTablets = (a,b) -> a.getExpiryDate().compareTo(b.getExpiryDate());
		tablets.sort(sortTablets);
		return tablets;
	}
	
	
	
	
	
	
	private Map<String,String> getTabletExpiryPeriod () {
		Map<String,String> tabletMap = new HashMap<String,String>(); 
		tablets.forEach(c -> {
				Period p = Period.between(c.getManufactureDate(), c.getExpiryDate());
				tabletMap.put(c.getTabletName(),p.getYears() + "year/s " + p.getMonths()+"month/s "+p.getDays()+"day/s");
		});
				
		return tabletMap;
	}
	
	
	
	
	
	private Map<String,List<String>> getSameYearExpiry () {
		Map<String,List<String>> sameYearExpMap = new HashMap<String,List<String>>(); 
		LocalDate today = LocalDate.now();
		int currentYear = today.getYear();
		
       
		
		tablets.forEach(c -> {
			List<String> tabName = new ArrayList<String>();
			if((c.getManufactureDate().getYear() == currentYear) && c.getExpiryDate().compareTo(today)<0) {
				
				sameYearExpMap.put(c.getManufacturer(), tabName);
			}
		});

		return sameYearExpMap;
	}
	
	
	
	//call all operational method
	

	public static void main(String[] args) {
	
		DateTimeExercise dt=new DateTimeExercise();
//		
//		System.out.println(dt.getExpiringTablets(3));
//		
//		dt.getExpiringTabletsSorted();
//		dt.tablets.forEach(System.out::println);
//		
//		System.out.println(dt.getTabletExpiryPeriod());
		System.out.println(dt.getSameYearExpiry());
	}

}
