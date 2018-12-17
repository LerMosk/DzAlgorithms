package bmstu.dz.lermo;

import javafx.util.Pair;

import java.util.*;

public class Graph {
    private List<Vertex> graph = new ArrayList<>();
    private List<Pair<Vertex, Vertex>> edges = new ArrayList<>();

    public Graph(int count_vertices) {
        for (int i = 0; i < count_vertices; i++) {
            graph.add(new Vertex(i));
        }
    }

    public Vertex getVertexFromKey(Integer key) {

        return graph.get(key);
    }

    public void addEdge(int v1, int v2) {
        if (!edges.contains(new Pair<>(graph.get(v1), graph.get(v2))) && !edges.contains(new Pair<>(graph.get(v2), graph.get(v1)))) {
            graph.get(v1).addNeighbor(graph.get(v2));
            graph.get(v2).addNeighbor(graph.get(v1));
            edges.add(new Pair<>(graph.get(v1), graph.get(v2)));
        }
    }

    public Collection<Vertex> getVertices() {
        return graph;
    }

    public List<Pair<Vertex, Vertex>> getEdges() {
        return edges;
    }

}
