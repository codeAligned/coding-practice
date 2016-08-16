package games;

import java.util.Stack;
import helpers.java.Inputs;

class Sudoku
{
    private static class Cell
    {
        public int i, j, k;

        public Cell(int i, int j, int k)
        {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    private static int[][] solve(int[][] sudoku)
    {
        Stack<Cell> stack = new Stack<Cell>();

        for(int i = 0; i < 9; i++)
        {
            int k = 1;

            for(int j = 0; j < 9; j++)
            {
                if(sudoku[i][j] == 0)
                {
                    boolean found = false;

                    for(; k <= 9; k++)
                    {
                        sudoku[i][j] = k;
                        if(check(sudoku, i, j))
                        {
                            Cell cell = new Cell(i, j, k);
                            stack.push(cell);
                            found = true;
                            break;
                        }
                        else
                        {
                            sudoku[i][j] = 0;
                        }
                    }

                    if(found)
                    {
                        k = 1;
                    }
                    else
                    {
                        Cell cell = stack.pop();
                        i = cell.i;
                        j = cell.j;

                        sudoku[i][j] = 0; // Reset this cell.
                        j -= 1; // Next increment will make it right!
                        k = cell.k + 1; // Try the next k.
                    }
                }
            }
        }

        return sudoku;
    }

    private static boolean check(int[][] sudoku, int i, int j)
    {
        int item = sudoku[i][j];

        for(int k = 0; k < sudoku[i].length; k++)
        {
            if(k != j && item == sudoku[i][k])
            {
                return false;
            }
        }

        for(int k = 0; k < sudoku[i].length; k++)
        {
            if(k != i && item == sudoku[k][j])
            {
                return false;
            }
        }

        int ci = 3 * (i / 3);
        int cj = 3 * (j / 3);
        for(int x = ci; x < ci + 3; x++)
        {
            for(int y = cj; y < cj + 3; y++)
            {
                if(x != i && y != j && sudoku[x][y] == sudoku[i][j])
                {
                    return false;
                }
            }
        }

        return true;
    }

    private static void print(int[][] sudoku)
    {
        int rowlen = sudoku.length;
        int collen = sudoku[0].length;

        for(int i = 0; i < rowlen; i++)
        {
            for(int j = 0; j < collen; j++)
            {
                String value = sudoku[i][j] == 0 ? "_" : sudoku[i][j] + "";
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] sudoku = new int[9][9];
        String[] lines = Inputs.readAllInputs();

        for(int i = 0; i < 9; i++)
        {
            Integer[] row = Inputs.createArrayOfIntegers(lines[i]);

            for(int j = 0; j < 9; j++)
            {
                sudoku[i][j] = row[j];
            }
        }

        print(sudoku);
        System.out.println("--------------------------------------");
        print(solve(sudoku));
    }
}
