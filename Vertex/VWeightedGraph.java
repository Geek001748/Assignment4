package Vertex;

import java.util.*;

public class VWeightedGraph<T> {
    private final boolean undirected;
    //    old version
//    private final Map<Vertex.Vertex, List<Edge.Edge<Vertex.Vertex>>> map = new HashMap<>();
    private final ArrayList<Vertex<T>> list = new ArrayList<>();

    public VWeightedGraph() {
        this(true);
    }

    public VWeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex<T> v) {
        if (hasVertex(v))
            return;

//        map.put(v, new LinkedList<>());
        list.add(v);
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops
        source.addAdjVertex(dest, weight);
        if (undirected)
            dest.addAdjVertex(source, weight);

//        map.get(source).add(new Edge.Edge<>(source, dest, weight));
//
//        if (undirected)
//            map.get(dest).add(new Edge.Edge<>(dest, source, weight));

    }

    public int getVerticesCount() {
//        return map.size();
        return list.size();
    }

    public int getEdgesCount() {
        int count = 0;
//        for (Vertex.Vertex v : map.keySet()) {
//            count += map.get(v).size();
//        }
        for (Vertex<T> v : list) {
            count += v.size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(Vertex<T> v) {
//        return map.containsKey(v);
        return list.contains(v);
    }

    public boolean hasEdge(Vertex<T> source, Vertex<T> dest) {
        return source.hasEdge(dest);
    }


//    public boolean hasEdge(Vertex.Vertex source, Vertex.Vertex dest) {
//        if (!hasVertex(source)) return false;
//
//        return map.get(source).contains(new Edge.Edge<>(source, dest));
//    }

    public List<Vertex> adjacencyList(Vertex v) {
//        if (!hasVertex(v)) return null;
//
//        List<Vertex.Vertex> vertices = new LinkedList<>();
//        for (Edge.Edge<Vertex.Vertex> e : map.get(v)) {
//            vertices.add(e.getDest());
//        }
//
//        return vertices;
        if (!hasVertex(v)) return null;
        return v.getAdjList();
    }

    //    public Iterable<Edge.Edge<Vertex.Vertex>> getEdges(Vertex.Vertex v) {
//        if (!hasVertex(v)) return null;
//
//        return map.get(v);
//    }
    public Iterable<Map<Vertex<T>, Double>> getEdges(Vertex<T> v) {
        if (!hasVertex(v)) return null;
        return (Iterable<Map<Vertex<T>, Double>>) v.getAdjVertices();
    }
}