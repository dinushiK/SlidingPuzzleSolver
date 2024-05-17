package com.example.slidingpuzzle;

import java.util.*;

public class PathFinder {

    public List<String> findShortestPath(PuzzleMap puzzleMap) {
        int width = puzzleMap.getWidth();
        int height = puzzleMap.getHeight();
        char[][] map = puzzleMap.getMap();
        Point start = puzzleMap.getStartPoint();
        Point finish = puzzleMap.getFinishPoint();

        // Direction vectors for UP, DOWN, LEFT, RIGHT movements
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};

        // Queue for BFS
        Queue<Node> queue = new LinkedList<>();
        // Track visited points
        Set<Point> visited = new HashSet<>();

        // Start BFS from the start point
        queue.add(new Node(start, new ArrayList<>()));
        visited.add(start);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Point currentPoint = currentNode.point;
            List<String> path = currentNode.path;

            // If we reached the finish point, print the path and return it
            if (currentPoint.equals(finish)) {
                printPath(path, start);
                return path;
            }

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int newX = currentPoint.getX() + dx[i];
                int newY = currentPoint.getY() + dy[i];

                // Check if the new point is within bounds and not a wall
                if (newX >= 0 && newY >= 0 && newX < width && newY < height && map[newX][newY] != '0') {
                    Point nextPoint = new Point(newX, newY);
                    if (!visited.contains(nextPoint)) {
                        visited.add(nextPoint);
                        // Create a new path by adding the current direction
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add("Move " + directions[i].toLowerCase() + " to (" + newX + "," + newY + ")");
                        // Add the new node to the queue
                        queue.add(new Node(nextPoint, newPath));
                    }
                }
            }
        }

        // If no path was found, return an empty list
        return new ArrayList<>();
    }

    // Method to print the path with steps and coordinates
    private void printPath(List<String> path, Point start) {
        System.out.println("1. Start at (" + start.getX() + "," + start.getY() + ")");
        for (int i = 0; i < path.size(); i++) {
            System.out.println((i + 2) + ". " + path.get(i));
        }
        System.out.println((path.size() + 2) + ". Done!");
    }

    // Node class to hold the current point and the path taken to reach it
    private static class Node {
        Point point;
        List<String> path;

        Node(Point point, List<String> path) {
            this.point = point;
            this.path = path;
        }
    }
}
