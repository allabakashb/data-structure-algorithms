package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Problem1376 {

class Node {
        
        int id;
        int time;
        List<Node> reportees;
        
        Node(int id, int time) {
           
            this.time = time;
            this.id = id;
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
                
        Map<Integer, Node> map = new HashMap<>();
        
        Node root = new Node(headID, informTime[headID]);
        map.put(headID, root);
        
        for (int i = 0; i < manager.length; i++) {
            
            if (i == headID) continue;
            
            Node curr = map.getOrDefault(i, new Node(i, informTime[i]));
                        
            Node mnger = map.get(manager[i]);
                
            if (mnger == null) {

                mnger = new Node(manager[i], informTime[manager[i]]);
                map.put(manager[i], mnger);
            }
            
            if (mnger.reportees == null) {

                mnger.reportees = new ArrayList<>();
            }
            
            mnger.reportees.add(curr);
            
            map.put(i, curr);
        }
        
        int time = 0;
        
        Stack<Node> st = new Stack<>();
        st.push(root);
        
        while (!st.isEmpty()) {
                        
            Node node = st.pop();
            
            if (node.reportees != null) {
                
                time += root.time;

                for (Node nd: node.reportees) {
                    
                    st.push(nd);
                }
            }
        }
        
        return time;
    }
    
	public static void main(String[] args) {
		int n = 7;
		int headID = 6;
		int[] manager = {1,2,3,4,5,6,-1};
		int[] informTime = {0,6,5,4,3,2,1};
		System.out.println(new Problem1376().numOfMinutes(n, headID, manager, informTime));
	}

}
