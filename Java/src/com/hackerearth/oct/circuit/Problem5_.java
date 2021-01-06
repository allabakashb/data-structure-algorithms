package com.hackerearth.oct.circuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5_ {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {

			int n = Integer.parseInt(br.readLine());

			String line = br.readLine();
			String[] A = line.split(" ");

			int counter = 0;

			for (int i = 0; i < n; i++) {

				int Ai = Integer.parseInt(A[i]);

				int k = Ai - 1;

				if ((k ^ Ai) == 1) {

					counter++;
				}

			}

			System.out.println(counter);
			t--;
		}
	}
}
