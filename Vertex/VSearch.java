package Vertex;

import java.util.*;

public class VSearch<T> {
    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public VSearch(Vertex<T> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> v) {
        return marked.contains(v);
    }

    public Iterable<Vertex<T>> pathTo(Vertex<T> v) {
        if (!hasPathTo(v)) return null;

        LinkedList<Vertex<T>> ls = new LinkedList<>();
        for (Vertex<T> i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i); // inverted adding
        }

        ls.push(source);

        return ls;
    }
}