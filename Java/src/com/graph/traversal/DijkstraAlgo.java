package com.graph.traversal;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

	public static void main(String[] args) {
		
		DijkstraAlgo dalg = new DijkstraAlgo();
		int nodes = 6;
		int[][] edges = new int[8][3];
		edges[0] = new int[]{0, 1, 5}; 
		edges[1] = new int[]{0, 2, 7}; 
		edges[2] = new int[]{1, 2, 1}; 
		edges[3] = new int[]{1, 3, 8}; 
		edges[4] = new int[]{2, 4, 3}; 
		edges[5] = new int[]{3, 4, 1}; 
		edges[6] = new int[]{3, 5, 1}; 
		edges[7] = new int[]{4, 5, 5}; 
		
		
		System.out.println(dalg.solve(Graph.createGraph(edges, nodes), nodes, nodes-1));
	}
	
	public int solve(Graph[] graph,int nodes, int dest) {
		
		int[] dist = new int[nodes];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[0] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]);
		boolean[] visited = new boolean[nodes];
		int[] prev = new int[nodes];
		
		pq.add(new int[] {0, 0});
		
		while (!pq.isEmpty()) {
			
			int[] node = pq.poll();
			
			if (!visited[node[0]]) {
			
				List<Edge> list = graph[node[0]].edges;
				visited[node[0]] = true;
				
				for (Edge edge: list) {
					
					if (edge.weight + node[1] < dist[edge.node]) {
						
						dist[edge.node] = edge.weight + node[1];
						pq.add(new int[] {edge.node, dist[edge.node]});
						prev[edge.node] = node[0];
					}
				}
			}
		}
		
		int n = dest;
		String path = ""+dest;
		while (prev[n] != 0) {
		
			path = prev[n] + " -> " + path;
			n = prev[n];
		}
		
		System.out.println("0 -> " + path);
		
		return dist[dest];
	}
}
