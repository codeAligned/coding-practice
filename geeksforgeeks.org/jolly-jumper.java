import java.util.Scanner;

class JollyJumper
{
    private static boolean isJumper(int[] seq)
    {
        int jumperLen = seq.length - 1;
        int jumpers = (jumperLen * (jumperLen + 1)) / 2;

        for(int i = 0; i < seq.length - 1; i++)
        {
            int diff = Math.abs(seq[i] - seq[i + 1]);
            jumpers -= diff;
        }

        return jumpers == 0;
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");

        int[] seq = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++)
        {
            seq[i] = Integer.parseInt(inputs[i]);
        }

        System.out.println(isJumper(seq));
    }
}
