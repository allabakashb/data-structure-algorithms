package com.june2020.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicates {

	public String removeDuplicateLetters(String text) {
		int[] lastSeen = buildLastSeenArray(text);
		Stack<Character> stack = fillResultStack(lastSeen, text);
		return convertStackToString(stack);
	}

	private int[] buildLastSeenArray(String text) {
		int n = text.length();
		int[] lastSeen = new int[26];

		for (int i = 0; i < n; i++) {
			lastSeen[text.charAt(i) - 'a'] = i;
		}

		return lastSeen;
	}

	private Stack<Character> fillResultStack(int[] lastSeen, String text) {
		int n = text.length();
		Set<Character> used = new HashSet<>();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			char current = text.charAt(i);

			if (used.contains(current))
				continue;

			while (!stack.isEmpty() && stack.peek() > current && lastSeen[stack.peek() - 'a'] > i) {
				used.remove(stack.pop());
			}

			used.add(current);
			stack.push(current);
		}

		return stack;
	}

	private String convertStackToString(Stack<Character> stack) {
		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}

		return builder.reverse().toString();
	}

	public static void main(String[] args) {

		new RemoveDuplicates().removeDuplicateLetters("bcabc");
	}
}
