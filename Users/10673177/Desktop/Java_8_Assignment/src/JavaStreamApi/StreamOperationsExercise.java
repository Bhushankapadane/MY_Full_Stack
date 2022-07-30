package JavaStreamApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperationsExercise {

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

	static void dispalyPlayer() {
		// createPlayer().forEach(a -> System.out.println(a.getPlayerName()));

		createPlayer().stream().map(a -> a.getPlayerName()).forEach(System.out::println);

	}

	// Display the name of players whose highest score is more than 100 and belong
	// to a particular country
	static void displayPlayerUsingCountry(String country) {
		createPlayer().stream()
				.filter(c -> c.getCountry().getCountry_Name().equals(country) && c.getHighestScore() > 100)
				.map(Player::getPlayerName).forEach(System.out::println);

	}

	// Return a LinkedList containing names of all Players, whose have scored more
	// than 5000 runs, sorted in descending order of names
	static LinkedList<String> getPlayerNames_Sorting() {

		LinkedList<String> Plist = createPlayer().stream().filter(sc -> sc.getHighestScore() > 100)
				.map(name -> name.getPlayerName()).sorted(Comparator.reverseOrder())
				.collect(Collectors.toCollection(LinkedList::new));

		return Plist;

	}

//	Return the player who has scored maximum runs
	static void getMaxRunsPlayer() {
		Optional<Player> maxruns = createPlayer().stream()
				.collect(Collectors.maxBy(Comparator.comparingInt(Player::getRuns)));
		if (maxruns.isPresent()) {
			System.out.println("playermaxruns " + maxruns.get());

		} else {
			System.out.println("false");
		}
	}

	// Return the average runs scored by players from a particular Country
	public static double getAverageRunsByCountry(String country) {
		System.out.println("--- Display Average Runs ---");
		IntSummaryStatistics avgRuns = createPlayer().stream()
				.filter(d -> d.getCountry().getCountry_Name().equals(country)).mapToInt(Player::getRuns)
				.summaryStatistics();
		return avgRuns.getAverage();
	}

	/*
	 * static void getAverageRunsByCountry(String country){ Double
	 * aa=createPlayer().stream().filter(o-> o.getCountry().getCountry_Name() ==
	 * country).collect(Collectors.averagingDouble(Player::getRuns));
	 * System.out.println(aa); }
	 */

	// Return a list with names of Players sorted as per country and then by
	// matchesPlayed(descending)
	public static  void getPlayerNamesSorted() {
		Comparator<Player> fc=(p1,p2)->p1.getCountry().getCountry_Name().compareTo(p2.getCountry().getCountry_Name());
		Comparator<Player> sc=Comparator.comparing(Player::getMatchesPlayed).reversed();
		createPlayer().stream().sorted(fc.thenComparing(sc)).map(p->p.getPlayerName())
		.collect(Collectors.toList()).forEach(System.out::println);
		
		
		

//		System.out.println("--- Sorted Players ---");
//		List<List<String>> sortedPlayers = new LinkedList<>();
//		List<String> players = new ArrayList<>();
//
//		players = createPlayer().stream()
//				.sorted((a, b) -> a.getCountry().getCountry_Name().compareTo(b.getCountry().getCountry_Name()))
//				.map(d -> d.getPlayerName()).collect(Collectors.toList());
//		sortedPlayers.add(players);
//
//		players = createPlayer().stream()
//				.sorted((a, b) -> b.getMatchesPlayed() > a.getMatchesPlayed() ? 1
//						: b.getMatchesPlayed() < a.getMatchesPlayed() ? -1 : 0)
//				.map(d -> d.getPlayerName()).collect(Collectors.toList());
//		sortedPlayers.add(players);
//
//		return sortedPlayers;
	}

	static void findPlayer(String name, String country) {
	createPlayer().stream()
				.filter(a -> a.getCountry().getCountry_Name().equalsIgnoreCase(country)
						&& a.getPlayerName().equalsIgnoreCase(name))
				.collect(Collectors.toList()).forEach(a->System.out.println(a.getPlayerName()));
	}

	
	static void ischeckHighScorerByCountry(String country) {
		boolean b = createPlayer().stream().filter(a -> a.getRuns() >= 10000)
				.anyMatch(a -> a.getCountry().getCountry_Name().equalsIgnoreCase(country));
		System.out.println(b);

	}

	public static void main(String[] args) {
//		 
		  dispalyPlayer();
//
//		  
		  displayPlayerUsingCountry("india");
//
//		  
//
		  getPlayerNamesSorted();
//		;
//
//		 
//
		// System.out.println(getPlayerNames_Sorting());
//
//	      
//
//		  getMaxRunsPlayer();
//		
//		 
//		
//		  getAverageRunsByCountry("Pak");
//
//		  
//
//
//		  
		findPlayer("Virat Kohli", "India");
//		
//		  
//
//		  ischeckHighScorerByCountry("SA");

	}

}
