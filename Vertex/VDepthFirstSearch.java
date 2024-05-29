package Vertex;

import Edge.MyGraph;

public class VDepthFirstSearch<T> extends VSearch<T> {
    public VDepthFirstSearch(VWeightedGraph<T> graph, Vertex<T> source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(VWeightedGraph<T> graph, Vertex<T> current) {
        marked.add(current);

        for (Vertex<T> v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}