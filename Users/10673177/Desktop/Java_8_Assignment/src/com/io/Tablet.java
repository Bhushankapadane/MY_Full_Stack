package com.io;

import java.time.LocalDate;


	public class Tablet {
		
		String tabletname;
		String manufacturer;
		LocalDate manufacturedate; 
		LocalDate expirydate;
		
		public Tablet(String tabletname, String manufacturer, LocalDate manufacturedate,LocalDate expirydate) {
		    this.tabletname = tabletname;
		    this.manufacturer = manufacturer;
		    this.manufacturedate = manufacturedate;
		    this.expirydate = expirydate;
		}

		public String getTabletname() {
			return tabletname;
		}

		public void setTabletname(String tabletname) {
			this.tabletname = tabletname;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}

		public LocalDate getManufacturedate() {
			return manufacturedate;
		}

		public void setManufacturedate(LocalDate manufacturedate) {
			this.manufacturedate = manufacturedate;
		}

		public LocalDate getExpirydate() {
			return expirydate;
		}

		public void setExpirydate(LocalDate expirydate) {
			this.expirydate = expirydate;
		}

		@Override
		public String toString() {
			return "Tablet [tabletname=" + tabletname + ", manufacturer=" + manufacturer + ", manufacturedate="
					+ manufacturedate + ", expirydate=" + expirydate + "]";
		}
		
		

	}



