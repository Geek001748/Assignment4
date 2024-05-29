import Edge.*;
import Vertex.Vertex;
import Vertex.VWeightedGraph;
import Vertex.VDijkstraSearch;
import Vertex.VDepthFirstSearch;
import Vertex.VBreadthFirstSearch;
import Vertex.VSearch;

import java.util.Scanner;

public class Main {
        static Vertex<String> Almaty = new Vertex<>("Almaty");
        static Vertex<String> Shymkent = new Vertex<>("Shymkent");
        static Vertex<String> Atyrau  = new Vertex<>("Atyrau");
        static Vertex<String> Astana = new Vertex<>("Astana");
        static Vertex<String> Kostanay = new Vertex<>("Kostanay");
        static Vertex<String> Kyzylorda = new Vertex<>("Kyzylorda");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        int choice;
        do {
            System.out.println("Choices: ");
            System.out.println("0. Exit ");
            System.out.println("1. Implementation with edges: ");
            System.out.println("2. Implementation with vertex: ");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    go = false;
                    break;
                case 1:
                    implWithEdge();
                    break;
                case 2:
                    implWithVertex();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (go);
    }

    public static void implWithEdge() {
        EWeightedGraph<String> weightedGraph = new EWeightedGraph<String>(true);
        fillWithWeightsEdge(weightedGraph);

        System.out.println("Dijkstra:");
        ESearch<String> djk = new EDijkstraSearch<String>(weightedGraph, "Almaty");
        outputPathEdge(djk, "Kyzylorda");


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<String>(true);
        fillWithoutWeightsEdge(graph);

        System.out.println("DFS:");
        ESearch<String> dfs = new EDepthFirstSearch<String>(graph, "Almaty");
        outputPathEdge(dfs, "Kyzylorda");

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        ESearch<String> bfs = new EBreadthFirstSearch<String>(graph, "Almaty");
        outputPathEdge(bfs, "Kyzylorda");
    }

    public static void fillWithoutWeightsEdge(MyGraph<String> graph) {
        graph.addEdge("Almaty", "Astana"); // 16 - 19
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }

    public static void fillWithWeightsEdge(EWeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }

    public static void outputPathEdge(ESearch<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }

    public static void implWithVertex() {
        VWeightedGraph<String> weightedGraph = new VWeightedGraph<String>(true);
        fillWithWeightsVertex(weightedGraph);

        System.out.println("Dijkstra:");
        VSearch<String> djk = new VDijkstraSearch<String>(weightedGraph, Almaty);
        outputPathVertex(djk, Kyzylorda);


        System.out.println("--------------------------------");

        VWeightedGraph<String> graph = new VWeightedGraph<String>(true);
        fillWithoutWeightsVertex(graph);

        System.out.println("DFS:");
        VSearch<String> dfs = new VDepthFirstSearch<String>(graph, Almaty);
        outputPathVertex(dfs, Kyzylorda);

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        VSearch<String> bfs = new VBreadthFirstSearch<String>(graph, Almaty);
        outputPathVertex(bfs, Kyzylorda);
    }

    public static void fillWithoutWeightsVertex(VWeightedGraph<String> graph) {
        graph.addVertex(Almaty);
        graph.addVertex(Shymkent);
        graph.addVertex(Atyrau);
        graph.addVertex(Astana);
        graph.addVertex(Kostanay);
        graph.addVertex(Kyzylorda);
    }

    public static void fillWithWeightsVertex(VWeightedGraph<String> graph) {
        graph.addEdge(Almaty, Astana, 2.1);
        graph.addEdge(Shymkent, Atyrau, 7.8);
        graph.addEdge(Atyrau, Astana, 7.1);
        graph.addEdge(Almaty, Shymkent, 7.2);
        graph.addEdge(Shymkent, Astana, 3.9);
        graph.addEdge(Astana, Kostanay, 3.5);
        graph.addEdge(Shymkent, Kyzylorda, 5.4);
    }

    public static void outputPathVertex(VSearch<String> search, Vertex<String> key) {
        for (Vertex v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}
