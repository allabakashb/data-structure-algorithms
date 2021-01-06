package com.hackerrank.visa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;


/*
 * Create the Filter and Mapper classes here.
 */
class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;
    
    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }
    
    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

class Filter {

	public static Predicate<? super String> nameStartingWithPrefix(String nextLine) {
		
		return new Predicate<String>() {

			@Override
			public boolean test(String t) {
				
				return t.startsWith(nextLine);
			}
		};
	}
	
}

class Mapper {

	public static Function<String, CharactersCount> getDistinctCharactersCount() {
		
		return new Function<String, CharactersCount>() {

			@Override
			public CharactersCount apply(String t) {
				
				Set<Character> set = new HashSet<Character>();
				
				char[] array = t.toCharArray();
				
				for (char ch: array) {
					
					set.add(ch);
				}
				
				return new CharactersCount(t, set.size());
			}

		};
	}


	
}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );
        
        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }
}