import java.util.Map;
import java.util.Objects;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data)
    {
        this.data = data;
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

    // getters&setters constructors
    // equals
}