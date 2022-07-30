package com.java8.collectors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import JavaStreamApi.Country;
import JavaStreamApi.Player;

public class StremCollectorDemo2 {
	
	public static List<Player> createPlayer() {

		List<Player> Playerlist = new LinkedList<>();

		Country country1 = new Country(1, "India");
		Country country2 = new Country(2, "Pak");
		Country country3 = new Country(3, "SA");
		Country country4 = new Country(4, "Australia");
		Country country5 = new Country(5, "England");
		Country country6 = new Country(6, "Hundustan");
		Country country7 = new Country(7, "Bharat");
		Country country8 = new Country(8, "Mycountry");

		Playerlist.add(new Player("Virat Kohli", 100, 20000, 100, country1));
		Playerlist.add(new Player("Babar Azam", 73, 4500, 200, country2));
		Playerlist.add(new Player("Hashim Amala", 85, 9000, 170, country3));
		Playerlist.add(new Player("Devid Warner", 105, 4000, 183, country4));
		Playerlist.add(new Player("joe Root", 95, 15000, 191, country5));
		Playerlist.add(new Player("Bhushan", 50, 2000, 100, country6));
		Playerlist.add(new Player("Yogesh", 45, 3000, 50, country7));
		Playerlist.add(new Player("Mohit", 20, 100, 6766, country8));

		return Playerlist;
	}

	public Map<String, List<Player>> getPlayersByCountry() {
		System.out.println("--- Get List of Players by Country");
		
		Map<String, List<Player>>	lp=  createPlayer().stream().collect(Collectors
		.groupingBy(c-> c.getCountry().getCountry_Name(),Collectors.toList()));
//				.collect(Collectors.groupingBy(p-> p.getCountry().getCountry_Name(),Collectors.toList()));
	return lp;// gb return group of operation
	}
	
}
