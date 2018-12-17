package bmstu.dz.lermo;

import java.util.*;

public class DCU<T> {
    private Map<T, Node<T>> nodes = new HashMap<>();

    private class Node<T> {
        public Node(T data) {
            this.data = data;
            parent = this;
            rank = 0;
        }

        private T data;
        private Node<T> parent;
        private int rank;
    }

    public void makeSet(T newData) {
        Node<T> newRepresentative = this.new Node<>(newData);
        nodes.put(newData, newRepresentative);
    }

    public T findSet(T data) {
        return findSet(nodes.get(data)).data;
    }

    private Node<T> findSet(Node<T> node) {
        if (node != node.parent) {
            node.parent = findSet(node.parent);
        }
        return node.parent;
    }

    public void union(T data1, T data2) {
        link(findSet(nodes.get(data1)), findSet(nodes.get(data2)));
    }

    private void link(Node<T> unionElement1, Node<T> unionElement2) {
        if (unionElement1.rank > unionElement2.rank) {
            unionElement2.parent = unionElement1;
        } else {
            unionElement1.parent = unionElement2;
        }
        if (unionElement1.rank == unionElement2.rank) {
            unionElement2.rank++;
        }
    }

    public Set<HashSet<T>> getSets() {
        HashMap<T, HashSet<T>> sets = new HashMap<>();
        for (Node<T> node : nodes.values()) {
            T representative = findSet(node.data);
            if (!sets.containsKey(representative)) {
                sets.put(representative, new HashSet<>());
            }
            sets.get(representative).add(node.data);
        }
        Set<HashSet<T>> sets2 = new HashSet<>();
        for (HashSet<T> set : sets.values()) {
            sets2.add(set);
        }
        return sets2;
    }
}
