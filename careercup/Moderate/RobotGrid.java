/*
Cracking The Coding Interview - 6th Edition. Page 135.

Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.
*/

package careercup.moderate;

import java.util.ArrayList;
import helpers.java.Inputs;

public class RobotGrid {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static ArrayList<Point> points;

    private static boolean isPathPossible(int[][] board, int r1, int c1, int r2, int c2) {
        /* End of road. */
        if(r2 < 0 || c2 < 0 || board[r2][c2] == 0) {
            return false;
        }

        boolean hasReachedDestination = r1 == r2 && c1 == c2;
        if(hasReachedDestination || isPathPossible(board, r1, c1, r2 - 1, c2) || isPathPossible(board, r1, c1, r2, c2 - 1)) {
            Point p = new Point(r2, c2);
            points.add(p);
            return true;
        }

        return false;
    }

    private static void printBestPath(int[][] board, int r1, int c1, int r2, int c2) {
        if(isPathPossible(board, r1, c1, r2, c2)) {
            for(Point p : points) {
                System.out.println("(" + p.x + ", " + p.y + ")");
            }
        }
    }

    public static void main(String[] args) {
        String[] lines = Inputs.readAllInputs();

        String[] dim = lines[0].split(" ");
        int n = Integer.parseInt(dim[0]);
        int m = Integer.parseInt(dim[1]);

        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++) {
            Integer[] row = Inputs.createArrayOfIntegers(lines[i + 1]);

            for(int j = 0; j < m; j++) {
                board[i][j] = row[j];
            }
        }

        points = new ArrayList<Point>();
        printBestPath(board, 0, 0, n-1, m-1);
    }
}
