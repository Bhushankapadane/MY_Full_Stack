package com.java8.collectors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

    

	public class SpecialStreamExercise1 {
		
		public static LinkedList<Integer> getSquaresOfThree() {
			System.out.println("--- Get Squares of Three ---");
			IntStream numStream = IntStream.range(21, 51);
			LinkedList<Integer> numbers = numStream.filter(i-> i%3==0 && i%2!=0)
					.map(j-> j*j)
					.boxed()   //converts to Stream<Integer>
					.collect(Collectors.toCollection(LinkedList::new));
			return numbers;
		}
		
		public static Integer[] getMultiplesOfFive() {
			System.out.println("--- Get Multiples of Five ---");
			Integer[] arr = Stream.iterate(1, i -> i + 1).filter(j-> j%5==0).limit(20).toArray(Integer[]::new);
			return arr;
		}
		
		public static void main(String[] args) {
			
			SpecialStreamExercise1.getSquaresOfThree().forEach(System.out::println);
			Arrays.stream(SpecialStreamExercise1.getMultiplesOfFive()).forEach(System.out::println);
		}

	}


