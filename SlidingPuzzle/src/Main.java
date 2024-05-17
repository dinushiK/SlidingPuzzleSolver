//Student Name: Don Dinushi Dulanjana Kolambathanthri
//IIT Student ID: 20210204
//UoW Student ID: w1953849

import com.example.slidingpuzzle.MapParser;
import com.example.slidingpuzzle.PuzzleMap;
import com.example.slidingpuzzle.Point;
import com.example.slidingpuzzle.Direction;
import com.example.slidingpuzzle.PathFinder;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // Create an instance of MapParser
        MapParser parser = new MapParser();

        try {
            // Parse the map from the test input file
            PuzzleMap puzzleMap = parser.parseMap("C:/AlgoCW/test_map/selfmade/test_map_1.txt");

            // Check the width and height
            int width = puzzleMap.getWidth();
            int height = puzzleMap.getHeight();
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);

            // Check the start and finish points
            Point startPoint = puzzleMap.getStartPoint();
            Point finishPoint = puzzleMap.getFinishPoint();
            System.out.println("Start Point: " + startPoint);
            System.out.println("Finish Point: " + finishPoint);

            // Print the map to visually verify the content
            puzzleMap.printMap();

            // Perform any other custom verification checks you want to include

        } catch (IOException e) {
            e.printStackTrace();
        }
        //step 3:test the pathfinder class_____________________________________
        {
            // Define the path to the test map file
            String mapFilePath = "C:/AlgoCW/test_map/selfmade/test_map_1.txt";

            // Create a MapParser object---------
            //MapParser parser = new MapParser();  // Declare the parser variable only once------

            try {
                // Parse the map from the file
                PuzzleMap puzzleMap = parser.parseMap(mapFilePath);

                // Create an instance of PathFinder
                PathFinder pathFinder = new PathFinder();

                // Find the shortest path using the findShortestPath method
                List<String> shortestPath = pathFinder.findShortestPath(puzzleMap);

                // Print the shortest path
                System.out.println("Shortest Path: " + shortestPath);

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
