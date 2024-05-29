package Vertex;

import Edge.MyGraph;

import java.util.LinkedList;
import java.util.Queue;

public class VBreadthFirstSearch<T> extends VSearch<T> {
    public VBreadthFirstSearch(VWeightedGraph<T> graph, Vertex<T> source) {
        super(source);

        bfs(graph, source);
    }

    private void bfs(VWeightedGraph<T> graph, Vertex<T> current) {
        marked.add(current);


        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(current); //[0]

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove(); // []

            for (Vertex<T> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v); // {[1,0] [2,0] [3,0] [4 0] [5 1] [6 1] [7 2]}
                    queue.add(vertex); // [1,2,3,4]
                }
            }
        }
    }
}