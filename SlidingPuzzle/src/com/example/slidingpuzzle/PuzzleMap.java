package com.example.slidingpuzzle;

public class PuzzleMap {
    private char[][] map;
    private int width;
    private int height;
    private Point startPoint;
    private Point finishPoint;

    // Constructor
    public PuzzleMap(char[][] map, int width, int height, Point startPoint, Point finishPoint) {
        this.map = map;
        this.width = width;
        this.height = height;
        this.startPoint = startPoint;
        this.finishPoint = finishPoint;
    }

    // Getter for the map
    public char[][] getMap() {
        return map;
    }

    // Getter for the width
    public int getWidth() {
        return width;
    }

    // Getter for the height
    public int getHeight() {
        return height;
    }

    // Getter for the start point
    public Point getStartPoint() {
        return startPoint;
    }

    // Getter for the finish point
    public Point getFinishPoint() {
        return finishPoint;
    }

    // Optional: Method to print the map

    //------new error :)---------------------------------------------
    /*public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Ensure array access is within bounds
                System.out.print("Checking index: i=" + i + ", j=" + j);
                if (i >= height || j >= width) {
                    System.err.println("Out of bounds access at: i=" + i + ", j=" + j);
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }*/

    // -------------------:) New type of error---------------------------
    /*public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Check that we are within the bounds of the map array
                if (i >= height || j >= width || map[i] == null || j >= map[i].length) {
                    System.err.println("Out of bounds access at: i=" + i + ", j=" + j);
                    continue; // Skip the current iteration if out of bounds
                }

                // Print the map character at the current index
                System.out.print(map[i][j]);
            }
            System.out.println(); // Move to a new line after each row
        }
    }*/
    public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Check if the index is within the bounds of the map array
                if (j < map[i].length) {
                    System.out.print(map[i][j]);
                } else {
                    System.err.println("Out of bounds access at: i=" + i + ", j=" + j);
                }
            }
            System.out.println(); // Print a new line after each row
        }
    }
}
