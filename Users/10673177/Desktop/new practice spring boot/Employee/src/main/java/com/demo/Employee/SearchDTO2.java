package com.demo.Employee;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchDTO2 {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
		Date startdate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
		Date enddate;

		public Date getStartdate() {
			return startdate;
		}

		public void setStartdate(Date startdate) {
			this.startdate = startdate;
		}

		public Date getEnddate() {
			return enddate;
		}

		public void setEnddate(Date enddate) {
			this.enddate = enddate;
		}
}
