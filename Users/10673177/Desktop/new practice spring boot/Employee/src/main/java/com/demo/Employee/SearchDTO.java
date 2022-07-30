package com.demo.Employee;

import java.time.LocalDate;
import java.util.Date;

public class SearchDTO {
	
	LocalDate startdate;
	
	LocalDate enddate;

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}
	
	
	

}
