package Vertex;

import java.util.*;

public class VDijkstraSearch<T> extends VSearch<T> {
    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distances;
    private final VWeightedGraph<T> graph;

    public VDijkstraSearch(VWeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        Vdijkstra();
    }

    public void Vdijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<T> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, currentNode); // inverted adding
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }
//    Old version
//    private double getDistance(Vertex.Vertex node, Vertex.Vertex target) {
//        for (Edge.Edge<Vertex.Vertex> edge : graph.getEdges(node)) {
//            if (edge.getDest().equals(target))
//                return edge.getWeight();
//        }
//
//        throw new RuntimeException("Not found!");
//    }

    //    New version
    private double getDistance(Vertex<T> node, Vertex<T> target) {
        if (!node.hasEdge(target))
            throw new RuntimeException("Not found!");
        return (double) node.getAdjVertices().get(target);
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;

                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(minimum))
                minimum = vertex;
        }

        return minimum;
    }

    private double getShortestDistance(Vertex<T> destination) {
        Double d = distances.get(destination);

        return (d == null ? Double.MAX_VALUE : d);
    }
}