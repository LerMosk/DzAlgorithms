package bmstu.dz.lermo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartitionGraphIntoComponentsTest {
    private List<String> testsNames;

    @Before
    public void setUp() throws Exception {
        testsNames = new ArrayList<>();
        testsNames.add("test1");
        testsNames.add("test2");
        testsNames.add("test3");
        testsNames.add("test4");
        testsNames.add("test5");
    }

    @Test
    public void DCUPartition() {
        for (String testName : testsNames) {
            try {
                String content = new Scanner(new File(testName + ".dat")).useDelimiter("\\Z").next();
                Graph graph = ComparisonAlgorithms.fromStringToGraph(content);
                Set<HashSet<Vertex>> actual = PartitionGraphIntoComponents.DCUPartition(graph);
                Set<HashSet<Vertex>> expected = parseFile(testName, graph);
                Assert.assertEquals(expected, actual);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void BFSPartition() {
        for (String testName : testsNames) {
            try {
                String content = new Scanner(new File(testName + ".dat")).useDelimiter("\\Z").next();
                Graph graph = ComparisonAlgorithms.fromStringToGraph(content);
                Set<HashSet<Vertex>> actual = PartitionGraphIntoComponents.BFSPartition(graph);
                Set<HashSet<Vertex>> expected = parseFile(testName, graph);
                Assert.assertEquals(expected, actual);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Set<HashSet<Vertex>> parseFile(String fileName, Graph graph) {
        Set<HashSet<Vertex>> components = new HashSet<>();
        try {
            Scanner scanner = new Scanner(new File(fileName + ".ans"));
            while (scanner.hasNextLine()) {
                HashSet<Vertex> component = new HashSet<>();
                String str = scanner.nextLine();
                Pattern pattern = Pattern.compile("([\\d][\\d]*)");
                Matcher m = pattern.matcher(str);
                while (m.find()) {
                    component.add(graph.getVertexFromKey(Integer.parseInt(m.group(1))));
                }
                components.add(component);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return components;
    }
}