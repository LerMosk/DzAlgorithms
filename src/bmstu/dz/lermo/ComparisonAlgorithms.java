package bmstu.dz.lermo;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComparisonAlgorithms {
    public static Graph fromStringToGraph(String strGraph) {
        int countVertices = (strGraph.indexOf(" ") != -1) ? Integer.parseInt(strGraph.substring(0, strGraph.indexOf(" "))) : Integer.parseInt(strGraph);
        Graph graph = new Graph(countVertices);
        Pattern pattern = Pattern.compile("([\\d][\\d]*),([\\d][\\d]*)");
        Matcher m = pattern.matcher(strGraph);
        while (m.find()) {
            graph.addEdge(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
        }
        return graph;
    }

    public static void main(String[] args) {
        try {
            String content = new Scanner(new File(args[0])).useDelimiter("\\Z").next();
            Graph graph = ComparisonAlgorithms.fromStringToGraph(content);
            long startBFS = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                PartitionGraphIntoComponents.BFSPartition(graph);
            }
            long finishBFS = System.nanoTime();
            double timeConsumedBFS = (finishBFS - startBFS) / 1000;

            long startDCU = System.nanoTime();
            for (int i = 0; i < 1000; i++) {
                PartitionGraphIntoComponents.DCUPartition(graph);
            }
            long finishDCU = System.nanoTime();
            double timeConsumedDCU = (finishDCU - startDCU) / 1000;
            FileWriter writer = new FileWriter(args[1], false);
            writer.write(timeConsumedBFS + " " + timeConsumedDCU);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

