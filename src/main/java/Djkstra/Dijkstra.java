package Djkstra;

import java.util.*;

public class Dijkstra {

    static class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int start) {
        int V = graph.size(); // Number of vertices

        // Initialize distance array and visited array
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        // Priority queue to store vertices based on their distance
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distance[a] - distance[b]);
        pq.offer(start);

        // Main Dijkstra's loop
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (Edge e : graph.get(u)) {
                int v = e.dest;
                int weight = e.weight;
                if (distance[v] > distance[u] + weight) {
                    distance[v] = distance[u] + weight;
                    pq.offer(v);
                }
            }
        }

        // Print the distances from start vertex to all other vertices
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + start + " to " + i + " is " + distance[i]);
        }
    }

    public static void main(String[] args) {
        // Example graph
        int V = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding edges to the graph
        graph.get(0).add(new Edge(1, 9));
        graph.get(0).add(new Edge(2, 6));
        graph.get(0).add(new Edge(3, 5));
        graph.get(0).add(new Edge(4, 3));
        graph.get(2).add(new Edge(1, 2));
        graph.get(2).add(new Edge(3, 4));

        // Calling Dijkstra's algorithm from vertex 0
        dijkstra(graph, 0);
    }
}

