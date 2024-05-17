package com.example.slidingpuzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapParser {

    public PuzzleMap parseMap(String filePath) throws IOException {
        // Variables to hold the map, width, and height
        char[][] map = null;
        int width = 0;
        int height = 0;
        Point startPoint = null;
        Point finishPoint = null;

        // Read the file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Initialize the map array when we know the width and height
                if (height == 0) {
                    width = line.length();
                    map = new char[width][];
                }

                // Allocate the line in the map
                map[height] = line.toCharArray();

                // Check for start and finish points
                for (int x = 0; x < line.length(); x++) {
                    if (line.charAt(x) == 'S') {
                        startPoint = new Point(x, height);
                    } else if (line.charAt(x) == 'F') {
                        finishPoint = new Point(x, height);
                    }
                }

                // Increment the height
                height++;
            }
        }

        // Create a PuzzleMap object and return it
        return new PuzzleMap(map, width, height, startPoint, finishPoint);
    }
}
