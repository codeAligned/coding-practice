/*
https://leetcode.com/problems/range-sum-query-2d-immutable/

Given a 2D matrix matrix, find the sum of the elements inside the rectangle
defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
*/

package leetcode;

import helpers.java.Inputs;

public class RangeSumQuery {
    int[][] sumMatrix;

    public RangeSumQuery(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        this.sumMatrix = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            int rowSum = 0;
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    this.sumMatrix[i][j] = 0;
                }
                else {
                    rowSum += matrix[i - 1][j - 1];
                    this.sumMatrix[i][j] = rowSum + this.sumMatrix[i - 1][j];
                }
            }
        }
    }

    public void printSumMatrix() {
        for(int i = 0; i < this.sumMatrix.length; i++) {
            for(int j = 0; j < this.sumMatrix[0].length; j++) {
                System.out.print(this.sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getRangeSum(int row1, int col1, int row2, int col2) {
        return this.sumMatrix[row2 + 1][col2 + 1] - this.sumMatrix[row2 + 1][col1] - this.sumMatrix[row1][col2 + 1] + this.sumMatrix[row1][col1];
    }

    public static void main(String[] args) {
        String[] inputs = Inputs.readAllInputs();

        String[] dim = inputs[0].split(" ");
        int n = Integer.parseInt(dim[0]);
        int m = Integer.parseInt(dim[1]);

        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] row = inputs[i + 1].split(" ");

            for(int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        String[] points = inputs[n + 1].split(" ");
        int row1 = Integer.parseInt(points[0]);
        int col1 = Integer.parseInt(points[1]);
        int row2 = Integer.parseInt(points[2]);
        int col2 = Integer.parseInt(points[3]);

        RangeSumQuery obj = new RangeSumQuery(matrix);
        obj.printSumMatrix();
        System.out.println(obj.getRangeSum(row1, col1, row2, col2));
    }
}
