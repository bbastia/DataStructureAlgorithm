package org.example.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int V; //no of vertices

    private LinkedList<Integer>[] adj;  //Adj list

    Graph(int V){
        this.V = V;
        adj = new LinkedList[V];

        for(int i=0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void BFS(int s){
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()){
            int edge = queue.poll();
            System.out.println(edge);

            for (int node : adj[edge]) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

    }

    public void DFS(int edge){

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(edge);

        while (!stack.isEmpty()){
            int node = stack.pop();
            visited[node] = true;
            System.out.println(node);

            for(int v :adj[node]){
                if(!visited[v]){
                    stack.push(v);
                }
            }
        }


    }

    public static void main(String[] args) {
        Graph graph = new Graph(7 );
        graph.addEdge(0,2);
        graph.addEdge(2,0);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.DFS(0);
    }

}
