package com.amazon.amcat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int p =  sc.nextInt();
		
		List<String> repo = new ArrayList<String>();

		for (int i = 0; i < p; i++) {
			
			repo.add(sc.next());
		}
		
		String query = sc.next();
		
		Problem1 p1 = new Problem1();
		List<List<String>> suggestionList = p1.threeProductSuggestions(p, repo, query);
		suggestionList.forEach(sugg -> {
			sugg.forEach(sug -> {
				
				System.out.print(sug + ", ");
			});
			System.out.println("");
		});
		
		sc.close();
	}

	List<List<String>> threeProductSuggestions(int numProducts, List<String> repository, 
			String customerQuery) {

		List<List<String>> suggestionList = new ArrayList<List<String>>();

		Collections.sort(repository);
		
		for (int i = 1; i < customerQuery.length(); i++) {
			
			List<String> suggestions = null;
			
			String query = customerQuery.substring(0, i+1);
			
			int count = 0, start = 0;
			for (int j = start; j < repository.size(); j++) {
				
				String product = repository.get(j);
				
				if (count < 3) {
					
					if (product.startsWith(query)) {
						
						if (suggestions == null) {
							
							suggestions = new ArrayList<String>();
						}
						suggestions.add(product);
						count++;
					} else if (query.compareTo(product) >= 0) {
						
						start = j + 1;
					} else {
						
						break;
					}
				} else {
					
					break;
				}
			}
			
			if (suggestions != null)
			suggestionList.add(suggestions);
		}
		
		return suggestionList;
	}

}
