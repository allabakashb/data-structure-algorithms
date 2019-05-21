package com.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GESortQuestion {

	public static void main(String[] args) {
		
		Map<String, Integer> names = new HashMap<String, Integer>();
        names.put("Anne", 10);
        names.put("John", 35);
        names.put("Bob", 2);
        Set<Entry<String, Integer>> set = names.entrySet();
		
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
          public int compare( Map.Entry<String, Integer> order1, Map.Entry<String, Integer> order2)
            {
                return (order2.getValue()).compareTo( order1.getValue() );
            }
        });
        for(Map.Entry<String, Integer> entry:list){
            System.out.print(" "+entry.getKey());
        }
	}
}
