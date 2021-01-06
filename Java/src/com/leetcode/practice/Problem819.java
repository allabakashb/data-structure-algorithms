package com.leetcode.practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Problem819 {

	public String mostCommonWord(String paragraph, String[] banned) {

		Map<String, Integer> map = new HashMap<>();

		for (String str : banned) {

			map.put(str, -1);
		}

		int max = 0, start = 0, end = 0;
		String st = "";
		for (int i = 0; i < paragraph.length(); i++) {

			if (paragraph.charAt(i) != ' ' && paragraph.charAt(i) != ',' && paragraph.charAt(i) != '.') {

				end++;
				continue;
			}

			if ((end - start) < 2) {

				start = ++end;
				continue;
			}

			String str = paragraph.substring(start, end).toLowerCase();

			start = ++end;
			Integer count = map.get(str);

			if (count == null) {

				count = 1;
			} else if (count != -1) {

				++count;
			}

			if (max < count) {

				max = count;
				st = str;
			}

			map.put(str, count);
		}
		
		return st.isEmpty() ? paragraph.substring(0, end-1).toLowerCase() : st;
	}

	public static void main(String[] args) {
		
		Problem819 pb = new Problem819();
		System.out.println(pb.mostCommonWord("B.", new String[]{"hit"}));
		
		new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return new Integer(Math.abs(o1)).compareTo(new Integer(o2)) ;
			}
		};
	}

}
