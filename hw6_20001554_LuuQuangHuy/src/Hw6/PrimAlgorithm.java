package Hw6;

import java.util.*;

public class PrimAlgorithm {

    public static List<Edge> primMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        visited.add(0); // start with the first vertex
        minHeap.addAll(graph.edges.get(0)); // add all edges of the first vertex to the heap

        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int u = edge.source;
            int v = edge.dest;

            // check if the edge connects an already visited vertex to an unvisited one
            if (visited.contains(u) && !visited.contains(v)) {
                mst.add(edge);
                visited.add(v);
                minHeap.addAll(graph.edges.get(v));
            } else if (visited.contains(v) && !visited.contains(u)) {
                mst.add(edge);
                visited.add(u);
                minHeap.addAll(graph.edges.get(u));
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices
        int E = 7; // number of edges
        Graph graph = new Graph(V, E);

        // measure the time it takes to run the algorithm
        long startTime = System.nanoTime();
        List<Edge> mst = primMST(graph);
        long endTime = System.nanoTime();

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.source + " - " + edge.dest + " : " + edge.weight);
        }

        long duration = (endTime - startTime) / 1000; // convert nanoseconds to microseconds
        System.out.println("Running time: " + duration + " microseconds");
    }

    static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V;
        List<List<Edge>> edges;

        public Graph(int V, int E) {
            this.V = V;
            this.edges = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                this.edges.add(new ArrayList<>());
            }

            Random random = new Random();
            int count = 0;
            while (count < E) {
                int u = random.nextInt(V);
                int v = random.nextInt(V);
                if (u != v) {
                    int weight = random.nextInt(10) + 1; // generate a random weight between 1 and 10
                    Edge edge = new Edge(u, v, weight);
                    if (!edges.get(u).contains(edge)) {
                        edges.get(u).add(edge);
                        edges.get(v).add(new Edge(v, u, weight)); // add the edge in both directions
                        count++;
                    }
                }
            }
        }
    }
}

