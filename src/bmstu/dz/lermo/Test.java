package bmstu.dz.lermo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        try {
            String content = new Scanner(new File(args[0] + ".dat")).useDelimiter("\\Z").next();
            Graph graph = ComparisonAlgorithms.fromStringToGraph(content);
            Set<HashSet<Vertex>> components = PartitionGraphIntoComponents.BFSPartition(graph);

            FileWriter writer = new FileWriter(args[0] + "t.ans", false);
            writer.write("BFS:\n");
            for (HashSet<Vertex> component : components) {
                for (Vertex i : component) {
                    writer.write(i.getKey() + ", ");
                }
                writer.append('\n');
            }

            Set<HashSet<Vertex>> components2 = PartitionGraphIntoComponents.DCUPartition(graph);
            writer.write("\nDCU:\n");
            for (HashSet<Vertex> component : components2) {
                for (Vertex i : component) {
                    writer.write(i.getKey() + ", ");
                }
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}