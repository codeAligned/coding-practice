/*
Cracking the coding interview: Chapter 1: Arrays & Strings.
Q 1.3: URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has
sufficient space at the end to hold the additional characters, and that you are given the "true" lenght of the string.
(Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
*/

class URLify
{
    public static void main(String args[])
    {
        String str = "https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch 01. Arrays and Strings/Q1_03_URLify/Question.java        ";
        char[] c = str.toCharArray();

        URLify obj = new URLify();
        c = obj.urlify(c);
        for(int i = 0; i < c.length; i++) System.out.print(c[i]);
    }

    public char[] urlify(char[] s)
    {
        int j = 0;
        int i = s.length - 1;

        for(j = i; j >= 0; j--)
        {
            if(s[j] != ' ')
            {
                break;
            }
        }

        while(i >= 0)
        {
            if(s[j] != ' ')
            {
                if(i != j)
                {
                    s[i] = s[j];
                    s[j] = ' ';
                }

                i--; j--;
            }
            else
            {
                s[i] = '0';
                s[i - 1] = '2';
                s[i - 2] = '%';

                i -= 3;
                j -= 1;
            }
        }

        return s;
    }
}
