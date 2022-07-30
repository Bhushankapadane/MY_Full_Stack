package com.java8.collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamCollectorsExercise {
	public static List<Player> playerList;
	
	public StreamCollectorsExercise () {
		Country country1 = new Country(1,"India");
		Country country2 = new Country(2,"Australia");
		Country country3 = new Country(3,"England");
		Country country4 = new Country(4,"New Zealand");
		playerList = new ArrayList<Player>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
					add(new Player("Suresh Raina",200,5200,150,country1));
					add(new Player("Virat Kohli",150,4300,80,country1));
					add(new Player("MS Dhoni",300,6000,183,country1));
					add(new Player("Sachin",1000,15000,200,country1));
					add(new Player("Steve Smith",120,3200,120,country2));
					add(new Player("David Warner",180,5350,160,country2));
					add(new Player("Ben Stokes",270,2700,184,country3));
					add(new Player("Kane Williamson",140,1600,130,country4));
			}
		};
	}
	
	
	public Map<String,List<Player>> getPlayersByCountry() {
		System.out.println("--- Get List of Players by Country");
		Map<String,List<Player>> getPlayerMap= playerList.stream()
				.collect(Collectors.groupingBy(p-> p.getCountry().getCountryName(),Collectors.toList()));
		return getPlayerMap;// gb return group of operation
	}
	
	public Map<String,List<String>> getPlayerNamesByCountry() {
		System.out.println("--- Get List of Player names by Country played matches > 100 ---");
		
		Map<String,List<String>> getPlayerMap = playerList.stream().filter(d-> d.getMatchesPlayed()>100)
				.collect(Collectors.groupingBy(p->p.getCountry().getCountryName(),Collectors.mapping(Player::getPlayerName, Collectors.toList())));
		
		return getPlayerMap;
	}
	
	public Map<String, Long> getTotalPlayersByCountry() {
		System.out.println("--- Total Players Count of Country ---");
		Map<String, Long> getPlayerMap = playerList.stream()
		.collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),Collectors.counting() ));
		return getPlayerMap;
	}
	
//	public Map<String, Long> getTotalPlayersByCountrys() {
//		System.out.println("--- Total Players Count of Country ---");
//		Map<String, Long> getPlayerMap = playerList.stream()
//		.collect(LinkedHashMap :: new, (map, item) -> map.put(playerList.stream().collect(Collectors.groupingBy(p -> p.getCountry().getCountryName())), playerList.stream().collect(Collectors.counting())),
//		Map:: putAll));
//		return getPlayerMap;
//	}
//	
	public Map<String, Integer> getTotalRunsByCountry() {
		System.out.println("--- Total Runs of Country ---");
		 Map<String, Integer> getPlayerMap = playerList.stream()
		.collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),Collectors.summingInt(Player::getRuns)));
		return getPlayerMap;
	}
	
	public Map<String, Integer> getMaxScoreByCountry() {
		System.out.println("--- Max Score of Country ---");
		Map<String, Integer> getPlayerMap = new HashMap<String, Integer>();
		playerList.stream()
		.collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),
				Collectors.maxBy(Comparator.comparingInt(Player::getHighestScore))))
		.entrySet().forEach(p-> getPlayerMap.put(p.getKey(), p.getValue().get().getHighestScore()));
		 
		return getPlayerMap;
	}
	
	public Map<String, String> getPlayerNamesStringByCountry() {
		System.out.println("--- Total Players Names of Country ---");
		 Map<String, String> getPlayerMap = playerList.stream()
		.collect(Collectors.groupingBy(p -> p.getCountry().getCountryName(),Collectors.mapping(Player::getPlayerName, Collectors.joining(","))));
		return getPlayerMap;
	}
	

	public static void main(String[] args) {
		
		StreamCollectorsExercise collectorExercise = new StreamCollectorsExercise();
		collectorExercise.getPlayersByCountry().entrySet().forEach(System.out::println);
		//collectorExercise.getPlayerNamesByCountry().entrySet().forEach(System.out::println);
		//collectorExercise.getTotalPlayersByCountry().entrySet().forEach(System.out::println);
		//collectorExercise.getTotalRunsByCountry().entrySet().forEach(System.out::println);
		//collectorExercise.getMaxScoreByCountry().entrySet().forEach(System.out::println);
		//collectorExercise.getPlayerNamesStringByCountry().entrySet().forEach(System.out::println);
	}

}

