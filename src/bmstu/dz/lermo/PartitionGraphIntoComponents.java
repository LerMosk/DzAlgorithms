package bmstu.dz.lermo;

import javafx.util.Pair;

import java.util.*;

public class PartitionGraphIntoComponents {
    private PartitionGraphIntoComponents() {
    }

    static public Set<HashSet<Vertex>> DCUPartition(Graph graph) {
        DCU<Vertex> dcu = new DCU<>();
        for (Vertex v : graph.getVertices()) {
            dcu.makeSet(v);
        }
        for (Pair<Vertex, Vertex> edge : graph.getEdges()) {
            dcu.union(edge.getKey(), edge.getValue());
        }
        Set<HashSet<Vertex>> components = dcu.getSets();
        return components;
    }

    static public Set<HashSet<Vertex>> BFSPartition(Graph graph) {
        Set<Vertex> grVert = new HashSet<>(graph.getVertices());
        Set<HashSet<Vertex>> components = new HashSet<>();
        while (!grVert.isEmpty()) {
            HashSet<Vertex> component = new HashSet<>();
            LinkedList<Vertex> verticesQ = new LinkedList<>();
            verticesQ.addLast(grVert.iterator().next());
            verticesQ.getFirst().setQueueMember(true);
            while (!verticesQ.isEmpty()) {
                for (Vertex i : verticesQ.getFirst().getNeighbors()) {
                    if (!i.isQueueMember()) {
                        i.setQueueMember(true);
                        verticesQ.addLast(i);
                    }
                }
                component.add(verticesQ.getFirst());
                grVert.remove(verticesQ.pop());
            }
            components.add(component);
        }
        graph.setVerticesQueueMemberFalse();
        return components;
    }

}
