package helpers.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Inputs
{
    public static String[] readAllInputs()
    {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<String>();

        String line = null;
        do
        {
            line = scanner.nextLine();
            inputs.add(line);
        } while(! line.equals("EOF"));

        scanner.close();

        int i = 0;
        String[] stringArray = new String[inputs.size()];
        for(String s : inputs)
        {
            stringArray[i] = s;
            i += 1;
        }

        return stringArray;
    }

    public static int[] createArrayInteger(String input)
    {
        String[] stringArray = input.split(" ");
        int[] data = new int[stringArray.length];

        int i = 0;
        for(String s : stringArray)
        {
            data[i] = Integer.parseInt(s);
            i += 1;
        }

        return data;
    }

    public static void printIntArray(int[] input, char end)
    {
        for(int d : input)
        {
            System.out.print(d + "" + end);
        }
        System.out.println();
    }
}
