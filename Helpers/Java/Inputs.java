package helpers.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Inputs
{
    public static String[] readAllInputs()
    {
        Scanner scanner = null;
        ArrayList<String> inputs;

        try
        {
            scanner = new Scanner(System.in);
            inputs = new ArrayList<String>();

            String line = null;
            do
            {
                line = scanner.nextLine();
                if(! line.equals("EOF")) inputs.add(line);
            } while(! line.equals("EOF"));
        }
        finally
        {
            if(scanner != null) scanner.close();
        }

        int i = 0;
        String[] stringArray = new String[inputs.size()];
        for(String s : inputs)
        {
            stringArray[i] = s;
            i += 1;
        }

        return stringArray;
    }

    public static Character[] createArrayOfChars(String input)
    {
        String[] stringArray = input.split(" ");
        Character[] data = new Character[stringArray.length];

        int i = 0;
        for(String s : stringArray)
        {
            data[i] = new Character(s.charAt(0));
            i += 1;
        }

        return data;
    }

    public static Integer[] createArrayOfIntegers(String input)
    {
        String[] stringArray = input.split(" ");
        Integer[] data = new Integer[stringArray.length];

        int i = 0;
        for(String s : stringArray)
        {
            data[i] = Integer.parseInt(s);
            i += 1;
        }

        return data;
    }
}
