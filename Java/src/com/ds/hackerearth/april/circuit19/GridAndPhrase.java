package com.ds.hackerearth.april.circuit19;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GridAndPhrase {

	private static char[] PHRASE = { 's', 'a', 'b', 'a' };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] nXm = br.readLine().split(" ");
		int totalWords = Integer.parseInt(nXm[0]);
		int wLength = Integer.parseInt(nXm[1]);
		String[] words = new String[totalWords];
		for (int i = 0; i < totalWords; i++) {
			words[i] = br.readLine();
		}
		
		GridAndPhrase gp = new GridAndPhrase();
		
		int count = 0;
		
		for (int wIndex = 0; wIndex < totalWords; wIndex++) {
			
			boolean done = false;
			int startIndexForS = 0, startIndexForA = 0;
			while (!done) {
				
				int sIndex = words[wIndex].indexOf("s", startIndexForS);
				
				int aIndex = words[wIndex].indexOf("a", startIndexForA);
				
				if (sIndex > -1 || aIndex > -1) {
					
					//right
					if (sIndex > -1) {
						count += gp.getRightSideCount(words[wIndex], sIndex, wLength);
					}
					
					//right top to bottom diagonal, top to bottom, bottom to top diagonal
					count += gp.getCountForOtherDirections(words, sIndex, wLength, wIndex, totalWords, aIndex);
					
					if (sIndex > -1) {
						startIndexForS = sIndex + 1;
					}
					
					if (aIndex > -1) {
						startIndexForA = aIndex + 1;
					}
					
				} else {
					
					done = true;

				}
			}			
			
		}
		
		System.out.println(count);
	}
	
	
	public int getRightSideCount(String word, int index, int length) {
		
		int charIndex = 1, count = 0;
		
		index++;
		
		while (index < length && charIndex < PHRASE.length &&
				word.charAt(index) == PHRASE[charIndex]) {
			charIndex++;
			index++;
		}
		
		if (charIndex >= PHRASE.length) {
			count++;
		}
		
		return count;
	}
	
	public int getCountForOtherDirections(String[] words, int sIndex, int wLength, 
			int wIndex, int wordsCount, int aIndex) {
		
		int count = 0, origSIndex = sIndex;
		
		boolean bottomToTopDiagonal = false, topToBottom = false, topToBottomDiagonal = false;
		int btpDCount = 2, ttBCount = 1, ttBDCount = 1;
				
		if (sIndex < 0) {
			topToBottom = true;
			topToBottomDiagonal = true;
		}
		
		if (aIndex < 2) {
			bottomToTopDiagonal = true;
		}
		
		for(int j = wIndex + 1; j < wordsCount; j++) {
			
			if (!topToBottom || !topToBottomDiagonal) {

				if (!topToBottomDiagonal) {
					
					sIndex++;

					if (sIndex < wLength && words[j].charAt(sIndex) == PHRASE[ttBDCount]) {
						
						ttBDCount++;
						
						if (ttBDCount >= PHRASE.length) {
							count++;
							topToBottomDiagonal = true;
						}
						
					} else {
						
						topToBottomDiagonal = true;
					}
					
				}
				
				if (!topToBottom) {
					
					if (words[j].charAt(origSIndex) == PHRASE[ttBCount]) {
						ttBCount++;
						
						if (ttBCount >= PHRASE.length) {
							count++;
							topToBottom = true;
						}
						
					} else {
						
						topToBottom = true;
					}
				}
			}
			
			if (!bottomToTopDiagonal) {
				aIndex--;
				if (aIndex > -1 && words[j].charAt(aIndex) == PHRASE[btpDCount]) {
					
					btpDCount--;
					
					if (btpDCount < 0) {
						count++;
						bottomToTopDiagonal = true;
					}
					
				} else {
					bottomToTopDiagonal = true;
				}
			}
			
			
			if (topToBottomDiagonal && topToBottom && bottomToTopDiagonal) {
			
				break;
			}
		}
		
		return count;
	}
	
}


/*
 * 
 *  https://www.hackerearth.com/challenges/competitive/april-circuits-19/algorithm/jadvaliioo-62280ff6/
 * 
 * 
 */