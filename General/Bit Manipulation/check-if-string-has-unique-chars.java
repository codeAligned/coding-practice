/*
Cracking the coding interview: Chapter 1: Arrays & Strings.
Q 1.1: Is Unique: Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
*/

/*
LESSON: BIT - To set a bit, OR with that position set.
LESSON: BIT - To unset a bit, first set that position, then NOT it, then AND.
LESSON: BIT - To toggle a bit, XOR with that position set.
LESSON: BIT - To check if atmost one num is non-zero, XOR of all must be equal to OR of all. E.g. 2^0^0=2|0|0
LESSON: BIT - To check if power of 2, AND with its neg must produce itself. E.g. 4 & -4 = 4. 3 & -3 != 3.
*/

class CheckIfStringHasUniqueChars
{
    public static void main(String args[])
    {
        String s1 = "Hello";
        String s2 = "abcd";
        String s3 = "The brown fox jumps the lazy dog";
        String s4 = "UNCOPYRIGHTABLE";
        String s5 = "SUBDERMATOGLYPHIC";

        CheckIfStringHasUniqueChars obj = new CheckIfStringHasUniqueChars();
        System.out.println(obj.isUnique(s1));
        System.out.println(obj.isUnique(s2));
        System.out.println(obj.isUnique(s3));
        System.out.println(obj.isUnique(s4));
        System.out.println(obj.isUnique(s5));
    }

    public boolean isBitSet(int n, int i)
    {
        i = 1 << i;
        int res = n & i;

        return res > 0;
    }

    public int setBit(int n, int i)
    {
        i = 1 << i;
        n = n | i;
        return n;
    }

    public boolean isUnique(String s)
    {
        s = s.replaceAll("\\s+", "").toUpperCase();
        int n = 0;
        char c[] = s.toCharArray();

        for(int i = 0; i < c.length; i++)
        {
            int ascii = (int) c[i];
            ascii = 65 - ascii;

            if(this.isBitSet(n, ascii))
            {
                return false;
            }
            else
            {
                n = this.setBit(n, ascii);
            }
        }

        return true;
    }
}
