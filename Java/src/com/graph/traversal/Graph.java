package com.graph.traversal;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	List<Edge> edges;
	
	Graph() {
		
		this.edges = new ArrayList<>();
	}
	
	public static Graph[] createGraph(int[][] edges, int nodes) {
		Graph[] graphs = new Graph[nodes];
		
		for (int i = 0; i < nodes; i++) {
			
			graphs[i] = new Graph();
		}
		
		for (int[] edge: edges) {
			
			graphs[edge[0]].edges.add(new Edge(edge[1], edge[2]));
			graphs[edge[1]].edges.add(new Edge(edge[0], edge[2]));
		}
		
		return graphs;
	}
}
