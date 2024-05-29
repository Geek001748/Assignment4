package Vertex;

import java.util.*;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;
        adjacentVertices = new HashMap<>();
    }
    public T getData()
    {
        return data;
    }
    @Override
    public boolean equals(Object object)
    {
        if(this == object)
        {
             return true;
        }
        if(object == null || getClass() != object.getClass())
        {
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) object;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(data);
    }
    @Override
    public String toString() {
        return data.toString();
    }
    public void addAdjVertex(Vertex<T> dest, double weight){
        adjacentVertices.put(dest, weight);
    }
    public boolean hasEdge(Vertex<T> v){
        return adjacentVertices.containsKey(v);
    }

    public List<Vertex<T>> getAdjList(){
        List<Vertex<T>> adjacencyList = new ArrayList<>();
        for(var n : adjacentVertices.entrySet()){
            adjacencyList.add(n.getKey());
        }
        return adjacencyList;
    }
    public Map<Vertex<T>, Double> getAdjVertices(){
        return adjacentVertices;
    }

    public int size(){
        return adjacentVertices.size();
    }
    // getters&setters constructors
    // equals
}