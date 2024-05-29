package Edge;

public class EDepthFirstSearch<Vertex> extends ESearch<Vertex> {
    public EDepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        for (Vertex v : graph.adjacencyList(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}