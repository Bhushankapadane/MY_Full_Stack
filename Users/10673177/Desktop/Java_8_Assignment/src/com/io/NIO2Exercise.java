package com.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class NIO2Exercise {
	
	static ArrayList<Tablet> tablets = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		  tablets.add(new Tablet("Paracetamol", "Cipala", LocalDate.parse("06/06/2020", formatter),LocalDate.parse("07/03/2022", formatter))); 
		  tablets.add(new Tablet("dolo", "Nestle", LocalDate.parse("06/08/2020", formatter),LocalDate.parse("16/04/2023", formatter)));
		  tablets.add(new Tablet("Azithromycin", "Vlab",  LocalDate.parse("10/08/2022", formatter),LocalDate.parse("22/01/2021", formatter)));
		  
		  
		NIO2Exercise obj = new NIO2Exercise();
		
		obj.getJavaFileOnGivenPath("Country.java","C:\\Users\\10673177\\New_Training_bosch\\Java_8_Assignment\\src\\com\\java8\\collectors");
		obj.getAllJavaFiles();
	    obj.getExpiredTablets("C:\\Users\\10673177\\New_Training_bosch\\Java_8_Assignment\\src\\com\\io\\tablet.text","Cipala");
		
	}
	
	static void getAllJavaFiles() throws IOException {
		
		Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\10673177\\New_Training_bosch\\Java_8_Assignment\\src\\com\\java8\\collectors"));
		List<String> result = walk.map(x -> x.toString())
				.filter(f -> f.endsWith(".java")).collect(Collectors.toList());
		result.forEach(System.out::println);	
	}
		
	
	
	static void getJavaFileOnGivenPath(String fileName,String AbsolutePath) throws IOException{
		
      Stream<Path> walk = Files.walk(Paths.get(AbsolutePath));
		List<String> result1 = walk.map(x -> x.toString())
				.filter(f -> f.contains(fileName))
				.collect(Collectors.toList());
		result1.forEach(System.out::println);
		
	}
	
    static Tablet getFileData(String str) {
		
		String[] arr = str.split(",");
		Tablet tablet = null;
		String mDAte = arr[2];
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		  String date = arr[2];
		  LocalDate manufacturedgDate = LocalDate.parse(mDAte,formatter);
			
		LocalDate expairedDate = LocalDate.parse(arr[3],formatter);
		return tablet = new Tablet (arr[0],arr[1],manufacturedgDate,expairedDate);
		
	}
	
	static void getExpiredTablets(String filename, String manufacturer) {
		
		try {
				LocalDate date = LocalDate.now();
				Map<String, LocalDate> map = new HashMap<>(); 
				Stream<String> filedata = Files.newBufferedReader(Paths.get(filename)).lines();	    //open the file for reading
			
				map = filedata.map(NIO2Exercise::getFileData)      
					          .filter(i -> i.manufacturer.equals(manufacturer) && i.expirydate.isBefore(date))
					          .collect(Collectors.toMap(Tablet::getTabletname,Tablet::getExpirydate));
				System.out.print("map"+map);
						     
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
}
