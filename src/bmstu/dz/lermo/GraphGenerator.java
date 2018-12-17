package bmstu.dz.lermo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GraphGenerator {
    private GraphGenerator() {
    }

    public static void randomGraphGenerator(String fileName) {
        final Random random = new Random();
        int countVertices = random.nextInt(95) + 5;
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(countVertices + " ");

            int countEges = random.nextInt(countVertices * (countVertices - 1) / 2 - 1) + 1;
            for (int i = 0; i < countEges; i++) {
                writer.write(random.nextInt(countVertices - 1) + "," + random.nextInt(countVertices - 1) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void graphGenerator(String fileName, int verticesSize, int edgeSize) {
        final Random random = new Random();
        int countVertices = verticesSize;
        try {
            FileWriter writer = new FileWriter(fileName, false);
            writer.write(countVertices + " ");
            for (int i = 0; i < edgeSize; i++) {
                writer.write(random.nextInt(countVertices - 1) + "," + random.nextInt(countVertices - 1) + " ");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GraphGenerator.graphGenerator("test07.dat", 500, 30000);
    }
}

