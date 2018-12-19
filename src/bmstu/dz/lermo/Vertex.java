package bmstu.dz.lermo;

import java.util.*;

public class Vertex {
    private int key;
    private List<Vertex> neighbors = new ArrayList<>();
    private boolean queueMember = false;

    public Vertex(int key) {
        this.key = key;
    }

    public void addNeighbor(Vertex v) {
        neighbors.add(v);
    }

    public int getKey() {
        return key;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }


    public void setQueueMember(boolean queueMember) {
        this.queueMember = queueMember;
    }

    public boolean isQueueMember() {
        return queueMember;
    }

}
